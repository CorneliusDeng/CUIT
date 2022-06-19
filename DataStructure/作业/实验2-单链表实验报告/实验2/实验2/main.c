#include "List.h"

int main()
{
	LNode L;//��LinkList����һ��Ұָ�룬����ȡ
	/*e���ר����Ϣ, e1��Ų����ר����Ϣ��e2���ɾ������ȡ����ר����Ϣ��
	e3���ֱ��ȡ������ר����Ϣ��e4��ʾҪ����ǰ����Ϣ��Ԫ�أ�pre_e������ҵ�ǰ��Ԫ��*/
	ET e, e1, e2, e3, e4, pre_e;
	//n��ʾ��һ������ר����Ϣ������length��������ȣ�n1��n2�ֱ�ΪLa��Lb����
	int n, length, n1, n2;
	//index1��ʾҪ����ר����Ϣ��λ��,index2��ʾҪɾ��ר����Ϣ��λ��,index3��ʾֱ��ȡ��ר����Ϣ��λ��
	int index1, index2, index3;

	/*����һ����ͷ���Ŀյ�����L,�������в���ר����Ϣ����ʾ������*/
	InitList_L(&L);
	printf("[�������ɹ�]\n\n");
	printf("�������뼸��ר����Ϣ��\t");
	int temp1 = scanf("%d", &n);//VS��scanf����ʾһ������û�з���ֵ��
	putchar('\n');
	for (int i = 1; i <= n; i++)
	{
		printf("������ר����Ϣ(ר�Һ����������ÿո�������س�������)\n");
		int temp2 = scanf("%d", &e.num);
		char ch = getchar();//������������֮��Ŀո�
		gets(e.name);
		ListInsert_L(&L, i, e);
	}
	putchar('\n');
	printf("[ר����Ϣ����]\n");
	printf("ר�Һ�\t����\n");
	PrintList_L(&L);
	putchar('\n');
	length = ListLength_L(&L);//������ĳ���
	printf("��ʱ��������Ϊ%d\n", length);

	/*������ָ��λ�ò���ר����Ϣ���������ʾ����*/
	putchar('\n');
	printf("�����������ĸ�λ�ò���ר����Ϣ��\t");
	int temp3 = scanf("%d", &index1);
	putchar('\n');
	printf("������ר����Ϣ(ר�Һ����������ÿո�������س�������)\n");
	int temp4 = scanf("%d", &e1.num);
	char ch1 = getchar();//������������֮��Ŀո�
	gets(e1.name);
	ListInsert_L(&L, index1, e1);
	putchar('\n');
	printf("[ר����Ϣ����]\n");
	printf("ר�Һ�\t����\n");
	PrintList_L(&L);
	putchar('\n');
	length = ListLength_L(&L);//������ĳ���
	printf("��ʱ��������Ϊ%d\n", length);


	/*������ָ��λ��ɾ��ר����Ϣ���������ʾ����*/
	putchar('\n');
	printf("�����������ĸ�λ��ɾ��ר����Ϣ��\t");
	int temp5 = scanf("%d", &index2);
	putchar('\n');
	ListDelete_L(&L, index2, &e2);
	putchar('\n');
	printf("[ר����Ϣ����]\n");
	printf("ר�Һ�\t����\n");
	PrintList_L(&L);
	putchar('\n');
	length = ListLength_L(&L);//������ĳ���
	printf("��ʱ��������Ϊ%d\n", length);
	printf("��ɾ����ר����Ϣ��;%d\t%s\n", e2.num, e2.name);


	/*ȡ��L�еĵ�i�����ֵ��ֵ������e*/
	putchar('\n');
	printf("���ڿ���ֱ��ȡ��ĳһλר�ҵ���Ϣ����������λ����Ϣ\t");
	int temp6 = scanf("%d", &index3);
	putchar('\n');
	GetElem_L(&L, index3, &e3);
	printf("ȡ����Ϣ�����������\n");
	printf("%d\t%s\n\n", e3.num, e3.name);

	/*��ǰ��*/
	printf("����������ҵ�ĳר����Ϣ�ı����ʲô�������ǰ��Ԫ��\t");
	int temp7 = scanf("%d", &e4.num);
	PriorElem_L(&L, e4, &pre_e);
	printf("ȡ��Ԫ�ص�ǰ����ϢΪ��\n");
	printf("%d\t%s\n", pre_e.num, pre_e.name); 


	/*˼�������*/
	putchar('\n');
	printf("*******************************˼�������*******************************\n");
	LNode La, Lb, Lc;
	InitList_L(&Lc);
	printf("��������Ҫ�����ĵ�����La��Lb���ȣ��м��ÿո������\t");
	int temp8 = scanf("%d%d", &n1, &n2);
	putchar('\n');
	printf("������La��Ԫ��\n");
	INLIST(&La, n1);
	putchar('\n');
	printf("������Lb��Ԫ��\n");
	INLIST(&Lb, n2);
	
	/*��La��Lb�ϲ���һ����������Lc*/
	putchar('\n');
	MerList(&La, &Lb, &Lc);
	printf("�ϲ����������������;\n");
	PrintList_L(&Lc);
	putchar('\n');


	FreeL(&Lb);//�ͷŵ�Lb��Lc��������Ӱ���ֲ���
	FreeL(&Lc);
	/*La��ֳ�ͬ���ṹ�ĵ�����Lb��Lc��Lb��ȫΪLa��������㣬LcΪΪż�����*/
	putchar('\n');
	PartList(&La, &Lb, &Lc);
	printf("��Ҫ��ֵĵ�����La����;\n");
	PrintList_L(&La);
	putchar('\n');
	printf("���֮��La�������������;\n");
	PrintList_L(&Lb);
	putchar('\n');
	printf("���֮��La��ż���������;\n");
	PrintList_L(&Lc);

	/*��La����*/
	putchar('\n');
	Reverse(&La);
	printf("��La���ú�Ľ������\n");
	PrintList_L(&La);
	putchar('\n');

	





	/*�ο�������Ϣ
	6745 ����
	5321 Ǭ¡
	8091 ����
	1344 �Կ�ط
	7809 ����
	1356 ������
	8012 ����
	5478 ��¡��
	4238 ����
	4213 ���
	1089 ��Ԫ�
	9908 ���
	9816 Ӻ��
	0812 ����
	1287 ������
	*/
}