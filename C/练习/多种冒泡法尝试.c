#include<stdio.h>

int main()//�Ӵ�С����
{
	int i, j, a[10], temp;

	printf("������ʮ��������\n");
	for(i = 0; i < 10; i++)
		scanf("%d", &a[i]);

	for(i = 1; i < 10; i++)//��һ��д��
	{
		for(j = 0; j < 10 - i; j++)
		{
			if(a[j] < a[j+1])
			{
				temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
			}
		}
	}
	printf("��һ�������Ľ���ǣ�\n");
	for(i = 0; i < 10; i++)
		printf("%-3d", a[i]);
	putchar('\n');



	for(i = 0; i < 9; i++)//�ڶ���д��
	{
		for(j = i; j < 9; j++)
		{
			if(a[j] < a[j+1])
			{
				temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
			}
		}
	}
	printf("�ڶ��������Ľ���ǣ�\n");
	for(i = 0; i < 10; i++)
		printf("%-3d", a[i]);
	putchar('\n');


	for(i = 0; i < 9; i++)//������д��
	{
		for(j = 0; j < 9 - i; j++)
		{
			if(a[j] < a[j+1])
			{
				temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
			}
		}
	}
	printf("�����������Ľ���ǣ�\n");
	for(i = 0; i < 10; i++)
		printf("%-3d", a[i]);
	putchar('\n');


	for(i = 0; i < 9; i++)//������д��
	{
		for(j = i + 1; j < 9; j++)
		{
			if(a[j] < a[j+1])
			{
				temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
			}
		}
	}
	printf("�����������Ľ���ǣ�\n");
	for(i = 0; i < 10; i++)
		printf("%-3d", a[i]);
	putchar('\n');
}
