# import csv
import pandas as pd
import numpy as np

# 判断是否为单位矩阵
def  identity_matrix(array, n):
    flag = 0
    for i in range(0,n-1):
        if (np.fabs(array[i][i] - 1) < 0.0000000001): # 主对角线上的数为浮点数，与1直接比较大小精度不够
            flag = 1
        else:
            return 0
    return flag

# list = []
# with open('D:\\AllSourceCode\\PythonSourceCode\\多元统计分析\\实验1\\test1-2.csv', 'r') as file:
#     reader = csv.reader(file)
#     for i, row in enumerate(reader):
#         list.append([float(row[0]), float(row[1]), float(row[2]), float(row[3])])

list = pd.read_csv('D:\\AllSourceCode\\PythonSourceCode\\多元统计分析\\实验1\\test1-2.csv')

D = np.array(list)  # 将得到的数组转换成矩阵
print('25x4的矩阵D：', '\n', D, '\n')

E = np.corrcoef(D.T)  # 求矩阵D的相关系数矩阵（4*4）E
print('矩阵D的相关系数矩阵（4*4）E', '\n', E, '\n')

F = np.cov(D.T)  # 求矩阵D的协方差矩阵（4*4）F
print('矩阵D的协方差矩阵（4*4）F', '\n', F, '\n')

eigenvalue_E, featurevector_E = np.linalg.eig(E)  # 求解矩阵E的特征值和特征向量
print('矩阵E的特征值=', eigenvalue_E, '\n', '矩阵E的特征向量为：', '\n', featurevector_E, '\n')

eigenvalue_F, featurevector_F = np.linalg.eig(F)  # 求解矩阵F的特征值和特征向量
print('矩阵F的特征值=', eigenvalue_F, '\n', '矩阵F的特征向量为：', '\n', featurevector_F, '\n')

flag1 = identity_matrix(np.dot(featurevector_E, featurevector_E.T), 4)
if flag1 == 1:
    print('矩阵E的特征向量矩阵是正交矩阵', '\n')
else:
    print('矩阵E的特征向量矩阵不是正交矩阵', '\n')

sum_E = 0
for i in eigenvalue_E:
    sum_E = sum_E + i
if (np.abs(sum_E - np.trace(E)) < 0.000000000001):
    print('矩阵E的特征值之和等于E的迹', '\n')
else:
    print('矩阵E的特征值之和不等于E的迹', '\n')

u,s,v = np.linalg.svd(D)
print('矩阵D的左奇异矩阵为：', '\n', u, '\n')
print('矩阵D的奇异值为：', s, '\n')
print('矩阵D的右奇异矩阵为', '\n', v, '\n')

flag2 = identity_matrix(np.dot(u, u.T), 25)
if flag2 == 1:
    print('矩阵D左奇异矩阵是正交矩阵', '\n')
else:
    print('矩阵D左奇异矩阵是正交矩阵', '\n')

flag3 = identity_matrix(np.dot(v, v.T), 4)
if flag3 == 1:
    print('矩阵D右奇异矩阵是正交矩阵', '\n')
else:
    print('矩阵D右奇异矩阵是正交矩阵', '\n')