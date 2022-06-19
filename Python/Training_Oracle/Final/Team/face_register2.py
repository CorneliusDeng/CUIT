import cv2
# from PIL import ImageTk
from tkinter import Tk,Label,Entry,Button,messagebox
import database_concerned as ali

def tk():
    # 1. 创窗口
    tk = Tk()
    tk.title = "人脸注册"
    tk.geometry("800x100")
    tk.geometry("+300+300")

    # 添加窗口内容
    lable1 = Label(tk, text="用户名", fg="orange", font=("宋体", 30))
    lable1.grid(row=0, column=0)
    input1 = Entry(tk, font=("宋体", 25))
    input1.grid(row=0, column=1)
    button1 = Button(tk, text="开始脸部注册", font=("宋体", 30), command=lambda :regist(input1))
    button1.grid(row=0, column=2)

    tk.mainloop()

def regist(input1):
    name = input1.get()
    name.strip()
    if name =="":
        messagebox.showinfo("不对，重新输！")
    else:
        # 加载人脸分类器
        face = cv2.CascadeClassifier('E:\\haarcascade_frontalface_default.xml')
        # 打开摄像头
        capture = cv2.VideoCapture(0)
        # 获取摄像头画面
        print(name)
        while True:
            rect, img = capture.read()
            # 灰度
            im_g = cv2.cvtColor(img, cv2.COLOR_RGB2GRAY)
            # 调用方法
            faces = face.detectMultiScale(im_g, 1.1, 5)

            for (x, y, w, h) in faces:
                # 5个参数，一个参数图片 ，2 左上角坐标，3 右下角坐标原点，4，颜色 5，线宽
                cv2.rectangle(img, (x, y), (x + w, y + h), (255, 255, 0), 2)
            cv2.imshow('video', img)  # 显示

            if cv2.waitKey(20) & 0xFF == ord('q'):
                # 保存图片
                cv2.imwrite("{}.png".format(name), img)
                ali.face_check_insert("{}.png".format(name), name)
                messagebox.showinfo(title='注册信息', message='注册成功')
                break
                # cv2.waitKey(0)
        capture.release()
        cv2.destroyAllWindows()

if __name__ == '__main__':
    tk()