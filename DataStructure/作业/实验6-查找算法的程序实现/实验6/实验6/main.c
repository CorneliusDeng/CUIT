#include "head.h"

void main()
{
	int a[100], number, key, index;
	int b[16] = { 90, 56, 23, 54, 78, 342, 658, 15, 82, 34, 999, 777, 543, 28, 432, 10001 };


	printf("\n*********************************折半查找*********************************\n\n");
	for (int i = 0; i < 16; i++)
	{
		a[i] = b[i];
	}
	SelectSort(b, 16);//对数列排序，实质有序方能使用折半查找的算法
	printf("[符合折半查找条件的15个数据的数组构建成功]\n");
	printf("\n请问您想查找的数据大小为？\t");
	int temp2 = scanf("%d", &key);
	index = BinarySearch(b, 16, key);
	if (index != -1)
	{
		printf("\n您想查找的数据位于数列的第%d个位置\n", index + 1);
	}
	else
	{
		printf("\n[查无此数]\n");
	}

	printf("\n*********************************哈希表相关操作*********************************\n\n");

	HashTable* hashtable;
	int data; //待查询数据
	int deldata;//待删除数据

	hashtable = (HashTable*)malloc(sizeof(HashTable));//创建哈希表并分配存储空间

	InitialHash(hashtable);//初始化哈希表

	int hasharray[HashSize-1];

	printf("请输入%d个哈希表的元素\n", HashSize-1);
	for (int i = 0; i < HashSize - 1; i++)
	{
		int temp = scanf("%d", &hasharray[i]);
	}
	for (int j = 0; j < HashSize - 1; j++)
	{
		InsertHash(hashtable, hasharray[j]);
	}

	printf("\n[哈希表构建完毕]\n");

	printf("哈希表遍历的结果为：\n");
	PrintHash(hashtable);
	putchar('\n');

	printf("\n现在进行删除功能测试，请问您想删除的数据大小为？\t");
	int temp = scanf("%d", &deldata);
	DeleteHsh(hashtable, deldata);
	printf("更新后的哈希表为:\n");
	PrintHash(hashtable);
	putchar('\n');
	putchar('\n');

	printf("请输入要查询的数据:\t");
	int temp3 = scanf("%d", &data);
	int result = SearchHash(hashtable, data);
	if (result == ERROR)
	{
		printf("查询失败！\n");
	}
	else
	{
		printf("待查询数据%d在哈希表的位置为%d", data, result);
	}
	putchar('\n');
}
