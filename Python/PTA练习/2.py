# 本题要求实现一个函数，判断参数是否是质数，是的话返回True，否则返回False
# 注意：函数中要有异常处理，如果参数不是整数，返回False

import math
def isPrime(num):
    while True:
        try:
            # eval()函数将字符串str当成有效的表达式来求值并返回计算结果。
            if type(eval(num)) != int:
                return False
            else:
                break
        except:
            return False
    n = int(num)
    if n == 1:
        return False
    for i in range(2, int(math.sqrt(n) + 1)):  # 或者range(2, n)
        if n % i == 0:
            return False
    else:
        return True


num = input("请输入一个数据：")
if isPrime(num):
    print('yes')
else:
    print('no')