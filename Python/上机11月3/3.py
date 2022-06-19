import random
n = 52
pocker = []

# PEP 8: expected 2 blank lines, found 1
# 在声明函数的那一行的上方必须有两行的空行，否则便出现这个情况
# 函数的注释可随函数为一体

# 提示：将要发的52张牌
# ，按照梅花0…12，方块13…25，红桃26…38，黑桃39…51顺序编号并存储在pocker列表（未洗牌之前）。
# 也就是说列表某元素存储是14则说明是方块2，26则说明是红桃A。gen_pocker(n)随机产生两个位置索引，交换两个位置的牌，
# 进行100次随机交换两张牌，从而达到洗牌目的。发牌时，将交换后pocker列表，按照顺序加到4个牌手的列表中


# 交换牌的顺序
def get_pocker(num):
    times = 100
    while times > 0:
        times -= 1
        p1 = random.randint(0, num-1)
        p2 = random.randint(0, num-1)
        t = pocker[p1]
        pocker[p1] = pocker[p2]
        pocker[p2] = t
    return pocker


# 获取牌的花色
def getColor(order):
    color = ["梅花", "方块", "黑桃", "红桃"]
    value = int(order/13)
    if value < 0 or value >= 4:
        return "ERROR!"
    return color[value]


#获取牌面大小
def getValue(order):
    value = order % 13
    if value == 0:
        return 'A'
    elif value >= 1 and value <= 9:
        return str(value+1)
    elif value == 10:
        return 'J'
    elif value == 11:
        return 'Q'
    elif value == 12:
        return 'k'


# 获取花色和牌面的组合
def getPuk(group):
    return getColor(group) + getValue(group)


(a, b, c, d) = ([], [], [], [])
pocker = [i for i in range(n)]  # 获取0~51存入列表
pocker = get_pocker(n)
print(pocker)  # 洗牌后的次序
for order in range(13):   # x为0~12
    m = order * 4  # 已经洗了牌了，现在一人13张牌，一次发一张，轮着发
    a.append(getPuk(pocker[m]))     # 0 4 8  12  16  20  24  28  32  36  40  44 48
    b.append(getPuk(pocker[m+1]))   # 1 5 9  13                                 49
    c.append(getPuk(pocker[m+2]))   # 2 6 10 14                                 50
    d.append(getPuk(pocker[m+3]))   # 3 7 11 15                                 51
a.sort()
b.sort()
c.sort()
d.sort()

print("牌手1：", end="")
for i in a:
    print(i, end="\t")
print("\n牌手2：", end="")
for i in b:
    print(i, end="\t")
print("\n牌手3：", end="")
for i in c:
    print(i, end="\t")
print("\n牌手4：", end="")
for i in d:
    print(i, end="\t")
