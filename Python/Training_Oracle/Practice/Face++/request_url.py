import requests

if __name__ == '__main__':
    url = "https://api-cn.faceplusplus.com/facepp/v3/compare"
    requestData = {
        'api_key': 'OVHDatOz2oMDzUPFt72QMvJydexI0gPN',
        'api_secret': 'NTJRr0ZloCFf5NnvjSTgjTzwRZCGwtj1',
        "image_url1": "https://bucket-notes.oss-cn-beijing.aliyuncs.com/czf.png",
        "image_url2": "https://bucket-notes.oss-cn-beijing.aliyuncs.com/czf2.png"
    }
    ret = requests.post(url=url, data=requestData).json()
    print(ret)
