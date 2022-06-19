#include<stdio.h>

int main()//从大到小排列
{
	int i, j, a[10], temp;

	printf("请输入十个整数：\n");
	for(i = 0; i < 10; i++)
		scanf("%d", &a[i]);

	for(i = 1; i < 10; i++)//第一种写法
	{
		for(j = 0; j < 10 - i; j++)
		{
			if(a[j] < a[j+1])
			{
				temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
			}
		}
	}
	printf("第一种排序后的结果是：\n");
	for(i = 0; i < 10; i++)
		printf("%-3d", a[i]);
	putchar('\n');



	for(i = 0; i < 9; i++)//第二种写法
	{
		for(j = i; j < 9; j++)
		{
			if(a[j] < a[j+1])
			{
				temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
			}
		}
	}
	printf("第二种排序后的结果是：\n");
	for(i = 0; i < 10; i++)
		printf("%-3d", a[i]);
	putchar('\n');


	for(i = 0; i < 9; i++)//第三种写法
	{
		for(j = 0; j < 9 - i; j++)
		{
			if(a[j] < a[j+1])
			{
				temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
			}
		}
	}
	printf("第三种排序后的结果是：\n");
	for(i = 0; i < 10; i++)
		printf("%-3d", a[i]);
	putchar('\n');


	for(i = 0; i < 9; i++)//第四种写法
	{
		for(j = i + 1; j < 9; j++)
		{
			if(a[j] < a[j+1])
			{
				temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
			}
		}
	}
	printf("第四种排序后的结果是：\n");
	for(i = 0; i < 10; i++)
		printf("%-3d", a[i]);
	putchar('\n');
}
