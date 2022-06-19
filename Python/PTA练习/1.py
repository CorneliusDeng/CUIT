# 函数repeat(ls)判定列表ls中是否包含重复元素，如果包含返回True，否则返回False。
# 每一个列表中只要有一个元素出现两次，那么该列表即被判定为包含重复元素。
# 然后使用该函数对n行字符串进行处理。最后统计包含重复元素的行数与不包含重复元素的行数。

def repeat(ls):
    s = set(ls)
    if len(ls) == len(s):
        return False
    else:
        return True


n = int(input())
countT = countF = 0
for i in range(n):
    # split()：拆分字符串。通过指定分隔符(默认为空格)对字符串进行切片，并返回分割后的字符串列表（list）
    if repeat(input().split()):
        countT += 1
    else:
        countF += 1
print("True={0},False={1}".format(countT, countF))

# 测试数据
# 5
# 1 2 3 4 5
# 1 3 2 5 4
# 1 2 3 6 1
# 1 2 3 2 1
# 1 1 1 1 1