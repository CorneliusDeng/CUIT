#include <stdio.h>

int CopyTextFile(char *cSourceFile, char *cTargetFile)
{
	FILE  *fp1,*fp2;       //定义文件指针
    char  cString[81];

	if ((fp1=fopen(cSourceFile,"r"))==NULL)
		return 1;
	if ((fp2=fopen(cTargetFile,"w"))==NULL)
	{
		fclose(fp1);
		return 2;
    }
	    
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

int main(int argc,char *argv[])
{
	if (argc!=3)
	{
		printf("\ntpye filename1 filename2");
		return 0;
	}
	CopyTextFile(argv[1],argv[2]);
	return 1;
}
