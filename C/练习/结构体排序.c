#include<stdio.h>
#define N 80
int main()
{
	struct student
	{
		int studentID;       //ѧ��
		char name[20];         //����
		float score[5];     //5�ſγɼ�
		float average;      //ƽ���ɼ�
	}stu[N];
	struct student temp;//����ṹ�����temp���ڽ���
	int n, i, j;
	printf("��������Ҫ¼����Ϣ��ѧ��������");
	scanf("%d", &n);	
	printf("�������ѧ������Ϣ��ѧ�š����������ſγɼ���\n");
	for(i = 0; i < n; i++)
	{
		scanf("%d%s%f%f%f%f%f", &stu[i].studentID, stu[i].name, &stu[i].score[0], &stu[i].score[1],                
			&stu[i].score[2], &stu[i].score[3], &stu[i].score[4]);					//��������
		stu[i].average = (stu[i].score[0] + stu[i].score[1] + stu[i].score[2] + stu[i].score[3] +stu[i].score[4] ) / 5; //��ƽ���ɼ�
	}

	for(i = 0; i < n - 1; i++)//ƽ���ɼ��Ӹߵ�������
	{
		for(j = 0; j < n - 1 - i; j++)
		{
			if(stu[j].average < stu[j+1].average)
			{
				temp = stu[j];
				stu[j] = stu[j+1];
				stu[j+1] = temp;
			}
		}
	}

	printf("ѧ���ɼ��ɸߵ������У�\n");
	for(i = 0; i < n; i++)
	{
		printf("%d\t%s\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t", stu[i].studentID, stu[i].name, stu[i].score[0], stu[i].score[1],                
			stu[i].score[2], stu[i].score[3], stu[i].score[4]);	
		putchar('\n');
	}

	return 0;
	
}