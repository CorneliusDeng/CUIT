/*************************************0-1�������⣨���ݷ���************************************/

#include <iostream>
using namespace std;
#define MAXN 100

//�����ʾ
int n;			//n����Ʒ
int W;			//������������
int w[MAXN] = { 0};	//�����Ʒ���������飬0�±�����
int v[MAXN] = { 0};	//�����Ʒ��ֵ�����飬0�±�����
//�������ʾ
int x[MAXN];			//������ս�
int maxv; 			//������Ž���ܼ�ֵ

void Knapsack(int i, int tw, int tv, int op[])  //���0/1��������
{
	if (i > n)				//�ҵ�һ��Ҷ�ӽ��
	{
		if (tw == W && tv > maxv) 		//�ҵ�һ�����������ĸ��Ž�,����
		{
			maxv = tv;
			for (int j = 1; j <= n; j++)
				x[j] = op[j];
		}
	}
	else					//��δ����������Ʒ
	{
		if (tw + w[i] <= W)			//���ӽ���֦
		{
			op[i] = 1;			//ѡȡ��i����Ʒ
			Knapsack(i + 1, tw + w[i], tv + v[i], op);
		}
		op[i] = 0;				//��ѡȡ��i����Ʒ,����
		Knapsack(i + 1, tw, tv, op);
	}
}

void dispasolution()         //������Ž�
{
	cout << "���װ����ǣ�" << endl;
	for (int i = 1; i <= n; i++)
	{
		if (x[i] == 1)
		{
			cout << "ѡȡ��" << i << "����Ʒ" << endl;
		}
	}
	cout << "������ = " << W << ", �ܼ�ֵ = " << maxv << endl;
}
int main()
{
	cout << "�������ʱ�ж�������Ʒ: " ;
	cin >> n;
	cout << endl << "�����뱳���ĳ���: ";
	cin >> W;
	for (int i = 1; i < 5; i++)
	{
		cout << endl << "�������" << i << "����Ʒ�������ͼ�ֵ���м��ÿո��������";
		cin >> w[i];
		cin >> v[i];
	}
	cout << endl;

	int op[MAXN];  //�����ʱ��
	memset(op, 0, sizeof(op));//��op�����е�����Ԫ����Ϊ0
	Knapsack(1, 0, 0, op);
	dispasolution();
	return 0;
}

/*
4
6
5 4
3 4
2 3
1 1
*/
