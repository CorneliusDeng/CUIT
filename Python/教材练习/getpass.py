import getpass

username = input("请输入姓名：")
passwd = getpass.passwd("密码：")

if username == "Cornelius" and passwd == "CorneliusDeng7":
    print("登录成功")
else:
    print("登录失败")