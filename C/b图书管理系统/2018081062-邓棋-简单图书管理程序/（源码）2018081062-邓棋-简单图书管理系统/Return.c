#include "library.h"

/*********************************************************************************
 Function: Return
 Description：归还图书
 Input parameter：studentnum、booknum、time
 Out parameter：NULL
 Relevance：NULL
 Return: 判断是否匹配借阅信息的flag
 Auhtor：Cornelius Deng
 DATE: 2019.6.17
**********************************************************************************/

int Return()
{
	char studentnum[20], booknum[20];
	int time;//还书时间
	int keeptime = 0;//书籍借出天数
	int i, j;
	int a, b;
	int flag = -1;

	system("cls");
    printf("--------------还书系统--------------\n");
	printf("请输入学号:");
	scanf("%s", studentnum);
	printf("请输入图书编号:");
	scanf("%s", booknum);
	printf("请输入还书时间 例如2019.6.23 写做(20190623):");
	scanf("%d", &time);

	for(i = 0; i < BorrowNum; i++)  //匹配信息
	{
		if ((strcmp(studentnum, borrow[i].studentnum) == 0) && (strcmp(booknum, borrow[i].booknum) == 0))
		{
			keeptime = time - borrow[i].time;
			printf("查询到以下记录:");
			printf("学号%s\t图书编码%s\n",borrow[i].studentnum, borrow[i].booknum);
			getch();

			for (a = 0; a < BookNum; a++)  
			{
				if (strcmp(borrow[i].booknum, book[a].num) == 0)
				{
					book[a].recent++;
					break;
				}
			}
			for (j = i; j < BorrowNum; j++)//覆盖消除记录
			{
				strcpy(borrow[j].studentnum, borrow[j+1].studentnum); 
				strcpy(borrow[j].booknum, borrow[j+1].booknum); 
				borrow[j].time = borrow[j+1].time;
			}
			BorrowNum--;
			if(keeptime < 30)  //借书时间小于30天
			{
				printf("已在规定时间内归还图书\n");
			}
			else //借书时间大于30
			{
				printf("逾期归还，罚款10元\n");
				for (b = 0; b < StudentNum; b++)
				{
					if (strcmp(studentnum, student[b].num) == 0)
					{
						student[b].money = student[b].money + 10;
					}
				}

			}
			flag = i;
		}
	}
	if (flag == -1)
	{
		printf("没有找到相关记录");
	}
	fflush(stdin);
	getch();
	return flag; 
}

