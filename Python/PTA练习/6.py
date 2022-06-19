# 本题要求实现一个计算Fibonacci数的简单函数，并利用其实现另一个函数,
# 输出两正整数m和n（0<m<n≤100000）之间的所有Fibonacci数的数目。
# 所谓Fibonacci数列就是满足任一项数字是前两项的和（最开始两项均定义为1）的数列,
# fib(0)=fib(1)=1。其中函数fib(n)须返回第n项Fibonacci数；
# 函数PrintFN(m,n)用列表返回[m, n]中的所有Fibonacci数。


def fib(n):
    if n == 0 or n == 1:
        return 1
    else:
        return fib(n-1) + fib(n-2)


def PrintFN(m,n):
    li = []
    for i in range(0, 25): # fib(24) = 75025
        if m <= fib(i) <= n:
            li.append(fib(i))
    return li


m, n, i = input().split()
n = int(n)
m = int(m)
i = int(i)
b = fib(i)
print("fib({0}) = {1}".format(i, b))
fiblist = PrintFN(m, n)
print(len(fiblist))