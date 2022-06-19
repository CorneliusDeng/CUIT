#include "library.h"

/*********************************************************************************
 Function: BIkeyword
 Description��ͨ���ؼ��ּ���ͼ��
 Input parameter��keyword
 Out parameter��book.num��book.name��book.author��book.pub��book.count��book.recent
 Relevance��NULL
 Return: NULL
 Auhtor��Cornelius Deng
 DATE: 2019.6.16
**********************************************************************************/

int BIkeyword()
{
    int i, flag = 0;
	char keyword[20];

    system("cls");
	
    printf("������ؼ��֣�\n");
	scanf("%s", keyword);

	putchar('\n');
	
	for (i = 0; i < BookNum; i++)
	{
		/*strstr(str1,str2)���������ж��ַ���str2�Ƿ����ַ���str1���Ӵ�
		�ǵĻ�����str2��str1���״γ��ֵĵ�ַ�����򷵻�NULL*/
		if (strstr(book[i].name, keyword) != NULL || strstr(book[i].author, keyword) != NULL || 
			strstr(book[i].publish, keyword) != NULL)
		{
		   printf("��ţ�%-6s", book[i].num); 
		   printf("������%-18s", book[i].name); 
		   printf("���ߣ�%-9s", book[i].author); 
		   printf("�����磺%-22s", book[i].publish); 
		   printf("������%-5d", book[i].count);
		   printf("�ִ棺%-5d\n", book[i].recent);
		   flag = 1;
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