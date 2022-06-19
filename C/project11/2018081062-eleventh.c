#include<stdio.h>
#include<stdlib.h>

/**********************************************************
	�������ܣ���Դ�ļ����������뵽��Ļ�����Ƶ�Ŀ���ļ�
	����������Դ�ļ���Ŀ���ļ��ĵ�ַ
	  ����ֵ��ûɶ�� 
***********************************************************/
int CopyTexFile(char *cSourceFile, char *cTargetFile)
{
	FILE *fp1, *fp2;
	char cFlag, cString[81];

	if((fp1 = fopen(cSourceFile,"r")) == NULL)//��Դ�ļ�
	{
		printf("�޷��򿪴��ļ�\n");
		exit(0);
	}
	if((fp2 = fopen(cTargetFile,"w")) == NULL)   //��Ŀ���ļ�
	{
		printf("�޷��򿪴��ļ�\n");
		exit(0);
	}


	cFlag = fgetc(fp1); //��cSoruceFileһ���ַ���cFlag
	while(feof(fp1) == 0)//�ж��ļ��Ƿ����
	{
		putchar(cFlag);//��ʾԴ�ļ�����
		cFlag = fgetc(fp1); //��cSoruceFileһ���ַ���cFlag
	}

	rewind(fp1);//Դ�ļ���дλ�����¶�λ��ʹ�ļ�λ�ñ�Ƿ����ļ���ͷ��

	while(1)
	{
		if(fgets(cString,81,fp1) == NULL)//��cSourceFileһ���ַ���cString
		break;
		fputs(cString,fp2);//��cSourceFile����д��cTargetFile��
	}
	fclose(fp1);
	fclose(fp2);
	return 0;
}

/************************************************************
	�������ܣ����ն��϶����ʮ�������Զ����Ƶķ�ʽд���ļ���
	�����������������ݵ��ļ�
	  ����ֵ��ûɶ�� 
*************************************************************/
int CreatBinFile(char *cFileName)
{
	FILE *fp;
	int i, iNum;

	if((fp = fopen(cFileName,"wb")) == NULL)//���ļ�
	{
		printf("�޷��򿪴��ļ�\n");
		exit(0);
	}
	
	for(i = 0; i < 10; i++)
	{
		printf("������һ����������\n");
		scanf("%d", &iNum);
		fwrite(&iNum,sizeof(int),1,fp);//��iNumд���ļ���
	}
	fclose(fp);
	return 1;
}

/************************************************************
	�������ܣ������������n���������ı���ʽ���浽�ļ���
	����������cFileNmaeΪ�ļ����ַ�����ָ�룬nΪ�������ݸ���
	  ����ֵ���ɹ�������1�����򣬷���0.
*************************************************************/
int SaveInt(char *cFileName, int n)
{
	FILE *fp;
	int i, iNum;
	
	if((fp = fopen(cFileName,"w+")) == NULL)  
	{
		printf("�޷��򿪴��ļ�\n");
		return 0;
	}

	printf("������%d����������\n",n);
	for (i = 0; i < n; i++)
	{
		scanf("%d",&iNum);
		fprintf(fp,"%d ",iNum);//д���ļ���ʱ��Ҫ��%d���һ���ո񣬲�Ȼ�������������������ݣ�����ʶ��ո�
	}
	fclose(fp);
	return 1;
}

/********************************************************************
	�������ܣ�����һ�������ļ��ж�ȡ���ݣ���������������һ������
	����������cFileNmaeΪ�ļ����ַ�����ָ�룬iMaxΪ���ֵ��ָ��
	  ����ֵ���ɹ�������1�����򣬷���0.
*********************************************************************/
int FindMax(char *cFileName, int *iMax)
{
	FILE *fp;
	int iNum;
	char cSpace;

	if((fp = fopen(cFileName,"r")) == NULL)  
	{
		printf("�޷��򿪴��ļ�\n");
		return 0;
	}

	fscanf(fp,"%d%c",iMax,&cSpace);
	while(feof(fp) == 0)
	{
		fscanf(fp,"%d%c",&iNum,&cSpace);
		if (*iMax<iNum) *iMax=iNum;
	}
	fclose(fp);
	return 1;
}


int main()
{
	char inFile[81], outFile[81], File3[40], File4[40];
	int iMax;
	
	printf("��Դ�ļ����������뵽��Ļ�����Ƶ�Ŀ���ļ�\n");
	printf("������Դ�ļ�·��:");//d:\Csourcecode\project11\File1.txt
	scanf("%s", inFile);
	printf("������Ŀ���ļ�·��:");//d:\Csourcecode\project11\File2.txt
	scanf("%s", outFile);
	CopyTexFile(inFile,outFile);
	
	putchar('\n');
	putchar('\n');

	printf("���ն��϶�ȡʮ�������������뵽Ŀ���ļ�����\n");
	printf("������Ŀ���ļ�·��:");//d:\Csourcecode\project11\File3.dat
	scanf("%s", File3);
	CreatBinFile(File3);
	
	putchar('\n');
	putchar('\n');

	printf("�����������4���������ı���ʽ���浽�ļ���\n");
	printf("������Ŀ���ļ�·��:");//d:\Csourcecode\project11\File4.dat
	scanf("%s", File4);
	SaveInt(File4,4);
	FindMax(File4, &iMax);
	printf("���ֵ��%d\n", iMax);
	putchar('\n');

	return 0;

}