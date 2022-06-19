#include "library.h"

/*********************************************************************************
 Function: Read
 Description：在主函数中读取数据信息
 Input parameter：NULL
 Out parameter：NULL
 Relevance：NULL
 Return: NULL
 Auhtor：Cornelius Deng
 DATE: 2019.6.23
**********************************************************************************/

void Read(BooksInformation book[], StuInformation student[], BorrowInfomation borrow[])
{
	int count = 0;
	int recent = 0;
	int i = 0;
	FILE *fp, *p1, *p2;


	if ((fp = fopen("book.txt", "r+")) == NULL)
	{
		printf("open failed!");
		exit(0);
	}
	if ((p1 = fopen("student.txt", "r+")) == NULL)
	{
		printf("open failed!");
		exit(0);
	}
	if ((p2 = fopen("borrow.txt", "r+")) == NULL)
	{
		printf("open failed!");
		exit(0);
	}
	for (i = 0; !feof(fp); i++)
		{
			if(fscanf(fp,"%s\t%s\t%s\t%s\t%d\t%d\t%d\n", book[i].num, book[i].name, book[i].author, book[i].publish,
				&book[i].count, &book[i].recent, &book[i].times) == 7)
			{
				BookNum++;
			}
		}
	for (i = 0; !feof(p1); i++)
	{
		if(fscanf(p1,"%s\t%s\t%d\n", student[i].num, student[i].name, &student[i].money) == 3)
		{
			StudentNum++;
		}
	}
	for (i = 0; !feof(p2); i++)
	{
		if(fscanf(p2,"%s\t%s\t%d\n",borrow[i].studentnum, borrow[i].booknum, &borrow[i].time) == 3)
		{
			BorrowNum++;
		}
	}

	for (i = 0; i < BookNum; i++)
	{
		count +=  book[i].count;
		recent += book[i].recent;
	}
	fclose(fp);
	fclose(p1);
	fclose(p2);

}