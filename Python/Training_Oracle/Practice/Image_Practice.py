from PIL import Image
from io import BytesIO
import requests
from PIL import ImageFilter
#
# if __name__ == "__main__":
#     im = Image.open("../imgs/a.jpg")
    # print(im.size)
    # print(im.mode)
    # print(im.format)
    # # print(im.show())
    # # 缩略图
    # im.thumbnail((256,128), Image.NEAREST)
    # print(im.show())

    # 改变图片格式
    # im.save("../imgs/a.png")
    # im2 = Image.open("../imgs/a.png")
    # im2.show()
    # print(im2.format)
    # 旋转图片
    # im.rotate(90).show()

    # # 获取网络图片
    # r = requests.get('https://images.wallpaperscraft.com/image/single/night_city_street_car_113387_1280x720.jpg')
    # im2 = Image.open(BytesIO(r.content))
    # # 展示图像
    # im2.show()

# from PIL import Image
# if __name__ == '__main__':
#     # 蓝色图像
#     # Image.new(mode, size, color=0)
#     image1 = Image.new('RGB', (128, 128), (0, 0, 255))
#     # 红色图像
#     image2 = Image.new('RGB', (128, 128), (255, 0, 0))
#     # 取中间值
#     im = Image.blend(image1, image2, 0.3)
#     image1.show()
#     image2.show()
#     # 显示紫色图像
#     im.show()

# from PIL import Image
# if __name__ == '__main__':
#     im = Image.open('../imgs/a.png')
#     im.show()
#     # 将每个像素值翻倍（相当于亮度翻倍）
#     evl1 = Image.eval(im, lambda x: x*2)
#     evl1.show()
#     # 将每个像素值减半（相当于亮度减半）
#     evl2 = Image.eval(im, lambda x: x//2)
#     evl2.show()

# from PIL import Image
# def trans(x):
#     if x >= 128:
#         x = 255
#     else:
#         x = 0
#     return x
#
# if __name__ == '__main__':
#     im = Image.open('../imgs/a.png')
#     image = Image.eval(im, trans)
#     image.show()

# 合成
# if __name__ == '__main__':
#     # 打开 a.jpg
#     image1 = Image.open('../imgs/a.png')
#     # 打开 b.jpg
#     image2 = Image.open('../imgs/b.png')
#     # 分离image1的通道
#     r, g, b = image1.split()
#     # 合成图像
#     im = Image.composite(image1, image2, mask=r)
#
#     image1.show()
#     image2.show()
#     im.show()

# if __name__ == '__main__':
#     im = Image.open('../imgs/a.jpg')
#     # 将三个通道分开
#     im_split = im.split()
#     # 分别显示三个单通道图像,因为是单通道，所以是灰度图
#     im_split[0].show()
#     im_split[1].show()
#     im_split[2].show()
#     # 将三个通道再次合并(原图）
#     im2 = Image.merge('RGB', im_split)
#     im2.show()
#     # 打开第二张图像
#     im3 = Image.open('../imgs/b.jpg')
#     # 将第二张图像的三个通道分开
#     im_split2 = im3.split()
#     # 将第二张图像的第1个通道和第一张图像的第2、3通道合成一张图像
#     rgbs = [im_split2[0], im_split[1], im_split[2]]
#     im4 = Image.merge('RGB', rgbs)
#     im4.show()

# 滤镜
# if __name__ == '__main__':
#     img = Image.open("../imgs/a.jpg")
#     imgfilted = img.filter(ImageFilter.EMBOSS)
#     imgfilted.save("a_lv.jpg")
#     imgfilted.show()

# 裁剪
# def image_clip(pil_im, x, y, width, height):
#     '''
#     从一张图片中截取某个区域
#     INPUT  -> 单张图文件, 坐标点x, 坐标点y, 目标宽度, 目标高度
#     OUTPUT -> 截取后的图片
#     '''
#     im_w, im_h = pil_im.size
#     x2 = x + width
#     y2 = y + height
#     if x + width > im_w:
#         x2 = im_w
#     if y + height > im_h:
#         y2 = im_h
#     box = (x, y, x2, y2)
#     region = pil_im.crop(box)
#     return region
# if __name__ == '__main__':
#     # 打开本地图像文件
#     im = Image.open('../imgs/a.jpg')
#     # 280, 160是截取图片的左上角坐标
#     # 560, 520是截取图片的宽度和高度
#     im2 = image_clip(im, 28, 16, 560, 520)
#     im2.show()

# def read_image(path, mode='RGB'):
#     pil_im = Image.open(path)
#     if mode == '1':
#         # 非黑即白模式: 0表示黑, 255表示白
#         return pil_im.convert('1')
#     elif mode == 'L':
#         # 灰色模式: 0表示黑，255表示白，其他数字表示不同的灰度。
#         return pil_im.convert('L')
#     elif mode == 'RGB':
#         return pil_im.convert('RGB')
# if __name__ == '__main__':
#     # im2 = read_image("../imgs/a.jpg", "RGB")
#     im2 = read_image("../imgs/a.jpg", "1")
#     # im2 = read_image("../imgs/a.jpg", "L")
#     im2.show()

# 给一张图片加上图片水印
# ori_im:原始图片
# mark_im：水印图片
def image_watermark_logo(ori_im, mark_im):
    ori_w, ori_h = ori_im.size
    mark_w, mark_h = mark_im.size
    # 图层
    # 创建一个新图片
    dst_im = Image.new('RGBA', ori_im.size, (255, 255, 255, 0))
    dst_im.show()
    # 把水印图片粘贴到新图片上
    # ori_w - mark_w, ori_h - mark_h:坐标
    dst_im.paste(mark_im, (ori_w - mark_w, ori_h - mark_h))
    dst_im.show()
    # 融合两个图片
    dst_im = Image.composite(dst_im, ori_im, dst_im)
    return dst_im


if __name__ == '__main__':
    ima = Image.open('../imgs/a.jpg')
    imb = Image.open('../imgs/demo-pic6.jpg')
    imc=image_watermark_logo(ima,imb)
    imc.show()

