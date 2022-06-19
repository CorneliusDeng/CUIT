# range(start, stop, step)  strp步长可不要，前闭后开区间

for i in range(1, 11):
    print(i, end=' ')  # 加个end，让输出在同一行
print()
for i in range(1, 11, 3):
    print(i, end=' ')  #间隔为3