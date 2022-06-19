#include "library.h"

/*********************************************************************************
 Function: BooksInfo
 Description：图书检索功能选择
 Input parameter：option
 Out parameter：NULL
 Relevance：BInum、BIname、BIauthor、BIpub、BIkeyword
 Return: NULL
 Auhtor：Cornelius Deng
 DATE: 2019.6.16
**********************************************************************************/


void BooksInfo()
{
	while(1)
	{
		int option;

		system("cls");
		printf("--------------查看图书信息--------------\n");
		printf("\n\t 请选择依据选项：");
		printf("\n\t 1.根据图书编号\n");
		printf("\n\t 2.根据图书名称\n");
		printf("\n\t 3.根据作者\n");
		printf("\n\t 4.根据出版社\n");
		printf("\n\t 5.根据关键字\n");
		printf("\n\t 0.返回\n");
		printf("\n请输入您的选择：");
		scanf("%1d", &option);
		switch(option)
		{
			case 1:
				system("cls"); BInum(); break;  //用编号查找
			case 2:
				system("cls"); BIname(); break;  //用书名查找
			case 3:
				system("cls"); BIauthor(); break;  //用作者查找
			case 4:
				system("cls"); BIpub(); break;  //用出版社查找
			case 5:
				system("cls"); BIkeyword(); break;  //用关键字查找
			case 0:
				system("cls"); Body2(); break;  //回到管理员模式
			default :
				printf("\n\n\t\t输入有误！！\n");
				system("PAUSE"); system("cls"); break;
		}	
	}
}