#include "library.h"

/*********************************************************************************
 Function: BIname
 Description��ͨ����������ͼ��
 Input parameter��name
 Out parameter��book.num��book.name��book.author��book.pub��book.count��book.recent
 Relevance��NULL
 Return: NULL
 Auhtor��Cornelius Deng
 DATE: 2019.6.16
**********************************************************************************/

int BIname()
{
    int i, flag = 0;
	char name[20];

    system("cls");
	
    printf("�������ƣ�\n");
	scanf("%s", name);

	putchar('\n');
	
	for (i = 0;i < BookNum; i++)
	{
		if (strcmp(name, book[i].name) == 0)
		{
		   printf("��ţ�%-6s", book[i].num); 
		   printf("������%-18s", book[i].name); 
		   printf("���ߣ�%-9s", book[i].author); 
		   printf("�����磺%-22s", book[i].publish); 
		   printf("������%-5d", book[i].count);
		   printf("�ִ棺%-5d\n", book[i].recent);
		   flag = 1;
		   break;
		}
	}

	fflush(stdin);

	if (flag == 0)
	{
		printf("\nδ�ҵ���ؼ�¼\n");
	}
	getch();
	return 0;
}