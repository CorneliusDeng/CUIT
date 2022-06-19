f = open("D:\\All SourceCode\\PythonSourceCode\\上机10月27\\out.txt", "w")

try:
    str = input("请输入：")
    while str != 'Q':
        f.write(str)
        f.write("\n")
        str = input("请输入：")
finally:
    f.close()