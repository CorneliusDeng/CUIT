#include <stdio.h>

//����Ļ����ʾ�ļ���ΪcFileName���ı��ļ�����
int TypeTextFile(char *cFileName)
{
	FILE  *fp;       //�����ļ�ָ��
    char  cOne;

	if ((fp=fopen(cFileName,"r"))==NULL)
		return 0;

	cOne=fgetc(fp);      //��cSourceFileһ���ַ���cOne
	while(cOne!=EOF) 
	{ 
       putchar(cOne);    //��ʾԴ�ļ�����
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
