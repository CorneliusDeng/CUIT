#include "library.h"

/*********************************************************************************
 Function: Add
 Description��ͼ��ɱ����
 Input parameter��num��name��author��pub
 Out parameter��NULL
 Relevance��NULL
 Return: NULL
 Auhtor��Cornelius Deng
 DATE: 2019.6.16
**********************************************************************************/

void Add()
{
	int i = 0, j = 0, count, recent, flag;
	char num[20],name[20],author[20],pub[20];//��š����������ߡ�������
	char choice;

	system("cls");


	printf("--------------�ɱ����--------------\n");
	
	for (i = BookNum; i < 100; i++)
	{
		flag = 0;
		printf("���: \n");
		scanf("%s", num);

		printf("����: \n"); 
		scanf("%s", name); 
			
		printf("����: \n");
		scanf("%s", author);

		printf("������: \n"); 
		scanf("%s", pub);

		printf("����: \n");
		scanf("%d", &count);

		recent = count;
		if(BookNum > 0)
		{
			for(j = 0; j < BookNum; j++)
			{
				if(strcmp(book[j].name, name)==0)//����ɱ���������������
				{
					flag = 1;
					book[j].count = book[j].count + count;
					book[j].recent = book[j].recent + count;
					printf("ͼ��%s���������%d��\n",book[j].name,count);
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
		printf("�Ƿ�Ҫ�˳�(y/n)\n");
		fflush(stdin);//������뻺����
		scanf("%c", &choice);
		fflush(stdin);
		if(choice=='y'||choice=='Y')
		{
			break;
		}
	}
}