#include<stdio.h>

int main()
{
	int n, i, j;

	printf("Please input n: ");
	scanf("%d",&n);

		
	for (i = 1; i <= n; i++)//输出图形的上半部分（共n行）
	{
		for (j = 1; j <= (i - 1); j++) //输出第i行第一个@前的空格
		{
			printf(" ");
		}
		printf("%c", '@'); //输出第i行第一个@
		if (i != n) //如果当前行不是第n行
		{
			for (j = 1; j <= 2 * (n - i) - 1; j++) //输出第i行第二个@前的空格
			{
				printf(" ");
			}
			printf("%c", '@'); //输出第i行第二个@
		}
		printf("\n");
	}
	
	for (i = n - 1; i >= 1; i--)//输出图形的下半部分（共n-1行）
	{
		for (j = 1; j <= (i - 1); j++)
		{
			printf(" ");//输入第n+x行前面的空格
		}
		printf("%c", '@');
		for (j = 1; j <= 2 * (n - i) - 1; j++)
		{
			printf(" ");
		}
		printf("%c", '@');
	
		printf("\n");
	}
	
	return 0;
}