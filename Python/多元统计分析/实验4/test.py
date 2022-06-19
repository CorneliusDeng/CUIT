import numpy as np
from sklearn import linear_model

x = np.array(input().split(" "), int).reshape(-1,1)
y = np.array(input().split(" "), float).reshape(-1,1)
y = y.reshape(-1,1)
inch = np.array(input(), int)

model = linear_model.LinearRegression()
model.fit(x, y)
pre = np.array([inch]).reshape(-1, 1)
pre = model.predict(pre)
print('Predict {} inch cost:${:.2f}'.format(inch, pre[0][0]))