import cv2
from PIL import ImageTk
from tkinter import Tk,Label,Entry,Button,messagebox
import tkinter
from tkinter import ttk
from tkinter import messagebox
from tkinter.simpledialog import *
from PIL import ImageTk, Image
""" 字体： 汉仪帅线体W   书体坊郭小语钢笔楷体 """


def regist():
    name = register().input1.get()
    name.strip()
    if name =="":
        messagebox.showinfo("不对，重新输！")
    else:
        # 根据不同地址修改即可
        # 加载人脸分类器
        face = cv2.CascadeClassifier('E:\\haarcascade_frontalface_default.xml')
        # 打开摄像头
        capture = cv2.VideoCapture(0, cv2.CAP_DSHOW)
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
                break
                # cv2.waitKey(0)
        capture.release()
        cv2.destroyAllWindows()


def register():
    # 1. 创窗口
    # tk = Tk()
    # tk.title = "人脸注册"
    # tk.geometry("800x100")
    # tk.geometry("+300+300")
    global fonts
    fonts = '汉仪帅线体W'

    # 初始化界面
    global root

    win_new = tkinter.Toplevel()
    win_new.geometry('920x750')
    win_new.title('Apriori --- 关联规则')
    win_new.configure(bg="#ebdac7")
    root = win_new
    root.title("人脸注册")
    root.geometry('780x480')
    # root.configure(bg="#98cccc")
    canvas = Canvas(root, width=1020, height=720, bd=0, highlightthickness=0)
    imgpath = 'background.jpg'
    img_bk = Image.open(imgpath)
    photo = ImageTk.PhotoImage(img_bk)
    # canvas.create_image(1020, 720, image=photo)
    canvas.pack(fill=tkinter.BOTH, expand=tkinter.YES)

    def changesize(event):
        image = ImageTk.PhotoImage(img_bk.resize((event.width, event.height), Image.ANTIALIAS))
        canvas.create_image(350, 250, image=photo)
        canvas.pack()

    # 添加窗口内容
    lable1 = Label(root,text = "用户名",fg = "orange",font = ("宋体",30))
    # lable1.grid(row=0,column = 0)
    input1 = Entry(root,font = ("宋体",25))
    # input1.grid(row=0,column = 1)
    button1 = Button(root,text = "开始脸部注册",font = ("宋体",30),command = regist)
    # button1.grid(row = 0,column = 2)
    lable1.place(x=200, y=150)
    input1.place(x=200, y=220)
    button1.place(x=200, y=280)

    canvas.bind('<Configure>', changesize)
    root.mainloop()