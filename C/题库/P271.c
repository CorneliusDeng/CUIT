#include<stdio.h>

int main(void)
{
	int a[20][20], m, n, i, j, k, sum = 0;

	printf("������ m �� n: ");
	scanf("%d%d", &m, &n);

	printf("������ %d ��, ÿ�� %d ������:\n", m, n);
	for (i = 0; i < m; i++)
	{
		for(j = 0; j < n; j++)
		{
			scanf("%d", &a[i][j]);
		}
	}

	printf("������Ҫ�����֮�е��к�: ");
	scanf("%d",  &k);

	for (i = 0, j = k; i < m; i++)
	{
		sum += a[i][k];
	}

	printf("\n�����ϸ�Ԫ��֮��Ϊ:%d\n", sum);

	return 0;
}
