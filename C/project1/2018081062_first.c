#include<stdio.h>
void myself()
{
	printf("רҵ���������\n""�༶��2��\n""ѧ�ţ�2018081062\n""����������\n""���ã�����������\n");
    printf("��������һ��ǧ����ָ�����ѣ�����Ϊ����̭ų��\n");
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
