/*************************************ͼ����ɫ���⣨���ݷ���*************************************/

#include <iostream>
using namespace std;

#define MAXN 20

//�����ʾ
int n, k, m;         //n�����㣬k���ߣ�m����ɫ
int a[MAXN][MAXN];	//���ͼ���ڽ׾���

//�������ʾ
int Count = 0;      //�ۼƽ����
int x[MAXN];       //x[i]��ʾ����i����ɫ

bool Same(int i)
{//�ж϶���i�Ƿ����������������ͬ����ɫ
	for (int j = 1; j <= n; j++)
	{
		if (a[i][j] == 1 && x[i] == x[j])
		{//�����ͬ
			return true;
		}		
	}
	return false;
}

void displaysolution()   //���һ����ɫ����
{
	cout <<"��" << Count << "����ɫ������" << endl;

	for (int j = 1; j <= n; j++)
	{
		cout << x[j] << ",";
	}
	cout << endl;
}

void GraphColor(int i)
{
	if (i > n) 
	{// ����Ҷ�ӽ�㣬����һ�ֽ�
		Count++;
		displaysolution();
	}
	else 
	{
		for (int j = 1; j <= m; j++) 
		{// ��������ÿһ����ɫ
			x[i] = j;
			if (!Same(i)) // ���û����ɫ��ͬ�����������Ϳ��һ����
				GraphColor(i + 1);
			x[i] = 0; // �õ�δ��ɫ�����ݵ�֮ǰһ����
		}
	}
}

int main()
{
	int x, y;
	cout << "�����붥�������";
	cin >> n;
	cout << "������ߵ�������";
	cin >> k; 
	cout << "��������ɫ��Ŀ��";
	cin >> m;

	cout << endl << "���������붥������������" << endl;
	for (int j = 1; j <= k; j++)	    //�����ڽӾ���
	{
		cin >> x;
		cin >> y;
		a[x][y] = 1;                //����ͼ�ı߶Գ�
		a[y][x] = 1;
	}
	cout << endl << "�����Ǿ������ɫ�����" << endl;
	GraphColor(1);                 //�Ӷ���1��ʼ����
	if (Count > 0)                    //������
		cout << endl << "һ���С�" << Count << "������ɫ����" << endl;
	else
		cout << "-1" << endl;

	return 0;
}


/*
��������
4 
4 
3
1 2
1 3
1 4
2 4
*/