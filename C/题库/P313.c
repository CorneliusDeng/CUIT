#include <stdio.h>

int main(void)
{
	int arr[20][20], i, j, max, min, maxHPos;
	int maxLPos, minHPos, minLPos, flag = 0, m, n, k;
	
	printf("Please input m and n:");
	scanf("%d%d", &m, &n);
	
	/* 从键盘输入m×n矩阵，并存放到数组arr中 */
	for (i = 0; i < m; i++)
	{
		for (j = 0; j < n; j++)
		{
			scanf("%d", &arr[i][j]);
		}
	}

	/* 在矩阵中找鞍点 */
	for (i = 0; i < m; i++)
	{
		/* 找第i行的最大值及最大值的下标（包括行标和列标），i的值从0开始 */
		max = arr[i][0];  
		maxHPos = i;
		maxLPos = 0;
		for (j = 1; j < n; j++)
		{
			if (arr[i][j] > max)
			{
				max = arr[i][j];
				maxHPos = i;
				maxLPos = j;
			}
		}
		
		/* 在第i行的最大值所在列找该列的最小值及其下标 */
		min = arr[0][maxLPos];
		minHPos = 0;
		minLPos = maxLPos;
		for (k = 1; k < m; k++)
		{
			if (arr[k][maxLPos] < min)
			{
				min = arr[k][maxLPos];
				minHPos = k;
				minLPos = maxLPos;
			}
		}
		
		/* 判断第i行的最大值是否是第i行最大值所在列的最小值，如果是，找到鞍点*/
		if ((maxHPos == minHPos) && (maxLPos == minLPos))
		{
			printf("you an dian, wei:a[%d][%d]=%d\n", maxHPos,
				maxLPos, arr[maxHPos][maxLPos]);
			flag = 1;  //给变量flag赋值1，表示鞍点已找到
			break;  //鞍点已找到，结束查找过程
		}
	}
	if (0 == flag) //flag的值为0，表示在矩阵中没有找到鞍点
	{
		printf("mei you an dian.\n");
	}
	
	return 0;
}