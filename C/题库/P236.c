#include<stdio.h>

int main(void)
{
	int a[20][20], i, j, m, sum ;
	int sum1 = 0, sum2 = 0, sum3 = 0;

	printf("Please input m: ");
	scanf("%d", &m);
	
	printf("\nPlease input array:\n");
	for (i = 0; i < m; i++)
	{
		for (j =0; j < m; j++)
		{
			scanf("%d", &a[i][j]);
		}
	}
	
	for (i = 0, j = 0; j < m; j++)
	{
		sum1 += a[i][j];
	}
	for (i = 2, j = 0; j < m; j++)
	{
		sum2 += a[i][j];
	}
	for (i = m - 1, j = 0; j < m; j++)
	{
		sum3 += a[i][j]; 
	}

	sum = sum1 + sum2 + sum3;

	printf("\nSum = %d\n", sum);

	return 0;

}