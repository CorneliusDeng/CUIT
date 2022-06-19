import tkinter
from tkinter import messagebox

class Login(object):
    def __init__(self):
        # 创建主窗口,用于容纳其它组件
        self.root = tkinter.Tk()
        # 给主窗口设置标题内容
        self.root.title("tkinter_practice")
        # 可以通过geometry函数来设置窗口的宽和高
        self.root.geometry('400x300')
        #  创建画布
        self.canvas = tkinter.Canvas(self.root, height=200, width=500)
        # 加载图片文件
        self.image_file = tkinter.PhotoImage(file='../imgs/digit.png')
        # 将图片置于画布上
        # (0,0）当anchor=NW则指定的是图片的左上角的位置。n北 s南 w西 e东 center中心 nw西北 ne东北 sw西南 se东南
        self.image = self.canvas.create_image(0, 0, anchor='nw', image=self.image_file)
        # 放置画布（为上端）
        self.canvas.pack(side='top')
        # 创建一个`label`名为`Account: `
        self.label_account = tkinter.Label(self.root, text='Account: ')
        # 创建一个`label`名为`Password: `
        self.label_password = tkinter.Label(self.root, text='Password: ')
        # 创建一个账号输入框,并设置尺寸
        self.input_account = tkinter.Entry(self.root, width=30)
        # 创建一个密码输入框,并设置尺寸
        self.input_password = tkinter.Entry(self.root, show='*', width=30)
        # 创建一个登录系统的按钮
        self.login_button = tkinter.Button(self.root, command=self.login, text="Login", width=10)
        # 创建一个注册系统的按钮
        self.siginUp_button = tkinter.Button(self.root, command=self.regist, text="Sign up", width=10)

        # 完成布局

    def gui_arrang(self):
        self.label_account.place(x=60, y=170)
        self.label_password.place(x=60, y=195)
        self.input_account.place(x=135, y=170)
        self.input_password.place(x=135, y=195)
        self.login_button.place(x=140, y=235)
        self.siginUp_button.place(x=240, y=235)

    # 进入注册界面
    def regist(self):
        tkinter.messagebox.showinfo(title='图片资源管理系统', message='进入注册界面')

    # 进行登录信息验证
    def login(self):
        account = self.input_account.get().ljust(10, " ")
        password = self.input_password.get().ljust(10, " ")
        if account.strip() == "admin" and password.strip() == "123456":
            tkinter.messagebox.showinfo(title='登录信息', message='登录成功')
        else:
            tkinter.messagebox.showinfo(title='登录信息', message='登录失败')

if __name__ == '__main__':
    # 初始化对象
    L = Login()
    # 进行布局
    L.gui_arrang()
    # 主程序执行
    tkinter.mainloop()