#include "La.h"

int InitList(SqList *La)
{//����һ���յ�˳���La
	La->elem = (int*)malloc(sizeof(int) * MAXSIZE);//Ϊ˳������һ����СΪMAXSIZE������ռ�
	if (!La->elem) exit(0);		//�������ʧ���˳�
	La->length = 0;					//�ձ���Ϊ0
	return 1;
}
void KongList(SqList *La)
{//��La��Ϊ�ձ�
	La->length = 0;
}

void FreeList(SqList *La)
{//����La
	free(La->elem);
}

int CalcueList(SqList* La)
{//��La�ı�
	printf("��ǰ˳���ĳ���Ϊ��%d\n", La->length);
}

int ListInsert(SqList *La, int i, int e)
{//��˳���La�е�i��λ�ò����µ�Ԫ��e
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

int LiseDelete(SqList *La, int i)
{//��˳���La��ɾ����i��Ԫ�أ�iֵ�ĺϷ���Χ��1<=i<=La.length
	if ((i < 1) || (i > La->length)) return False; //iֵ���Ϸ�
	
	for (int j = i; j <= La->length - 1; j++)
	{
		La->elem[j-1] = La->elem[j];//��ɾ��Ԫ��֮���Ԫ��ת��
	}

	--La->length;//����1

	return 1;
}

int LocateElem(SqList La, int e)
{//��˳���La�в���ֵΪe������Ԫ�أ����������
	int flag = -1;
	for (int i = 0; i < La.length; i++)
	{
		if (La.elem[i] == e)
		{
			flag = 1;
			return i;//���ҳɹ���return֮����˳���ѭ�������Բ���Ҫbreak��
		}	
	}
	return flag;
}

void PrintList(SqList La)
{//��ӡLa�е�Ԫ��ֵ
	for (int i = 0; i < La.length; i++)
	{
		printf("%-4d", La.elem[i]);
	}
	putchar('\n');
}

void MergeList(SqList *La, SqList *Lb, SqList *Lc)
{//�鲢La��Lb�õ��µ�˳�����Ա�Lc 
	int * pa, * pa_last, * pb, * pb_last, * pc;//
	pa = La->elem;  //paָ��La��һ��Ԫ��
	pb = Lb->elem;  //pbָ��Lb�ڶ���Ԫ��
	Lc->length = La->length + Lb->length;//���La��Lb���ȸ���Lc
	pc = Lc->elem = (int*)malloc(Lc->length * sizeof(int));//��������ռ�
	if (!Lc->elem)   //����ʧ��
	{
		exit(0);
	}	 
	pa_last = La->elem + La->length - 1; //ָ��La���һ��Ԫ��
	pb_last = Lb->elem + Lb->length - 1; //ָ��Lb���һ��Ԫ��
	while (pa <= pa_last && pb <= pb_last)   //��La�ͱ�Lb����Ԫ��û�й鲢
	{
		if (*pa <= *pb)   //La�ĵ�ǰԪ�ز�����Lb��ǰ��Ԫ��
		{
			*pc++ = *pa++;  //��paָ���Ԫ�ظ���pc ��ָ����һ����Ԫ
		}
		else
		{
			*pc++ = *pb++;  //��pbָ���Ԫ�ظ���Pc ��ָ����һ����Ԫ
		}
	}
	while (pa <= pa_last)    //��La��Ԫ��ȫ���鲢
	{
		*pc++ = *pa++;  //����La��ʣ��Ԫ��
	}
	while (pb <= pb_last)    //��Lb��Ԫ��ȫ���鲢
	{
		*pc++ = *pb++;  //����Lb��ʣ��Ԫ��
	}
}

void union_Sq(SqList *La, SqList *Lb, SqList  *Lc) 
{//��La��Lb�Ĳ���Lc
	int i, index;
	Lc->length = La->length;
	for (i = 0; i < La->length; i++)
	{
		Lc->elem[i] = La->elem[i];//��La������ȫ����ֵ��Lc
	}
	for (i = 0; i < Lb->length; i++) 
	{
		index = LocateElem(*La, Lb->elem[i]);//����Lb����La��ͬ�����ݣ����ҵ��˷���-1��index
		if (index == -1)
		{
			ListInsert(Lc, Lc->length + 1, Lb->elem[i]);
		}
			
	}
}

void intersection_Sq(SqList* La, SqList* Lb, SqList* Lc)
{//��La��Lb�Ľ���
	int i, index;
	for (i = 0; i < Lb->length; i++)
	{
		index = LocateElem(*La, Lb->elem[i]);//����Lb����La��ͬ�����ݣ����ҵ��˷������±��index
		if (index != -1)
		{
			ListInsert(Lc,Lc->length+1,Lb->elem[i]);
		}
	}
}

