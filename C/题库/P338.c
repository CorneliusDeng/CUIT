#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main()
{
	char num[11];	    //学号
	char name[11];	//姓名
	char sex[3];	//性别
	char obj[20];	//课程名称
	int score;		//成绩
	static int count1 = 0;		//选学人数
	float zongchengji = 0;  //总成绩
	float ave;		//平均成绩

	int flag = 0;// flag值为0，表示没有找到该行为，为1，表示找到该名字

	char FindName[20]; //该数组用来存放从键盘输入的要查询的名字
	FILE *fp;

	printf("请输入要计算及格率的课程名称：");
	scanf("%s", FindName);

	printf("\n计算结果为：\n");

	if ((fp = fopen("xscj.txt", "r")) == NULL)
	{
		printf("文件打开失败，请检查文件名及路径是否正确、文件是否存在！");
		exit(0);
	}

	/* 以下五条语句的功能：从文件xscj.txt中读数据 */	
	fscanf(fp,"%s",num);
	fscanf(fp,"%s",name);
	fscanf(fp,"%s",sex);
	fscanf(fp,"%s",obj);
	fscanf(fp,"%d",&score);

	while (feof(fp) == 0)//判断文件是否结束,为0表示还没有结束
	{
		if (strcmp(obj, FindName) == 0)//比较xscj.txt中的信息与输入的信息是否相同,为0则相同
		{
			count1++;
			zongchengji += score;
			flag = 1; //将标志变量的值置为1，说明已经找到要查询的名字
		}
		/*如果读写成功，就再次读数据*/
		fscanf(fp,"%s",num);
		fscanf(fp,"%s",name);
		fscanf(fp,"%s",sex);
		fscanf(fp,"%s",obj);
		fscanf(fp,"%d",&score);
	}
	

	if (flag == 0)
	{
		printf("文件中没有名称为“%s”的课程\n", FindName);
	}
	else
	{
		ave = zongchengji / count1;
		printf("课程“%s”有 %d 人选学，平均成绩为%.1f\n", FindName, count1, ave);	
	}
	fclose(fp); 

	return 0;
}
