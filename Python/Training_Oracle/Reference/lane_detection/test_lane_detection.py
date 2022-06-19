# 调用函数，测试车道识别
from lane_detection import process_an_image

# 在右侧，生成plots图
import matplotlib.pyplot as plt
import matplotlib.image as mplimg

#读取车道图片
img = mplimg.imread('../resources/lane.jpg')
print("start to process the image....")
# 生成结果图
res_img=process_an_image(img)
print("show you the image....")
plt.imshow(res_img)
plt.show()