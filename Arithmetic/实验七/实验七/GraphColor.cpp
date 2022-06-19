/*************************************图的着色问题（回溯法）*************************************/

#include <iostream>
using namespace std;

#define MAXN 20

//问题表示
int n, k, m;         //n个顶点，k条边，m种颜色
int a[MAXN][MAXN];	//存放图的邻阶矩阵

//求解结果表示
int Count = 0;      //累计解个数
int x[MAXN];       //x[i]表示顶点i的着色

bool Same(int i)
{//判断顶点i是否与相连顶点存在相同的着色
	for (int j = 1; j <= n; j++)
	{
		if (a[i][j] == 1 && x[i] == x[j])
		{//如果相同
			return true;
		}		
	}
	return false;
}

void displaysolution()   //输出一种着色方案
{
	cout <<"第" << Count << "种着色方案：" << endl;

	for (int j = 1; j <= n; j++)
	{
		cout << x[j] << ",";
	}
	cout << endl;
}

void GraphColor(int i)
{
	if (i > n) 
	{// 到达叶子结点，则是一种解
		Count++;
		displaysolution();
	}
	else 
	{
		for (int j = 1; j <= m; j++) 
		{// 遍历尝试每一种颜色
			x[i] = j;
			if (!Same(i)) // 如果没有颜色相同的情况，则填涂下一个点
				GraphColor(i + 1);
			x[i] = 0; // 该点未填色，回溯到之前一个点
		}
	}
}

int main()
{
	int x, y;
	cout << "请输入顶点个数：";
	cin >> n;
	cout << "请输入边的条数：";
	cin >> k; 
	cout << "请输入颜色数目：";
	cin >> m;

	cout << endl << "现在请输入顶点的相连情况：" << endl;
	for (int j = 1; j <= k; j++)	    //建立邻接矩阵
	{
		cin >> x;
		cin >> y;
		a[x][y] = 1;                //无向图的边对称
		a[y][x] = 1;
	}
	cout << endl << "以下是具体的着色情况：" << endl;
	GraphColor(1);                 //从顶点1开始搜索
	if (Count > 0)                    //输出结果
		cout << endl << "一共有【" << Count << "】种着色方案" << endl;
	else
		cout << "-1" << endl;

	return 0;
}


/*
输入样例
4 
4 
3
1 2
1 3
1 4
2 4
*/