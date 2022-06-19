import pytesseract
from PIL import Image
if __name__ == '__main__':
    image1 = Image.open('../imgs/c_eng.png')
    # image.show()
    text = pytesseract.image_to_string(image1)
    print(text)
    image2 = Image.deopen('../imgs/b_china.png')
    image2.load()
    hanzi = pytesseract.image_to_string(image2, lang='chi_sim')
    print(hanzi)

