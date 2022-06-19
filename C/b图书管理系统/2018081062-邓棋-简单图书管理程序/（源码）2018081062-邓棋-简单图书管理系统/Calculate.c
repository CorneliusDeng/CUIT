#include "library.h"

/*********************************************************************************
 Function: Calculate
 Description：统计、排名借阅信息
 Input parameter：NULL
 Out parameter：NULL
 Relevance：NULL
 Return: NULL
 Auhtor：Cornelius Deng
 DATE: 2019.6.23
**********************************************************************************/

void Calculate()
{
	int i, j;
	
	system("cls");
    printf("--------------热门图书借阅排行榜--------------\n");
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
		printf("N0.%4d, 书名:%-10s\n", i+1, book[i].name);
	}

	putchar('\n');

	printf("--------------延迟还书罚款排行榜--------------\n");
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
		printf("N0.%4d, 姓名:%-6s,罚款: %-4d 元\n",i+1, student[i].name, student[i].money);
	}

	putchar('\n');

	getch();
}