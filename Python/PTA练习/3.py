# 给定两个均不超过9的正整数a和n，要求编写函数fn(a,n)
# 求a+aa+aaa++⋯+aa⋯aa(n个a）之和，fn须返回的是数列和


def fn(a, n):
    sum = li = 0
    for i in range(1, n + 1):
        sum += a
        a *= 10
        li += sum
    return li

a, b = input().split()
s = fn(int(a), int(b))
print(s)