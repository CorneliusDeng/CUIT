#include "head.h"

void main()
{
	int a[100], number, key, index;
	int b[16] = { 90, 56, 23, 54, 78, 342, 658, 15, 82, 34, 999, 777, 543, 28, 432, 10001 };


	printf("\n*********************************�۰����*********************************\n\n");
	for (int i = 0; i < 16; i++)
	{
		a[i] = b[i];
	}
	SelectSort(b, 16);//����������ʵ��������ʹ���۰���ҵ��㷨
	printf("[�����۰����������15�����ݵ����鹹���ɹ�]\n");
	printf("\n����������ҵ����ݴ�СΪ��\t");
	int temp2 = scanf("%d", &key);
	index = BinarySearch(b, 16, key);
	if (index != -1)
	{
		printf("\n������ҵ�����λ�����еĵ�%d��λ��\n", index + 1);
	}
	else
	{
		printf("\n[���޴���]\n");
	}

	printf("\n*********************************��ϣ����ز���*********************************\n\n");

	HashTable* hashtable;
	int data; //����ѯ����
	int deldata;//��ɾ������

	hashtable = (HashTable*)malloc(sizeof(HashTable));//������ϣ������洢�ռ�

	InitialHash(hashtable);//��ʼ����ϣ��

	int hasharray[HashSize-1];

	printf("������%d����ϣ���Ԫ��\n", HashSize-1);
	for (int i = 0; i < HashSize - 1; i++)
	{
		int temp = scanf("%d", &hasharray[i]);
	}
	for (int j = 0; j < HashSize - 1; j++)
	{
		InsertHash(hashtable, hasharray[j]);
	}

	printf("\n[��ϣ�������]\n");

	printf("��ϣ������Ľ��Ϊ��\n");
	PrintHash(hashtable);
	putchar('\n');

	printf("\n���ڽ���ɾ�����ܲ��ԣ���������ɾ�������ݴ�СΪ��\t");
	int temp = scanf("%d", &deldata);
	DeleteHsh(hashtable, deldata);
	printf("���º�Ĺ�ϣ��Ϊ:\n");
	PrintHash(hashtable);
	putchar('\n');
	putchar('\n');

	printf("������Ҫ��ѯ������:\t");
	int temp3 = scanf("%d", &data);
	int result = SearchHash(hashtable, data);
	if (result == ERROR)
	{
		printf("��ѯʧ�ܣ�\n");
	}
	else
	{
		printf("����ѯ����%d�ڹ�ϣ���λ��Ϊ%d", data, result);
	}
	putchar('\n');
}
