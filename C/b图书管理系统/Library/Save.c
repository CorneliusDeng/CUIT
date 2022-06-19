#include "library.h"

/*********************************************************************************
 Function: Save
 Description：保存数据信息
 Input parameter：NULL
 Out parameter：NULL
 Relevance：NULL
 Return: NULL
 Auhtor：Cornelius Deng
 DATE: 2019.6.23
**********************************************************************************/

void Save(BooksInformation book[], StuInformation student[], BorrowInfomation borrow[])
{
	int i = 0;
	FILE *fp, *p1, *p2;

	if ((fp = fopen("book.txt", "w+")) == NULL)
	{
		printf("open failed!");
		exit(0);
	}
	
	if ((p1 = fopen("student.txt", "w+")) == NULL)
	{
		printf("open failed!");
		exit(0);
	}
	if ((p2 = fopen("borrow.txt", "w+")) == NULL)
	{
		printf("open failed!");
		exit(0);
	}

	for (i = 0; i < BookNum; i++)
	{
		fprintf(fp,"%s\t%s\t%s\t%s\t%d\t%d\t%d\n", book[i].num, book[i].name, book[i].author, book[i].publish,
			book[i].count, book[i].recent, book[i].times);
	}
	
	for (i = 0; i < StudentNum; i++)
	{
		fprintf(p1,"%s\t%s\t%d\n", student[i].num, student[i].name, student[i].money);
	}

	for (i = 0; i < BorrowNum;i++)
	{
		fprintf(p2,"%s\t%s\t%d\n", borrow[i].studentnum, borrow[i].booknum, borrow[i].time);
	}

	fclose(fp);
	fclose(p1);
	fclose(p2);
}