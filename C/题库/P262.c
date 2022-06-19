#include <stdio.h>

int main()
{
	int i ,j, m, n, p;
	int arr[20][20];
	
	printf("请输入 m 和 n: ");
	scanf("%d%d", &m, &n);

	printf("请输入 %d 行, 每行 %d 列整数:\n", m, n);
	for (i = 0; i < m; i++)
	{
		for (j = 0; j < n; j++)
		{
			scanf("%d", &arr[i][j]);
		}
	}
	
	printf("请输入要显示列的列号: ");
	scanf("%d", &p);

	printf("\n该列的内容为: ");
	for (i = 0; i < m; i++)
	{
		printf("%d ", arr[i][p]);
	}
	putchar('\n');


}