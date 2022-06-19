import turtle
import random

# if __name__ == '__main__':
#     # 1、获取画笔
#     turtle = turtle.Turtle()
#     # 2、获取屏幕
#     screen = turtle.getscreen()
#     # 3、设置颜色
#     turtle.color('red', 'yellow')
#     # 4、开始填充
#     turtle.begin_fill()
#     for i in range(2):
#         turtle.forward(100)
#         turtle.right(90)
#         turtle.forward(50)
#         turtle.right(90)
#     # 5、结束填充
#     turtle.end_fill()
#     # 6、启动事件循环 必须是图形程序中的最后一个语句。
#     screen.mainloop()

# # 获取画笔
# pen = turtle.Turtle()
# #设置画笔的速度（0最快，1最慢)
# pen.speed(0)
# # 有以下这些选项cmode：1和255。
# # 对于1模式，程序员就只能在使用数字0和1代表的rgb规模，否则，TurtleGraphicsError将提高。
# # 对于255选项，程序员可以使用之间的数字0和255。使用该1选项时，颜色
# # (0.33, 0.33, 0.33)
# # 将等于
# # (85, 85, 85) #(255*0.33, 255*0.33, 255*0.33)
# turtle.colormode(255)
#
# def circle(radius):
#     if radius > 200:
#         pass
#     else:
#         #设置画笔颜色为以 r, g, b 元组表示的 RGB 颜色
#         pen.pencolor(random.randint(0, 255), random.randint(0, 255), random.randint(0, 255))
#         # 绘制一个 radius 指定半径的圆
#         pen.circle(radius)
#         #forward / back
#         #将使海龟向前 / 向后跳跃，同样的
#         #left / right
#         #将使海龟立即改变朝向。
#         pen.forward(1)
#         circle(radius + 1)
#
# if __name__ == '__main__':
#     screen = turtle.getscreen()
#     circle(50)
#     screen.mainloop()

pen = turtle.Turtle()
myWin = turtle.Screen()
# set the colormode to 255
turtle.colormode(255)
# set color
turtle.color(0, 0, 255)
# motion
for i in range(100):
    # turtle.forward(2)
    # turtle.right(10)
    turtle.circle(5 + i, 90)
myWin.exitonclick()
