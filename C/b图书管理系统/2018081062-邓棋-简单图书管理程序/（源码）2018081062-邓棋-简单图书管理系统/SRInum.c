#include "library.h"

/*********************************************************************************
 Function: SRInum
 Description：通过学号查询读者信息
 Input parameter：num
 Out parameter：student.num、student.name
 Relevance：NULL
 Return: NULL
 Auhtor：Cornelius Deng
 DATE: 2019.6.21
**********************************************************************************/

int SRInum()
{
    int i, flag = 0;
	char num[20];

    system("cls");
	
    printf("输入所要查询的读者学号：\n");
	scanf("%s", num);
	
	for (i = 0; i < StudentNum; i++)  //匹配信息
	{
		if (strcmp(num, student[i].num) == 0)
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