#include<stdio.h>
void myself()
{
	printf("专业：软件工程\n""班级：2班\n""学号：2018081062\n""姓名：邓棋\n""爱好：乐器、朗诵\n");
    printf("座右铭：一切千夫所指的困难，都是为了淘汰懦夫！\n");
}

int add(int x,int y)
{
	return(x+y);
}
void AddTwo()
{
	int sum;

	sum=add(10,24);
	printf("sum=%d\n",sum);
}

void Avg()
{
	float  a,b,c,aver;

	printf("\nPlease input 3 float:");
	scanf("%f,%f,%f",&a,&b,&c);
	aver=(a+b+c)/3;
	printf("\n  average=%f\n",aver);
}

void DisplayDigit()
{
	int a;

	printf("\nPlease input a number:");
	scanf("%d",&a);
	printf("a=%d\n",a);
}

void Func()
{
	int a,s,c;

	printf("\nPlease input an integer:");
	scanf("%d",&a);
	s=a*a;
	c=4*a;
	printf("\ns=%d\n",s);
	printf("\nc=%d\n",c);
}
int main(void)
{
	myself();
	AddTwo();
	Avg();
	DisplayDigit();
	Func();
	return 0;
}
