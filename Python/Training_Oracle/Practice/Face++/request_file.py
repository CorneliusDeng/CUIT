import requests
if __name__ == '__main__':
    url = "https://api-cn.faceplusplus.com/facepp/v3/compare"
    data = {
        'api_key': 'OVHDatOz2oMDzUPFt72QMvJydexI0gPN',
        'api_secret': 'NTJRr0ZloCFf5NnvjSTgjTzwRZCGwtj1',
    }
    # 参数值是一个元组，内容为以下格式（文件名，打开的文件流，文件类型）
    files = {
        'image_file1': ("face1.jpg", open("face1.jpg", "rb"), "images/jpeg"),
        'image_file2': ("face2.jpeg", open("face2.jpeg", "rb"), "images/jpeg")
    }
    # 发送请求
    response = requests.post(url=url, files=files, data=data)
    # 打印结果
    print("两张图片的比对相似度：", response.json().get('confidence'))