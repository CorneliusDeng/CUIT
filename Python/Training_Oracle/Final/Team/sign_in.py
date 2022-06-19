import tkinter
from tkinter import ttk, CENTER
from tkinter import messagebox
from tkinter.simpledialog import *
from PIL import ImageTk, Image
""" 字体： 汉仪帅线体W   书体坊郭小语钢笔楷体 """
from login import Face_login
from face_register2 import tk
from register import usr_sign_up
import database_concerned as ali
import pymysql
from database_concerned import text_check_insert,text_check_select




def menu():
    """
    生成菜单页面
    """

    global fonts
    fonts = ('汉仪帅线体W', 12)

    # 初始化界面
    global root
    root = tkinter.Tk()
    root.title("登录系统")
    root.geometry('780x480')
    # root.configure(bg="#98cccc")
    canvas = tkinter.Canvas(root, width=1020, height=720, bd=0, highlightthickness=0)
    imgpath = 'background.jpg'
    img = Image.open(imgpath)
    photo = ImageTk.PhotoImage(img)
    # canvas.create_image(1020, 720, image=photo)
    canvas.pack(fill=tkinter.BOTH,expand=tkinter.YES)

    def changesize(event):
        image = ImageTk.PhotoImage(img.resize((event.width,event.height),Image.ANTIALIAS))
        canvas.create_image(350, 250, image=photo)
        canvas.pack()

    # 进入注册界面
    def regist():
        # tkinter.messagebox.showinfo(title='图片资源管理系统', message='进入注册界面')
        tk()

    # 进行登录信息验证
    def login():
        account = input_account.get().ljust(10, " ")
        password = input_password.get().ljust(10, " ")
        check_pwd = text_check_select(account.strip())
        if password.strip() == check_pwd:
            tkinter.messagebox.showinfo(title='登录信息', message='登录成功')
        else:
            tkinter.messagebox.showinfo(title='登录信息', message='登录失败')

    canvas.bind('<Configure>', changesize)
    # 把Label组件放置于窗体上，两个方向都填满，并根据窗体大小自动缩放lbPic.pack(fill=tkinter.BOTH,expand=tkinter.YES)
    label_account = tkinter.Label(root, text='账号: ', heigh=1, width=6, font=fonts, justify=CENTER, anchor="center",
                                  bg="#ccffcc", borderwidth=1)
    # 创建一个`label`名为`Password: `
    label_password = tkinter.Label(root, text='密码: ', heigh=1, width=6, font=fonts, justify=CENTER, anchor="center",
                                   bg="#ccffcc", borderwidth=1)
    # 创建一个账号输入框,并设置尺寸
    input_account = tkinter.Entry(root, width=32)
    # 创建一个密码输入框,并设置尺寸
    input_password = tkinter.Entry(root, show='*', width=32)

    # 创建一个登录系统的按钮
    login_button = tkinter.Button(root, command=login, text="Login", width=10, font=fonts, justify=CENTER,
                                  anchor="center", bg="#ccffcc", borderwidth=1)
    # 创建一个注册系统的按钮
    siginUp_button = tkinter.Button(root, command=usr_sign_up, text="Sign up", width=10, font=fonts, justify=CENTER,
                                    anchor="center", bg="#ccffcc", borderwidth=1)
    # 人脸登录按钮
    face_login_button = tkinter.Button(root, command=Face_login, text="Face Login", width=10, font=fonts,
                                       justify=CENTER, anchor="center", bg="#ccffcc", borderwidth=1)
    label_account.place(x=200, y=170)
    label_password.place(x=200, y=195)
    input_account.place(x=300, y=170)
    input_password.place(x=300, y=195)
    login_button.place(x=250, y=235)
    siginUp_button.place(x=350, y=235)
    face_login_button.place(x=450, y=235)

    root.mainloop()


if __name__ == '__main__':
    menu()
