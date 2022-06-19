#include<stdio.h>
#include<stdlib.h>

/**********************************************************
	函数功能：将源文件的内容输入到屏幕并复制到目标文件
	函数参数：源文件和目标文件的地址
	  返回值：没啥用 
***********************************************************/
int CopyTexFile(char *cSourceFile, char *cTargetFile)
{
	FILE *fp1, *fp2;
	char cFlag, cString[81];

	if((fp1 = fopen(cSourceFile,"r")) == NULL)//打开源文件
	{
		printf("无法打开此文件\n");
		exit(0);
	}
	if((fp2 = fopen(cTargetFile,"w")) == NULL)   //打开目标文件
	{
		printf("无法打开此文件\n");
		exit(0);
	}


	cFlag = fgetc(fp1); //读cSoruceFile一个字符到cFlag
	while(feof(fp1) == 0)//判断文件是否结束
	{
		putchar(cFlag);//显示源文件内容
		cFlag = fgetc(fp1); //读cSoruceFile一个字符到cFlag
	}

	rewind(fp1);//源文件读写位置重新定位（使文件位置标记返回文件开头）

	while(1)
	{
		if(fgets(cString,81,fp1) == NULL)//读cSourceFile一行字符到cString
		break;
		fputs(cString,fp2);//将cSourceFile内容写到cTargetFile中
	}
	fclose(fp1);
	fclose(fp2);
	return 0;
}

/************************************************************
	函数功能：从终端上读入的十个整数以二进制的方式写入文件中
	函数参数：保存数据的文件
	  返回值：没啥用 
*************************************************************/
int CreatBinFile(char *cFileName)
{
	FILE *fp;
	int i, iNum;

	if((fp = fopen(cFileName,"wb")) == NULL)//打开文件
	{
		printf("无法打开此文件\n");
		exit(0);
	}
	
	for(i = 0; i < 10; i++)
	{
		printf("请输入一个整形数据\n");
		scanf("%d", &iNum);
		fwrite(&iNum,sizeof(int),1,fp);//将iNum写到文件中
	}
	fclose(fp);
	return 1;
}

/************************************************************
	函数功能：将键盘输入的n个整数以文本形式保存到文件中
	函数参数：cFileNmae为文件名字符串的指针，n为输入数据个数
	  返回值：成功，返回1；否则，返回0.
*************************************************************/
int SaveInt(char *cFileName, int n)
{
	FILE *fp;
	int i, iNum;
	
	if((fp = fopen(cFileName,"w+")) == NULL)  
	{
		printf("无法打开此文件\n");
		return 0;
	}

	printf("请输入%d个整型数据\n",n);
	for (i = 0; i < n; i++)
	{
		scanf("%d",&iNum);
		fprintf(fp,"%d ",iNum);//写入文件的时候要在%d后打一个空格，不然会输出我输入的所有数据，不会识别空格
	}
	fclose(fp);
	return 1;
}

/********************************************************************
	函数功能：从上一个函数文件中读取数据，并返回其中最大的一个数据
	函数参数：cFileNmae为文件名字符串的指针，iMax为最大值的指针
	  返回值：成功，返回1；否则，返回0.
*********************************************************************/
int FindMax(char *cFileName, int *iMax)
{
	FILE *fp;
	int iNum;
	char cSpace;

	if((fp = fopen(cFileName,"r")) == NULL)  
	{
		printf("无法打开此文件\n");
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
	
	printf("将源文件的内容输入到屏幕并复制到目标文件\n");
	printf("请输入源文件路径:");//d:\Csourcecode\project11\File1.txt
	scanf("%s", inFile);
	printf("请输入目标文件路径:");//d:\Csourcecode\project11\File2.txt
	scanf("%s", outFile);
	CopyTexFile(inFile,outFile);
	
	putchar('\n');
	putchar('\n');

	printf("从终端上读取十个整形数据输入到目标文件当中\n");
	printf("请输入目标文件路径:");//d:\Csourcecode\project11\File3.dat
	scanf("%s", File3);
	CreatBinFile(File3);
	
	putchar('\n');
	putchar('\n');

	printf("将键盘输入的4个整数以文本形式保存到文件中\n");
	printf("请输入目标文件路径:");//d:\Csourcecode\project11\File4.dat
	scanf("%s", File4);
	SaveInt(File4,4);
	FindMax(File4, &iMax);
	printf("最大值是%d\n", iMax);
	putchar('\n');

	return 0;

}