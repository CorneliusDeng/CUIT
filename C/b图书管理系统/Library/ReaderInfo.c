#include "library.h"

/*********************************************************************************
 Function: ReaderInfo
 Description����ɾ������Ϣ����ѡ��
 Input parameter��option
 Out parameter��NULL
 Relevance��TypeinReaInfor��DeleReaInfor��Body1
 Return: NULL
 Auhtor��Cornelius Deng
 DATE: 2019.6.20
**********************************************************************************/

void ReaderInfo()
{
	int option;

	system("cls");

	printf("��������������������������Ϣ��������������������������\n");
	
	printf("���� 1 ¼�������Ϣ����\n");
	printf("���� 2 ɾ��������Ϣ����\n");
	printf("���� 0 ���ء���\n");
	printf("  ����������ѡ��: ");
	scanf("%d", &option);

	system("cls");

	switch(option)
	{
		case 1:
			system("cls"); TypeinReaInfor(); break;  
		case 2:
			system("cls"); DeleReaInfor(); break; 
		case 0:
			system("cls"); Body1(); break;  //�ص�����Աģʽ
		default :
			printf("\n\n\t\t�������󣡣�\n");
			system("PAUSE"); system("cls"); break;
	}

}
