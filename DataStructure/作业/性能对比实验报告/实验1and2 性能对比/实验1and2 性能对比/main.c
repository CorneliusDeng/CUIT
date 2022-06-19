#include "compare.h"

void main()
{

	/*	clock函数返回进程运行时间，但是这个运行时间单位不是秒，而是CPU运行的时钟周期计数。
	 *	所以要得到消耗的时间（秒），
	 *	需要除以CPU时钟频率，也就是CLOCKS_PER_SEC.以得到一个以秒为单位的数值
	 *
	 *	因为程序的运行时间较短，此次的时间计算都是计算的单次的10000倍
	 */

	/*顺序表*/
	SqList La;
	int value1, index1, flag1;//value表示需要查找的数据大小，index表示要查找数据的位置信息，flag作为定位是否成功的标志
	double time1, start1, end1;

	int n1;//用来表示每次初始化数据的时候要插入多少个数据

	printf("请问您想对多少个数据以顺序表的形式存储进行操作？\t");
	scanf_s("%d", &n1);

	InitList(&La);//初始化
	for (int i = 1; i <= n1; i++)//插入数据
	{
		ListInsert(&La, i, i);//第一个i表示位置，第二个i表示大小，正向赋值
	}
	printf("[顺序表初始化成功]！\n\n");

	/*定位元素*/
	printf("请输入要查找的数据大小:");
	scanf_s("%d", &value1);//用scanf提示返回值被忽略

	start1 = clock();
	for (int k = 0; k < 10000; k++)
	{
		flag1 = LocateElem(La, value1, &index1);//查找
	}
	end1 = clock();

	time1 = (end1 - start1) / CLOCKS_PER_SEC;

	if (flag1 == 1)//如果有这个数据，打印数据索引
	{
		printf("[顺序表元素定位成功！]\n[所耗时间为：%f]\n其索引为 %d\n",time1, index1);
	}
	else
	{
		printf("没有此数据\n");
	}
	putchar('\n');
	putchar('\n');

	/*插入元素*/
	printf("请问您想在哪个位置插入什么大小的数据？（位置和大小用空格隔开）");
	scanf_s("%d%d", &index1, &value1);

	start1 = clock();
	for (int k = 0; k < 10000; k++)
	{
		ListInsert(&La, index1, value1);
	}
	end1 = clock();

	time1 = (end1 - start1) / CLOCKS_PER_SEC;
	
	printf("[顺序表元素插入成功！]\n[所耗时间为：%f]\n\n", time1);


	/*删除元素*/
	printf("请输入需要删除的数据索引值：");
	scanf_s("%d", &index1);//用scanf提示返回值被忽略

	start1 = clock();
	for (int k = 0; k < 10000; k++)
	{
		LiseDelete(&La, index1);//删除一个数
	}
	end1 = clock();

	time1 = (end1 - start1) / CLOCKS_PER_SEC;
	
	printf("[顺序表元素删除成功！]\n[所耗时间为：%f]\n\n", time1);


	printf("\n\n********************顺序表与链表操作的分割线********************\n\n");

	/*链表*/
	LNode L; 
	int value2, index2, flag2;//value表示需要查找的数据大小，index表示要查找数据的位置信息，flag作为定位是否成功的标志
	double time2, start2, end2;

	int n2;//用来表示每次初始化数据的时候要插入多少个数据

	printf("请问您想对多少个数据以链表的形式存储进行操作？\t\t");
	scanf_s("%d", &n2);

	InitList_L(&L);
	for (int i = 1; i <= n2; i++)//插入十个数
	{
		ListInsert_L(&L, i, i);//第一个i表示位置，第二个i表示大小，正向赋值
	}
	printf("[链表创建成功]\n\n");

	/*定位元素*/
	printf("请输入要查找的数据大小:\t");
	scanf_s("%d", &value2);//用scanf提示返回值被忽略

	
	start2 = clock();
	for (int m = 0; m < 10000; m++)
	{
		flag2 = ListLocate(&L, value2, &index2);
	}
	end2 = clock();

	time2 = (end2 - start2) / CLOCKS_PER_SEC;
	
	if (flag2 != -1)//如果有这个数据，打印数据索引
	{
		printf("[链表元素定位成功！]\n[所用时间为：%f]\n其索引为 %d\n", time2, index2);
	}
	else
	{
		printf("没有此数据\n");
	}
	putchar('\n');
	putchar('\n');

	/*插入元素*/
	printf("请问您想在哪个位置插入什么大小的数据？（位置和大小用空格隔开）");
	scanf_s("%d%d", &index2, &value2);

	start2 = clock();
	for (int m = 0; m < 10000; m++)
	{
		ListInsert_L(&L, index2, value2);
	}
	end2 = clock();

	time2 = (end2 - start2) / CLOCKS_PER_SEC;

	
	printf("[链表元素插入成功！]\n[所耗时间为：%f]\n\n", time2);

	/*删除元素*/
	printf("请输入需要删除的数据索引值：");
	scanf_s("%d", &index2);//用scanf提示返回值被忽略

	start2 = clock();
	for (int m = 0; m < 10000; m++)
	{
		ListDelete_L(&L, index2);
	}
	end2 = clock();

	time2 = (end2 - start2) / CLOCKS_PER_SEC;
	
	printf("[顺序表元素删除成功！]\n[所耗时间为：%f]\n\n", time2);

}