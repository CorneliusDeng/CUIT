#include "library.h"

/*********************************************************************************
 Function: BIpub
 Description：通过出版社检索图书
 Input parameter：publish
 Out parameter：book.num、book.name、book.author、book.pub、book.count、book.recent
 Relevance：NULL
 Return: NULL
 Auhtor：Cornelius Deng
 DATE: 2019.6.16
**********************************************************************************/

int BIpub()
{
    int i, flag = 0;
	char publish[20];

    system("cls");
	
    printf("请输入出版社名称：\n");
	scanf("%s", publish);
	
	putchar('\n');

	for (i = 0; i < BookNum; i++)
	{
		if (strcmp(publish, book[i].publish) == 0)
		{
		   printf("编号：%-6s", book[i].num); 
		   printf("书名：%-18s", book[i].name); 
		   printf("作者：%-9s", book[i].author); 
		   printf("出版社：%-22s", book[i].publish); 
		   printf("总数：%-5d", book[i].count);
		   printf("现存：%-5d\n", book[i].recent);
		   flag = 1;
		}
	}

	fflush(stdin);

	if (flag == 0)
	{
		printf("\n未找到相关记录\n");
	}
	getch();
	return 0;
}