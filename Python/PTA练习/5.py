# 本题要求实现一个统计整数中指定数字的个数的简单函数。
# CountDigit(number,digit )
# 其中number是整数，digit为[1, 9]区间内的整数。函数CountDigit应返回number中digit出现的次数。

def CountDigit(number, digit):
    number = str(number)
    digit = str(digit)
    count = 0
    for ch in number:
        if ch == digit:
            count += 1
    return count


number, digit = input().split()
number = int(number)
digit = int(digit)
count = CountDigit(number, digit)
print("Number of digit {0} in {1} ：{2}".format(digit, number, count))