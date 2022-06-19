# 目标1：读取图片
# 目标2：转换为灰色的图片
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
