# Python中的选择循环语句可以不要括号，但是冒号不能省略
import random

n1 = random.randint(0, 100)
n2 = random.randint(0, 100)
print("整数1={0}，整数2={1}".format(n1, n2))
na = n1
nb = n2
r = 1
# 辗转相除法
if na == 0 or nb == 0:
    print("数据错误")
else:
    while r != 0:
        if n2 > n1:
            n1, n2 = n2, n1  # 交换位置
        r = n1 % n2
        n1 = n2
        n2 = r
    n = int((na * nb) / n1)
    print("最大公约数是{0}，最小公倍数是{1}".format(n1, n))