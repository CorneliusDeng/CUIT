#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(void)
{
	
	char paizhao[20]; //����
	char riqi[20];    //����
	char xingwei[20]; //��Ϊ
	
	int flag = 0;// flagֵΪ0����ʾû���ҵ�����Ϊ��Ϊ1����ʾ�ҵ�����Ϊ
	static int i = 1;

	char FindName[20]; //������������ŴӼ��������Ҫ��ѯ����Ϊ
	FILE *fp;

	printf("������Ҫ���ҵ�Υ�����ͣ�");
	scanf("%s", FindName); //����Ҫ��ѯ����Ϊ��
	
	printf("\n���ҽ��Ϊ��\n");
	if((fp = fopen("jtwz.txt", "r")) == NULL) //���ı��ļ�jtwz.txt
	{
		printf("�ļ���ʧ�ܣ������ļ�����·���Ƿ���ȷ���ļ��Ƿ���ڣ�");
		exit(0);
	}
	
	/* �����������Ĺ��ܣ����ļ�jtwz.txt�ж����� 	
	fscanf(fp,"%s ",paizhao);
	fscanf(fp,"%s ",riqi);
	fscanf(fp,"%s",xingwei);*/

	while (fscanf(fp, "%s %s %s", paizhao, riqi, xingwei) == 3)//�ж��ļ��Ƿ����,Ϊ0��ʾ��û�н���,Ҳ��������������д!feop(fp)
	{
		if (strcmp(xingwei, FindName) == 0)//�Ƚ�jtwz.txt�е���Ϣ���������Ϣ�Ƿ���ͬ,Ϊ0����ͬ
		{
			printf("%d %s, %s, %s\n", i, paizhao, riqi, xingwei);
			i++;
			flag = 1; //����־������ֵ��Ϊ1��˵���Ѿ��ҵ�Ҫ��ѯ����Ʒ
		}
		/*�����д�ɹ������ٴζ�д
		fscanf(fp,"%s ",paizhao);
		fscanf(fp,"%s ",riqi);
		fscanf(fp,"%s",xingwei);*/
	
	}
	if (flag == 0)
	{
		printf("�ļ���û���ҵ���%s���ļ�¼\n", FindName); 
	}
	fclose(fp); 

	return 0;
}