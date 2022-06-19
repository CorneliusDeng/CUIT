#include "library.h"

/*********************************************************************************
 Function: TypeinReaInfor
 Description：录入读者信息
 Input parameter：choice
 Out parameter：NULL
 Relevance：NULL
 Return: NULL
 Auhtor：Cornelius Deng
 DATE: 2019.6.20
**********************************************************************************/

void TypeinReaInfor()
{
	int i = 0;
	char choice;

	system("cls");

	printf("--------------录入学生信息--------------\n");
		for (i = StudentNum; i < 1000; i++)
		{
				printf("学号:\n");
				scanf("%s", student[i].num); 

				printf("姓名:\n"); 
				scanf("%s", student[i].name);

				student[i].money = 0;
				StudentNum++;

				printf("是否要退出(y/n)\n");
				fflush(stdin);
				scanf("%c", &choice);
				fflush(stdin);
				if(choice == 'y'||choice == 'Y')
				{
					break;
				}
		}

}