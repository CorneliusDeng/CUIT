#include "library.h"

/*********************************************************************************
 Function: Add
 Description：图书采编入库
 Input parameter：num、name、author、pub
 Out parameter：NULL
 Relevance：NULL
 Return: NULL
 Auhtor：Cornelius Deng
 DATE: 2019.6.16
**********************************************************************************/

void Add()
{
	int i = 0, j = 0, count, recent, flag;
	char num[20],name[20],author[20],pub[20];//书号、书名、作者、出版社
	char choice;

	system("cls");


	printf("--------------采编入库--------------\n");
	
	for (i = BookNum; i < 100; i++)
	{
		flag = 0;
		printf("书号: \n");
		scanf("%s", num);

		printf("书名: \n"); 
		scanf("%s", name); 
			
		printf("作者: \n");
		scanf("%s", author);

		printf("出版社: \n"); 
		scanf("%s", pub);

		printf("数量: \n");
		scanf("%d", &count);

		recent = count;
		if(BookNum > 0)
		{
			for(j = 0; j < BookNum; j++)
			{
				if(strcmp(book[j].name, name)==0)//如过采编的书已在书库内了
				{
					flag = 1;
					book[j].count = book[j].count + count;
					book[j].recent = book[j].recent + count;
					printf("图书%s库存已增加%d本\n",book[j].name,count);
				}
			}
		}
		if(flag == 0)
		{
			strcpy(book[i].num,num);
			strcpy(book[i].name,name);
			strcpy(book[i].author,author);
			strcpy(book[i].publish,pub);
			book[i].count = count;
			book[i].recent = recent;
			book[i].times = 0;
			flag++;
			BookNum++;
		}
		printf("是否要退出(y/n)\n");
		fflush(stdin);//清空输入缓冲区
		scanf("%c", &choice);
		fflush(stdin);
		if(choice=='y'||choice=='Y')
		{
			break;
		}
	}
}