#include <stdio.h>

int main()
{
	int i ,j, m, n, p;
	int arr[20][20];
	
	printf("������ m �� n: ");
	scanf("%d%d", &m, &n);

	printf("������ %d ��, ÿ�� %d ������:\n", m, n);
	for (i = 0; i < m; i++)
	{
		for (j = 0; j < n; j++)
		{
			scanf("%d", &arr[i][j]);
		}
	}
	
	printf("������Ҫ��ʾ�е��к�: ");
	scanf("%d", &p);

	printf("\n���е�����Ϊ: ");
	for (i = 0; i < m; i++)
	{
		printf("%d ", arr[i][p]);
	}
	putchar('\n');


}