#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main()
{
	char num[11];	    //ѧ��
	char name[11];	//����
	char sex[3];	//�Ա�
	char obj[20];	//�γ�����
	int score;		//�ɼ�
	static int count1 = 0;		//ѡѧ����
	float zongchengji = 0;  //�ܳɼ�
	float ave;		//ƽ���ɼ�

	int flag = 0;// flagֵΪ0����ʾû���ҵ�����Ϊ��Ϊ1����ʾ�ҵ�������

	char FindName[20]; //������������ŴӼ��������Ҫ��ѯ������
	FILE *fp;

	printf("������Ҫ���㼰���ʵĿγ����ƣ�");
	scanf("%s", FindName);

	printf("\n������Ϊ��\n");

	if ((fp = fopen("xscj.txt", "r")) == NULL)
	{
		printf("�ļ���ʧ�ܣ������ļ�����·���Ƿ���ȷ���ļ��Ƿ���ڣ�");
		exit(0);
	}

	/* �����������Ĺ��ܣ����ļ�xscj.txt�ж����� */	
	fscanf(fp,"%s",num);
	fscanf(fp,"%s",name);
	fscanf(fp,"%s",sex);
	fscanf(fp,"%s",obj);
	fscanf(fp,"%d",&score);

	while (feof(fp) == 0)//�ж��ļ��Ƿ����,Ϊ0��ʾ��û�н���
	{
		if (strcmp(obj, FindName) == 0)//�Ƚ�xscj.txt�е���Ϣ���������Ϣ�Ƿ���ͬ,Ϊ0����ͬ
		{
			count1++;
			zongchengji += score;
			flag = 1; //����־������ֵ��Ϊ1��˵���Ѿ��ҵ�Ҫ��ѯ������
		}
		/*�����д�ɹ������ٴζ�����*/
		fscanf(fp,"%s",num);
		fscanf(fp,"%s",name);
		fscanf(fp,"%s",sex);
		fscanf(fp,"%s",obj);
		fscanf(fp,"%d",&score);
	}
	

	if (flag == 0)
	{
		printf("�ļ���û������Ϊ��%s���Ŀγ�\n", FindName);
	}
	else
	{
		ave = zongchengji / count1;
		printf("�γ̡�%s���� %d ��ѡѧ��ƽ���ɼ�Ϊ%.1f\n", FindName, count1, ave);	
	}
	fclose(fp); 

	return 0;
}
