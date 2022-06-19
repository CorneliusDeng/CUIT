#include "library.h"

/*********************************************************************************
 Function: ReaderInfo
 Description：增删读者信息功能选择
 Input parameter：option
 Out parameter：NULL
 Relevance：TypeinReaInfor、DeleReaInfor、Body1
 Return: NULL
 Auhtor：Cornelius Deng
 DATE: 2019.6.20
**********************************************************************************/

void ReaderInfo()
{
	int option;

	system("cls");

	printf("——————————读者信息管理————————————\n");
	
	printf("—— 1 录入读者信息——\n");
	printf("—— 2 删除读者信息——\n");
	printf("—— 0 返回——\n");
	printf("  请输入您的选择: ");
	scanf("%d", &option);

	system("cls");

	switch(option)
	{
		case 1:
			system("cls"); TypeinReaInfor(); break;  
		case 2:
			system("cls"); DeleReaInfor(); break; 
		case 0:
			system("cls"); Body1(); break;  //回到管理员模式
		default :
			printf("\n\n\t\t输入有误！！\n");
			system("PAUSE"); system("cls"); break;
	}

}
