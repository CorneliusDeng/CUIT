#include "library.h"

/*********************************************************************************
 Function: BooksInfo
 Description��ͼ���������ѡ��
 Input parameter��option
 Out parameter��NULL
 Relevance��BInum��BIname��BIauthor��BIpub��BIkeyword
 Return: NULL
 Auhtor��Cornelius Deng
 DATE: 2019.6.16
**********************************************************************************/


void BooksInfo()
{
	while(1)
	{
		int option;

		system("cls");
		printf("--------------�鿴ͼ����Ϣ--------------\n");
		printf("\n\t ��ѡ������ѡ�");
		printf("\n\t 1.����ͼ����\n");
		printf("\n\t 2.����ͼ������\n");
		printf("\n\t 3.��������\n");
		printf("\n\t 4.���ݳ�����\n");
		printf("\n\t 5.���ݹؼ���\n");
		printf("\n\t 0.����\n");
		printf("\n����������ѡ��");
		scanf("%1d", &option);
		switch(option)
		{
			case 1:
				system("cls"); BInum(); break;  //�ñ�Ų���
			case 2:
				system("cls"); BIname(); break;  //����������
			case 3:
				system("cls"); BIauthor(); break;  //�����߲���
			case 4:
				system("cls"); BIpub(); break;  //�ó��������
			case 5:
				system("cls"); BIkeyword(); break;  //�ùؼ��ֲ���
			case 0:
				system("cls"); Body2(); break;  //�ص�����Աģʽ
			default :
				printf("\n\n\t\t�������󣡣�\n");
				system("PAUSE"); system("cls"); break;
		}	
	}
}