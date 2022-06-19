#include "head.h"

void main()
{
	int a1[8] = { 49, 38, 65, 97, 76, 13, 27, 49 };
	int a2[9] = { -11, 49, 38, 65, 97, 76, 13, 27, 49 };
	int a3[8] = { 49, 38, 65, 97, 76, 13, 27, 49 };
	int a4[8] = { 49, 38, 65, 97, 76, 13, 27, 49 };
	int a5[8] = { 49, 38, 65, 97, 76, 13, 27, 49 };
	int a6[8] = { 49, 38, 65, 97, 76, 13, 27, 49 };

	printf("有一个初始数组，它的数据内容是：\n[49, 38, 65, 97, 76, 13, 27, 49]\n");
	printf("\n**********************接下来将测试几种常用的排序方法**********************\n\n");

	printf("现在测试冒泡排序，结果展示如下：\n");
	BubbleSort(a1, 8);
	for (int i = 0; i < 8; i++)
	{
		printf("%d\t", a1[i]);
	}
	putchar('\n');

	printf("\n现在测试堆排序，结果展示如下：\n");
	HeapSort(a2, 8);
	for (int i = 1; i < 9; i++)//堆排序有些特殊，要从1开始，不然无法存在其二倍下标的限制条件
	{
		printf("%d\t", a2[i]);
	}
	putchar('\n');

	printf("\n现在测试选择排序，结果展示如下：\n");
	SelectSort(a3, 8);
	for (int i = 0; i < 8; i++)//堆排序有些特殊，要从1开始，不然无法存在其二倍下标的限制条件
	{
		printf("%d\t", a3[i]);
	}
	putchar('\n');

	printf("\n现在测试简单插入排序，结果展示如下：\n");
	StraightInsertionSort(a4, 8);
	for (int i = 0; i < 8; i++)
	{
		printf("%d\t", a4[i]);
	}
	putchar('\n');

	printf("\n现在测试快速排序，结果展示如下：\n");
	QuickSort(a5, 0, 7);
	for (int i = 0; i < 8; i++)
	{
		printf("%d\t", a5[i]);
	}
	putchar('\n');

	printf("\n现在测试归并排序，结果展示如下：\n");
	MergingSort(a6, a6, 0, 7);
	for (int i = 0; i < 8; i++)
	{
		printf("%d\t", a6[i]);
	}
	putchar('\n');

}