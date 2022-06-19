#include "library.h"

/*********************************************************************************
 Function: Delete
 Description：清除图书库存
 Input parameter：name
 Out parameter：NULL
 Relevance：NULL
 Return: 标记是否找到图书的flag
 Auhtor：Cornelius Deng
 DATE: 2019.6.16
**********************************************************************************/

int Delete()
{
	int i, j, flag = -1;
	char name[20];
	system("cls");

	printf("--------------清除库存--------------\n");
	printf("请输入想要删除的图书名称:");
	scanf("%s", name);
	for (i = 0; i < BookNum; i++)
	{
		if(strcmp(book[i].name,name) == 0)
		{
			for(j = i; j < BookNum; j++)
			{
				strcpy(book[j].num,book[j+1].num); 
				strcpy(book[j].name,book[j+1].name); 
				strcpy(book[j].author,book[j+1].author); 
				strcpy(book[j].publish,book[j+1].publish); 
				book[j].count = book[j+1].count;
				book[j].recent = book[j+1].recent;
				BookNum--;
			}
			printf("该书已经删除！"); 
			flag = i;
		}
	}
	
	if(flag == -1)
	{
		printf("没有找到相关记录");
		fflush(stdin);
		getch();
	}
	
	return flag; 
}