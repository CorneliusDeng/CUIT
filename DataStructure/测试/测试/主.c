#include "��ͷ.h"

int main()
{
	LNode L;
	int n;
	int minK, maxK;
	

	InitList_L(&L);
	printf("[�������ɹ�]\n\n");

	printf("����Ҫ���뼸��˳���������Ϣ?");
	int temp1 = scanf("%d", &n);//VS��scanf����ʾһ������û�з���ֵ��
	putchar('\n');

	for (int i = 1; i <= n; i++)
	{
		ListInsert_L(&L, i, i);
	}

	PrintList_L(&L);
	putchar('\n');

	printf("��������ɾ����������ʲô��");
	int temp2 = scanf("%d%d", &minK, &maxK);

	SelectList_L(&L, minK, maxK);
	PrintList_L(&L);
	putchar('\n');
}

