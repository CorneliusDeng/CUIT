#include "La.h"

int main()
{
	SqList La;
	int j, value, index;//value表示需要查找的数据大小，index表示要查找数据的位置信息

	//作业1
	printf("**********************作业1**********************\n");
	InitList(&La);//初始化
	
	for(j = 1; j < 11; j++)//插入十个数
	{
		ListInsert(&La, j, j);//第一个j表示位置，第二个j表示大小，正向赋值
	}

	printf("顺序线性表初始化插入十个数据：\n");
	PrintList(La);//打印
	putchar('\n');
	putchar('\n');

	CalcueList(&La);//显示表长
	putchar('\n');
	putchar('\n');

	printf("请输入要查找的数据大小:");
	scanf_s("%d", &value);//用scanf提示返回值被忽略
	index = LocateElem(La, value);//查找
	if (index != 0)//如果有这个数据，打印数据索引
	{ 
		printf("查找数据大小为%d的元素，返回的位置如下:\n", value);
		printf("值为 %d 的索引为 %d\n", value, index + 1);
	}
	else
	{
		printf("没有此数据\n");
	}
	putchar('\n');
	putchar('\n');
		
	printf("请输入需要删除的数据索引值：");
	scanf_s("%d", &index);//用scanf提示返回值被忽略
	printf("删除第%d位数据之后的链表：\n", index);
	LiseDelete(&La, index);//删除第一个数
	PrintList(La);//打印
	putchar('\n');
	putchar('\n');

	CalcueList(&La);//显示表长
	putchar('\n');
	putchar('\n');

	KongList(&La);//置空
	FreeList(&La);//销毁

	//作业2
	printf("**********************作业2**********************\n");
	SqList Lb, Lc;
	InitList(&Lc);
	InitList(&La);//初始化
	for (j = 1; j < 11; j++)//插入十个数
	{
		ListInsert(&La, j, j);//插入
	}
	printf("顺序线性表La重新初始化插入十个数据：\n");
	PrintList(La);//打印
	putchar('\n');
	putchar('\n');

	InitList(&Lb);//初始化
	for (j = 1; j < 11 ; j++)//插入十个数
	{
		ListInsert(&Lb, j, j + 3);//插入
	}
	printf("顺序线性表Lb初始化插入十个数据：\n");
	PrintList(Lb);//打印
	putchar('\n');
	putchar('\n');
	
	printf("实现La与Lb归并\n");
	MergeList(&La, &Lb, &Lc);
	PrintList(Lc);//打印
	putchar('\n');
	putchar('\n');

	KongList(&Lc);
	printf("求La与Lb的并集\n");
	union_Sq(&La, &Lb, &Lc);
	PrintList(Lc);//打印
	putchar('\n');
	putchar('\n');

	KongList(&Lc);
	printf("求La与Lb的交集\n");
	intersection_Sq(&La, &Lb, &Lc);
	PrintList(Lc);//打印
}