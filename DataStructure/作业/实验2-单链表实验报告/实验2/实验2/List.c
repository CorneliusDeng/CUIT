#include "List.h"

int InitList_L(LinkList L)
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

int ListLength_L(LinkList L)
{//������ĳ���
	p = L->next;
	int length = 0;
	while (p != NULL)
	{
		length++;
		p = p->next;//��p�ƶ�����һ�����
	}
	return length;
}

int GetElem_L(LinkList L, int i, ET* e)
{//ȡ��L�еĵ�i�����ֵ��ֵ������e
	p = L->next;
	int step = 1;	         //stepΪ������		
	while (p && step < i)	//���ҵ�i��Ԫ��
	{
		p = p->next;
		step++;
	}
	if (p == NULL || step > i)  //��i��Ԫ�ز�����
	{
		return Error;
	}
	*e = p->data;         //ȡ����i��Ԫ�ص�ֵ����e         
	return OK;
}

int ListInsert_L(LinkList L, int i, ET e)
{//�ڱ�L�ĵ�i��λ���ϲ���һ��ֵΪe������Ԫ��
	p = L;
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

int ListDelete_L(LinkList L, int i, ET* e)
{//�ڱ�L��ɾ��λ��Ϊ i ������Ԫ�أ�����ɾ����Ԫ�ظ�ֵ��e
	p = L;
	int step = 0;		  //stepΪ������
	while (p->next && step < i - 1)  //Ѱ�ҵ�i��1����㣬��pָ����
	{
		p = p->next;
		step++;
	}
	if (!(p->next) || step > i - 1) return Error; //i���ڱ�����iС��1
	LinkList q = p->next;		      //qָ��Ҫɾ���Ľ��i
	p->next = q->next;      // ɾ�����i
	*e = q->data;
	free(q);			        //�ͷŽ��q�Ĵ洢�ռ�
	return OK;
}

int PriorElem_L(LinkList L, ET e, ET* pre_e)
{//�ڱ�L����Ԫ��e��ֱ��ǰ��Ԫ�أ�����ֵ��pre_e
	LinkList q = L;
	p = L->next;

	while (p && p->data.num != e.num)
	{
		q = p;
		p = q->next;
	}

	if (!p) return Error;

	*pre_e = q->data;//p->dataΪ��ǰԪ�أ�Ҫȥǰ������q

	return OK;
}

void PrintList_L(LinkList L)
{//��ӡ����������еĽ��Ԫ��ֵ
	if (L->next == NULL) return Error;
	p = L->next;

	while (p != NULL)
	{
		printf("%d\t%s\n", p->data.num, p->data.name);
		p = p->next;
	}
}


void INLIST(LinkList L, int n)
{//��λ������n��Ԫ�ص�ֵ���������б�ͷ���ĵ�����
	//L = (LinkList)malloc(sizeof(LNode));
	//L->next = NULL;//�Ƚ���һ����ͷ���Ŀ�����

	/*ǰ��Ķ�ע�͵�������һ����������ĳ�����������Ϣ�ĺ���*/

	LinkList r = L;//βָ��rָ��ͷ���

	for (int i = 0; i < n; i++)
	{
		p = (LinkList)malloc(sizeof(LNode));//�����½ڵ�
		if (p == NULL) return Error;
		printf("������ר����Ϣ(ר�Һ����������ÿո�������س�������)\n");
		int temp = scanf("%d%s", &p->data.num, &p->data.name);//����Ԫ��ֵ�����½��p��������
		p->next = NULL;
		r->next = p;//���½��p����β���r֮��
		r = p;//rָ���µ�β���p
	}
}


int MerList(LinkList La, LinkList Lb, LinkList Lc)
{//�ϲ���������
	int k = 0;
	int c = 1;//c����������ÿ�β������1��ȷ��ÿ�β���Ķ��������ĩβ

	LinkList pa, pb;

	pa = La->next;//pa��pb�ֱ�ָ��La����Lb���е�ǰ���Ƚϲ���Ľ��
	pb = Lb->next;

	while (pa && pb)
	{

		if ((pa->data.num) <= (pb->data.num))//���������ز���Lc��
		{
			ListInsert_L(Lc, c, pa->data);
			c++;
			pa = pa->next;
		}
		else
		{
			ListInsert_L(Lc, c, pb->data);
			c++;
			pb = pb->next;
		}
	}
	while (pa)//pb������
	{
		ListInsert_L(Lc, c++, pa->data);
		pa = pa->next;
	}
	while (pb)//pa������
	{
		ListInsert_L(Lc, c++, pb->data);
		pb = pb->next;
	}
	return OK;
}

int Reverse(LinkList L)
{//�������� 
	
	LinkList tp = L->next;
	p = L;
	int i = 1, j, c;
	ET e;

	while (tp->next)
	{
		tp = tp->next;
		i++;//tp��L�ϻ���������������i��ʾ��ʱ��������
	}
	c = i + 1;
	for (j = 1; j < i; j++)
	{
		GetElem_L(L, 1, &e);//����ȡ�������е�Ԫ��
		ListInsert_L(L, c, e);//���뵽ĩβ
		L->next = L->next->next;//λ�ö�λ����һ��Ԫ��
		c--;//������ǰ����
	}
	return OK;
}

int PartList(LinkList La, LinkList Lb, LinkList Lc)
{//���La
	if (La->next == NULL) return Error;
	LNode* p1 = La->next;//��LinkList�����p�������г���������ǰ�������ݲ���
	int index = 1;
	int a = 1, b = 1;

	while (p1 != NULL)
	{
		if (index % 2 == 0)
		{
			ListInsert_L(Lc, a, p1->data);//Lc�к���La���ż�����
			a++;
		}
		else
		{
			ListInsert_L(Lb, b, p1->data);//Lb��ֻ��La�����������
			b++;
		}
		index++;
		p1 = p1->next;
	}
	return OK;
}

void FreeL(LinkList Lb)
{
	Lb->next = NULL;
}