#include "library.h"

/*********************************************************************************
 Function: SRIname
 Description��ͨ��������ѯ������Ϣ
 Input parameter��name
 Out parameter��student.num��student.name
 Relevance��NULL
 Return: NULL
 Auhtor��Cornelius Deng
 DATE: 2019.6.21
**********************************************************************************/

int SRIname()
{
    int i, flag = 0;
	char name[20];

    system("cls");
	
    printf("������Ҫ��ѯ�Ķ���������\n");
	scanf("%s", name);
	
	for (i = 0; i < StudentNum; i++)
	{
		if (strcmp(name, student[i].name) == 0)
		{
		   printf("ѧ�ţ�%s\t", student[i].num); 
		   printf("������%s\t", student[i].name); 
		   flag = 1;
		   break;
		}
	}

	fflush(stdin);

	if (flag == 0)
	{
		printf("\nδ�ҵ����ѧ����¼\n");
	}
	getch();
	return 0;
}