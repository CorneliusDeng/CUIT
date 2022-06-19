#include<stdio.h>

int main(void)
{
	int a[20][20], m, n, i, j, k, sum = 0;

	printf("请输入 m 和 n: ");
	scanf("%d%d", &m, &n);

	printf("请输入 %d 行, 每行 %d 列整数:\n", m, n);
	for (i = 0; i < m; i++)
	{
		for(j = 0; j < n; j++)
		{
			scanf("%d", &a[i][j]);
		}
	}

	printf("请输入要计算和之列的列号: ");
	scanf("%d",  &k);

	for (i = 0, j = k; i < m; i++)
	{
		sum += a[i][k];
	}

	printf("\n该列上各元素之和为:%d\n", sum);

	return 0;
}
