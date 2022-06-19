#include<stdio.h>

int main(void)
{
	int i, j, a[10], tmp;

	printf("please input 10 integer numbers: ");
	for (i = 0; i < 10; i++)
	{
		scanf("%d", &a[i]);
	}

	putchar('\n');
	printf("\nthe array before sorted: ");
	for (i = 0; i < 10; i++)
	{
		printf("%-4d", a[i]);
	}

	for (i = 0; i < 10; i++)//冒泡法对这十个数进行比较且按序排列
	{
		for (j = 0; j < 9 - i ; j++)
		{
			if (a[j] > a[j+1])
			{
				tmp = a[j];
				a[j] = a[j+1];
				a[j+1] = tmp;
			}
		}
	}

	printf("\nthe array after  sorted: ");
	for (i = 0; i < 10; i++)
	{
		printf("%-4d", a[i]);
	}

	return 0;

}