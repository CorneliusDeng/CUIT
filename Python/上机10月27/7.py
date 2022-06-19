a = int(input("请输入被除数："))
b = int(input("请输入除数："))

assert b != 0, '除数不能为0'
c = a / b

print("运算结果是：", c)