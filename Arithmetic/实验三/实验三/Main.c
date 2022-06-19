#include "head.h"

void main()
{
	int a[10], number, b[1000], key, index, value;
	int c[15] = { 90, 56, 23, 54, 78, 342, 658, 15, 82, 34, 999, 777, 543, 28, 432 };

	/*堆排序*/
	printf("*********************************堆排序测试*********************************\n");
	printf("请您输入9个的整数,接下来将使用堆排序的方法将其置为递增数列\n");
	for (int i = 1; i < 10; i++)//堆排序的插入要从位序号1开始
	{
		int temp = scanf("%d", &a[i]);
	}
	//堆排序函数
	HeapSort(a, 9);
	printf("\n堆排序后的结果：\n");
	for (int i = 1; i < 10; i++)
	{
		printf("%d\t", a[i]);
	}
	putchar('\n');

	/*折半查找*/
	printf("\n*********************************折半查找测试*********************************\n");
	printf("\n接下来将测试折半查找算法，请问您想输入几个数据作为查找的数组？\t");
	int temp1 = scanf("%d", &number);
	printf("\n现在请您输入%d个整型数据\n", number);
	for (int i = 0; i < number; i++)
	{
		int temp = scanf("%d", &b[i]);
	}
	SelectSort(b, number);//对数列排序
	printf("\n将输入的数列排序后显示如下：\n");
	for (int i = 0; i < number; i++)
	{
		printf("%d\t", b[i]);
	}
	printf("\n请问您想查找的数据大小为？\t");
	int temp2 = scanf("%d", &key);
	index = BinarySearch(b, number, key);
	if (index != -1)
	{
		printf("\n您想查找的数据位于数列的第%d个位置\n", index + 1);
	}
	else
	{
		printf("\n[查无此数]\n");
	}

	/*二叉查找树*/
	printf("\n*********************************二叉查找树测试*********************************\n");
	BSTree Tree, result;
	Tree = CreatBST(c, 15);
	printf("请输入您想搜索的数据大小：\t");
	int temp = scanf("%d", &value);
	printf("\n查询结果如下：\n");
	result = SearchBSTree(Tree, value);
	if (result != NULL)
	{
		printf("找到所查找的值为%d", result->data);
	}
	else
	{
		printf("找不到所要查找的值");
	}
/*
一些例子

堆排序：  10 56 7 45 90 23 83 4 43

折半查找：number=15  90 56 23 54 78 342 658 15 82 34 999 777 543 28 432

二叉查找树： 90 56 23 54 78 342 658 15 82 34 999 777 543 28 432
*/
}