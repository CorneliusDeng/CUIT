#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main()
{
	long num;	    //学号
	char name[10];	//姓名
	char sex[2];	//性别
	char obj[14];	//课程名称
	int score;		//成绩

	int flag = 0;// flag值为0，表示没有找到该行为，为1，表示找到该名字
	static int i = 1;

	char FindName[10]; //该数组用来存放从键盘输入的要查询的名字
	FILE *fp;

	printf("请输入要查找成绩的学生姓名：");
	scanf("%s", FindName);

	printf("\n查找结果为：\n");

	if ((fp = fopen("xscj.txt", "r")) == NULL)
	{
		printf("文件打开失败，请检查文件名及路径是否正确、文件是否存在！");
		exit(0);
	}

	/* 以下五条语句的功能：从文件xscj.txt中读数据 */	
	fscanf(fp,"%d ",&num);
	fscanf(fp,"%s ",name);
	fscanf(fp,"%s ",sex);
	fscanf(fp,"%s ",obj);
	fscanf(fp,"%d",&score);

	while (feof(fp) == 0)//判断文件是否结束,为0表示还没有结束
	{
		if (strcmp(name, FindName) == 0)//比较xscj.txt中的信息与输入的信息是否相同,为0则相同
		{
			printf ("%d %d, %-8s, %s, %-14s, %d\n", i, num, name, sex, obj, score);
			i++;
			flag = 1; //将标志变量的值置为1，说明已经找到要查询的名字
		}
		/*如果读写成功，就再次读数据*/
		fscanf(fp,"%d ",&num);
		fscanf(fp,"%s ",name);
		fscanf(fp,"%s ",sex);
		fscanf(fp,"%s ",obj);
		fscanf(fp,"%d",&score);
	
	}
	if (flag == 0)
	{
		printf("文件中没有找到姓名为“%s”的学生\n", FindName);
	}
	fclose(fp); 

	return 0;

	
}