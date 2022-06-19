# 总结 斐波那契数列
# 右对齐用>,左对齐用<


def fib_recur(n):
    if n == 1 or n == 2:
        return 1
    return fib_recur(n-1)+fib_recur(n-2)


def fib(n):
    a, b = 1, 1
    if n <= 2:
        return 1
    else:
        for i in range(1, n - 1):
            a, b = b, a + b
        return b


print("递归算法")
for i in range(1, 21):
    print(str.format("{0:>5}", fib_recur(i)), end='')
    if i % 10 == 0:
        print()

print()
print("递推算法")
for i in range(1, 21):
    print(str.format("{0:>5}", fib(i)), end='')
    if i % 10 == 0:
        print()