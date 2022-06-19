if __name__ == '__main__':

# if语句运用
   # sex = str(input("请输入运动员的性别："))
   # weight = int(input("请输入运动员的体重："))
   # if sex == "男" and weight >= 80:
   #    print("该名男运动员的级别为重量级")
   # elif sex == "男" and weight >= 60:
   #    print("该名男运动员的级别为中量级")
   # elif sex == "男" and weight >= 50:
   #    print("该名男运动员的级别为轻量级")
   # elif sex == "女" and weight >= 60:
   #    print("该名女运动员的级别为重量级")
   # elif sex == "女" and weight >= 50:
   #    print("该名女运动员的级别为中量级")
   # elif sex == "女" and weight >= 40:
   #    print("该名女运动员的级别为轻量级")
   # else:
   #    print("输入有误，请重新输入")

   # sum = 2 + 22 + 222 +...+ 22222222
   #  sum = 0
   #  i = 2
   #  for t in range(1, 9):
   #      sum += i
   #      i = 10 * i + 2
   #  print("sum=", sum)

   # 斐波那契数列 f = 1, 1, 2, 3, 5, 8 ...., n = 12
   #  方法一
   #  def Feb(n):
   #      sum = 0
   #      if n == 1 or n == 2:
   #          return 1
   #      else:
   #          return Feb(n-1) + Feb(n-2)
   #  print(Feb(12))
   #  # 方法二
   #  first = 1
   #  second = 1
   #  third = 0
   #  for i in range(3,13):
   #      third = first + second
   #      first = second
   #      second = third
   #  print(third)

   # 倒序输出一个整数
   #  n = int(input("请输入一个整数："))
   #  temp = str(n)
   #  length = len(temp)
   #  result = ""
   #  while length != 0:
   #      result += temp[length-1]
   #      length -= 1
   #  print("倒序输出一个整数",result)

    # 猜数游戏
    # import random
    # temp = random.randint(1,100)
    # count = 0
    # while 1:
    #     guess = int(input("请输入一个数："))
    #     count += 1
    #     if guess > temp:
    #         print("大于")
    #     elif guess < temp:
    #         print("小于")
    #     else:
    #         print("猜中了！猜词次数为", count)
    #         break

    # 水仙花数
    # for num in range(100, 1000):
    #     gewei = num % 10
    #     shiwei = num // 10 % 10
    #     baiwei = num // 100
    #     if gewei ** 3 + shiwei ** 3 + baiwei ** 3 == num:
    #         print(num)

    # sum = 1! + 2! +...+ 10!
    sum = 0
    for i in range(1, 11):
        temp = 1
        for j in range(1, i+1):
            temp *= j
        sum +=  temp
    print(sum)

    # 求出任何一个数的不同约数（不包括1和本身）
    # def f(n):
    #     list = []
    #     for i in range(2,n):
    #         if n % i == 0:
    #             list.append(i)
    #     return list
    # list_test = f(120)
    # print(list_test)

    # def make_counter():
    #     count = 0
    #     def counter(): # 闭包
    #         nonlocal count
    #         count += 1
    #         return count
    #     return counter
    # def make_counter_test():
    #     mc = make_counter()
    #     print(mc())
    #     print(mc())
    #     print(mc())
    # make_counter_test()

