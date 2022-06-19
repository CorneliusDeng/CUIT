#include "��ͷ.h"

Status InitList_L(LinkList L)
{//����һ��ͷ���Ϊ�յĵ�����L
	 //L = (LinkList)malloc(sizeof(LNode));//C���棬�β��Ѿ������ڴ�ռ䣬�ٿ��ٿռ䣬�ͻ�ʹ���β�����
	if (L == NULL)
	{
		printf("����ռ�ʧ�ܣ�\n");
		exit(Error);
	}
	L->next = NULL;

	return OK;
}

Status ListInsert_L(LinkList L, int i, ET e)
{//�ڱ�L�ĵ�i��λ���ϲ���һ��ֵΪe������Ԫ��
	LinkList p = L;
	int step = 0;		  //stepΪ������
	while (p != NULL && step < i - 1)  //Ѱ�ҵ�i��1����㣬��pָ����
	{
		p = p->next;
		step++;
	}
	if (p == NULL || step > i - 1) return Error; 	//i���ڱ�+1����iС��1
	LinkList s = (LinkList)malloc(sizeof(LNode)); //�����½��s
	if (s == NULL)  exit(Error);
	s->data = e;
	s->next = p->next;        // �� p���֮������½��s
	p->next = s;

	return OK;
}

void PrintList_L(LinkList L)
{//��ӡ����������еĽ��Ԫ��ֵ
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

