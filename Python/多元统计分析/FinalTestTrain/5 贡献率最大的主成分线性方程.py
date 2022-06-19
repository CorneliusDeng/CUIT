# 有一组数据现在要用主成分做降维处理，且原始数据在降维前需采用均值标准化后才参与计算，最后给出特征值最大的第一主成分的变换公式。

# 输入样例
# 2.5,2.4,0.5,0.7,2.2,2.9,1.9,2.2,3.1,3.0,2.3,2.7,2,1.6,1,1.1,1.5,1.6,1.1,0.9
# 10,2

import numpy as np

def zsn(x):
    x = (x - x.mean()) / np.std(x)
    return x

data = np.array(input().split(','), float)
sample, n = [int(i) for i in input().split(',')]
data = data.reshape(sample, n)
mean = data.mean(axis=0)
data = zsn(data)
cov = np.cov(data.T)
f, v = np.linalg.eig(cov)
i = f.argmax()
print('第1主成分={:.5f}*(x1{:+.2f}){:+.5f}*(x2{:+.2f})'.format(v[:, i][0], -mean[0], v[:, i][1], -mean[1]))