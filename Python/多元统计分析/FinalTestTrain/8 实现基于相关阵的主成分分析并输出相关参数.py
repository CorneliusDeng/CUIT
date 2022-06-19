# 某面馆有各种种类的汤面，为了得知受欢迎程度，进行了在【面】、【汤】、【配料】3个维度的打分
# 利用主成分分析法对数据挖掘：①求解数据的相关矩阵；②基于相关矩阵对数据进行主成分分析（求解相关阵的特征值）；
# ③输出面和汤的相关系数；第一主成和第二主成分的方差贡献率，以及两者的累计方差贡献率。

# 输入样例
# 2 1 5 2 3 4 4 1 3 5 4 5 3 2 5 3 4 2 3 5 5 1 4 3 5 2 3 1 2 3
# 10 3

import numpy as np

data = np.array(input().split(), int)
sample, n = [int(i) for i in input().split()]
data = data.reshape((sample, n))
data = (data - data.mean()) / np.std(data)
corr = np.corrcoef(data.T)
f, v = np.linalg.eig(corr)
f.sort()
f = f / f.sum()
f.sort()
print(f'对面和汤打分的相关系数为{corr[0][1]:.2f}。')
print(f'第一主成的方差贡献率为{f[-1]:.2%} ，第二主成分的方差贡献率为{f[-2]:.2%}，前两个主成分的累计贡献率为{f[-1] + f[-2]:.2%}。', end='')