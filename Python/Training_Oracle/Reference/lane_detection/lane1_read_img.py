# 目标1：读取图片
import matplotlib.image as mplimg
import cv2

# 通过opencv读取到图片后，都是BGR
img = mplimg.imread('../resources/lane.jpg')
# 输出这张图片
cv2.imwrite('../resources/lane1_read_img.jpg', img)