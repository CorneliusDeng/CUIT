#include "library.h"

/*********************************************************************************
 Function: Return
 Description���黹ͼ��
 Input parameter��studentnum��booknum��time
 Out parameter��NULL
 Relevance��NULL
 Return: �ж��Ƿ�ƥ�������Ϣ��flag
 Auhtor��Cornelius Deng
 DATE: 2019.6.17
**********************************************************************************/

int Return()
{
	char studentnum[20], booknum[20];
	int time;//����ʱ��
	int keeptime = 0;//�鼮�������
	int i, j;
	int a, b;
	int flag = -1;

	system("cls");
    printf("--------------����ϵͳ--------------\n");
	printf("������ѧ��:");
	scanf("%s", studentnum);
	printf("������ͼ����:");
	scanf("%s", booknum);
	printf("�����뻹��ʱ�� ����2019.6.23 д��(20190623):");
	scanf("%d", &time);

	for(i = 0; i < BorrowNum; i++)  //ƥ����Ϣ
	{
		if ((strcmp(studentnum, borrow[i].studentnum) == 0) && (strcmp(booknum, borrow[i].booknum) == 0))
		{
			keeptime = time - borrow[i].time;
			printf("��ѯ�����¼�¼:");
			printf("ѧ��%s\tͼ�����%s\n",borrow[i].studentnum, borrow[i].booknum);
			getch();

			for (a = 0; a < BookNum; a++)  
			{
				if (strcmp(borrow[i].booknum, book[a].num) == 0)
				{
					book[a].recent++;
					break;
				}
			}
			for (j = i; j < BorrowNum; j++)//����������¼
			{
				strcpy(borrow[j].studentnum, borrow[j+1].studentnum); 
				strcpy(borrow[j].booknum, borrow[j+1].booknum); 
				borrow[j].time = borrow[j+1].time;
			}
			BorrowNum--;
			if(keeptime < 30)  //����ʱ��С��30��
			{
				printf("���ڹ涨ʱ���ڹ黹ͼ��\n");
			}
			else //����ʱ�����30
			{
				printf("���ڹ黹������10Ԫ\n");
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
		printf("û���ҵ���ؼ�¼");
	}
	fflush(stdin);
	getch();
	return flag; 
}

