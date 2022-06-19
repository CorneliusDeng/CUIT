/**********************************̰���㷨0/1��������***********************************
#include <iostream>
using namespace std;
#define maxN 100

int max(int a, int b)
{
	if (a >= b)
	{
		return a;
	}
	else
	{
		return b;
	}
}

void Knapsack(int v[], int w[], int x[], int c, int n, int m[maxN][maxN])
{//��������Ϊ����Ʒ��ֵ���顢��Ʒ�������飬��Ʒѡ��״̬���顢�������ء���Ʒ��������ʱ����
	int i, j;

	for (j = 0; j < c; j++)
	{
		if (j < w[n])
		{
			m[n][j] = 0;
		}
		else
		{
			m[n][j] = v[n];
		}
	}
	for (i = n - 1; i >= 1; i--)
	{
		for (j = w[i]; j <= c; j++)
		{
			m[i][j] = max(m[i + 1][j], m[i + 1][j - w[i]] + v[i]);
		}
	}

	for (i = 1; i < n; i++)
	{
		if (m[i][c] == m[i + 1][c])
		{
			x[i] = 0;
		}
		else
		{
			x[i] = 1;
			c = c - w[i];
		}
	}

	x[n] = m[n][c] ? 1 : 0;
}

int main()
{
	int i ;
	int n, m;//��Ʒ�������ͱ����ĳ�����
	

	cout << "��ʱ����Ʒ�����ǣ�";
	cin >> n;
	cout << "�����ĳ�����Ϊ��";
	cin >> m;
	
	int w[maxN], v[maxN]; //�����Ʒ�����ͼ�ֵ������
	int x[maxN] = { 0 };//��Ʒѡ��״̬����

	cout << endl;
	for (i = 1; i < n + 1; i++)//0λ�����Ԫ��
	{
		cout << "������������Ʒ�������ͼ�ֵ���м��ÿո�ָ���:";
		cin >> w[i];
		cin >> v[i];
		cout << endl;
	}

	int array[maxN][maxN] = { 0 };
	Knapsack(v, w, x, m, n, array);
	cout << "�ڱ����ĳ��ط�Χ�ڣ����ܷ�����Ʒ������ֵΪ:" << array[1][m] << endl;
	cout << endl << "��Ʒ���뱳����״̬��";
	for (i = 1; i <= n; i++)
	{
		cout << x[i] << "   ";
		
	}
	cout << endl;

	return 0;
}*/

/*
7
15
2 10
3 5
5 15
7 7
1 6
4 18
1 3
*/