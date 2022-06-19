#include "library.h"

/*********************************************************************************
 Function: ReaderInfo
 Description：删除读者信息
 Input parameter：num
 Out parameter：NULL
 Relevance：NULL
 Return: 标记是否找到学生信息的flag
 Auhtor：Cornelius Deng
 DATE: 2019.6.20
**********************************************************************************/

int DeleReaInfor()
{
	int i, j, flag = -1;
	char num[20];

	system("cls");
	printf("--------------删除学生信息--------------\n");
	printf("请输入想要删除的学号:");
	scanf("%s", num);

	for (i = 0; i < StudentNum; i++)  //查询学号
	{
		if(strcmp(student[i].num, num)==0)  //匹配
		{
			for (j = i; j < StudentNum; j++)
			{
				strcpy(student[j].num, student[j+1].num); 
				strcpy(student[j].name, student[j+1].name);
				StudentNum--;
			}
			printf("该学生信息已经删除！"); 
			flag = i;
		}
	}
	if(flag == -1)  //显示信息已删除
	{
		printf("没有找到相关记录");
	}
	fflush(stdin);
	getch();//读取一个字符，但是屏幕上并不会显示
	return flag; 
}