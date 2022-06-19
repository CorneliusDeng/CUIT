#include "compare.h"

void main()
{

	/*	clock�������ؽ�������ʱ�䣬�����������ʱ�䵥λ�����룬����CPU���е�ʱ�����ڼ�����
	 *	����Ҫ�õ����ĵ�ʱ�䣨�룩��
	 *	��Ҫ����CPUʱ��Ƶ�ʣ�Ҳ����CLOCKS_PER_SEC.�Եõ�һ������Ϊ��λ����ֵ
	 *
	 *	��Ϊ���������ʱ��϶̣��˴ε�ʱ����㶼�Ǽ���ĵ��ε�10000��
	 */

	/*˳���*/
	SqList La;
	int value1, index1, flag1;//value��ʾ��Ҫ���ҵ����ݴ�С��index��ʾҪ�������ݵ�λ����Ϣ��flag��Ϊ��λ�Ƿ�ɹ��ı�־
	double time1, start1, end1;

	int n1;//������ʾÿ�γ�ʼ�����ݵ�ʱ��Ҫ������ٸ�����

	printf("��������Զ��ٸ�������˳������ʽ�洢���в�����\t");
	scanf_s("%d", &n1);

	InitList(&La);//��ʼ��
	for (int i = 1; i <= n1; i++)//��������
	{
		ListInsert(&La, i, i);//��һ��i��ʾλ�ã��ڶ���i��ʾ��С������ֵ
	}
	printf("[˳����ʼ���ɹ�]��\n\n");

	/*��λԪ��*/
	printf("������Ҫ���ҵ����ݴ�С:");
	scanf_s("%d", &value1);//��scanf��ʾ����ֵ������

	start1 = clock();
	for (int k = 0; k < 10000; k++)
	{
		flag1 = LocateElem(La, value1, &index1);//����
	}
	end1 = clock();

	time1 = (end1 - start1) / CLOCKS_PER_SEC;

	if (flag1 == 1)//�����������ݣ���ӡ��������
	{
		printf("[˳���Ԫ�ض�λ�ɹ���]\n[����ʱ��Ϊ��%f]\n������Ϊ %d\n",time1, index1);
	}
	else
	{
		printf("û�д�����\n");
	}
	putchar('\n');
	putchar('\n');

	/*����Ԫ��*/
	printf("�����������ĸ�λ�ò���ʲô��С�����ݣ���λ�úʹ�С�ÿո������");
	scanf_s("%d%d", &index1, &value1);

	start1 = clock();
	for (int k = 0; k < 10000; k++)
	{
		ListInsert(&La, index1, value1);
	}
	end1 = clock();

	time1 = (end1 - start1) / CLOCKS_PER_SEC;
	
	printf("[˳���Ԫ�ز���ɹ���]\n[����ʱ��Ϊ��%f]\n\n", time1);


	/*ɾ��Ԫ��*/
	printf("��������Ҫɾ������������ֵ��");
	scanf_s("%d", &index1);//��scanf��ʾ����ֵ������

	start1 = clock();
	for (int k = 0; k < 10000; k++)
	{
		LiseDelete(&La, index1);//ɾ��һ����
	}
	end1 = clock();

	time1 = (end1 - start1) / CLOCKS_PER_SEC;
	
	printf("[˳���Ԫ��ɾ���ɹ���]\n[����ʱ��Ϊ��%f]\n\n", time1);


	printf("\n\n********************˳�������������ķָ���********************\n\n");

	/*����*/
	LNode L; 
	int value2, index2, flag2;//value��ʾ��Ҫ���ҵ����ݴ�С��index��ʾҪ�������ݵ�λ����Ϣ��flag��Ϊ��λ�Ƿ�ɹ��ı�־
	double time2, start2, end2;

	int n2;//������ʾÿ�γ�ʼ�����ݵ�ʱ��Ҫ������ٸ�����

	printf("��������Զ��ٸ��������������ʽ�洢���в�����\t\t");
	scanf_s("%d", &n2);

	InitList_L(&L);
	for (int i = 1; i <= n2; i++)//����ʮ����
	{
		ListInsert_L(&L, i, i);//��һ��i��ʾλ�ã��ڶ���i��ʾ��С������ֵ
	}
	printf("[�������ɹ�]\n\n");

	/*��λԪ��*/
	printf("������Ҫ���ҵ����ݴ�С:\t");
	scanf_s("%d", &value2);//��scanf��ʾ����ֵ������

	
	start2 = clock();
	for (int m = 0; m < 10000; m++)
	{
		flag2 = ListLocate(&L, value2, &index2);
	}
	end2 = clock();

	time2 = (end2 - start2) / CLOCKS_PER_SEC;
	
	if (flag2 != -1)//�����������ݣ���ӡ��������
	{
		printf("[����Ԫ�ض�λ�ɹ���]\n[����ʱ��Ϊ��%f]\n������Ϊ %d\n", time2, index2);
	}
	else
	{
		printf("û�д�����\n");
	}
	putchar('\n');
	putchar('\n');

	/*����Ԫ��*/
	printf("�����������ĸ�λ�ò���ʲô��С�����ݣ���λ�úʹ�С�ÿո������");
	scanf_s("%d%d", &index2, &value2);

	start2 = clock();
	for (int m = 0; m < 10000; m++)
	{
		ListInsert_L(&L, index2, value2);
	}
	end2 = clock();

	time2 = (end2 - start2) / CLOCKS_PER_SEC;

	
	printf("[����Ԫ�ز���ɹ���]\n[����ʱ��Ϊ��%f]\n\n", time2);

	/*ɾ��Ԫ��*/
	printf("��������Ҫɾ������������ֵ��");
	scanf_s("%d", &index2);//��scanf��ʾ����ֵ������

	start2 = clock();
	for (int m = 0; m < 10000; m++)
	{
		ListDelete_L(&L, index2);
	}
	end2 = clock();

	time2 = (end2 - start2) / CLOCKS_PER_SEC;
	
	printf("[˳���Ԫ��ɾ���ɹ���]\n[����ʱ��Ϊ��%f]\n\n", time2);

}