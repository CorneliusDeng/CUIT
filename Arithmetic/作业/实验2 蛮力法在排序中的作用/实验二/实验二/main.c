#include "head.h"

void main()
{
	int a[10] = { 9, 8, 4, 89, 90, 23, 78, 34, 1, 67 };
	int b[10] = { 9, 8, 4, 89, 90, 23, 78, 34, 1, 67 };
	int c[10] = { 9, 8, 4, 89, 90, 23, 78, 34, 1, 67 };

	printf("选择排序之前的数组如下：\n");
	for (int i = 0; i < 10; i++)
	{
		printf("%d\t", a[i]);
	}

	SelectSort(a, 10);

	printf("\n选择排序之后的数组如下：\n");
	for (int i = 0; i < 10; i++)
	{
		printf("%d\t", a[i]);
	}
	

	printf("\n\n冒泡排序前的数组如下：\n");
	for (int i = 0; i < 10; i++)
	{
		printf("%d\t", b[i]);
	}

	BubbleSort(b, 10);

	printf("\n冒泡排序后的数组如下\n");
	for (int i = 0; i < 10; i++)
	{
		printf("%d\t", b[i]);
	}
	
	printf("\n\n鸡尾酒排序前的数组如下：\n");
	for (int i = 0; i < 10; i++)
	{
		printf("%d\t", c[i]);
	}

	CockTailSort(c, 10);

	printf("\n鸡尾酒排序后的数组如下\n");
	for (int i = 0; i < 10; i++)
	{
		printf("%d\t", c[i]);
	}

	putchar('\n');
}