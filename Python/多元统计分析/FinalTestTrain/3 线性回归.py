# 通过分析匹萨直径与价格的线性关系，可预测任意直径匹萨的价格。假设我们查到了部分匹萨的直径与价格的数据，如下表所示：
# 请预测直径为12英寸的披萨的价格。

# 输入样例
# 6 8 10 14 18
# 7 9 13 17.5 18
# 12

import numpy as np
from sklearn import linear_model

x = np.array(input().split(" "), int).reshape(-1,1)
y = np.array(input().split(" "), float).reshape(-1,1)
inch = np.array(input(), int)

model = linear_model.LinearRegression()
model.fit(x, y)
pre = np.array([inch]).reshape(-1,1)
pre = np.array([inch]).reshape(-1, 1)
pre = model.predict(pre)
print('Predict 12 inch cost:${:.2f}'.format(pre[0][0]), end="")