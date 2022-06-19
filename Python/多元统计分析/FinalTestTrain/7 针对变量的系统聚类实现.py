# 比较10种咖啡豆的质量，由5名专业人员对每种咖啡的香气、甜感、酸质、醇厚度、风味、余韵和平衡7项指标
# 进行打分，最低分1分，最高分为10分，得到每种咖啡的每项指标的平均得分。
# 采用系统聚类法对该数据的变量进行聚类（划分为2类），选择最大距离法，距离判断指标选择相关系数，判断香气和酸质是否属于一类，输出结果。

# 输入样例
# 4.65 6.32 4.87 4.88 6.73 7.45 8.1 8.42 6.45 7.5 4.22 6.11 4.6 4.68 6.65 7.56 8.23 8.54 6.81 7.32 4.5 6.85 4.03 4.12 6.27 7.8 7.95 7.2 6.31 7.52 5.01 6.21 4.95 4.43 6.72 7.6 8.01 8.12 6.52 7.42 4.5 6.85 4.15 4.12 6.13 7.8 7.95 7.88 6.31 7.52 4.15 6.52 4.02 4.03 6.51 7.2 8.31 8.26 6.27 7.1 4.12 6.33 4.11 4.14 6.36 7.18 8.26 7.98 6.06 6.95
# 10 7
# 2

import numpy as np
from sklearn.cluster import AgglomerativeClustering

data = np.array(input().split(), float)
sample, n = [int(i) for i in input().split()]
class_ = int(input())
data = data.reshape(sample, n)
ac = AgglomerativeClustering(n_clusters=class_, affinity='correlation', linkage='complete')
ac.fit(data.T)
if ac.labels_[0] == ac.labels_[2]:
    print('香气和酸质属于一类。')
else:
    print('香气和酸质不属于一类。')