# 总结
# 1.对于列表，用max() min() len()方法可以直接取列表中的最大值、最小值、元素个数
# 2.元祖的使用方法和列表差不多，只是数据是不可变对象

s1 = [9, 7, 8, 3, 2, 1, 55, 6]
s2 = ["apple", "pear", "melon", "kiwi"]
s3 = "TheQuickBrownFox"


def Test(s):
    if s is list:
        max1 = max(s)
        min1 = min(s)
        l = len(s)
        return max1, min1, l
    else:
        li = list(s)
        max1 = max(li)
        min1 = min(li)
        l = len(li)
        return max1, min1, l


m = Test(s1)   # 返回一个元祖
print("List = ", s1)
print("最大值={0}, 最小值={1}, 元素个数={2}".format(m[0], m[1], m[2]))

m = Test(s2)
print("List = ", s2)
print("最大值={0}, 最小值={1}, 元素个数={2}".format(m[0], m[1], m[2]))

m = Test(s3)
print("List = ", s3)
print("最大值={0}, 最小值={1}, 元素个数={2}".format(m[0], m[1], m[2]))


# 不返回元祖，可以直接写成
# print("最大值={0}, 最小值={1}, 元素个数={2}".format(max(s1), min(s1), len(s1)))
# print("最大值={0}, 最小值={1}, 元素个数={2}".format(max(s2), min(s2), len(s2)))
# print("最大值={0}, 最小值={1}, 元素个数={2}".format(max(s3), min(s3), len(s3)))