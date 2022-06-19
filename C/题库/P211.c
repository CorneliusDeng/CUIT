#include <stdio.h>

int main()
{
	int n;
	int i, j;

	printf("Please input n:");
	scanf("%d", &n);

	//输出菱形的上半部分（共n+1行） 
	for (i = 1; i <= n + 1; i++)  // 输出前n+1行# 
	{
		for (j = i; j <= n; j++)  // 输出第i行时，先输出空格,决定输出的空格数
		{
			printf(" ");
		}
		for (j = 1; j <= 2 * i - 1; j++)  //输出第i行的#
		{
			printf("#");
		}
		printf("\n");
	}
	
	//输出菱形的下半部分（共n行） 
	for (i = 1; i <= n; i++)  
	{
		for (j = 1; j <= i; j++)
		{
			printf(" ");
		}
		for (j = 1; j <= 2 * (n - i) + 1; j++)
		{
			printf("#");
		}
		printf("\n");
	}
	
	return 0;

}