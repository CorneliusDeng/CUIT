#include<stdio.h>

int main(void)
{
	int m, i ,j, a[20][20];
	int sum, sum1 = 0, sum2 = 0;

	printf("Please input m: ");
	scanf("%d", &m);

	printf("\nPlease input array:\n");
	for (i = 0; i < m; i++)
	{
		for (j = 0; j < m; j++)
		{
			scanf("%d", &a[i][j]);
		}
	}

	for (i = 0, j = 0; i < m; i++)//计算矩阵第一列的和，储存在sum1中
	{
		sum1 += a[i][j]; 
	}
	for (i = 0, j = m - 1; i < m; i++)//计算矩阵最后一列的和，储存在sum2中
	{
		sum2 += a[i][j];
	}

	sum = sum1 + sum2;

	printf("\nSum = %d\n", sum);

	return 0;
}