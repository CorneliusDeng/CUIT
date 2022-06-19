# 输入一个字符串，再输入两个字符，求这两个字符在字符串中的索引。
s = input("请输入一行字符串：")
# s = str(input("请输入一行字符串："))
new_list = list(s)
a, b = map(str, input("请输入两个字符：").split())
for i in range(len(new_list)-1, -1, -1):
    if new_list[i] == b:
        print(i, b)
    if new_list[i] == a:
        print(i, a)
