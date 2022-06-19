import datetime


class Student:
    def __init__(self, name, stuno, birthday, score):
        self.name = name
        self.stuno = stuno
        self.birthday = birthday
        self.score = score

    def information(self):
        print(self.name, "同学的学号是", self.stuno)

    def age(self):
        yearnow = datetime.date.today().year
        print("{0}同学在{1}年出生,今年{2}岁".format(self.name, self.birthday, yearnow - self.birthday))

    def scoregrade(self):
        if self.score >= 90:
            print("{0}同学的Python成绩是{1},等级是优秀！".format(self.name, self.score))
        elif self.score >= 80:
            print("{0}同学的Python成绩是{1},等级是良好！".format(self.name, self.score))
        elif self.score >= 70:
            print("{0}同学的Python成绩是{1},等级是中等！".format(self.name, self.score))
        elif self.score >= 60:
            print("{0}同学的Python成绩是{1},等级是及格！".format(self.name, self.score))
        else:
            print("{0}同学的Python成绩是{1},等级是不及格！".format(self.name, self.score))


a = Student("邓棋", 2018081062, 2000, 100)
a.information()
a.age()
a.scoregrade()
