import pymysql
import paramiko

# 阿里云上传文件
class SFTP():
    """
    实现ssh远程登陆，并且上传文件
    """
    def __init__(self, ip=None, filename=None):
        self.ip = ip
        # 如果常用一个ip，可以设置默认ip
        if not self.ip:
            self.ip = "101.132.145.179"
        self.filename = filename

    def connect(self):
        # 连接
        try:
            conn = paramiko.Transport((self.ip, 22))
        except Exception as e:
            print(e)
        else:
            # 用户名，用户密码
            self.name = 'root'
            passwd = 'CorneliusDeng7'
            try:
                # 尝试与远程服务器连接
                conn.connect(username = self.name, password = passwd)
                self.sftp_ob = paramiko.SFTPClient.from_transport(conn)
            except Exception as e:
                # 失败则打印原因
                print(e)
                return
            else:
                print("阿里云连接成功！")

    def upload(self):
        self.connect()
        self.sftp_ob.put(self.filename, "/usr/local/images/"+self.filename)
        print("图片上传云端完成！")


# 账号密码登录：插入数据
def text_check_insert(re_name, re_password):
    # 连接数据库
    try:
        db = pymysql.connect(host='101.132.145.179', user='root', password='123456', database='Training_Oracle')
    except:
        print("连接不成功")
    # 使用cursor()方法获取操作游标
    cursor = db.cursor()
    # SQL 插入语句
    sql = "insert into name_password(name,password) values(%s,%s)"
    try:
        # 执行sql语句
        cursor.execute(sql, (re_name, re_password))
        # 提交到数据库执行
        db.commit()
        print(re_name, ",", re_password, "插入执行成功")
    except:
        # 如果发生错误则回滚
        db.rollback()
        print(re_name, ",", re_password, "插入执行不成功")
    # 关闭游标、数据库连接
    cursor.close()
    db.close()

# 账号密码登录：验证数据
def text_check_select(re_name):
    # 连接数据库
    try:
        db = pymysql.connect(host='101.132.145.179', user='root', password='123456', database='Training_Oracle')
    except:
        print("连接不成功")
    # 使用cursor()方法获取操作游标
    cursor = db.cursor()
    # SQL 查询语句
    sql = "select password from name_password where name=%s"
    try:
        # 执行sql语句
        cursor.execute(sql, re_name)
        result = cursor.fetchone()
        # 返回查询结果
        return result[0]
    except:
        # 如果发生错误则回滚
        db.rollback()
        print("查询执行不成功")
    # 关闭游标、数据库连接
    cursor.close()
    db.close()

# 人脸登录：插入数据
def face_check_insert(img, name):
    # 连接数据库
    try:
        db = pymysql.connect(host='101.132.145.179', user='root', password='123456', database='Training_Oracle')
    except:
        print("连接不成功")
    # 使用cursor()方法获取操作游标
    cursor = db.cursor()
    # 上传图片到阿里云
    sftp = SFTP("101.132.145.179", img)
    sftp.upload()
    # SQL 插入语句
    img_url = 'http://101.132.145.179:8080/pic/' + img
    sql = "insert into detect_face(image_url,name) values(%s,%s)"
    try:
        # 执行sql语句
        cursor.execute(sql, (img_url, name))
        # 提交到数据库执行
        db.commit()
        print("人脸图片插入执行成功")
    except:
        # 如果发生错误则回滚
        db.rollback()
        print("人脸图片插入执行不成功")
    # 关闭游标、数据库连接
    cursor.close()
    db.close()

# 人脸登录：验证数据
def face_check_select(re_name):
    # 连接数据库
    try:
        db = pymysql.connect(host='101.132.145.179', user='root', password='123456', database='Training_Oracle')
    except:
        print("连接不成功")
    # 使用cursor()方法获取操作游标
    cursor = db.cursor()
    # SQL 查询语句
    sql = "select image_url from detect_face where name=%s"
    try:
        # 执行sql语句
        cursor.execute(sql, re_name)
        result = cursor.fetchone()
        # 返回查询结果
        return result[0]
    except:
        # 如果发生错误则回滚
        db.rollback()
        print("查询执行不成功")
    # 关闭游标、数据库连接
    cursor.close()
    db.close()

