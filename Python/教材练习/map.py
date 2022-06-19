# 内置函数map()可以使用指定函数处理需要遍历的可迭代对象
# map(func, seq1[, seq2,])将func作用于seq中的每一个元素，如果func为None，则作用相当于zip()

print(list(map(abs,[-1,0,6,-9])))  # 用取绝对值函数
print(list(map(lambda x, y : x + y ,'abc', 'de')))   # 拼接字符串