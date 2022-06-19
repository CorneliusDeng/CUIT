a = int(input("请输入整数a："))
b = int(input("请输入整数b："))

assert b != 0, "除数不能为0"
c = a / b
print(str.format("{0} / {1} = {2}", a, b, c))
# 运行选项里面的Interpreter options：-O就是优化模式