#include <stdio.h>

//在屏幕上显示文件名为cFileName的文本文件内容
int TypeTextFile(char *cFileName)
{
	FILE  *fp;       //定义文件指针
    char  cOne;

	if ((fp=fopen(cFileName,"r"))==NULL)
		return 0;

	cOne=fgetc(fp);      //读cSourceFile一个字符到cOne
	while(cOne!=EOF) 
	{ 
       putchar(cOne);    //显示源文件内容
       cOne=fgetc(fp); 
	};
	fclose(fp);
	return 1;
}

int main(int argc, char *argv[])
{
	if (argc!=2)
	{
		printf("\nCmd Format:type filename");
		return 0;
	}
	TypeTextFile(argv[1]);
	return 1;
}
