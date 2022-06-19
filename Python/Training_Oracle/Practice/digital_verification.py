# 导入PIL和random库
import pytesseract as pytesseract
from PIL import ImageDraw, Image, ImageFont, ImageFilter
from random import randint

'''生成随机数字'''
def gengerate_digital_number():
    # 创建空白图片
    # Image.new( mode, size, color )
    image1 = Image.new('RGB', (240, 120), (120, 130, 140))
    # image1.show()
    # 创建图像对象
    draw1 = ImageDraw.Draw(image1)
    # 创建背景板（主要是利用point随机写点的颜色，最后效果如图1）
    for x in range(240):
        for y in range(120):
            r = randint(0, 128)
            g = randint(0, 128)
            b = randint(0, 128)
            draw1.point((x, y), (r, g, b))
    # 创建字体
    font1 = ImageFont.truetype('../Font/AxureHandwriting.otf', 50)
    # 随机写入数字利用randint
    for x in range(5):
        y = 30
        r = randint(129, 255)
        g = randint(129, 255)
        b = randint(129, 255)
        num = str(randint(0, 9))
        # （坐标，文本，颜色，字体）
        draw1.text((x * 50, y), num, (r, g, b), font1)
    # 图像滤镜效果
    image1.filter(ImageFilter.BLUR)
    # 将图片进行展示
    image1.show()
    image1.save("../imgs/1_digit.png")


'''文字识别'''
def digital_verfication():
    # 1、读取图片
    img = Image.open("../imgs/1_digit.png")
    # 2、将图片变成灰色
    img_gray = img.convert('L')
    # img_gray.show()
    img_gray.save('../imgs/2_gray.png')
    # 3、转成黑白图片
    img_black_white = img_gray.point(lambda x: 0 if x > 128 else 255)
    img_black_white.save('../imgs/3_black_white.png')
    # 4、 去噪（这里省略）
    # 5、识别
    image = Image.open('../imgs/3_black_white.png')
    text = pytesseract.image_to_string(image)
    print(text)

if __name__ == '__main__':
    gengerate_digital_number()
    digital_verfication()

