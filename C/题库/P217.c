#include<stdio.h>

int main(void)
{
	int i, j, m, a[20][20];
	int sum, sum1 = 0, sum2 = 0;

	printf("Please input m: ");
	scanf("%d", &m);

	printf("Please input array:\n");
	for (i = 0; i < m; i++)
	{
		for (j = 0; j < m; j++)
		{
			scanf("%d",&a[i][j]);
		}
	}

	for (i = 0; i < m; i++)//计算主对角线上的值
	{
		for (j = 0; j < m; j++)
		{
			if (i == j)
			{
				sum1 += a[i][j];
			}
		}
	}

	for (i = 0; i < m; i++)//计算副对角线上的值
	{
		for (j = 0; j < m; j++)
		{
			if ((i + j) == (m - 1) && (i != j))
			{
				sum2 += a[i][j]; 
			}
		}
	}

	sum = sum1 + sum2;
	printf("sum=%d\n",sum);

	return 0;
}