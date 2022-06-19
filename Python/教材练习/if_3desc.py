a = int(input("请输入整数a:"))
b = int(input("请输入整数b:"))
c = int(input("请输入整数c:"))

if (a < b): t = a; a = b; b = t;     # a, b = b, a 系列解包方法
if (a < c): t = a; a = c; c = t;
if (b < c): t = b; b = c; c = t;

print(str.format("排序结果如下（降序）{0},{1},{2}", a, b, c))