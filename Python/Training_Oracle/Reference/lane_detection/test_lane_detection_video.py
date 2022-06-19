# 最终目标：测试车道视频识别
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

# 生成视频
from moviepy.editor import VideoFileClip
clip = VideoFileClip("../resources/video_2.mp4")#input video
output = '../resources/video_2_out.mp4' #ouput video
out_clip = clip.fl_image(process_an_image)# 对视频的每一帧进行处理
# 将处理后的视频写入新的视频文件，并且不保存音频
# audio可以为True、False或文件名
# 如果True且剪辑附加了音频，则音频将作为视频的音频保存
# 如果为False则不保存音频
# 如果为音频文件名,则将此音频文件将作为视频的音频
out_clip.write_videofile(output, audio=False)
