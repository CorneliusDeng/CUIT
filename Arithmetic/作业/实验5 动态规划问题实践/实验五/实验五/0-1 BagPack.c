#include "head.h"

int KnapSack(int n, int w[], int v[], int x[], int C)
{//动态规划0/1背包问题，返回其容量内最大价值

	int V[50][50];//前i个物品装入容量为j的背包中获得的最大价值
	int i, j;
	//填表,其中第一行和第一列全为0
	for (i = 0; i <= n; i++)
	{
		V[i][0] = 0;
	}
	for (j = 0; j <= C; j++)
	{
		V[0][j] = 0;
	}
	
	printf("动态规划过程排列如下：\n");
	for (i = 1; i <= n; i++)
	{
		for (j = 1; j <= C; j++)
		{
			if (j < w[i - 1])
			{
				V[i][j] = V[i - 1][j];
				printf("[%d][%d]=%2d  ", i, j, V[i][j]);
			}

			else
			{
				V[i][j] = max(V[i - 1][j], V[i - 1][j - w[i - 1]] + v[i - 1]);
				printf("[%d][%d]=%2d  ", i, j, V[i][j]);
			}
		}
		putchar('\n');
	}
	//判断哪些物品被选中
	j = C;
	for (i = n; i >= 1; i--)
	{
		if (V[i][j] > V[i - 1][j])
		{
			x[i] = 1;
			j = j - w[i - 1];
		}
		else
			x[i] = 0;
	}
	printf("对于上述%d个物品，选中与否用（0/1）展示:\n", n);
	for (i = 1; i <= n; i++)
	{
		printf("%d ", x[i]);
	}
		
	printf("\n");
	return V[n][C];

}
