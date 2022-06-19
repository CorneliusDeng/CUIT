from idlelib import window
from tkinter.messagebox import showinfo
import cv2 as cv
import database_concerned as ali

from tkinter import Tk, Label, Entry, Button, messagebox
import requests
import tkinter

from PIL import ImageTk, Image


def getface():
    capture = cv.VideoCapture(0, cv.CAP_DSHOW)
    while True:
        ref, frame = capture.read()
        frame = cv.flip(frame, 1)
        # 显示
        cv.imshow("video",frame)
        if cv.waitKey(20) & 0xFF == ord('q'):
            cv.imwrite("login.png", frame)
            break
    capture.release()
    cv.destroyAllWindows()

def check(input1):
    if input1.get() == "":
        showinfo(title="输入失败", message="用户名不能为空")
    else:
        getface()
        ali.face_check_insert('login.png', 'login')
        img_url1 = ali.face_check_select('login')
        img_url2 = ali.face_check_select(input1.get())

        url = "https://api-cn.faceplusplus.com/facepp/v3/compare"
        requestData = {'api_key': 'OVHDatOz2oMDzUPFt72QMvJydexI0gPN',
                       'api_secret': 'NTJRr0ZloCFf5NnvjSTgjTzwRZCGwtj1',
                       "image_url1": img_url1,
                       "image_url2": img_url2}
        # 发送请求
        ret = requests.post(url=url, data=requestData).json()
        print("人脸相似度：{}".format(ret["confidence"]))
        # 打印结果
        if ret["confidence"] >= 85:
            showinfo(title="成功", message="人脸登录成功")
        else:
            showinfo(title="失败", message="人脸登录失败")


def Face_login():
    # 创建窗口
    tk = Tk()
    tk.title = "人脸登录"
    tk.geometry("800x100")
    tk.geometry("+300+300")

    # 添加窗口内容
    lable1 = Label(tk, text="用户名", fg="orange", font=("宋体", 30))
    lable1.grid(row=0, column=0)
    input1 = Entry(tk, font=("宋体", 25))
    input1.grid(row=0, column=1)
    button1 = Button(tk, text="开始脸部检测", font=("宋体", 30), command=lambda :check(input1))
    button1.grid(row=0, column=2)


if __name__ == '__main__':
    # # 1. 创窗口
    # tk = Tk()
    # tk.title = "登录"
    # tk.geometry("800x300")
    # tk.geometry("+300+300")
    #
    # # 添加窗口内容
    # lable1 = Label(tk, text="登录", fg="orange", font=("宋体", 30))
    # lable1.grid(row=0, column=0)
    # button1 = Button(tk, text="人脸登录", font=("宋体", 30), command=login)
    # button1.grid(row=1, column=0)

    global fonts
    fonts = '汉仪帅线体W'

    # 初始化界面
    global root
    root = Tk()
    root.title("算法功能演示")
    root.geometry('780x480')
    # root.configure(bg="#98cccc")
    canvas = tkinter.Canvas(root, width=1020, height=720, bd=0, highlightthickness=0)
    imgpath = 'background.jpg'
    img = Image.open(imgpath)
    photo = ImageTk.PhotoImage(img)
    # canvas.create_image(1020, 720, image=photo)
    canvas.pack(fill=tkinter.BOTH, expand=tkinter.YES)

    def changesize(event):
        image = ImageTk.PhotoImage(img.resize((event.width, event.height), Image.ANTIALIAS))
        canvas.create_image(350, 250, image=photo)
        canvas.pack()
    lable1 = Label(root, text="登录", fg="orange", font=("宋体", 30))

    # lable1.grid(row=0, column=0)
    button1 = Button(root, text="人脸登录", font=("宋体", 30), command=Face_login)
    # button1.grid(row=1, column=0)
    lable1.place(x=200, y=170)
    button1.place(x=200, y=195)
    canvas.bind('<Configure>', changesize)



    root.mainloop()


    # Tk.mainloop()
