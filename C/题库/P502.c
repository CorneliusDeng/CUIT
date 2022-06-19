#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	char ch, zxhang, bit[8]; //数组dianzhen用来存放从文件中读取的字形码
	int i, j, k = 128;
	FILE *fp;

	/* 将128，64，32，16，8，4，2，1逐个存放到数组bit中*/
	for (i=0; i<8; i++)
	{
		bit[i] = k;
		k = k / 2;
	
	}
	printf("Please input a char:");
	ch = getchar(); //从键盘输入一个在屏幕上显示的字符
	fp = fopen("ASC12.fon", "rb"); //打开题目给出的字库文件ASC12.fon
	/* 如果文件ASC12.fon打不开，输出错误信息并退出程序 */
	if (fp == NULL)
	{
		printf("cannot open file!");
		exit(0);
	}

	fseek(fp, ch*12, 0); //将文件指针定位到指定字符（变量ch中的字符）的字形码存放的起始位置
	
	/* 在屏幕上显示指定的字形 */
	for (i=0; i<12; i++) //每个i值对应屏幕上的一行
	{
		zxhang = fgetc(fp); //每次从文件中读一行字形码（即一个字节的数据），存放在变量zxhang中
		for (j=0; j<8; j++) //每个j值对应屏幕上的1列
		{
			/* dianzh[i]&bit[j]) != 0表示第i行第j列上的值为1，该位置应该输出指定的字符\；其余四个
			   条件表示是边框位置，边框位置应该输出指定字符\*/
			if (((zxhang & bit[j]) != 0) || (0 == i) || (11 == i) || (0 == j) || (7 == j))
			{
				printf("\\");
			}
			else
			{
				printf(" "); //如果第i行第j列上的值为0，并且该位置不是边框位置，则在该位置上输出空格
			}
		}
		printf("\n"); //输出完一行后换行
	}

	return 0;
}