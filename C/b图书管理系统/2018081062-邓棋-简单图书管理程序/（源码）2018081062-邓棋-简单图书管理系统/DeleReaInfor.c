#include "library.h"

/*********************************************************************************
 Function: ReaderInfo
 Description��ɾ��������Ϣ
 Input parameter��num
 Out parameter��NULL
 Relevance��NULL
 Return: ����Ƿ��ҵ�ѧ����Ϣ��flag
 Auhtor��Cornelius Deng
 DATE: 2019.6.20
**********************************************************************************/

int DeleReaInfor()
{
	int i, j, flag = -1;
	char num[20];

	system("cls");
	printf("--------------ɾ��ѧ����Ϣ--------------\n");
	printf("��������Ҫɾ����ѧ��:");
	scanf("%s", num);

	for (i = 0; i < StudentNum; i++)  //��ѯѧ��
	{
		if(strcmp(student[i].num, num)==0)  //ƥ��
		{
			for (j = i; j < StudentNum; j++)
			{
				strcpy(student[j].num, student[j+1].num); 
				strcpy(student[j].name, student[j+1].name);
				StudentNum--;
			}
			printf("��ѧ����Ϣ�Ѿ�ɾ����"); 
			flag = i;
		}
	}
	if(flag == -1)  //��ʾ��Ϣ��ɾ��
	{
		printf("û���ҵ���ؼ�¼");
	}
	fflush(stdin);
	getch();//��ȡһ���ַ���������Ļ�ϲ�������ʾ
	return flag; 
}