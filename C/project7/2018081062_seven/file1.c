//源文件：file1.c
#include<stdio.h>
int K;
int P = 10;

void fan(int l)
{
	register int m = 0;//定义局部变量m
	static int n = 0;//定义静态局部变量n
	K++;
	m++;
	n++;
	l++;
	P++;
	printf("\n%4d%4d%4d%4d%4d",K,m,n,l,P);//输出各变量的值
}

void seven_prog2()
{
	fan(5);//调用函数fan
	fan(6);
	K = 5;
	fan(3);
}

void main()
{
	void seven_prog3();
	printf("%4c%4c%4c%4c%4c",'k','m','n','l','p');
	seven_prog2();
	printf("\n--------------------");
	seven_prog3();
	printf("\n");
	putchar('\n');
	fac();

	return 0;
}
