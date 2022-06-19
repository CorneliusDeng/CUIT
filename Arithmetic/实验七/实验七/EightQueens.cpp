/*************************************八皇后问题（回溯法）************************************/

#include <iostream>
#include <math.h>   //使用绝对值函数abs
using namespace std;

#define MAXN 100
int x[MAXN];          //存放各皇后所在的列号
int counts = 0;           //累计解的个数
int flag = 0;		//有无解的标记

bool place(int i)   //考察皇后i放置在x[i]列是否发生冲突
{
	for (int j = 1; j < i; j++) //j=1～i-1是已放置了皇后的行
	{
		if (x[i] == x[j] || abs(i - j) == abs(x[i] - x[j]))
		{
			return false;  //冲突返回false
		}
	}
			
	return true;
}

void dispasolution(int n)
{
	cout << "第" << ++counts << "个解：";
	for (int i = 1; i <= n; i++)
	{
		cout << x[i] << "  ";
	}
	cout << endl;
}

void Queens(int n)	//求解n皇后问题
{
	int i = 1;		//i表示当前行,也表示放置第i个皇后
	x[i] = 0;		//x[i]是当前列,每个新考虑的皇后初始位置置为0列
	while (i >= 1)	//尚未回溯到头，循环
	{
		x[i]++;		//原位置后移动一列
		while (x[i] <= n && !place(i))  //试探一个位置(i,x[i])
			x[i]++;
		if (x[i] <= n)	//为第i个皇后找到了一个合适位置(i,x[i])
		{
			if (i == n)	//若放置了所有皇后,输出一个解
			{
				dispasolution(n);
				flag = 1;
			}
			else		//皇后没有放置完
			{
				i++;	//转向下一行,即开始下一个新皇后的放置
				x[i] = 0;	//每个新考虑的皇后初始位置置为0列
			}
		}
		else i--; 	//若第i个皇后找不到合适的位置,则回溯到上一个皇后
	}

	if (!flag)
	{
		cout << endl << "【无解】" << endl;
	}
	else
		cout << endl << "共有【" << counts << "】个解" << endl;
}

int main()
{
	int n;
	cout << "请确定n皇后问题的规模：";
	cin >> n;
	cout << endl;
	Queens(n);

	return 0;
}


/*
n皇后问题递归算法
void Backtrack(int i)
{
	 if (i>n)       //n个皇后都放置好,输出
		dispasolution();
	 else
	 {   for (int j=1;j<=n;j++) //每层均有n种放法
		 {
			  x[i]=j; //在第j列放置皇后i即x[i]
			  if (place(i)==1)  //不冲突
				 Backtrack(i+1);//继续递归放置下一个皇后
		 }
	 }
}
*/
