#include "标头.h"

Status InitList_L(LinkList L)
{//构造一个头结点为空的单链表L
	 //L = (LinkList)malloc(sizeof(LNode));//C里面，形参已经有了内存空间，再开辟空间，就会使得形参无用
	if (L == NULL)
	{
		printf("申请空间失败！\n");
		exit(Error);
	}
	L->next = NULL;

	return OK;
}

Status ListInsert_L(LinkList L, int i, ET e)
{//在表L的第i个位置上插入一个值为e的数据元素
	LinkList p = L;
	int step = 0;		  //step为计数器
	while (p != NULL && step < i - 1)  //寻找第i－1个结点，令p指向它
	{
		p = p->next;
		step++;
	}
	if (p == NULL || step > i - 1) return Error; 	//i大于表长+1或者i小于1
	LinkList s = (LinkList)malloc(sizeof(LNode)); //申请新结点s
	if (s == NULL)  exit(Error);
	s->data = e;
	s->next = p->next;        // 在 p结点之后插入新结点s
	p->next = s;

	return OK;
}

void PrintList_L(LinkList L)
{//打印输出单链表中的结点元素值
	LinkList p;
	if (L->next == NULL) return Error;
	p = L->next;

	while (p != NULL)
	{
		printf("%d\t", p->data);
		p = p->next;
	}
}

Status SelectList_L(LinkList L, int minK, int maxK)
{
	if (L->next == NULL) return Error;
	LinkList p = L->next;
	LinkList pre = (LinkList)malloc(sizeof(LNode));
	LinkList q, s;
	
	while (p && p->data <= minK)
	{
		pre = p;
		p = p->next;
	}
	if (p)
	{
		while (p && p->data < maxK)
		{
			p = p->next;
		}
		q = pre->next;
		pre->next = p;
		while (q != p)
		{
			s = q->next;
			q = s;
		}

	}
}

