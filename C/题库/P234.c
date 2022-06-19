#include <stdio.h>

int main()
{
	int i ,j, m, sum, sum1 = 0, sum2 = 0;
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

	for (j = 0; j < m; j++)
	{
		sum1 += arr[0][j];
		sum2 += arr[m-1][j];
	}

	sum = sum1 + sum2;

	printf("\nSum = %d\n", sum);
}