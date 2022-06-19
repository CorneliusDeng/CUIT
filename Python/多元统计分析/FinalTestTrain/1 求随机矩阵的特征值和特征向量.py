# 输入25个整型数据，然后将其转换为5X5的矩阵，求其特征值及特征向量，正确的输入格式请见样例，
# 若输入的格式不是int型或者输入个数不对，输出：输入有错！

# 输入样例
# 1 2 3 4 5 6 7 8 9 10 1 2 1 3 14 12 12 14 1 4 5 7 8 9 23

import numpy as np
try:
    l = input().split(" ")
    num = list(map(int,l))
    A = np.array(num).reshape(5, 5)
    a, b = np.linalg.eig(A)
    print(a,"\n",b)

except:
    print("输入有错！")