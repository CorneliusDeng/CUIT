#include "library.h"

/*********************************************************************************
 Function: SRIname
 Description：通过姓名查询读者信息
 Input parameter：name
 Out parameter：student.num、student.name
 Relevance：NULL
 Return: NULL
 Auhtor：Cornelius Deng
 DATE: 2019.6.21
**********************************************************************************/

int SRIname()
{
    int i, flag = 0;
	char name[20];

    system("cls");
	
    printf("输入所要查询的读者姓名：\n");
	scanf("%s", name);
	
	for (i = 0; i < StudentNum; i++)
	{
		if (strcmp(name, student[i].name) == 0)
		{
		   printf("学号：%s\t", student[i].num); 
		   printf("姓名：%s\t", student[i].name); 
		   flag = 1;
		   break;
		}
	}

	fflush(stdin);

	if (flag == 0)
	{
		printf("\n未找到相关学生记录\n");
	}
	getch();
	return 0;
}