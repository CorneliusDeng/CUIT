#include "library.h"

/*********************************************************************************
 Function: SearchReaInfo
 Description����ѯ������Ϣ����ѡ��
 Input parameter��option
 Out parameter��NULL
 Relevance��SRInum��SRIname��Body1
 Return: NULL
 Auhtor��Cornelius Deng
 DATE: 2019.6.21
**********************************************************************************/

void SearchReaInfo()
{
	while(1)
	{
		int option;

		system("cls");
		printf("--------------��ѯ������Ϣ--------------\n");
		printf("\n\t ��ѡ������");
		printf("\n\t 1.����ѧ�Ų���\n");
		printf("\n\t 2.������������\n");
		printf("\n\t 0.����\n");
		printf("\n����������ѡ��");
		scanf("%1d", &option);

		switch(option)
		{
			case 1:
				system("cls"); SRInum(); break;  //��ѧ�Ų���
			case 2:
				system("cls"); SRIname(); break;  //����������
			case 0:
				system("cls"); Body1(); break;  //�ص�����Աģʽ
			default :
				printf("\n\n\t\t�������󣡣�\n");
				system("PAUSE"); system("cls"); break;
		}	
	}
}