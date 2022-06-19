import requests
if __name__ == '__main__':
    url = "https://api-cn.faceplusplus.com/imagepp/v1/licenseplate"
    data = {
        'api_key': 'OVHDatOz2oMDzUPFt72QMvJydexI0gPN',
        'api_secret': 'NTJRr0ZloCFf5NnvjSTgjTzwRZCGwtj1',
        'image_url': 'https://img1.baidu.com/it/u=581886903,4085304045&fm=26&fmt=auto'
    }
    result = requests.post(url=url, data=data).json()
    res = result.get("results")
    print(res[0].get('license_plate_number'))
