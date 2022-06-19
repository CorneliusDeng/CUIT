j = 0
print("100~200之间不能被3整除的数为：")
for i in range(100, 200 + 1):
    if i % 3 == 0:
        continue   # 跳过被3整除的数
    print(str.format("{0:<5}", i), end="")   # 每个数占五个位置，不足的后面补空格，并且不换行

    j += 1
    if j % 10 == 0:
        print()    #
          # 一行显示十个数