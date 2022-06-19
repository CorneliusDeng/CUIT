import numpy as np
import pandas
from sklearn import preprocessing
from factor_analyzer import FactorAnalyzer, Rotator

#  数据处理其他方法，在读数据时直接处理
#  dataread = pandas.read_excel('D:\\AllSourceCode\\PythonSourceCode\\多元统计分析\\实验4\\test4-2.xlsx',
#  encoding='utf-8', index_col=(0, 1))
dataread = pandas.read_excel('D:\\AllSourceCode\\PythonSourceCode\\多元统计分析\\实验4\\test4-2.xlsx')
# 消除属性名为“国家和地区”以及“国家和地区的英文第一字母”这两列
dataread = dataread.drop(['国家和地区'], axis=1)
dataread = dataread.drop(['国家和地区的英文第一字母'], axis=1)
dataread.head()  # 把第一行内容作为名称，即排除在有效数据之外
# 将读到的数据转化为array类型
values = dataread.values

# z-score 标准化
data = preprocessing.scale(values)
n = len(data[0])  # 取属性个数
# 数据帧(DataFrame)是二维数据结构，即数据以行和列的表格方式排列。将标准化后的数据变为数据帧。
df = pandas.DataFrame(data)
print(df)

# 因子分析，格式为：FactorAnalyzer(rotation= None,n_factors=n,method='principal')
# rotation:旋转的方式，包括None:不旋转,'varimax':最大方差法,'promax'：最优斜交旋转；
# n_factors:公因子的数量；
# method:因子分析的方法，包括'minres':最小残差因子法,'principal':主成分分析法；
fa = FactorAnalyzer(n, rotation=None, method='principal')
fa.fit(df)

# 将结果四舍五入，保存为小数点后三位有效数字的百分数
print('方差贡献率(%)：', np.round(fa.get_factor_variance()[1] * 100, 3))
print('累计方差贡献率(%)：', np.round(fa.get_factor_variance()[2] * 100, 3))

# 保留小数点后两位有效数字
rotator = Rotator()
print('因子载荷矩阵：')
print(np.round(rotator.fit_transform(fa.loadings_), 2))

