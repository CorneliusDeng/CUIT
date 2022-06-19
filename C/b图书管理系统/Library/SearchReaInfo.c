#include "library.h"

/*********************************************************************************
 Function: SearchReaInfo
 Description：查询读者信息功能选择
 Input parameter：option
 Out parameter：NULL
 Relevance：SRInum、SRIname、Body1
 Return: NULL
 Auhtor：Cornelius Deng
 DATE: 2019.6.21
**********************************************************************************/

void SearchReaInfo()
{
	while(1)
	{
		int option;

		system("cls");
		printf("--------------查询读者信息--------------\n");
		printf("\n\t 请选择查找项：");
		printf("\n\t 1.根据学号查找\n");
		printf("\n\t 2.根据姓名查找\n");
		printf("\n\t 0.返回\n");
		printf("\n请输入您的选择：");
		scanf("%1d", &option);

		switch(option)
		{
			case 1:
				system("cls"); SRInum(); break;  //用学号查找
			case 2:
				system("cls"); SRIname(); break;  //用姓名查找
			case 0:
				system("cls"); Body1(); break;  //回到管理员模式
			default :
				printf("\n\n\t\t输入有误！！\n");
				system("PAUSE"); system("cls"); break;
		}	
	}
}