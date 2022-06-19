#include <stdio.h>
#include <stdlib.h>

#define LEN sizeof(struct student)

typedef struct student
{
	long num;
	float score;
	struct student *next;
}STU;

int n;//ȫ�ֱ�����һ����־���жϵ��׵����ĸ����

STU *creat(void)
{
	STU *head, *p1, *p2;

	n = 0;

	p1 = p2 = (STU *)malloc(LEN);//����һ���µ�Ԫ��ʹ��ʱ��p1��p2��ָ��������
	printf("������һλͬѧ��ѧ�š��ɼ����м��ÿո�����������������������0 0\n");
	scanf("%ld%f", &p1->num, &p1->score);
	head = NULL;

	while(p1->num != 0)//�����ж�������ʹ�����ѧ�Ŷ���Ϊ0
	{
		n++;//������1��ʹ������������Ȼ������ƥ��
		if (n == 1) head = p1;//����ǵ�һ����㣬ʹheadҲָ���¿��ٵĽ��
		else p2->next = p1;//����ͽ��½ṹ��ĵ�ַ����p2��һ�����ӵĹ���

		p2 = p1;//ʹp2����p1��λ�ã�һ���ƶ�����
		p1 = (STU*)malloc(LEN); //�����µĶ�̬������
		printf("������һλͬѧ��ѧ�š��ɼ����м��ÿո�����������������������0 0\n");
		scanf("%ld%f", &p1->num, &p1->score);
	}

	p2->next = NULL;//��������ѧ�Ŷ�Ϊ0�ˣ�ֱ�ӽ�p2�ĵ�ַ��ΪNULL

	return head;//�������������һ�����ĵ�ַ
}

int main()
{
	STU *pt;
	pt = creat(); 
	printf("����Ľ��Ϊ��\n");
	do
	{
		printf("num:%ld  score:%5.1f\n", pt->num, pt->score);
		pt = pt->next;//ʹ��ָ����һ����㣬ʹ�������
	}while(pt != NULL);
	
	return 0;
}
