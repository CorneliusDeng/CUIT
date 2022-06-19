# 目标1：读取图片
# 目标2：转换为灰色的图片
# 目标3: 高斯平滑，去除多余噪点
# 目标4：边缘检测，根据倾斜度检测
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