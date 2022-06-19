#include "head.h"

void main()
{
	int array1[100], n, array2[100];

	printf("请问您想输入多少个数据？\t");
	int temp1 = scanf("%d", &n);
	printf("\n请您在下面输入%d个元素\n", n);
	for (int i = 0; i < n; i++)
	{
		int temp = scanf("%d", &array1[i]);
	}

	for (int i = 0; i < n; i++)//复制数组
	{
		array2[i] = array1[i];
	}

	QuickSort(array1, 0, n-1);
	printf("\n现在测试快速排序，结果是：\n");
	for (int i = 0; i < n; i++)
	{
		printf("%d\t", array1[i]);
	}
	putchar('\n');

	MergingSort(array2, array2, 0, n - 1);
	printf("\n现在测试归并排序，结果是：\n");
	for (int i = 0; i < n; i++)
	{
		printf("%d\t", array2[i]);
	}

	putchar('\n');



/*
实验数据
15个数字： 90 67 34 45 89 23 1 9 6 32 99 63 97 27 19
*/

}