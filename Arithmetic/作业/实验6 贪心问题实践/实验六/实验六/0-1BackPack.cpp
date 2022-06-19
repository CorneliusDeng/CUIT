/**********************************贪心算法0/1背包问题***********************************
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
{//参数依次为：物品价值数组、物品重量数组，物品选择状态数组、背包承重、物品数量、临时数组
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
	int n, m;//物品的数量和背包的承重量
	

	cout << "此时的物品数量是：";
	cin >> n;
	cout << "背包的承重量为：";
	cin >> m;
	
	int w[maxN], v[maxN]; //存放物品数量和价值的数组
	int x[maxN] = { 0 };//物品选择状态数组

	cout << endl;
	for (i = 1; i < n + 1; i++)//0位不存放元素
	{
		cout << "请依次输入物品的重量和价值（中间用空格分隔）:";
		cin >> w[i];
		cin >> v[i];
		cout << endl;
	}

	int array[maxN][maxN] = { 0 };
	Knapsack(v, w, x, m, n, array);
	cout << "在背包的承重范围内，它能放入物品的最大价值为:" << array[1][m] << endl;
	cout << endl << "物品放入背包的状态：";
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