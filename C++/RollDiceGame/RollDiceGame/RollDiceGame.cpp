//ÿ�����������棬�����ֱ�Ϊ1��2��3��4��5��6����Ϸ���ڳ���ʼʱ����һ���޷�����������Ϊ��������������ӡ�
//ÿ��Ͷ�������ӣ���һ���������Ϊ7��11��Ϊʤ����Ϸ����������Ϊ2��3��12��Ϊ������Ϸ������
//����Ϊ����ֵ�򽫴�ֵ��Ϊ�Լ��ĵ����������ڶ��֡�������...ֱ��ĳ�ֵĺ������ڵ�����ȡʤ�����ڴ�ǰ���ֺ���Ϊ7��Ϊ����
//��rolldice��������ģ��Ͷ���ӡ�������������������

#include <iostream>
#include <cstdlib>//cstdlib��C++�����һ�����ú����⣬ �ȼ���C�е�<stdlib.h>
using namespace std;

enum GameStatus {win, lose, playing};//ö������

int RollDice()
{//�����ӣ�����������������
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
	cin >> seed;//�������������
	srand(seed);//�����Ӵ���rand()

	sum = RollDice();//��һ�������ӣ��������

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

	while (status == playing)//ֻҪ״̬��Ϊplaying,�ͼ���������һ��
	{
		sum = RollDice();
		if (sum == mypoint)    //ĳ�ֵĺ������ڵ�����ȡʤ
			status = win;
		else if (sum == 7)    //���ֺ���Ϊ7��Ϊ��
			status = lose;
	}

	//��״̬��Ϊplayingʱ�����ѭ������,���³���������Ϸ���
	if (status == win)
		cout << "player wins" << endl;
	else
		cout << "player loses" << endl;
}

