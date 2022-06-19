#include "library.h"

/*********************************************************************************
 Function: BIkeyword
 Description：通过关键字检索图书
 Input parameter：keyword
 Out parameter：book.num、book.name、book.author、book.pub、book.count、book.recent
 Relevance：NULL
 Return: NULL
 Auhtor：Cornelius Deng
 DATE: 2019.6.16
**********************************************************************************/

int BIkeyword()
{
    int i, flag = 0;
	char keyword[20];

    system("cls");
	
    printf("请输入关键字：\n");
	scanf("%s", keyword);

	putchar('\n');
	
	for (i = 0; i < BookNum; i++)
	{
		/*strstr(str1,str2)函数用于判断字符串str2是否是字符串str1的子串
		是的话返回str2在str1中首次出现的地址，否则返回NULL*/
		if (strstr(book[i].name, keyword) != NULL || strstr(book[i].author, keyword) != NULL || 
			strstr(book[i].publish, keyword) != NULL)
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