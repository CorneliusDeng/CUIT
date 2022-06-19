/*************************************0-1背包问题（回溯法）************************************/

#include <iostream>
using namespace std;
#define MAXN 100

//问题表示
int n;			//n种物品
int W;			//背包限制重量
int w[MAXN] = { 0};	//存放物品重量的数组，0下标弃用
int v[MAXN] = { 0};	//存放物品价值的数组，0下标弃用
//求解结果表示
int x[MAXN];			//存放最终解
int maxv; 			//存放最优解的总价值

void Knapsack(int i, int tw, int tv, int op[])  //求解0/1背包问题
{
	if (i > n)				//找到一个叶子结点
	{
		if (tw == W && tv > maxv) 		//找到一个满足条件的更优解,保存
		{
			maxv = tv;
			for (int j = 1; j <= n; j++)
				x[j] = op[j];
		}
	}
	else					//尚未找完所有物品
	{
		if (tw + w[i] <= W)			//左孩子结点剪枝
		{
			op[i] = 1;			//选取第i个物品
			Knapsack(i + 1, tw + w[i], tv + v[i], op);
		}
		op[i] = 0;				//不选取第i个物品,回溯
		Knapsack(i + 1, tw, tv, op);
	}
}

void dispasolution()         //输出最优解
{
	cout << "最佳装填方案是：" << endl;
	for (int i = 1; i <= n; i++)
	{
		if (x[i] == 1)
		{
			cout << "选取第" << i << "个物品" << endl;
		}
	}
	cout << "总重量 = " << W << ", 总价值 = " << maxv << endl;
}
int main()
{
	cout << "请输入此时有多少种物品: " ;
	cin >> n;
	cout << endl << "请输入背包的承重: ";
	cin >> W;
	for (int i = 1; i < 5; i++)
	{
		cout << endl << "请输入第" << i << "件物品的重量和价值（中间用空格隔开）：";
		cin >> w[i];
		cin >> v[i];
	}
	cout << endl;

	int op[MAXN];  //存放临时解
	memset(op, 0, sizeof(op));//将op数组中的所有元素设为0
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
