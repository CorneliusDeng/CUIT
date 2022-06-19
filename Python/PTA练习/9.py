# 输入一行字符串及下标，能取出相应字符。程序能对不合法数据做相应异常处理

try:
    s = input("请输入一行字符串：")
    index = input("请输入下标：")
    print("{0}".format(s[int(index)]))
except ValueError:
    print("下标要整数")
except IndexError:
    print("下标越界")