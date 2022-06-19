/**********************************���������************************************/

#include <iostream>
using namespace std;
#define N 100

struct Activity
{
	int number;            //����
	int begin;           //���ʼʱ��
	int end;            //�����ʱ��
	bool flag;          //�˻�Ƿ�ѡ��
	int roomnum;      //�˻���ļ���Ҿ���
};


//���ڻ�������ս���ʱ���������,ʹ�ÿ�������
void quicksort(Activity* a, int p, int r)
{
	if (p < r)
	{
		int i = p - 1, j = p;
		Activity aa = a[r];
		while (j < r)          
		{//���whileѭ�����ڽ����黮��ΪС�����һ��Ԫ�أ��������һ��Ԫ�غ����һ��Ԫ�������֡�
			if (a[j].end <= aa.end)
			{
				i++;        
				//i����ָ���һ����������һ��Ԫ�أ�Ȼ��i++ȥռ���µ�λ�á�
				//jʼ��ָ��ڶ�����������һ��Ԫ�ص���һ��Ԫ�أ�Ҳ���Ǽ����������Ԫ��
				Activity t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
			j++;
		}
		//�������еĽ�����Ϊ�˰����һ��Ԫ���ᵽ��Ӧ���е�λ��
		Activity t = a[r];               
		a[r] = a[i + 1];
		a[i + 1] = t;
		quicksort(a, p, i);
		quicksort(a, i + 1, r);
	}
}


int select_room(Activity* a, int* time, int n)
{
	int i = 1, j = 1;
	//�����ʼ�����ݣ��ѵ�һ��������ˣ�Ȼ��ѭ���ӵڶ������ʼ
	int sumroom = 1;        //�Ѿ�ռ�õĽ��ң�����Ȼ�󷵻�����ֵ
	int sumact = 1;           //�Ѿ���ѡ��Ļ����ʼ��Ϊ1
	time[1] = a[0].end;      //��ʼ������1�����һ����Ľ���ʱ��Ϊ�1�Ľ���ʱ��
	a[0].roomnum = 1;         //����һ���ռ�õĽ��ҳ�ʼ��Ϊ����1
	for (i = 1; i < n; i++)                   //����i���
	{
		for (j = 1; j <= sumroom; j++)
		{
			//����j������,�ѻi�Ž��ĸ�����
			if (a[i].begin >= time[j] && (!a[i].flag))          
			{//�i��ʼ��ʱ��Ƚ���j���һ����Ľ���ʱ�����һiû�б��滮������ô��Ӧ�ðɻi�������j     

				//����һ������
				a[i].roomnum = j;
				a[i].flag = true;
				time[j] = a[i].end;
				sumact++;
			}
		}
		
		if (sumact < n && i == n - 1)             
		{//�Ѿ���һ������ܼ���Ļ�����ˣ��i�������м�����ң���ô�����Լ��¿�һ�����
			i = 0;                              //�������� ����������
			sumroom++;
		}
	}
	return sumroom;
}

int main()
{
	Activity a[N];          //����һ���ṹ��
	int time[N];            //time ���ڼ�¼ĳ����������ĩβ��Ľ���ʱ�䣬��������һ����Ŀ�ʼʱ��Ƚ�
	int n, i = 0, j;                  //����Ļ����
	int sum;
	int k = 0;
	cout << "����������";
	cin >> n;
	cout << endl;
	for (i = 0; i < n; i++)
	{
		time[i + 1] = 0;
		a[i].number = i + 1;
		a[i].flag = false;
		a[i].roomnum = 0;
		cout << "������" << ++k << "�Ŀ�ʼʱ��:";
		cin >> a[i].begin;
		cout << "������" << k << "�Ľ���ʱ��:";
		cin >> a[i].end;
		cout << endl;

	}
	quicksort(a, 0, n - 1);
	sum = select_room(a, time, n);
	cout << "��ռ��������Ŀ�ǣ���" << sum << "��" << endl;
	for (i = 0; i < n; i++)
	{
		cout << "�" << a[i].number << "�ڽ���" << a[i].roomnum << "��" << endl;
	}
}

/*
6
1
5
1
4
2
6
8
9
9
10
3
6
*/