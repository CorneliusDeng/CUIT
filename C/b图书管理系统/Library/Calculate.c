#include "library.h"

/*********************************************************************************
 Function: Calculate
 Description��ͳ�ơ�����������Ϣ
 Input parameter��NULL
 Out parameter��NULL
 Relevance��NULL
 Return: NULL
 Auhtor��Cornelius Deng
 DATE: 2019.6.23
**********************************************************************************/

void Calculate()
{
	int i, j;
	
	system("cls");
    printf("--------------����ͼ��������а�--------------\n");
	for (i = 0; i < BookNum; i++)
	{
		for (j = i; j < BookNum; j++)
		{
			if (book[i].times < book[j].times)
			{
				temp = book[i];
				book[i] = book[j];
				book[j] = temp;
			}
		}
	}
	for (i = 0; i < 10;i++)
	{
		printf("N0.%4d, ����:%-10s\n", i+1, book[i].name);
	}

	putchar('\n');

	printf("--------------�ӳٻ��鷣�����а�--------------\n");
	for (i = 0; i < StudentNum; i++)
	{
		for (j = i; j < StudentNum; j++)
		{
			if (student[i].money < student[j].money)
			{
				temp1 = student[i];
				student[i] = student[j];
				student[j] = temp1;
			}
		}
	}

	for (i = 0; i < 5; i++)
	{
		printf("N0.%4d, ����:%-6s,����: %-4d Ԫ\n",i+1, student[i].name, student[i].money);
	}

	putchar('\n');

	getch();
}