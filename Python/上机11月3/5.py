# 总结
# 1.当使用print输出对象的时候，只要自己定义了__str__(self)方法，那么就会打印从在这个方法中return的数据
#   __str__方法需要返回一个字符串，当做这个对象的描写

import random
# Card类代表一张牌，其中FaceNum字段指出是牌面数字1~13，Suit字段指出的是花色
class Card:
    RANKS = ['A', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K']
    SUITS = ['梅花', '方块', '红桃', '黑桃']

    def __init__(self, rank, suit):
        self.rank = rank  # 牌面数字1~13
        self.suit = suit  # 花色

    def __str__(self):
        # 当使用print输出对象的时候，只要自己定义了__str__(self)方法，那么就会打印从在这个方法中return的数据
        # __str__方法需要返回一个字符串，当做这个对象的描写
        return self.suit + self.rank

    def pic_order(self):  # 牌的顺序号
        if self.rank == 'A':
            FaceNum = 1
        elif self.rank == 'J':
            FaceNum = 11
        elif self.rank == 'Q':
            FaceNum = 12
        elif self.rank == 'K':
            FaceNum = 13
        else:
            FaceNum = int(self.rank)
        if self.suit == '梅花':
            Suit = 1
        elif self.suit == '方块':
            Suit = 2
        elif self.suit == '红桃':
            Suit = 3
        else:
            Suit = 4
        return (Suit - 1) * 13 + FaceNum


# Hand类代表一手牌，可以认为是一位牌手手里的牌，其中cards列表变量存储牌手手里的牌。
# 可以增加牌、清空手里的牌、把一张牌给别的牌手。
class Hand:
    def __init__(self):
        self.cards = []            # cards列表变量存储牌手手里的牌

    def __str__(self):
        rep = ''
        for card in sorted([str(i) for i in self.cards]):
            # sort是对于列表类型的排序函数，函数原型为：L.sort(key=None, reverse=False)，该方法没有返回值，是对列表的就地排序
            # sorted 可以对所有可迭代的对象进行排序操作，尤其是可以对字典进行排序，其形式为：sorted(iterable, key=None, reverse=False)。sorted函数是有返回值的
            rep += card + '\t'
        return rep

    def clear(self):            # 清空手里的牌
        self.cards = []

    def add(self, card):
        self.cards.append(card)

    def give(self, card, other_hand):  # 把一张牌给其他牌手
        self.cards.remove(card)
        other_hand.add(card)


# Poke类代表一副牌，可以把一副牌看作是有52张牌的牌手，所以继承Hand类。
class Poke(Hand):
    def populate(self):                  # 生成一副牌
        for suit in Card.SUITS:
            for rank in Card.RANKS:
                self.add(Card(rank, suit))

    def shuffle(self):                  # 洗牌
        random.shuffle(self.cards)       # 打乱牌的顺序，random中的shuffle() 方法将序列的所有元素随机排序。

    def deal(self, hands, per_hand=13):    # 发牌，发给玩家，每人默认13张牌
        for rounds in range(per_hand):  # 0~12
            for hand in hands:
                if self.cards:
                    top_card = self.cards[0]
                    self.give(top_card, hand)  # 发的牌给玩家保存
                else:
                    print('不能继续发牌了，牌已经发完了!')


players = [Hand(), Hand(), Hand(), Hand()]
poke = Poke()
poke.populate()           # 生成一副牌
poke.shuffle()            # 洗牌
poke.deal(players, 13)    # 发给每人13张牌
n = 1
for hand in players:
    print('牌手', n, end=':')
    print(hand)
    n += 1