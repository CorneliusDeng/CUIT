#include <stdio.h>

typedef struct student
{
	int num;
	float score;
	struct student *next;
}STU;

int main()
{
	STU a, b, c, *head, *p;
	
	/*��ֵģ��*/
	a.num = 10101;
	a.score = 89.5;
	b.num = 10102;
	b.score = 90;
	c.num = 10103;
	c.score = 85;

	/*��������ģ��*/
	head = &a;//�����a����ʼ��ַ����ͷָ��head
	a.next  = &b;//�����b����ʼ��ַ����a����next��Ա
	b.next = &c;//�����c����ʼ��ַ����b����next��Ա
	c.next = NULL;//c����next��Ա�������������ַ
	p = head;//ʹpָ��a���

	do
	{
		printf("%ld %5.1f\n", p->num, p->score);//���pָ��Ľ�������
		p = p->next;//ʹpָ����һ���
	}while(p != NULL);//�����c����p��ֵΪNULL��ѭ����ֹ

	return 0;
}