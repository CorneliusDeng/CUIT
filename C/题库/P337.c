#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main()
{
	long num;	    //ѧ��
	char name[10];	//����
	char sex[2];	//�Ա�
	char obj[14];	//�γ�����
	int score;		//�ɼ�

	int flag = 0;// flagֵΪ0����ʾû���ҵ�����Ϊ��Ϊ1����ʾ�ҵ�������
	static int i = 1;

	char FindName[10]; //������������ŴӼ��������Ҫ��ѯ������
	FILE *fp;

	printf("������Ҫ���ҳɼ���ѧ��������");
	scanf("%s", FindName);

	printf("\n���ҽ��Ϊ��\n");

	if ((fp = fopen("xscj.txt", "r")) == NULL)
	{
		printf("�ļ���ʧ�ܣ������ļ�����·���Ƿ���ȷ���ļ��Ƿ���ڣ�");
		exit(0);
	}

	/* �����������Ĺ��ܣ����ļ�xscj.txt�ж����� */	
	fscanf(fp,"%d ",&num);
	fscanf(fp,"%s ",name);
	fscanf(fp,"%s ",sex);
	fscanf(fp,"%s ",obj);
	fscanf(fp,"%d",&score);

	while (feof(fp) == 0)//�ж��ļ��Ƿ����,Ϊ0��ʾ��û�н���
	{
		if (strcmp(name, FindName) == 0)//�Ƚ�xscj.txt�е���Ϣ���������Ϣ�Ƿ���ͬ,Ϊ0����ͬ
		{
			printf ("%d %d, %-8s, %s, %-14s, %d\n", i, num, name, sex, obj, score);
			i++;
			flag = 1; //����־������ֵ��Ϊ1��˵���Ѿ��ҵ�Ҫ��ѯ������
		}
		/*�����д�ɹ������ٴζ�����*/
		fscanf(fp,"%d ",&num);
		fscanf(fp,"%s ",name);
		fscanf(fp,"%s ",sex);
		fscanf(fp,"%s ",obj);
		fscanf(fp,"%d",&score);
	
	}
	if (flag == 0)
	{
		printf("�ļ���û���ҵ�����Ϊ��%s����ѧ��\n", FindName);
	}
	fclose(fp); 

	return 0;

	
}