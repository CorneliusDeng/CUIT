#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(void)
{
	
	char paizhao[20]; //牌照
	char riqi[20];    //日期
	char xingwei[20]; //行为
	
	int flag = 0;// flag值为0，表示没有找到该行为，为1，表示找到该行为
	static int i = 1;

	char FindName[20]; //该数组用来存放从键盘输入的要查询的行为
	FILE *fp;

	printf("请输入要查找的违章类型：");
	scanf("%s", FindName); //输入要查询的行为名
	
	printf("\n查找结果为：\n");
	if((fp = fopen("jtwz.txt", "r")) == NULL) //打开文本文件jtwz.txt
	{
		printf("文件打开失败，请检查文件名及路径是否正确、文件是否存在！");
		exit(0);
	}
	
	/* 以下三条语句的功能：从文件jtwz.txt中读数据 	
	fscanf(fp,"%s ",paizhao);
	fscanf(fp,"%s ",riqi);
	fscanf(fp,"%s",xingwei);*/

	while (fscanf(fp, "%s %s %s", paizhao, riqi, xingwei) == 3)//判断文件是否结束,为0表示还没有结束,也可以在括号里面写!feop(fp)
	{
		if (strcmp(xingwei, FindName) == 0)//比较jtwz.txt中的信息与输入的信息是否相同,为0则相同
		{
			printf("%d %s, %s, %s\n", i, paizhao, riqi, xingwei);
			i++;
			flag = 1; //将标志变量的值置为1，说明已经找到要查询的商品
		}
		/*如果读写成功，就再次读写
		fscanf(fp,"%s ",paizhao);
		fscanf(fp,"%s ",riqi);
		fscanf(fp,"%s",xingwei);*/
	
	}
	if (flag == 0)
	{
		printf("文件中没有找到“%s”的记录\n", FindName); 
	}
	fclose(fp); 

	return 0;
}