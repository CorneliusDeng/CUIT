/*************************************�˻ʺ����⣨���ݷ���************************************/

#include <iostream>
#include <math.h>   //ʹ�þ���ֵ����abs
using namespace std;

#define MAXN 100
int x[MAXN];          //��Ÿ��ʺ����ڵ��к�
int counts = 0;           //�ۼƽ�ĸ���
int flag = 0;		//���޽�ı��

bool place(int i)   //����ʺ�i������x[i]���Ƿ�����ͻ
{
	for (int j = 1; j < i; j++) //j=1��i-1���ѷ����˻ʺ����
	{
		if (x[i] == x[j] || abs(i - j) == abs(x[i] - x[j]))
		{
			return false;  //��ͻ����false
		}
	}
			
	return true;
}

void dispasolution(int n)
{
	cout << "��" << ++counts << "���⣺";
	for (int i = 1; i <= n; i++)
	{
		cout << x[i] << "  ";
	}
	cout << endl;
}

void Queens(int n)	//���n�ʺ�����
{
	int i = 1;		//i��ʾ��ǰ��,Ҳ��ʾ���õ�i���ʺ�
	x[i] = 0;		//x[i]�ǵ�ǰ��,ÿ���¿��ǵĻʺ��ʼλ����Ϊ0��
	while (i >= 1)	//��δ���ݵ�ͷ��ѭ��
	{
		x[i]++;		//ԭλ�ú��ƶ�һ��
		while (x[i] <= n && !place(i))  //��̽һ��λ��(i,x[i])
			x[i]++;
		if (x[i] <= n)	//Ϊ��i���ʺ��ҵ���һ������λ��(i,x[i])
		{
			if (i == n)	//�����������лʺ�,���һ����
			{
				dispasolution(n);
				flag = 1;
			}
			else		//�ʺ�û�з�����
			{
				i++;	//ת����һ��,����ʼ��һ���»ʺ�ķ���
				x[i] = 0;	//ÿ���¿��ǵĻʺ��ʼλ����Ϊ0��
			}
		}
		else i--; 	//����i���ʺ��Ҳ������ʵ�λ��,����ݵ���һ���ʺ�
	}

	if (!flag)
	{
		cout << endl << "���޽⡿" << endl;
	}
	else
		cout << endl << "���С�" << counts << "������" << endl;
}

int main()
{
	int n;
	cout << "��ȷ��n�ʺ�����Ĺ�ģ��";
	cin >> n;
	cout << endl;
	Queens(n);

	return 0;
}


/*
n�ʺ�����ݹ��㷨
void Backtrack(int i)
{
	 if (i>n)       //n���ʺ󶼷��ú�,���
		dispasolution();
	 else
	 {   for (int j=1;j<=n;j++) //ÿ�����n�ַŷ�
		 {
			  x[i]=j; //�ڵ�j�з��ûʺ�i��x[i]
			  if (place(i)==1)  //����ͻ
				 Backtrack(i+1);//�����ݹ������һ���ʺ�
		 }
	 }
}
*/
