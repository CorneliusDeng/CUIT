import csv
import numpy as np
from scipy.stats import f as F #引入F分布

# 读取csv文件
list = []
with open('D:\\AllSourceCode\\PythonSourceCode\\多元统计分析\多元均值检验，协方差阵未知\\4-3.csv', 'r') as file:
    reader = csv.reader(file)
    for i, row in enumerate(reader):
        if(i != 0): # 不取列名，把第一列的省名也省略
            list.append([float(row[1]), float(row[2]), float(row[3]), float(row[4]), float(row[5])])

data = np.array(list) # 将得到的5x9数组转换成矩阵
n = len(data) # 样本总数 9
p = 5 # 变量数 5
# 计算均值向量
# axis=0，那么输出矩阵是1行，求每一列的平均（按照每一行去求平均）；axis=1，输出矩阵是1列，求每一行的平均（按照每一列去求平均）
# 还可以这么理解，axis是几，那就表明哪一维度被压缩成1。
u = np.mean(data, axis=0)
cov_matrix = np.cov(data.T) # 计算协方差阵 ‘.T’就是取转置矩阵
u0 = np.array([6212.01, 32.87, 2972, 9.5, 15.78]) # 引入检验值
T_sq = np.dot(np.dot(n * (u - u0).T, np.linalg.inv(cov_matrix)), u - u0) # 计算T^2
alpha = 0.1 # 置信水平
cut_off = (n - 1) * p / (n - p) * F.ppf(1-alpha, p, n-p) # 计算F
p_value = 1 - F.cdf(T_sq * (n-p)/(n-1)/p, p, n-p) # 计算累计密度函数p

print('均值向量:')
print(u)
print('协方差阵：')
print(cov_matrix)
print('T^2：', T_sq)
print('F：', cut_off)
print('p：', p_value)

