//每个骰子有六面，点数分别为1、2、3、4、5、6。游戏者在程序开始时输入一个无符号整数，作为产生随机数的种子。
//每轮投两次骰子，第一轮如果和数为7或11则为胜，游戏结束；和数为2、3或12则为负，游戏结束；
//和数为其它值则将此值作为自己的点数，继续第二轮、第三轮...直到某轮的和数等于点数则取胜，若在此前出现和数为7则为负。
//由rolldice函数负责模拟投骰子、计算和数并输出和数。

#include <iostream>
#include <cstdlib>//cstdlib是C++里面的一个常用函数库， 等价于C中的<stdlib.h>
using namespace std;

enum GameStatus {win, lose, playing};//枚举类型

int RollDice()
{//掷骰子，计算和数，输出和数
	int dice1 = 1 + rand() % 6;
	int dice2 = 1 + rand() % 6;
	int sum = dice1 + dice2;
	cout << "player rolled:\t" << dice1 << " + " << dice2 << " = " << sum << endl;
	return sum;
}

void main()
{
	int sum, mypoint;
	GameStatus status;

	unsigned seed;
	cout << "please enter an unsigned integer\t";
	cin >> seed;//输入随机数种子
	srand(seed);//将种子传给rand()

	sum = RollDice();//第一轮掷骰子，计算和数

	switch (sum)
	{
		case 7:
		case 11:
			status = win;
			break;
		case 2:
		case 3:
		case 12:
			status = lose;
			break;
		default:
			status = playing;
			mypoint = sum;
			cout << "point is  " << mypoint << endl;
			break;
	}

	while (status == playing)//只要状态仍为playing,就继续进行下一轮
	{
		sum = RollDice();
		if (sum == mypoint)    //某轮的和数等于点数则取胜
			status = win;
		else if (sum == 7)    //出现和数为7则为负
			status = lose;
	}

	//当状态不为playing时上面的循环结束,以下程序段输出游戏结果
	if (status == win)
		cout << "player wins" << endl;
	else
		cout << "player loses" << endl;
}

