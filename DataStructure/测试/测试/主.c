#include "标头.h"

int main()
{
	LNode L;
	int n;
	int minK, maxK;
	

	InitList_L(&L);
	printf("[链表创建成功]\n\n");

	printf("您需要插入几个顺序的数据信息?");
	int temp1 = scanf("%d", &n);//VS用scanf会提示一个警告没有返回值。
	putchar('\n');

	for (int i = 1; i <= n; i++)
	{
		ListInsert_L(&L, i, i);
	}

	PrintList_L(&L);
	putchar('\n');

	printf("请问您想删除的区间是什么？");
	int temp2 = scanf("%d%d", &minK, &maxK);

	SelectList_L(&L, minK, maxK);
	PrintList_L(&L);
	putchar('\n');
}

