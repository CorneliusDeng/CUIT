import numpy as np

# 判断一个矩阵是否为单位矩阵
def  identity_matrix(array, n):
    flag = 0
    for i in range(0,n-1):
        if (np.fabs(array[i][i] - 1) < 0.0000000001): # 主对角线上的数为浮点数，与1直接比较大小精度不够
            flag = 1
        else:
            return 0
    return flag

dataA = np.array([[-1, 3, 2], [5, 7, -2], [-3, 0, 1]])
dataB = np.array([[8, 2, -1], [6, 4, 0], [-2, 3, 5]])
print('A+B:', '\n', dataA + dataB, '\n')
print('A-B:', '\n', dataA - dataB, '\n')
print('A*B:', '\n', np.dot(dataA, dataB), '\n')
print('A·B:', '\n', dataA * dataB, '\n')  # 矩阵AB点乘
dataC = np.array(np.dot(dataA, dataB))
print('C=A*B的逆矩阵', '\n', np.linalg.inv(dataC), '\n') # 矩阵C求逆
print('C=A*B的行列式', '\n', np.linalg.det(dataC), '\n') # 矩阵C的行列式

dataD = np.array(np.dot(dataC, np.linalg.inv(dataC)))
flag = identity_matrix(dataD, 3)
if flag == 1:
    print('C和C的逆矩阵之积为单位矩阵')
else:
    print('C和C的逆矩阵之积不为单位矩阵')

