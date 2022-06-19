# 1、导入模块
import requests
from bs4 import  BeautifulSoup
from PIL import Image

# if __name__ == '__main__':
#     # 2、封装发送给服务端数据
#     name = "刘虎"
#     datax = {
#         "word": name,
#         "sizes": 50,
#         "fonts": "lfc.ttf",
#         "fontcolor": "#000000"
#     }
#     # 3、通过request对象爬取网页内容
#     response = requests.post("http://www.uustv.com/", data=datax)
#     response.encoding = "utf-8"
#     text=response.text
#     # print(response.text)
#     # 4、从网页内容中解析出需要的内容
#     # <div class="tu">﻿<img src="tmp/164083127052395.gif"/></div>
#     soup = BeautifulSoup(text, "html.parser")
#     img = soup.select(".tu img")[0]
#     # 5、拿到图片的地址
#     img_url="http://www.uustv.com/"+img.attrs['src']
#     # 6、调用get方法，获取这个图片的内容
#     img_content=requests.get(img_url).content
#     # 7、把图片内容写入文件
#     ff = open('{}.gif'.format(name), "wb")
#     ff.write(img_content)

# if __name__ == '__main__':
#     respons = requests.post("https://www.cuit.edu.cn/")
#     respons.encoding = "utf-8"
#     text = respons.text
#
#     soup = BeautifulSoup(text, "html.parser")
#     img = soup.select(".image img")[0]
#     img_url = "https://www.cuit.edu.cn/" + img.attrs['src']
#     img_content=requests.get(img_url).content
#     ff = open('{}.png'.format("logo"), "wb")
#     ff.write(img_content)
#     image = Image.open("logo.png")
#     image.show()

if __name__ == '__main__':
    num = 0
    for i in range(1, 6):
        response = requests.post("http://m.mingxing.com/tuku/index.html")
        response.encoding = "utf-8"
        text = response.text
        soup = BeautifulSoup(text, "html.parser")
        for j in range(24):
            img = soup.select(".zy_ul3 img")[j]
            img_url = "http://m.mingxing.com/tuku/index.html" + img.attrs['src']
            img_content = requests.get(img_url).content
            ff = open('D://AllSourceCode/Python/Training_Oracle/crawler_picture/'
                      + '{}'.format(i) + '{}.png'.format(j), "wb")
            ff.write(img_content)
            num += 1
            if num == 100:
                break
        if num == 100:
            break

