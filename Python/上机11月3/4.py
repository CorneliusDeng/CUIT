# 总结
# 1.如果直接导入math，使用pi需要变成math.pi

from math import pi

class MyMath:
    def __init__(self, r):
        self.r = float(r)

    def CirclePerimeter(self):
        cp = self.r * 2 * pi
        print("圆的周长 = %.2f" % cp)

    def CircleArea(self):
        ca = self.r ** 2 * pi
        print("圆的面积 =  %.2f" % ca)

    def BallArea(self):
        ba = 4 * pi * (self.r ** 2)
        print("球的表面积 =  %.2f" % ba)

    def BallVolume(self):
        bv = (4 / 3) * pi * (self.r ** 3)
        print("球的体积 =  %.2f" % bv)


radius = input("请输入半径：")
example = MyMath(radius)
example.CirclePerimeter()
example.CircleArea()
example.BallArea()
example.BallVolume()