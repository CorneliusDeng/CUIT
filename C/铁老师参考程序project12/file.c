#include <stdio.h>
#include <conio.h>
#include <string.h>
#include <stdlib.h>

#define N 3
#define ESC   27           //Esc��ֵ

typedef struct 
{
	char name[15];        //�û���
	char password[6];     //�û�����
}USER;


//ʵ��2���ı��ļ�����1�������ļ���
int CreateTextFile(char *cFileName)
{
	FILE *fp;                                     //�����ļ�ָ��
	char  string[16];                       
  
	if ( (fp=fopen(cFileName,"w")) == NULL)      //���ļ� 
	{
		printf("can't open this file");
		return 0;
    }
 
/*	while (strlen(gets(string)) > 0)               
    {
		fputs(string,fp);                        //д�ַ������ļ�
   //     fputs("\n",fp);
    }
*/

// ̽�����뻺���������ã� gets��fgets�Ի��з��Ĳ�ͬ����
	while (fgets(string,16,stdin) != NULL)               
    {
		if (strlen(string)==1) break;
		fputs(string,fp);             //д�ַ������ļ�
        puts(string);
		
    }

    fclose(fp);                        /*�ر��ļ�*/
	return 1;
}

//�ı��ļ�����2���ļ�����
int CopyTextFile(char *cSourceFile, char *cTargetFile)
{
	FILE  *fp1,*fp2;       //�����ļ�ָ��
    char  cOne,cString[81];

	if ((fp1=fopen(cSourceFile,"r"))==NULL)
		return 1;
	if ((fp2=fopen(cTargetFile,"w"))==NULL)
	{
		fclose(fp1);
		return 2;
    }
	cOne=fgetc(fp1);      //��cSourceFileһ���ַ���cOne
	while(cOne!=EOF) 
	{ 
       putchar(cOne);    //��ʾԴ�ļ�����
       cOne=fgetc(fp1); 
	};
    
	fseek(fp1,0L,0);   //Դ�ļ���дλ�����¶�λ rewind(fp1);
    
	while(1)
    {                 
        if (fgets(cString,80,fp1)==NULL) //��cSourceFileһ���ַ���cString
			break;  
		fputs(cString,fp2);     //��cSourceFile����д��cTargetFile��
   
	};

    fclose(fp1);
    fclose(fp2); 
	return 3;
}


//�������ļ��Ķ�д:�����ļ�
int CreateBinFile(char *cFileName)
{ 
	FILE *fp;
	int i,iNum;

	if( (fp=fopen(cFileName,"wb" )) == NULL )
		return 0;
	for(i=0;i<10;i++)
	{
		scanf("%d",&iNum);
		fwrite(&iNum,sizeof(int),1,fp);
	}
	fclose(fp);
    return 1;
} 

 //�Ӽ��������û��������벢�򵥼���
void GetPass(USER *pUserTable, int n)   
{
    int i,j;

	printf("Please input user name and password. Password has 6 char.");
    for (i=0; i<n; i++)
	{
		printf("\nNo.%d:\nname:",i+1);
        scanf("%s",pUserTable[i].name);        //�����û���
		printf("password:");
		for (j=0; j<6; j++)
		{
		 pUserTable[i].password[j] = getch();      //�Ӽ��������û���������Ļ������ 
		 pUserTable[i].password[j] += 10;          //password�򵥼���
		 putchar('*');                             //�����ַ�'*'
		}
    }
}

int SavePass(char *cFileName, USER *pUserTable, int n)
{
	FILE *fpUser;

	fpUser=fopen(cFileName,"wb");
	if (fpUser==NULL) return 0;
	fwrite(pUserTable,sizeof(USER),n,fpUser);
	fclose(fpUser);
	return 1;
}

void CheckPass(char *filename,int n)       //�������ļ������ݽ��ܲ���ʾ
{
	FILE *fp;
    USER temp;
    int i,j;

	fp=fopen(filename,"rb");
	for (i=0; i<n; i++)
	{
		fread(&temp,sizeof(USER),1,fp);  //��һ����¼
		printf("\nNo.%d:\nname:%s\npassword:",i+1,temp.name);   //��ʾ�û���
		for (j=0; j<6; j++) 
		{
			temp.password[j] -= 10;         //password����
		    putchar(temp.password[j]);      //����ַ���ʾ����
		}
	}
	fclose(fp);
	printf("\n");
}

/**********************************************
�������ܣ������������n���������ı���ʽ���浽�ļ��У����ݼ��Կո���
����ԭ�ͣ�int SaveInt (char *cFileName,int n)
����������cFileNameΪ�ļ����ַ�����ָ��
		  nΪ���ݸ���
����ֵ��  �ɹ�������1�����򣬷���0
***********************************************/
int SaveInt (char *cFileName,int n)
{
	FILE *fp;
	int i,iNum;

	fp=fopen(cFileName,"w");
	if (fp==NULL) return 0;
	printf("Input %d integers:\n",n);
	for (i=0; i<n; i++)
	{
		scanf("%d",&iNum);
		fprintf(fp,"%d ",iNum);
	}
	fclose(fp);
	return 1;
}
/****************************************************************
�������ܣ���������ʽ���ļ��ж�ȡ���ݣ���������������һ������
����ԭ�ͣ�int FindMax (char *cFileName,int *iMax);
����������cFileNameΪ�ļ����ַ�����ָ��
          iMaxΪ���ֵ��ָ��
����ֵ��  �ɹ�������1�����򣬷���0
******************************************************************/
int FindMax (char *cFileName,int *iMax)
{
	FILE *fp;
	int iThis;
	char cSpace;

	fp=fopen(cFileName,"r");
    if (fp==NULL) return 0;

	fscanf(fp,"%d%c",iMax,&cSpace);
	while(!feof(fp))
	{
		fscanf(fp,"%d%c",&iThis,&cSpace);
		if (*iMax<iThis) *iMax=iThis;
	}
	fclose(fp);
	return 1;
}

/************************************************************
����CreateMyFile�������ı���Ϣ������ESC�����������浽ָ���ļ���
����ԭ�ͣ�int CreateFile(char *cFileName)
����������cFileNameΪ�ļ�����ָ��
����ֵ���ɹ�������1�����򣬷���0
************************************************************/
long CreateMyFile(char *cFileName)
{
	FILE *fp;
	char cInfo;

	fp=fopen(cFileName,"w");
	if (fp==NULL) return 0;
	printf("\nInput your text:\n");
	cInfo=getche();                    //����getch��getche���ûس������ɽ����ַ�
	while (cInfo!=ESC) {
		if (cInfo==13) printf("\n");
		fputc(cInfo,fp);
	    cInfo=getche();
	}
	fclose(fp);
	return 1;
}

/************************************************************
����GetFileLen������ָ���ı��ļ��ĳ���
����ԭ�ͣ�long GetFileLen(char *cFileName)
����������cFileNameΪ�ļ�����ָ��
����ֵ���ɹ��������ļ����ֽڸ��������򣬷���-1
************************************************************/
long GetFileLen(char *cFileName)
{
	FILE *fp;
	long iLen=0L;

	fp=fopen(cFileName,"r");
	if (fp==NULL) return -1;
	fseek(fp,0,SEEK_END);
	iLen=ftell(fp);
	fclose(fp);
	return iLen;
}

/************************************************************
����ReadFileToBuf����ָ���ı��ļ������ݶ���ָ�����ڴ�����
����ԭ�ͣ�int ReadFileToBuf(char *cFileName,char *cBuff)
����������cFileNameΪ�ļ�����ָ��
          cBuffΪָ�����ڴ������׵�ַ
����ֵ���ɹ��������ַ����������򣬷���-1
************************************************************/
int ReadFileToBuf(char *cFileName,char *cBuff)
{
	FILE *fp;
	char cInfo;
	int i=0;

    fp=fopen(cFileName,"r");
	if (fp==NULL) return -1;
	cInfo=fgetc(fp);
    while (cInfo!=EOF) {
		cBuff[i]=cInfo;
		i++;
        cInfo=fgetc(fp);
	}
	fclose(fp);
	return i;
}

/************************************************************
����SortBuf����ָ�����ڴ�������������
����ԭ�ͣ�void SortBuf(char *cBuff,int n)
����������cBuffΪָ�����ڴ������׵�ַ
          nΪ���ݸ���
����ֵ����
************************************************************/
void SortBuf(char *cBuff,int n)
{
	int i,j,k;
    char cTemp;

	for (i=0; i<n-1; i++)
	{
		k=i;
		for (j=i+1; j<n; j++)
			if (cBuff[k]>cBuff[j]) k=j;
		if(k!=i)
		{
				cTemp=cBuff[i];
				cBuff[i]=cBuff[k];
                cBuff[k]=cTemp;
		}
	}

}

/************************************************************
��������SaveBuf����ָ�����ڴ��������ݱ��浽�ı��ļ���
����ԭ�ͣ�int SaveBuf(char *cFileName,char *cBuff,int n)
����������cFileNameΪ�ļ�����ָ��
          cBuffΪָ�����ڴ������׵�ַ
          nΪ���ݸ���
����ֵ���ɹ�������1�����򣬷���0
************************************************************/
int SaveBuf(char *cFileName,char *cBuff,int n)
{
	FILE *fp;
	int i;

    fp=fopen(cFileName,"w");
	if (fp==NULL) return 0;
    for (i=0; i<n; i++)
		fputc(cBuff[i],fp);
	fclose(fp);
    return 1;
}

/************************************************************
��������ShowBuf����ָ�����ڴ�����������ʾ����Ļ�ϣ�ע�⴦��س���
����ԭ�ͣ�void ShowBuf(char *cBuff,int n)
����������cBuffΪָ�����ڴ������׵�ַ
          nΪ���ݸ���
����ֵ����
************************************************************/
void ShowBuf(char *cBuff,int n)
{  
	int i;

		printf("\nShow buf:\n");
        for (i=0; i<n; i++)
			 if (cBuff[i]==13) printf("\n");     //����
             else  printf("%c",cBuff[i]);
}

void main()
{

    //ʵ��2-1
//	printf("Input strings to create file:\n");
//	CreateTextFile("C:\\temp\\file1.txt");
//	ʵ��2
//	printf("copy file:\n");
//  CopyTextFile("C:\\temp\\file1.txt","C:\\temp\\file2.txt");
//	ʵ��3.1
	printf("Input 10 integers to Create Binary file:\n");
	CreateBinFile("c:\\temp\\binary.dat");
/*  
    //	ʵ��3.2
    USER UserTable[N];
    GetPass(UserTable,N);
	SavePass("c:\\temp\\user.dat",UserTable,N);
	CheckPass("c:\\temp\\user.dat",N);
*/
/*	//	ʵ��4
    int iMax;
	SaveInt("c:\\temp\\mydata.dat",10);
    FindMax("c:\\temp\\mydata.dat",&iMax);
	printf("The max is %d\n",iMax);
*/
    /*	ʵ��5
    char *cBuffer=NULL;
    long iCount1,iCount2;

	CreateMyFile("C:\\temp\\a.dat");
	CreateMyFile("C:\\temp\\b.dat");
    
	fflush(stdout);
	iCount1 = GetFileLen("C:\\temp\\a.dat");
//	printf("\nfile a:%d\n",iCount1);
	iCount2 = GetFileLen("C:\\temp\\b.dat");
//	printf("\nfile b:%d\n",iCount2);
   	cBuffer=(char *)malloc(iCount1+iCount2);

 	if (cBuffer) {
		ReadFileToBuf("C:\\temp\\a.dat",cBuffer);
//		ShowBuf(cBuffer,iCount1);
		ReadFileToBuf("C:\\temp\\b.dat",cBuffer+iCount1);
        
		    
		SortBuf(cBuffer,iCount1+iCount2);
//		ShowBuf(cBuffer,iCount1+iCount2);
        
		SaveBuf("C:\\temp\\c.dat",cBuffer,iCount1+iCount2);
	}

*/
	


}
