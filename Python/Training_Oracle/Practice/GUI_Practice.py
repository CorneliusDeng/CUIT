from tkinter import Tk, Label, Entry, Button, messagebox
from PIL import ImageTk
import requests
from bs4 import  BeautifulSoup

def submit():
    # 获取输入框的内容
    name = input1.get()
    # 去掉左右两边的空格
    name = name.strip()
    if name == "":
        messagebox.showinfo("提示", "内容不能为空")
    else:
        datax = {
            "word": name,
            "sizes": 50,
            "fonts": "lfc.ttf",
            "fontcolor": "#000000"
        }
        # 1、通过request对象爬取网页内容
        response = requests.post("http://www.uustv.com/", data=datax)
        response.encoding = "utf-8"
        text = response.text
        # 2、从网页内容中解析出需要的内容
        soup = BeautifulSoup(text, "html.parser")
        img = soup.select(".tu img")[0]
        # 3、拿到图片的地址
        img_url = "http://www.uustv.com/" + img.attrs['src']
        # 4、调用get方法，获取这个图片的内容
        img_content = requests.get(img_url).content
        # 5、把图片内容写入文件
        ff = open('{}.gif'.format(name), "wb")
        ff.write(img_content)
        # 6、在对话框中创建一个图片
        image1 = ImageTk.PhotoImage(file="{}.gif".format(name))
        label2 = Label(tk, image=image1)
        label2.bitmap = image1
        label2.grid(row=2, columnspan=3)


if __name__ == '__main__':
    # 1、创建窗口
    tk = Tk()
    # 标题
    tk.title("python GUI编程实训-tkinter应用")
    # 窗口的宽度和高度,长高用小写x隔开
    tk.geometry("600x400")
    # 窗口的位置：+x轴+y轴
    tk.geometry("+400+200")

    # 2、创建一个label
    label1 = Label(tk, text="签名", fg="red", font=("宋体", 30))
    label1.grid(row=0, column=0)

    # 3、创建一个输入框
    input1 = Entry(tk, font=("宋体", 20))
    input1.grid(row=0, column=1)

    # 4、创建一个按钮
    btn1=Button(tk, text="确定", font=("宋体", 30), command=submit)
    btn1.grid(row=0, column=2)

    # 5、默认图
    image1 = ImageTk.PhotoImage(file="../imgs/b_china.png")
    label2 = Label(tk, image=image1)
    label2.grid(row=2, columnspan=3)

    # 消息循环 显示窗口
    tk.mainloop()
