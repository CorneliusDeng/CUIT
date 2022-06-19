#include<stdio.h>

int main(void)
{
	int i, j, tmp, a[100], n = 0;

	printf("Input: ");
	for (i = 0; i < 100; i++)//输入数字存放进数组并计数
	{
		scanf("%d", &tmp);
		if (tmp != -888)
		{
			a[i] = tmp;
			n++;
		}
		else
		{
			break;
		}
	}

	for (i = 0; i < n -1; i++)//对数组内的数字进行从小到大的冒泡排序
	{
		for (j = 0; j < n - 1 - i; j++)
		{
			if (a[j] > a [j+1])
			{
				tmp = a[j];
				a[j] = a[j+1];
				a[j+1] = tmp;
			}
		}
	}

	printf("\nResult: ");
	for (i = 0; i < n; i++)
	{
		printf("%d ", a[i]);
	}
	putchar('\n');

	return 0;
}