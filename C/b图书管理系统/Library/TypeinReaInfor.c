#include "library.h"

/*********************************************************************************
 Function: TypeinReaInfor
 Description��¼�������Ϣ
 Input parameter��choice
 Out parameter��NULL
 Relevance��NULL
 Return: NULL
 Auhtor��Cornelius Deng
 DATE: 2019.6.20
**********************************************************************************/

void TypeinReaInfor()
{
	int i = 0;
	char choice;

	system("cls");

	printf("--------------¼��ѧ����Ϣ--------------\n");
		for (i = StudentNum; i < 1000; i++)
		{
				printf("ѧ��:\n");
				scanf("%s", student[i].num); 

				printf("����:\n"); 
				scanf("%s", student[i].name);

				student[i].money = 0;
				StudentNum++;

				printf("�Ƿ�Ҫ�˳�(y/n)\n");
				fflush(stdin);
				scanf("%c", &choice);
				fflush(stdin);
				if(choice == 'y'||choice == 'Y')
				{
					break;
				}
		}

}