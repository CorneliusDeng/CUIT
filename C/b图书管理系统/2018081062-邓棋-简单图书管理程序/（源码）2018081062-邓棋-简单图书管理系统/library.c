#include "library.h"

/*********************************************************************************
 Function: Body1��Body2��welcome
 Description����¼���棬����ѡ��
 Input parameter��option
 Out parameter��function
 Relevance��NULL
 Return: NULL
 Auhtor��Cornelius Deng
 DATE: 2019.6.15
**********************************************************************************/

void Body1()
{
	int choice = 1;

	do
	{
		system("cls");   
		printf("                          ͼ�����ϵͳ(����Ա)                    \n");
		printf("     ****************�ɶ���Ϣ���̴�ѧͼ��ݻ�ӭ��*****************\n");
		printf("           *  1 ͼ��ɱ����               2 ������ͼ��        *\n");
		printf("           *  3 ��ѯͼ����Ϣ               4 ��ɾ������Ϣ        *\n");
		printf("           *  5 ��ѯ������Ϣ               6 ͳ�Ƽ���            *\n");
		printf("           *                  0 �˳�ϵͳ                         *\n");
		printf("     *************************************************************\n");
		printf("                     ���������������ܱ��:");
		scanf("%d", &choice);
		switch(choice)	
		{
			case 1: Add(); break;
			case 2: Delete(); break;
			case 3: BooksInfo(); break;
			case 4: ReaderInfo(); break;
			case 5: SearchReaInfo(); break;
			case 6: Calculate();Read2(book, student, borrow);break;
			case 0: system("cls");Save(book, student, borrow);
			printf("\n\n\n\n\n\t���������Ѹ��±���");
			printf("\n\n\n\n\n\t�ɶ���Ϣ���̴�ѧͼ����ڴ������ٴ�����");
			printf("\n\n\n\n\n\t^^^^^^^^^^��л����ʹ�ã��ټ�^^^^^^^^^^��\n\n");
			system("PAUSE");
			exit(0);
			default :
				printf("\n\n\t\t�������󣡣�\n");
				system("PAUSE");system("cls"); break;
		}
	}while(choice != 0);
}


void Body2()
{
	int choice = 1;
	do
	{
		system("cls");   
		printf("                           ͼ�����ϵͳ(����)                     \n");
		printf("     ****************�ɶ���Ϣ���̴�ѧͼ��ݻ�ӭ��*****************\n");
		printf("           *  1 ͼ�����                   2 ����ͼ��            *\n");
		printf("           *  3 �黹ͼ��                   4 �鿴��            *\n");
		printf("           *                0 �˳�ϵͳ                           *\n");
		printf("     *************************************************************\n");
		printf("                      ���������������ܱ��:");
		
		scanf("%d", &choice);

		switch(choice)
		{
			case 1: BooksInfo(); break;
			case 2: Borrow(); break;
			case 3: Return(); break;
			case 4: Calculate();break;
			case 0: system("cls");Save(book, student, borrow);
			printf("\n\n\n\n\n\t���������Ѹ��±���");
			printf("\n\n\n\n\n\t�ɶ���Ϣ���̴�ѧͼ����ڴ������ٴ�����");
			printf("\n\n\n\n\n\t^^^^^^^^^^��л����ʹ�ã��ټ�^^^^^^^^^^��\n\n");
			system("PAUSE");
			exit(0);
			default :
				printf("\n\n\t\t�������󣡣�\n");
				system("PAUSE");system("cls"); break;
		}
	}while(choice != 0);
}

void welcome()
{
	int option;
	
	printf("************************************************************\n");
	printf("             **��ӭ����ɶ���Ϣ���̴�ѧͼ���**\n");
	printf("************************************************************\n");
	printf("                 **���������ݽ���ѡ��**\n");
	printf("************************************************************\n");
	printf("                        1:����Ա\n");
	printf("                        2:����\n");
	printf("                        3:�˳�\n");
	printf("************************************************************\n");
	printf("                        �ҵ�ѡ���ǣ�");
	scanf("%d", &option);
	printf("************************************************************\n");
	


	switch(option)
	{
		case 1:
			system("cls");Body1();break;
		case 2:
			system("cls");Body2();break;
		case 3:
			exit(0);
		default :
			printf("\n\n\t\t�����������󣡣�\n");
			system("PAUSE"); system("cls"); break;

	}
}

int main()
{
	BookNum = 0;
	StudentNum = 0;
	BorrowNum = 0;
	
	Read(book, student, borrow);
	welcome();

	return 0;
}
