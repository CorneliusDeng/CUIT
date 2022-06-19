#include "compare.h"

/*˳������*/

//��λԪ��
int LocateElem(SqList La, int e, int *index)
{//��˳���La�в���ֵΪe������Ԫ��
	int flag = -1;
	for (int i = 0; i < La.length; i++)
	{
		if (La.elem[i] == e)
		{
			flag = 1;
			*index = i + 1;
		}
	}
	return flag;
}

//����Ԫ��
int ListInsert(SqList* La, int i, int e)
{//��˳���La�е�i��λ�ò����µ�Ԫ��e��iֵ�úϷ���Χ��1<=i<=La.length+1
	if ((i < 1) || (i > La->length + 1)) return False;//iֵ���Ϸ�

	if (La->length == MAXSIZE) return False;//��ǰ����ռ�����

	for (int j = La->length - 1; j >= i - 1; j--)//����λ�ü�֮���Ԫ�غ���
	{
		La->elem[j + 1] = La->elem[j];
	}

	La->elem[i - 1] = e;//����Ԫ��e�����i��λ��
	++La->length;		//����1
	return 1;
}

//ɾ��Ԫ��
int LiseDelete(SqList* La, int i)
{//��˳���La��ɾ����i��Ԫ�أ�iֵ�ĺϷ���Χ��1<=i<=La.length
	if ((i < 1) || (i > La->length)) return False; //iֵ���Ϸ�

	for (int j = i; j <= La->length - 1; j++)
	{
		La->elem[j - 1] = La->elem[j];//��ɾ��Ԫ��֮���Ԫ��ת��
	}

	--La->length;//����1

	return 1;
}

//������������
int InitList(SqList* La)
{//����һ���յ�˳���La
	La->elem = (int*)malloc(sizeof(int) * MAXSIZE);//Ϊ˳������һ����СΪMAXSIZE������ռ�
	if (!La->elem) exit(0);		//�������ʧ���˳�
	La->length = 0;					//�ձ���Ϊ0
	return 1;
}
int CalcueList(SqList* La)
{//��La�ı�
	printf("��ǰ˳���ĳ���Ϊ��%d\n", La->length);
}
void PrintList(SqList La)
{//��ӡLa�е�Ԫ��ֵ
	for (int i = 0; i < La.length; i++)
	{
		printf("%-4d", La.elem[i]);
	}
	putchar('\n');
}


/*************************************************************************************************************/


/*�������*/

//��λԪ��
int ListLocate(LinkList L, int e, int *location)
{//������L�в���ֵΪe������Ԫ�أ����������
	p = L;
	int flag = -1;
	*location = 0;
	while (p != NULL && e != p->data)  
	{
		p = p->next;
		(*location)++;
	}
	if (p == NULL) return Error; 
	if (p->data == e)
	{
		flag = 1;
	}
	
	return flag;
}

//����Ԫ��
int ListInsert_L(LinkList L, int i, int e)
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

//ɾ��Ԫ��
int ListDelete_L(LinkList L, int i)
{//�ڱ�L��ɾ��λ��Ϊ i ������Ԫ��
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
	free(q);			        //�ͷŽ��q�Ĵ洢�ռ�
	return OK;
}

//������������
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
void PrintList_L(LinkList L)
{//��ӡ����������еĽ��Ԫ��ֵ
	if (L->next == NULL) return Error;
	p = L->next;

	while (p != NULL)
	{
		printf("%d\t", p->data);
		p = p->next;
	}
}