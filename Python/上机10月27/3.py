# 字符->Unicode
str1 = list(input("请输入字符串："))
# new_list = list(str1)
oo = []
for i in range(len(str1)):
    c = ord(str1[i])
    oo.append(c)
print(oo)


# 十进制数->对应字符
aa = []
str2 = [1000000, 101, 12, 23, 325]
for i in range(len(str2)):
    d = chr(str2[i])
    aa.append(d)
print(aa)