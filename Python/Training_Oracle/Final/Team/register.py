import json
import tkinter
import tkinter.messagebox
import pickle
from idlelib import window
import cv2
# from PIL import ImageTk
from tkinter import Tk,Label,Entry,Button,messagebox
import database_concerned as ali
import pymysql
from database_concerned import text_check_insert,text_check_select

# 登录函数
import cv2

# 检测人脸的分类器的根目录
import requests
# 注册函数
def usr_sign_up():
    #人脸注册
    def regist():
        name = new_name.get()
        print(name)
        if name == "":
            messagebox.showinfo("不对，重新输！")
        else:
            # 加载人脸分类器
            path = r'D:\\AllSourceCode\Python\Training_Oracle\venv\Lib\site-packages\cv2\data\haarcascade_frontalface_default.xml'
            face = cv2.CascadeClassifier(path)
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
    # 确认注册时的相应函数
    def signtowcg():
        # 获取输入框内的内容
        nn = new_name.get()
        np = new_pwd.get()
        npf = new_pwd_confirm.get()

        if np != npf:
            tkinter.messagebox.showerror('错误', '密码前后不一致')
        elif np == '' or nn == '':
            tkinter.messagebox.showerror('错误', '用户名或密码为空')
        else:
            # 本地加载已有用户信息,如果没有则已有用户信息为空
            try:
                results =text_check_select(nn)
                if results:
                    tkinter.messagebox.showerror('错误', '用户名已存在')
                else:
                    # 执行SQL语句
                    text_check_insert(str(nn), str(np))
                    tkinter.messagebox.showinfo('欢迎', '注册成功')
                    # 注册成功关闭注册框
                    window_sign_up.destroy()
            except:
                print('Uable to fetch data!')

    # 新建注册界面
    global window_sign_up
    window_sign_up = tkinter.Tk()
    window_sign_up.geometry('350x200')
    window_sign_up.geometry("+700+400")
    window_sign_up.title('注册')
    # 用户名变量及标签、输入框
    tkinter.Label(window_sign_up, text='用户名：').place(x=10, y=10)
    new_name =tkinter.Entry(window_sign_up)
    new_name.place(x=150, y=10)
    # 密码变量及标签、输入框
    tkinter.Label(window_sign_up, text='请输入密码：').place(x=10, y=50)
    new_pwd =tkinter.Entry(window_sign_up,show='*')
    new_pwd .place(x=150, y=50)
    # 重复密码变量及标签、输入框
    tkinter.Label(window_sign_up, text='请再次输入密码：').place(x=10, y=90)
    new_pwd_confirm=tkinter.Entry(window_sign_up,  show='*')
    new_pwd_confirm.place(x=150, y=90)
    # 人脸录入
    tkinter.Label(window_sign_up, text='请进行人脸录入：').place(x=10, y=130)
    bt_photo_sign_up = tkinter.Button(window_sign_up, text='录入',command=regist)
    bt_photo_sign_up.place(x=150, y=130)
    # 确认注册按钮及位置
    bt_confirm_sign_up = tkinter.Button(window_sign_up, text='确认注册',
                                   command=signtowcg)
    bt_confirm_sign_up.place(x=150, y=170)
    tkinter.mainloop()


# 退出的函数
def usr_sign_quit():
    window.destroy()

if __name__ == '__main__':
    usr_sign_up()