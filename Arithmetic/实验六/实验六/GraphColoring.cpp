/**********************************图的着色问题***********************************
#include <iostream>
using namespace std;

int g[1000][1000];
int state[1000];
int n;
int cnum;
int x = 0;

int judge(int index)
{
	for (int i = 0; i < index; i++)
	{
		if (g[index][i] == 1 && state[i] == state[index])
			return 0;
	}
	return 1;
}

void Show(int index)
{ 
	int i;

	for (i = 1; i <= index; i++) 
	{
		cout << i << "is Color" << state[i] << endl;
	}
	x += 1;
	cout << endl;
}

void sear(int index)
{
	int i;

	if (judge(index))
	{
		if (index == n - 1)
			Show(index);
		else
		{
			for (i = 1; i <= cnum; i++)
			{
				state[index + 1] = i;
				sear(index + 1);
			}
		}
	}
}

int main()
{
	int a, b, i;

	cout << "请输入边的条数：";
	cin >> n;
	cout << "请输入可支配颜色数：";
	cin >> cnum;
	cout << "请输入的矩阵：" << endl;
	for (i = 1; i <= n; i++)
	{
		cin >> a;
		cin >> b;
		g[a][b] = 1;
		g[b][a] = 1;
	}
	cout << endl;
	cout << "着色结果为：" << endl;
	sear(0);
	cout << "一共有" << x << "种着色方案" << endl;
	return 0;
}*/


/*
5
3
1 2
1 3
1 4
2 3
4 3
*/
