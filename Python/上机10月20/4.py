import random

Words = ("China", "Russia", "Britain", "France", "America", "Germany", "Japan")
print("欢迎参加本次游戏，游戏规则是：\n请你猜一下打乱字母顺序的单词，如果猜对才可以继续游戏，\n\
如果猜错请继续猜！")
isGo_on = 'Y'
while isGo_on == "Y" or isGo_on == "y":
    randomWord = random.choice(Words)
    correctWord = randomWord
    jumble = ''
    while randomWord:
        position = random.randrange(len(randomWord))
        # randrange（）方法返回指定递增基数集合中的一个随机数，基数默认值为1
        jumble += randomWord[position]
        randomWord = randomWord[:position] + randomWord[(position + 1):] # 序列的索引和切片
    print("\n乱序后的单词：", jumble)
    guessWord = input("\n请您猜猜看:")
    while guessWord != correctWord and guessWord != "":
        print("不好意思，您猜的不正确。")
        guessWord = input("\n请您继续猜")
    if guessWord == correctWord:
        print("恭喜您！猜对啦！\n")
    isGo_on = input("\n\n请问是否继续游戏（Y / N）")