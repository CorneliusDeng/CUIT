import cv2 as cv
# if __name__ == '__main__':
#     # 读取图片
#     src = cv.imread("../imgs/a.png")
#     # 设置窗口的名字和大小
#     cv.namedWindow("loading picture", cv.WINDOW_AUTOSIZE)
#     # 显示图片
#     cv.imshow("loading picture", src)
#     # 图像类别
#     print(type(src))
#     # 图片形状
#     print(src.shape)
#     # 每个像素点所占字节位数
#     print(src.dtype)
#     # 等待操作
#     cv.waitKey(0)
#     # 退出
#     cv.destroyWindow()

# 从视频中截取图片
# def video_demo():
#     # 打开0号摄像头，捕捉该摄像头实时信息
#     # 参数0代表摄像头的编号
#     # 有多个摄像头的情况下，可用编号打开摄像头
#     # 若是加载视频，则将参数改为视频路径，cv.VideoCapture加载视频是没有声音的，OpenCV只对视频的每一帧进行分析
#     capture = cv.VideoCapture(0)
#     while (True):
#         # 获取是否有视频的返回值 ref
#         # 视频中的每一帧 frame
#         ref, frame = capture.read()
#
#         # 加入该段代码将使拍出来的画面呈现镜像效果
#         # 第二个参数为视频是否上下颠倒 0为上下颠倒 1为不进行上下颠倒
#         frame = cv.flip(frame, 1)
#
#         # 将每一帧在窗口中显示出来
#         cv.imshow("video", frame)
#
#         # 设置视频刷新频率，单位为毫秒
#         # 返回值为键盘按键的值
#         c = cv.waitKey(50)
#
#         # 27为 Esc 按键的返回值
#         if c == 27:
#             cv.imwrite('video.jpg', frame)
#             break
# if __name__ == '__main__':
#     video_demo()

# 图像取反
# def access_pixel(image):
#     """访问图像所有的像素"""
#     print(image.shape)
#
#     # 获取图像的高度，图像的高度为shape的第一个值（维度）
#     height = image.shape[0]
#     # 获取图像的宽读，图像的宽度为shape的第二个值（维度）
#     width = image.shape[1]
#     # 获取图像通道数目，图像的通道数目为shape的第三个值（维度）
#     # 加载进来的图像都有三个通道，三个通道是图像的RGB
#     channels = image.shape[2]
#     print("width: %s,height: %s channels: %s" % (width, height, channels))
#
#     # 方法1：循环获取每个像素点，并且修改，然后存储修改后的像素点.时间复杂度O(n*3)，特别慢
#     # for row in range(height):
#     #     for col in range(width):
#     #         for c in range(channels):
#     #             pv = image[row, col, c]
#     #             image[row, col, c] = 255 - pv
#     # 方法2
#     image = cv.bitwise_not(image)
#
#     # 输出的是一个呈现负片效果的图片
#     cv.imshow("pixels_demo", image)
# if __name__ == '__main__':
#     # 读入图片文件
#     src = cv.imread('../imgs/a.jpg')
#     # 获取cpu当前时钟总数
#     t1 = cv.getTickCount()
#     access_pixel(src)
#     t2 = cv.getTickCount()
#     # 计算处理像素花费的时间
#     # cv.getTickFrequency() 每秒的时钟总数
#     time = ((t2 - t1) / cv.getTickFrequency())
#     print("time: %s s" % time)
#     # 等待用户操作
#     cv.waitKey(0)
#     # 释放所有窗口
#     cv.destroyAllWindows()

# 翻转图片
# if __name__ == '__main__':
#     image = cv.imread("../imgs/a.png")
#     image1 = cv.flip(image, 1)  # 水平翻转
#     image2 = cv.flip(image, 0)  # 垂直翻转
#     image3 = cv.flip(image, -1)  # 水平垂直翻转
#     cv.imshow("origin", image)
#     cv.imshow("level", image1)
#     cv.imshow("vertical", image2)
#     cv.imshow("level_vertical", image3)
#     cv.waitKey(0)

# 转换图片灰度图
if __name__ == '__main__':
    img = cv.imread('../imgs/a.jpg', 0)
    cv.imshow("des", img)
    cv.waitKey(0)
    cv.destroyAllWindows()
