# 导入模块
import cv2

def detect(filename):
    # 加载人脸、眼睛检测级联分类器
    face_cascade = cv2.CascadeClassifier(cascade_path + '\haarcascade_frontalface_default.xml')
    eyes_xml = cv2.CascadeClassifier(eyes_path + '\haarcascade_eye.xml')

    # 读取图片（读进来直接是BGR 格式数据）
    img = cv2.imread(filename)
    # cv2.cvtColor(p1,p2) 是颜色空间转换函数，p1是需要转换的图片，p2是转换成何种格式,将BGR格式转换成灰度图片
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    # detectMultiScale函数
    # 参数image--待检测图片，一般为灰度图像加快检测速度；
    # 参数scaleFactor--表示在前后两次相继的扫描中，搜索窗口的比例系数。默认为1.1即每次搜索窗口依次扩大10%;
    # 参数minNeighbors--表示构成检测目标的相邻矩形的最小个数(默认为3个),即矢量方向（多元函数求偏导）
    faces = face_cascade.detectMultiScale(gray, 1.3, 3)
    for (x, y, w, h) in faces:
        # 绘制人脸矩形（图片，左上角，右下角，样色，边框的宽度)
        img = cv2.rectangle(img, (x, y), (x + w, y + h), (255, 255, 0), 2)
        # 绘制人脸圆形
        # img = cv2.circle(img, (x+int(w/2), y+int(h/2)), int(w/2), (255, 255, 0))
        # 在人脸的基础上识别眼睛
        face_gray = gray[y:y + h, x:x + w]
        face_color = img[y:y + h, x:x + w]
        # 眼睛识别
        eyes = eyes_xml.detectMultiScale(face_gray, 1.3, 5)
        print("在这张脸上有%d个眼睛" % len(eyes))
        # 绘制出识别到的眼睛
        for (e_x, e_y, e_w, e_h) in eyes:
            cv2.rectangle(face_color, (e_x, e_y), (e_x + e_w, e_y + e_h), (0, 255, 0), 2)

    # 新建一个显示窗口
    cv2.namedWindow("faces detected")
    # 显示图片
    cv2.imshow("faces detected", img)
    # waitKey()函数的功能是不断刷新图像，频率为delay，单位是ms, delay:为0时，则会一直显示这一帧, 必须有键按下才继续往下执行。
    cv2.waitKey(0)

if __name__ == '__main__':
    # 图片
    file = '../../imgs/eyes4.jpeg'
    # 检测人脸的分类器的根目录
    cascade_path = r'D:\\AllSourceCode\Python\Training_Oracle\venv\Lib\site-packages\cv2\data'
    eyes_path = r"D:\\AllSourceCode\Python\Training_Oracle\venv\Lib\site-packages\cv2\data"
    detect(file)


