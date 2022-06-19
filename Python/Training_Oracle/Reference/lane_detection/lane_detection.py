# 目标1：读取图片
# 目标2：转换为灰色的图片
# 目标3: 高斯平滑，去除多余噪点
# 目标4：边缘检测，根据倾斜度检测
# 目标5：得到关注区域的边缘检测图
# 目标6：通过霍夫变换，得到符合要求线
# 目标7：车道推断，根据不连续的线，生成连续的线
# 目标8：生成车道图和原始图片合并的图片
# 目标9：封装成函数
import matplotlib.image as mplimg
import cv2
import numpy as np

# 1. 各种初始化的参数
# 霍夫变换参数
rho = 1# rho的步长，即直线到图像原点(0,0)点的距离
theta = np.pi / 180# theta的范围
threshold = 15# 累加器中的值高于它时才认为是一条直线
min_line_length = 40# 线的最短长度，比这个短的都被忽略
max_line_gap = 20# 两条直线之间的最大间隔，小于此值，认为是一条直线

# 设置高斯焦点核心大小
blur_ksize = 5  # Gaussian blur kernel size 高斯焦点核心大小

# 边缘检测：低阈值50，高阈值150。
# 用50和150，因为目标图片中的车道大致符合这个倾斜度
canny_lthreshold = 50  # Canny edge detection low threshold
canny_hthreshold = 150  # Canny edge detection high threshold

# 2. 定义各中函数

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
def draw_lanes(img, lines, color=[255, 0, 0], thickness=8):
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


# 3. 定义函数，完整调用图片的各阶段代码
def process_an_image(img):
  roi_vtx = np.array([[(0, img.shape[0]), (460, 325), (520, 325), (img.shape[1], img.shape[0])]])#目标区域的四个点坐标，roi_vtx是一个三维的数组
  gray = cv2.cvtColor(img, cv2.COLOR_RGB2GRAY)#图像转换为灰度图
  blur_gray = cv2.GaussianBlur(gray, (blur_ksize, blur_ksize), 0, 0)#使用高斯模糊去噪声
  edges = cv2.Canny(blur_gray, canny_lthreshold, canny_hthreshold)#使用Canny进行边缘检测
  roi_edges = roi_mask(edges, roi_vtx)#对边缘检测的图像生成图像蒙板，去掉不感兴趣的区域，保留兴趣区
  line_img = hough_lines(roi_edges, rho, theta, threshold, min_line_length, max_line_gap)#使用霍夫直线检测，并且绘制直线
  res_img = cv2.addWeighted(img, 0.8, line_img, 1, 0)#将处理后的图像与原图做融合
  return res_img


if __name__ == '__main__':
    # 在右侧，生成plots图
    import matplotlib.pyplot as plt
    import matplotlib.image as mplimg

    # 读取车道图片
    img = mplimg.imread('../resources/lane.jpg')
    print("start to process the image....")
    # 生成结果图
    res_img=process_an_image(img)
    print("show you the image....")
    plt.imshow(res_img)
    plt.show()
