#include "library.h"

/*********************************************************************************
 Function: SRInum
 Description��ͨ��ѧ�Ų�ѯ������Ϣ
 Input parameter��num
 Out parameter��student.num��student.name
 Relevance��NULL
 Return: NULL
 Auhtor��Cornelius Deng
 DATE: 2019.6.21
**********************************************************************************/

int SRInum()
{
    int i, flag = 0;
	char num[20];

    system("cls");
	
    printf("������Ҫ��ѯ�Ķ���ѧ�ţ�\n");
	scanf("%s", num);
	
	for (i = 0; i < StudentNum; i++)  //ƥ����Ϣ
	{
		if (strcmp(num, student[i].num) == 0)
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