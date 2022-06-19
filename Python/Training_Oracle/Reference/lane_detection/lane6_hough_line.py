# 目标1：读取图片
# 目标2：转换为灰色的图片
# 目标3: 高斯平滑，去除多余噪点
# 目标4：边缘检测，根据倾斜度检测
# 目标5：得到关注区域的边缘检测图
# 目标6：通过霍夫变换，得到符合要求线

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

# 定义霍夫线函数，调用上面绘制线的方法，传入参数，绘制霍夫线
def hough_lines(img, rho, theta, threshold,
                min_line_len, max_line_gap):
  # 各种参数，生成线和线的图片
  lines = cv2.HoughLinesP(img, rho, theta, threshold, np.array([]),
                          minLineLength=min_line_len,
                          maxLineGap=max_line_gap)
  line_img = np.zeros((img.shape[0], img.shape[1], 3), dtype=np.uint8)
  # 调用上面绘制线的方法，进行处理
  draw_lines(line_img, lines)
  return line_img

# 调用霍夫线函数，并传入上阶段产生的线条不连续的车道图，生成基于霍夫线推断出来的车道图
line_img = hough_lines(roi_edges, rho, theta, threshold,
                       min_line_length, max_line_gap)

# 输出这张图片——获得基于上一张图片-不连续的车道图——————》红色的去噪点车道图，仍是不连续的
cv2.imwrite('../resources/lane6_hough_line.jpg', line_img)