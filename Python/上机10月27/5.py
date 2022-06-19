import sys
n = int((sys.argv[1]))
b = []
c = []
for i in range(0,n+1):
    num1 = 2 * i
    b.append(num1)
    num2 = 2 ** i
    c.append(num2)
f = open("D:\\All SourceCode\\PythonSourceCode\\上机10月27\\out.txt", "w")
print(b, file=f)
print(c, file=f)
f.close()