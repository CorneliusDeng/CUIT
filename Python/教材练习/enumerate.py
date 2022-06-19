seasons = ["Spring", "Summer", "Autumn", "Winter"]
for i, s in enumerate(seasons, start=1):
    print("第{0}季节：{1}".format(i, s))

# 内置函数enumerate()函数用于将一个可遍历的数据对象（例如列表、元祖或字符串
# 组合为一个索引序列，并返回一个可迭代对象，所以可以在for循环中中可直接迭代下标和元素