#include <stdio.h>
#include <stdlib.h>

typedef struct 
{
	int num;
	char name[10];
	char sex[3];
	int year;
	int scoreC;
	int scoreEng;
	int scoreWei;
	float aver;
}STU;

int main (void)
{
	FILE *fp;
	STU stu[50], temp;
	int icount = 0;
	int i, j;
	char ch;


	fp = fopen ("ѧ���ɼ�.txt", "r");
	if (fp == NULL)
	{
		puts("ѧ���ɼ��ļ���ѧ���ɼ�.txt����ʧ�ܣ�����ϸ����ļ����Ƿ���ȷ����Ӧ�ļ��Ƿ���ڣ�");
		exit (0);
	}
	ch = fgetc (fp);
	while (ch != '\n')
	{
		ch = fgetc(fp);
	}
	fscanf (fp, "%d	%s	%s	%d	%d	%d	%d", &stu[icount].num, stu[icount].name, stu[icount].sex, &stu[icount].year, &stu[icount].scoreC, &stu[icount].scoreEng, &stu[icount].scoreWei);
	while (!feof (fp))
	{
		stu[icount].aver = (stu[icount].scoreC + stu[icount].scoreEng + stu[icount].scoreWei) / (float)3;
		icount++;
		fscanf (fp, "%d	%s	%s	%d	%d	%d	%d", &stu[icount].num, stu[icount].name, stu[icount].sex, &stu[icount].year, &stu[icount].scoreC, &stu[icount].scoreEng, &stu[icount].scoreWei);
	}
	for (i = 0; i < icount - 1; i++)
	{
		for (j = 0; j < icount - 1 - i; j++)
		{
			if (stu[j + 1].aver > stu[j].aver)
			{
				temp = stu[j];
				stu[j] = stu[j + 1];
				stu[j + 1] = temp;
			}
		}
	}
	puts("����  ƽ���ɼ�  ѧ��        ����      �Ա�  ������  C����  Ӣ��  ΢����");
	for (i = 0; i < icount; i++)
	{
		printf("%3d   %7.2f   %d  %-8s   %-2s    %d   %3d    %3d   %3d\n", i + 1, stu[i].aver, stu[i].num, stu[i].name, stu[i].sex, stu[i].year, stu[i].scoreC, stu[i].scoreEng, stu[i].scoreWei);
	}
	return 0;
}


