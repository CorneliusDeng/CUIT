#include "head.h"

void main()
{
	int a[10], number, b[1000], key, index, value;
	int c[15] = { 90, 56, 23, 54, 78, 342, 658, 15, 82, 34, 999, 777, 543, 28, 432 };

	/*������*/
	printf("*********************************���������*********************************\n");
	printf("��������9��������,��������ʹ�ö�����ķ���������Ϊ��������\n");
	for (int i = 1; i < 10; i++)//������Ĳ���Ҫ��λ���1��ʼ
	{
		int temp = scanf("%d", &a[i]);
	}
	//��������
	HeapSort(a, 9);
	printf("\n�������Ľ����\n");
	for (int i = 1; i < 10; i++)
	{
		printf("%d\t", a[i]);
	}
	putchar('\n');

	/*�۰����*/
	printf("\n*********************************�۰���Ҳ���*********************************\n");
	printf("\n�������������۰�����㷨�������������뼸��������Ϊ���ҵ����飿\t");
	int temp1 = scanf("%d", &number);
	printf("\n������������%d����������\n", number);
	for (int i = 0; i < number; i++)
	{
		int temp = scanf("%d", &b[i]);
	}
	SelectSort(b, number);//����������
	printf("\n������������������ʾ���£�\n");
	for (int i = 0; i < number; i++)
	{
		printf("%d\t", b[i]);
	}
	printf("\n����������ҵ����ݴ�СΪ��\t");
	int temp2 = scanf("%d", &key);
	index = BinarySearch(b, number, key);
	if (index != -1)
	{
		printf("\n������ҵ�����λ�����еĵ�%d��λ��\n", index + 1);
	}
	else
	{
		printf("\n[���޴���]\n");
	}

	/*���������*/
	printf("\n*********************************�������������*********************************\n");
	BSTree Tree, result;
	Tree = CreatBST(c, 15);
	printf("�������������������ݴ�С��\t");
	int temp = scanf("%d", &value);
	printf("\n��ѯ������£�\n");
	result = SearchBSTree(Tree, value);
	if (result != NULL)
	{
		printf("�ҵ������ҵ�ֵΪ%d", result->data);
	}
	else
	{
		printf("�Ҳ�����Ҫ���ҵ�ֵ");
	}
/*
һЩ����

������  10 56 7 45 90 23 83 4 43

�۰���ң�number=15  90 56 23 54 78 342 658 15 82 34 999 777 543 28 432

����������� 90 56 23 54 78 342 658 15 82 34 999 777 543 28 432
*/
}