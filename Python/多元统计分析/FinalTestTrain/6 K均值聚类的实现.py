# 已知一批数据，有两个变量：销售额和利润，有8个样本：
# 采用K均值聚类算法对样本进行聚类，判断公司A所在类，并输出该类的中心坐标。

# 输入样例
# 174 54 90 28 54 15 161 133 86 9 24 19 37 7 33 86
# 8 2
# 3

import numpy as np
from sklearn.cluster import KMeans

data = np.array(input().split(), int)
sample, n = [int(i) for i in input().split()]
class_ = int(input())
data = data.reshape((sample, n))
k = KMeans(n_clusters=class_)
k.fit(data)
a = k.labels_[0]
print('A公司所在类的中心为：{:.2f},{:.2f}。'.format(k.cluster_centers_[a, 0], k.cluster_centers_[a, 1]))

data = np.array(input().split(), int)
sample, n = [int(i) for i in input().split()]
class_ = int(input())
data = data.reshape(sample, n)
k = KMeans(n_clusters=class_)
k.fit(data)
a = k.labels_[0]
print('A公司所在类的中心为：{:.2f},{:.2f}。'.format(k.cluster_centers_[a, 0], k.cluster_centers_[a, 1]))