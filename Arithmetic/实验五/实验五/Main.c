#include "head.h"

void main()
{	
	/**************************************数塔问题************************************************/
	printf("请输入数塔的行数(1<n<=100)：");
	int temp1 = scanf("%d", &nc);

	printf("请按行依次输入数塔中的值(整型，第i层有i个节点)：\n");
	for (int i = 0; i < nc; i++)
	{
		for (int j = 0; j <=  i; j++) 
 		{
			int temp2 = scanf("%d", &numbertower[i][j]);
		}
	}
	putchar('\n');
	
	NumberTower(nc);
	print_result(nc);

	printf("\n************************************************分割线*************************************************\n");

	/**************************************0/1背包问题************************************************/
	int maxv;//获得的最大价值
	int w[15];//物品的重量
	int v[15];//物品的价值
	int x[15];//物品的选取状态
	int n, i;//n为物品数量
	int C;//背包最大容量
	printf("\n请输入背包的最大容量:\n");
	int temp3 = scanf("%d", &C);

	printf("输入物品数:\n");
	int temp2 = scanf("%d", &n);
	printf("请分别输入物品的重量:\n");
	for (i = 0; i < n; i++)
	{
		int temp4 = scanf("%d", &w[i]);
	}


	printf("请分别输入物品的价值:\n");
	for (i = 0; i < n; i++)
	{
		int temp5 = scanf("%d", &v[i]);
	}


	maxv = KnapSack(n, w, v, x, C);

	printf("在背包容量内，能够选取的物品最大价值为:\t");
	printf("%d\n", maxv);


	/*
	测试数据
	
	数塔
	5
	8
	12 15
	3 9 6
	8 10 5 12000
	18 4 1 10 9
	
	0/1背包问题
	10
	5
	2 2 6 5 4
	6 3 5 4 6
	*/
}