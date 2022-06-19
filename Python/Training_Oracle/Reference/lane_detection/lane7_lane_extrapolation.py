# 目标1：读取图片
# 目标2：转换为灰色的图片
# 目标3: 高斯平滑，去除多余噪点
# 目标4：边缘检测，根据倾斜度检测
# 目标5：得到关注区域的边缘检测图
# 目标6：通过霍夫变换，得到符合要求线
# 目标7：车道推断，根据不连续的线，生成连续的线

import matplotlib.image as mplimg
import cv2

# 通过opencv读取到图片后，都是BGR
# 读取车道图片
img = mplimg.imread('../resources/lane.jpg')
# 输出这张图片
cv2.imwrite('../resources/lane1_read_img.jpg', img)

# Note that if you use cv2.imread() to read image, the image will be in format BGR.
# 是将RGB图片转换成灰色图片
gray = cv2.cvtColor(img, cv2.COLOR_RGB2GRAY)
# 输出这张灰色图片
cv2.imwrite('../resources/lane2_to_gray.jpg', gray)

# 高斯平滑——能够抑制图片中的高频部分，而让低频部分顺利通过。去除噪点
# Gaussian Filter是一种低通过滤器，能够抑制图片中的高频部分，而让低频部分顺利通过
# 设置高斯焦点核心大小
blur_ksize = 5  # Gaussian blur kernel size 高斯焦点核心大小
# 执行处理，得到处理后的图片对象
blur_gray = cv2.GaussianBlur(gray, (blur_ksize, blur_ksize), 0, 0)
# 输出这张灰色图片
cv2.imwrite('../resources/lane3_guassion_smoothing.jpg', blur_gray)

# 边缘检测：低阈值50，高阈值150。
# 用50和150，因为目标图片中的车道大致符合这个倾斜度
canny_lthreshold = 50  # Canny edge detection low threshold
canny_hthreshold = 150  # Canny edge detection high threshold
edges = cv2.Canny(blur_gray, canny_lthreshold, canny_hthreshold)
# 输出这张边缘检测后的图-可以获得只有黑色和白线组成的图片
cv2.imwrite('../resources/lane4_edges.jpg', edges)

import numpy as np
# 定义函数：关注区域_遮罩——除了关注区域外，其他地方全用遮住
# 参数1，要传入的图像，参数2：verticess-关注区域的四个坐标点（三维的数组）
def roi_mask(img, vertices):
  # 生成遮罩图片：生成与输入图像相同大小的图像，并使用0填充,图像为黑色
  mask = np.zeros_like(img)
  # 颜色：黑色
  mask_color = 255

  # 根据输入的图片，定义3通道或者1通道的颜色填充遮罩多余的区域
  # if len(img.shape) > 2:
  #     channel_count = img.shape[2]  # i.e. 3 or 4 depending on your image
  #     mask_color = (255,) * channel_count  # 如果 channel_count=3,则为(255,255,255)
  # else:
  #     mask_color = 255

  # 填充区域：黑色的遮罩 关注区域  遮罩的颜色
  cv2.fillPoly(mask, vertices, mask_color)
  # 生成遮罩后的图片
  masked_img = cv2.bitwise_and(img, mask)
  return masked_img

# 定义参数2：verticess-关注区域的四个坐标点（三维的数组）
roi_vtx = np.array([[(0, img.shape[0]),
                     (460, 325),
                     (520, 325),
                     (img.shape[1], img.shape[0])
                    ]])
#得到关注区域的边缘检测图， 调用函数，参数1：上次的边界图 参数2：关注区域
roi_edges = roi_mask(edges, roi_vtx)

# 输出这张经过遮罩后的边缘检测图
cv2.imwrite('../resources/lane5_roi_edges.jpg', roi_edges)

# 霍夫变换参数
rho = 1# rho的步长，即直线到图像原点(0,0)点的距离
theta = np.pi / 180# theta的范围
threshold = 15# 累加器中的值高于它时才认为是一条直线
min_line_length = 40# 线的最短长度，比这个短的都被忽略
max_line_gap = 20# 两条直线之间的最大间隔，小于此值，认为是一条直线

# 绘制直线-颜色蓝色：[255, 0, 0] 绿色[0, 255, 0] 红色[0,0,255]
# 此处是错误的，再最后需要改正
def draw_lines(img, lines, color=[0, 0, 255], thickness=2):
  for line in lines:
    for x1, y1, x2, y2 in line:
      cv2.line(img, (x1, y1), (x2, y2), color, thickness)

# 排除不满足斜率要求的线，将不满足斜率要求的直线弹出
def clean_lines(lines, threshold):
    slope=[]
    for line in lines:
        for x1,y1,x2,y2 in line:
            k=(y2-y1)/(x2-x1)
            slope.append(k)
    #slope = [(y2 - y1) / (x2 - x1) for line in lines for x1, y1, x2, y2 in line]
    while len(lines) > 0:
        mean = np.mean(slope)#计算斜率的平均值，因为后面会将直线和斜率值弹出
        diff = [abs(s - mean) for s in slope]#计算每条直线斜率与平均值的差值
        idx = np.argmax(diff)#计算差值的最大值的下标
        if diff[idx] > threshold:#将差值大于阈值的直线弹出
          slope.pop(idx)#弹出斜率
          lines.pop(idx)#弹出直线
        else:
          break

# 生成直线表达式——拟合点集，生成直线表达式，并计算直线在图像中的两个端点的坐标
def calc_lane_vertices(point_list, ymin, ymax):
  x = [p[0] for p in point_list]#提取x
  y = [p[1] for p in point_list]#提取y
  fit = np.polyfit(y, x, 1)#用一次多项式x=a*y+b拟合这些点，fit是(a,b)
  fit_fn = np.poly1d(fit)#生成多项式对象a*y+b

  xmin = int(fit_fn(ymin))#计算这条直线在图像中最左侧的横坐标
  xmax = int(fit_fn(ymax))#计算这条直线在图像中最右侧的横坐标

  return [(xmin, ymin), (xmax, ymax)]

# 绘制车道：排除多余直线的方法、生成直线的方法
# 需要的参数：图片、霍夫函数的相关线段参数、……
# 这个函数要在霍夫直线函数hough_lines中替换掉原先的draw_lines
# -颜色蓝色：[255, 0, 0] 绿色[0, 255, 0] 红色[0,0,255]
def draw_lanes(img, lines, color=[0, 0, 255], thickness=8):
  left_lines, right_lines = [], []#用于存储左边和右边的直线
  for line in lines:#对直线进行分类
    for x1, y1, x2, y2 in line:
      k = (y2 - y1) / (x2 - x1)
      if k < 0:
        left_lines.append(line)
      else:
        right_lines.append(line)

  if (len(left_lines) <= 0 or len(right_lines) <= 0):
    return img

  clean_lines(left_lines, 0.1)#弹出左侧不满足斜率要求的直线
  clean_lines(right_lines, 0.1)#弹出右侧不满足斜率要求的直线
  left_points = [(x1, y1) for line in left_lines for x1,y1,x2,y2 in line]#提取左侧直线族中的所有的第一个点
  left_points = left_points + [(x2, y2) for line in left_lines for x1,y1,x2,y2 in line]#提取左侧直线族中的所有的第二个点
  right_points = [(x1, y1) for line in right_lines for x1,y1,x2,y2 in line]#提取右侧直线族中的所有的第一个点
  right_points = right_points + [(x2, y2) for line in right_lines for x1,y1,x2,y2 in line]#提取右侧侧直线族中的所有的第二个点

  left_vtx = calc_lane_vertices(left_points, 325, img.shape[0])#拟合点集，生成直线表达式，并计算左侧直线在图像中的两个端点的坐标
  right_vtx = calc_lane_vertices(right_points, 325, img.shape[0])#拟合点集，生成直线表达式，并计算右侧直线在图像中的两个端点的坐标

  cv2.line(img, left_vtx[0], left_vtx[1], color, thickness)#画出直线
  cv2.line(img, right_vtx[0], right_vtx[1], color, thickness)#画出直线

# 定义霍夫线函数，调用上面绘制线的方法，传入参数，绘制霍夫线
def hough_lines(img, rho, theta, threshold,
                min_line_len, max_line_gap):
  # 各种参数，生成线和线的图片
  lines = cv2.HoughLinesP(img, rho, theta, threshold, np.array([]),
                          minLineLength=min_line_len,
                          maxLineGap=max_line_gap)
  line_img = np.zeros((img.shape[0], img.shape[1], 3), dtype=np.uint8)
  # 调用上面绘制线的方法，进行处理
  # draw_lines(line_img, lines)
  # 调用下面绘制车道线的方法，进行处理
  draw_lanes(line_img, lines)
  return line_img

# 调用霍夫线函数，并传入上阶段产生的线条不连续的车道图，生成基于霍夫线推断出来的车道图
# line_img = hough_lines(roi_edges, rho, theta, threshold,
#                        min_line_length, max_line_gap)

# 输出这张图片——获得基于上一张图片-不连续的车道图——————》红色的去噪点车道图，仍是不连续的
# cv2.imwrite('../resources/lane6_hough_line.jpg', line_img)

# 调用霍夫线函数
line_img2 = hough_lines(roi_edges, rho, theta, threshold,
                       min_line_length, max_line_gap)
# 因为目前上面的霍夫函数已经调用了车道线生成函数，所以产生的是：连续的车道图
cv2.imwrite('../resources/lane7_lane_extrapolation.jpg', line_img2)
