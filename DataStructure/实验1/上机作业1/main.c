#include "La.h"

int main()
{
	SqList La;
	int j, value, index;//value��ʾ��Ҫ���ҵ����ݴ�С��index��ʾҪ�������ݵ�λ����Ϣ

	//��ҵ1
	printf("**********************��ҵ1**********************\n");
	InitList(&La);//��ʼ��
	
	for(j = 1; j < 11; j++)//����ʮ����
	{
		ListInsert(&La, j, j);//��һ��j��ʾλ�ã��ڶ���j��ʾ��С������ֵ
	}

	printf("˳�����Ա��ʼ������ʮ�����ݣ�\n");
	PrintList(La);//��ӡ
	putchar('\n');
	putchar('\n');

	CalcueList(&La);//��ʾ��
	putchar('\n');
	putchar('\n');

	printf("������Ҫ���ҵ����ݴ�С:");
	scanf_s("%d", &value);//��scanf��ʾ����ֵ������
	index = LocateElem(La, value);//����
	if (index != 0)//�����������ݣ���ӡ��������
	{ 
		printf("�������ݴ�СΪ%d��Ԫ�أ����ص�λ������:\n", value);
		printf("ֵΪ %d ������Ϊ %d\n", value, index + 1);
	}
	else
	{
		printf("û�д�����\n");
	}
	putchar('\n');
	putchar('\n');
		
	printf("��������Ҫɾ������������ֵ��");
	scanf_s("%d", &index);//��scanf��ʾ����ֵ������
	printf("ɾ����%dλ����֮�������\n", index);
	LiseDelete(&La, index);//ɾ����һ����
	PrintList(La);//��ӡ
	putchar('\n');
	putchar('\n');

	CalcueList(&La);//��ʾ��
	putchar('\n');
	putchar('\n');

	KongList(&La);//�ÿ�
	FreeList(&La);//����

	//��ҵ2
	printf("**********************��ҵ2**********************\n");
	SqList Lb, Lc;
	InitList(&Lc);
	InitList(&La);//��ʼ��
	for (j = 1; j < 11; j++)//����ʮ����
	{
		ListInsert(&La, j, j);//����
	}
	printf("˳�����Ա�La���³�ʼ������ʮ�����ݣ�\n");
	PrintList(La);//��ӡ
	putchar('\n');
	putchar('\n');

	InitList(&Lb);//��ʼ��
	for (j = 1; j < 11 ; j++)//����ʮ����
	{
		ListInsert(&Lb, j, j + 3);//����
	}
	printf("˳�����Ա�Lb��ʼ������ʮ�����ݣ�\n");
	PrintList(Lb);//��ӡ
	putchar('\n');
	putchar('\n');
	
	printf("ʵ��La��Lb�鲢\n");
	MergeList(&La, &Lb, &Lc);
	PrintList(Lc);//��ӡ
	putchar('\n');
	putchar('\n');

	KongList(&Lc);
	printf("��La��Lb�Ĳ���\n");
	union_Sq(&La, &Lb, &Lc);
	PrintList(Lc);//��ӡ
	putchar('\n');
	putchar('\n');

	KongList(&Lc);
	printf("��La��Lb�Ľ���\n");
	intersection_Sq(&La, &Lb, &Lc);
	PrintList(Lc);//��ӡ
}