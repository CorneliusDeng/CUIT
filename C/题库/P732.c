#include <stdio.h>

int main(void)
{
	int i, j, sum = 0, arr[3][3];

	for (i=0; i<3; i++)
	{
		for (j=0; j<3; j++)
		{
			scanf("%d", &arr[i][j]);
		}
	}
	
	for (i=0; i<3; i++)
	{
		for (j=0; j<3; j++)
		{
			sum += arr[i][j];
		}
	}
	
	printf("sum=%d\n", sum); 

	return 0;
}