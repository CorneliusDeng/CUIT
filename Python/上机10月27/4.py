num = 0
sum = 0
argv = 0
while True:
    a = int(input("请输入数据：（输入-1结束）:"))
    if a == -1:
        break
    num += 1
    sum += a
    argv = sum / num
print("输入的元素个数是", num)
print("其总和为", sum)
print("其平均数为", argv)