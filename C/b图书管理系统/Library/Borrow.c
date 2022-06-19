#include "library.h"

/*********************************************************************************
 Function: Borrow
 Description������ͼ��
 Input parameter��booknum��studentnum��time
 Out parameter��NULL
 Relevance��NULL
 Return: NULL
 Auhtor��Cornelius Deng
 DATE: 2019.6.17
**********************************************************************************/

int Borrow()
{
	int bookflag = 0, studentflag = 0;
	int order;//��Ϊ�Ѿ���ѯ��ͼ��ı��
	int time;//���ĵ����ʱ��
	int i, j;
	char booknum[20];
	char studentnum[20];

	system("cls");
    printf("--------------���߽���ϵͳ--------------\n");

	printf("������Ҫ��ͼ��ı��:");
	scanf("%s", booknum);

	for (i = 0; i < BookNum; i++)  //��ѯͼ��
	{
		if(strcmp(book[i].num, booknum) == 0)
		{
			bookflag = 1;
			order = i;
			break;
		}
	}
	if (bookflag == 0)  //ͼ�鲻����
	{
		printf("ͼ�鲻����,����������\n");
		fflush(stdin);
		getch();
		return bookflag;
	}
	else  //ͼ�����
	{
		printf("%s ����%d��,����%d��\n", book[order].name,
			book[order].count, book[order].recent);

		/*���ڿ�ʼ�Ǽǽ�����Ϣ*/
		printf("������ѧ��֤��:");
		scanf("%s", studentnum);
		for (j = 0; j < StudentNum; j++)  //��ѯѧ��
		{
			if(strcmp(student[j].num, studentnum)==0)
			{
				studentflag = 1;
				break;
			}
		}
		if(studentflag == 0)  //ѧ�Ų�����
		{
			printf("û��ѧ����Ϣ\n");
			fflush(stdin);
			getch();
			return studentflag;
		}
		else
		{
			if(book[order].recent == 0)  //��ͼ��û�п��
			{
				printf("��ʱû�п��,����ʧ��\n");
				fflush(stdin);
				getch();
				return 0;
			}
			else  //�п��
			{
				printf("���������ʱ�� ����2019.6.23 д��(20190623):");
				scanf("%d", &time);
				for (i = BorrowNum; i < 1000;i++)  //¼�������Ϣ
				{
					strcpy(borrow[i].studentnum, studentnum);
					strcpy(borrow[i].booknum, booknum);
					borrow[i].time = time;
				}
				book[order].recent--;
				BorrowNum++;
				book[order].times++;
				printf("\n����ɹ�,����30���ڹ黹,�����������******\n");
				fflush(stdin);
				getch();
				return 0;
			}
		}
	}
}