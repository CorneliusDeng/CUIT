# 已知一个10*2维的矩阵M：
# 实现矩阵M与该矩阵转置的矩阵乘法运算（叉乘），获得n*n方阵N；
# ② 数据进行Z-score标准化后进行主成分分析（或者直接利用相关阵进行主成分分析）；③输出贡献率最大的主成分（第一主成分）线性方程。

# 10.39 7.91 7.64 6.94 6.38 5.22 9.54 8.57 6.24 10.51 20.81 17.96 19.01 17.48 19.58 18.43 17.52 17.02 13.7 20.04
# 10 2
# 1

import numpy as np
from sklearn.decomposition import PCA

data = np.array(input().split(), float)
sample, n = [int(i) for i in input().split()]
class_ = int(input())
data = data.reshape((sample, n))
data = data.dot(data.T)
mean = data.mean()
data = (data - mean) / np.std(data)
pca = PCA(n_components=class_)
pca.fit(data)
com = pca.components_[class_ - 1]
com = [f'{complex(i).real:.2f}'.rstrip('0').rstrip('.') for i in com]
r = ','.join(com)
print(
    f'第{class_}主成分线性方程系数为：{r}。')