# 使用函数求素数和
# prime(p), 其中函数prime当用户传入参数p为素数时返回True，
# 否则返回False. PrimeSum(m,n),函数PrimeSum返回区间[m, n]内所有素数的和。题目保证用户传入的参数1<=m<n。

def prime(p):
    p = int(p)
    for i in range(2,p):
        if p % i == 0:
            return False
    if p != 1:
        return True

def PrimeSum(m,n):
    sum = 0
    for i in range(m,n+1):
        if prime(i):
            sum += i
    return sum

m, n = input().split()
m = int(m)
n = int(n)
print(PrimeSum(m, n))