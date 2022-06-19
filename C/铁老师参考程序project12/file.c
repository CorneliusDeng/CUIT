#include <stdio.h>
#include <conio.h>
#include <string.h>
#include <stdlib.h>

#define N 3
#define ESC   27           //Esc键值

typedef struct 
{
	char name[15];        //用户名
	char password[6];     //用户密码
}USER;


//实验2：文本文件操作1（创建文件）
int CreateTextFile(char *cFileName)
{
	FILE *fp;                                     //定义文件指针
	char  string[16];                       
  
	if ( (fp=fopen(cFileName,"w")) == NULL)      //打开文件 
	{
		printf("can't open this file");
		return 0;
    }
 
/*	while (strlen(gets(string)) > 0)               
    {
		fputs(string,fp);                        //写字符串到文件
   //     fputs("\n",fp);
    }
*/

// 探究输入缓冲区的作用， gets和fgets对换行符的不同处理
	while (fgets(string,16,stdin) != NULL)               
    {
		if (strlen(string)==1) break;
		fputs(string,fp);             //写字符串到文件
        puts(string);
		
    }

    fclose(fp);                        /*关闭文件*/
	return 1;
}

//文本文件操作2：文件复制
int CopyTextFile(char *cSourceFile, char *cTargetFile)
{
	FILE  *fp1,*fp2;       //定义文件指针
    char  cOne,cString[81];

	if ((fp1=fopen(cSourceFile,"r"))==NULL)
		return 1;
	if ((fp2=fopen(cTargetFile,"w"))==NULL)
	{
		fclose(fp1);
		return 2;
    }
	cOne=fgetc(fp1);      //读cSourceFile一个字符到cOne
	while(cOne!=EOF) 
	{ 
       putchar(cOne);    //显示源文件内容
       cOne=fgetc(fp1); 
	};
    
	fseek(fp1,0L,0);   //源文件读写位置重新定位 rewind(fp1);
    
	while(1)
    {                 
        if (fgets(cString,80,fp1)==NULL) //读cSourceFile一行字符到cString
			break;  
		fputs(cString,fp2);     //将cSourceFile内容写到cTargetFile中
   
	};

    fclose(fp1);
    fclose(fp2); 
	return 3;
}


//二进制文件的读写:创建文件
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

 //从键盘输入用户名、密码并简单加密
void GetPass(USER *pUserTable, int n)   
{
    int i,j;

	printf("Please input user name and password. Password has 6 char.");
    for (i=0; i<n; i++)
	{
		printf("\nNo.%d:\nname:",i+1);
        scanf("%s",pUserTable[i].name);        //输入用户名
		printf("password:");
		for (j=0; j<6; j++)
		{
		 pUserTable[i].password[j] = getch();      //从键盘输入用户密码且屏幕不回显 
		 pUserTable[i].password[j] += 10;          //password简单加密
		 putchar('*');                             //回显字符'*'
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

void CheckPass(char *filename,int n)       //将给定文件的内容解密并显示
{
	FILE *fp;
    USER temp;
    int i,j;

	fp=fopen(filename,"rb");
	for (i=0; i<n; i++)
	{
		fread(&temp,sizeof(USER),1,fp);  //读一个记录
		printf("\nNo.%d:\nname:%s\npassword:",i+1,temp.name);   //显示用户名
		for (j=0; j<6; j++) 
		{
			temp.password[j] -= 10;         //password解密
		    putchar(temp.password[j]);      //逐个字符显示密码
		}
	}
	fclose(fp);
	printf("\n");
}

/**********************************************
函数功能：将键盘输入的n个整数以文本形式保存到文件中，数据间以空格间隔
函数原型：int SaveInt (char *cFileName,int n)
函数参数：cFileName为文件名字符串的指针
		  n为数据个数
返回值：  成功，返回1；否则，返回0
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
函数功能：从上述格式的文件中读取数据，并返回其中最大的一个数据
函数原型：int FindMax (char *cFileName,int *iMax);
函数参数：cFileName为文件名字符串的指针
          iMax为最大值的指针
返回值：  成功，返回1；否则，返回0
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
函数CreateMyFile，输入文本信息（输入ESC结束）并保存到指定文件中
函数原型：int CreateFile(char *cFileName)
函数参数：cFileName为文件名的指针
返回值：成功，返回1；否则，返回0
************************************************************/
long CreateMyFile(char *cFileName)
{
	FILE *fp;
	char cInfo;

	fp=fopen(cFileName,"w");
	if (fp==NULL) return 0;
	printf("\nInput your text:\n");
	cInfo=getche();                    //函数getch、getche不用回车，即可接收字符
	while (cInfo!=ESC) {
		if (cInfo==13) printf("\n");
		fputc(cInfo,fp);
	    cInfo=getche();
	}
	fclose(fp);
	return 1;
}

/************************************************************
函数GetFileLen，计算指定文本文件的长度
函数原型：long GetFileLen(char *cFileName)
函数参数：cFileName为文件名的指针
返回值：成功，返回文件的字节个数；否则，返回-1
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
函数ReadFileToBuf，将指定文本文件的内容读到指定的内存区域
函数原型：int ReadFileToBuf(char *cFileName,char *cBuff)
函数参数：cFileName为文件名的指针
          cBuff为指定的内存区域首地址
返回值：成功，返回字符个数；否则，返回-1
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
函数SortBuf，将指定的内存区域数据排序
函数原型：void SortBuf(char *cBuff,int n)
函数参数：cBuff为指定的内存区域首地址
          n为数据个数
返回值：无
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
函数函数SaveBuf，将指定的内存区域数据保存到文本文件中
函数原型：int SaveBuf(char *cFileName,char *cBuff,int n)
函数参数：cFileName为文件名的指针
          cBuff为指定的内存区域首地址
          n为数据个数
返回值：成功，返回1；否则，返回0
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
函数函数ShowBuf，将指定的内存区域数据显示在屏幕上，注意处理回车符
函数原型：void ShowBuf(char *cBuff,int n)
函数参数：cBuff为指定的内存区域首地址
          n为数据个数
返回值：无
************************************************************/
void ShowBuf(char *cBuff,int n)
{  
	int i;

		printf("\nShow buf:\n");
        for (i=0; i<n; i++)
			 if (cBuff[i]==13) printf("\n");     //换行
             else  printf("%c",cBuff[i]);
}

void main()
{

    //实验2-1
//	printf("Input strings to create file:\n");
//	CreateTextFile("C:\\temp\\file1.txt");
//	实验2
//	printf("copy file:\n");
//  CopyTextFile("C:\\temp\\file1.txt","C:\\temp\\file2.txt");
//	实验3.1
	printf("Input 10 integers to Create Binary file:\n");
	CreateBinFile("c:\\temp\\binary.dat");
/*  
    //	实验3.2
    USER UserTable[N];
    GetPass(UserTable,N);
	SavePass("c:\\temp\\user.dat",UserTable,N);
	CheckPass("c:\\temp\\user.dat",N);
*/
/*	//	实验4
    int iMax;
	SaveInt("c:\\temp\\mydata.dat",10);
    FindMax("c:\\temp\\mydata.dat",&iMax);
	printf("The max is %d\n",iMax);
*/
    /*	实验5
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
