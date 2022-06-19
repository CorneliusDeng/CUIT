# 导入模块
import cv2

# 加载用于人脸、人眼识别的级联分类器文件
path1 = r'D:\\AllSourceCode\Python\Training_Oracle\venv\Lib\site-packages\cv2\data\haarcascade_frontalface_default.xml'
face = cv2.CascadeClassifier(path1)
path2 = r'D:\\AllSourceCode\Python\Training_Oracle\venv\Lib\site-packages\cv2\data\haarcascade_eye.xml'
eye = cv2.CascadeClassifier(path2)
# 打开摄像头
capture = cv2.VideoCapture(0)
# 获取摄像头画面
cv2.namedWindow('video')
while True:
    # 读取视频图片`
    ret, frame = capture.read()
    # 把截取的图片转化为灰度图
    gray = cv2.cvtColor(frame, cv2.COLOR_RGB2GRAY)
    # 在灰度图中检测人脸
    faces = face.detectMultiScale(gray, 1.1, 3, minSize=(100, 100), maxSize=(500, 500))
    # 在人链中画出矩形
    for (x, y, w, h) in faces:
       # 5个参数：参数1图片 ，参数2 左上角坐标，参数3 右下角坐标原点，参数4 颜色， 参数5 线宽
        img = cv2.rectangle(frame, (x, y), (x + w, y + h), (0, 255, 0), 2)
       # 在人脸的基础上识别眼睛
        face_gray = gray[y:y + h, x:x + w]
        face_color = img[y:y + h, x:x + w]
        # 眼睛识别
        eyes = eye.detectMultiScale(face_gray, 1.3, 5)
        # print("在这张脸上有%d个眼睛" % len(eyes))
        # 绘制出识别到的眼睛
        for (e_x, e_y, e_w, e_h) in eyes:
            cv2.rectangle(face_color, (e_x, e_y), (e_x + e_w, e_y + e_h), (0, 255, 0), 2)
    # 显示
    cv2.imshow('video', frame)
    # ord()返回对应的 ASCII 数值
    # waitKey()多少毫秒刷屏一次，返回按键的ASCII码
    # &：位与运算
    # 原来系统中按键对应的ASCII码值并不一定仅仅只有8位，
    # 同一按键对应的ASCII并不一定相同（但是后8位一定相同）
    # 引用&0xff，正是为了只取按键对应的ASCII值后8位

    if cv2.waitKey(20) & 0xFF == ord('q'):
        # 保存图片
        cv2.imwrite("../..//imgs/detect_face_eye_video.png", frame)
        break
# 释放资源
capture.release()
# 关闭窗口
cv2.destroyAllWindows()