# datetime.date.today().year返回的类型是整型的，需要让输入的year转换为int型才能参与计算
import datetime

name = input("请输入您的姓名：")
year = int(input("请输入您的出生年份："))
yearnow = datetime.date.today().year
age = yearnow - year
print("您好！{0}。您今年{1}岁".format(name, age))