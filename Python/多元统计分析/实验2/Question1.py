import csv
import numpy as np
from scipy.stats import pearsonr
import statsmodels.api as sm
from math import sqrt

# 计算x3与x1、x2的偏相关系数
def PartialCorr(x1, x2, x3):
    r12 = pearsonr(x1, x2)[0]  # 返回两个值，r:相关系数 [-1，1]之间，p-value:p值。
    r13 = pearsonr(x1, x3)[0]
    r23 = pearsonr(x2, x3)[0]
    return (r12 - r13*r23) / (sqrt(1 - r13**2) * sqrt(1 - r23**2))

x = []  # 自变量
x = []  # 自变量
y = []  # 因变量
arg_names = []  # 变量名

with open('D:\\AllSourceCode\\PythonSourceCode\\多元统计分析\\实验2\\test2-1.csv', 'r', encoding='UTF-8') as f:
    reader = csv.reader(f)
    for i, row in enumerate(reader):
        if i != 0:
            y.append(int(row[1]))
            x.append(row[2:6])
        else:
            arg_names = row[2:6]

# 将读取进来的字符串数据转换为int型
for i in range(len(x)):
    for j in range(len(x[i])):
        x[i][j] = int(x[i][j])

data_x = np.array(x)
data_y = np.array(y)

# 相关系数
print('相关系数:')
xT = data_x.T
for i in range(len(xT)):
    print('y与', arg_names[i], '相关系数=', pearsonr(xT[i], data_y)[0])

# 偏相关系数
print('偏相关系数:')
for i in range(len(xT)):
    for j in range(1, len(xT)-i):
        print('y与变量', arg_names[i], '和', arg_names[i+j], '偏相关系数=', PartialCorr(xT[i], xT[i+j], data_y))

# 多元回归方程
x = sm.add_constant(x)
model = sm.OLS(y, x).fit()
print(model.summary())