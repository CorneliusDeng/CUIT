#include <stdio.h>

int main()
{
	int i ,j, m, sum, sum1 = 0, sum2 = 0, sum3 = 0;
	int arr[20][20];

	printf("Please input m: ");
	scanf("%d", &m);

	printf("\nPlease input array:\n");
	for (i = 0; i < m; i++)
	{
		for (j = 0; j < m; j++)
		{
			scanf("%d", &arr[i][j]);
		}
	}

	for (i = 0; i < m; i++)
	{
		sum1 += arr[i][0];
		sum2 += arr[i][2];
		sum3 += arr[i][m-1];

	}
	sum = sum1 + sum2 + sum3;

	printf("\nSum = %d\n", sum);
}