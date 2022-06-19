#include "library.h"

/*********************************************************************************
 Function: Borrow
 Description：借阅图书
 Input parameter：booknum、studentnum、time
 Out parameter：NULL
 Relevance：NULL
 Return: NULL
 Auhtor：Cornelius Deng
 DATE: 2019.6.17
**********************************************************************************/

int Borrow()
{
	int bookflag = 0, studentflag = 0;
	int order;//作为已经查询到图书的编号
	int time;//借阅当天的时间
	int i, j;
	char booknum[20];
	char studentnum[20];

	system("cls");
    printf("--------------读者借书系统--------------\n");

	printf("请输入要借图书的编号:");
	scanf("%s", booknum);

	for (i = 0; i < BookNum; i++)  //查询图书
	{
		if(strcmp(book[i].num, booknum) == 0)
		{
			bookflag = 1;
			order = i;
			break;
		}
	}
	if (bookflag == 0)  //图书不存在
	{
		printf("图书不存在,请重新输入\n");
		fflush(stdin);
		getch();
		return bookflag;
	}
	else  //图书存在
	{
		printf("%s 共有%d本,现有%d本\n", book[order].name,
			book[order].count, book[order].recent);

		/*现在开始登记借阅信息*/
		printf("请输入学生证号:");
		scanf("%s", studentnum);
		for (j = 0; j < StudentNum; j++)  //查询学号
		{
			if(strcmp(student[j].num, studentnum)==0)
			{
				studentflag = 1;
				break;
			}
		}
		if(studentflag == 0)  //学号不存在
		{
			printf("没有学生信息\n");
			fflush(stdin);
			getch();
			return studentflag;
		}
		else
		{
			if(book[order].recent == 0)  //该图书没有库存
			{
				printf("暂时没有库存,借阅失败\n");
				fflush(stdin);
				getch();
				return 0;
			}
			else  //有库存
			{
				printf("请输入借阅时间 例如2019.6.23 写做(20190623):");
				scanf("%d", &time);
				for (i = BorrowNum; i < 1000;i++)  //录入借阅信息
				{
					strcpy(borrow[i].studentnum, studentnum);
					strcpy(borrow[i].booknum, booknum);
					borrow[i].time = time;
				}
				book[order].recent--;
				BorrowNum++;
				book[order].times++;
				printf("\n借书成功,请在30天内归还,按任意键返回******\n");
				fflush(stdin);
				getch();
				return 0;
			}
		}
	}
}