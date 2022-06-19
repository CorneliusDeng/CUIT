import pytesseract
from PIL import Image
if __name__ == '__main__':
    image = Image.open('poem.JPG')
    image.load()
    hanzi = pytesseract.image_to_string(image, lang='chi_sim')
    print(hanzi)

