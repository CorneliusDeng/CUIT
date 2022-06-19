import pandas as pd
import scipy.cluster.hierarchy as sch
from sklearn.cluster import AgglomerativeClustering
from sklearn.preprocessing import MinMaxScaler
from matplotlib import pyplot as plt

data = pd.read_csv("D:\\AllSourceCode\\PythonSourceCode\\多元统计分析\\实验3\\test3-1.csv", encoding="UTF-8")  # 读入数据
# 清除‘酒’这列行标号
data = data.drop(['酒'], axis=1)
df = MinMaxScaler().fit_transform(data)

# 最小距离+欧氏距离
# 建立模型
model = AgglomerativeClustering(n_clusters=3)
model.fit(df)
data['类别标签'] = model.labels_
print(data.head())
# 画图 single为最近邻点算法，euclidean为欧式距离
ss = sch.linkage(df, method='single', metric='euclidean')
sch.dendrogram(ss)
plt.show()


# 最大距离+切贝谢夫距离
# 建立模型
model = AgglomerativeClustering(n_clusters=3)
model.fit(df)
data['类别标签'] = model.labels_
print(data.head())
# 画图 complete为最远邻点算法，chebychev为切贝谢夫距离
ss = sch.linkage(df, method='complete', metric='chebychev')
sch.dendrogram(ss)
plt.show()
