# 总结 消除重复的元素
# 亦可用list（set（））的方法

def delList(L):
    L1 = []
    for i in L:
        if i not in L1:
            L1.append(i)
    return L1
La = [1, 2, 2, 3, 3, 4, 5]
Lb = [1, 8, 8, 3, 9, 3, 3, 3, 3, 3, 6, 3]
print(delList(La))
print(delList(Lb))

print("另一种方法，还能排序")
print(list(set(La)))
print(list(set(Lb)))