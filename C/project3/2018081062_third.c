#include<stdio.h>
#include<stdlib.h>
#include<time.h>
double fun(double x);
int RandInt(int max,int min);//��������
int main(void)
{
	double a,b,f1,f2;
	int MyRand,c,d;
	srand(time(0));
	MyRand=rand();
    a=3;
	b=0.8;
	c=RandInt(100,0);
	d=RandInt(100,0);
	f1=fun(a);
	f2=fun(b);

	printf("f1=%f\n",f1);
	printf("f2=%f\n",f2);
	printf("\nMyRand=%d\n",MyRand);
	printf("����һ���������%d\n",RandInt(200,10));
	printf("%d+%d=%d\n",c,d,c+d);

	return 0;
}

double fun(double x)
{
	double y;
	y=x*x+4*x-5;
	return y;
}

int RandInt(int max,int min)
{
	int Number;
	/*srand(time(0));//����������ӣ���ʼ��һ����(��������ֻ��Ҫ��һ��srand(time(0)),�����������ʱ����̣����������������ͬ)*/
    Number=rand()%(max-min+1)+min;
	return Number;
}



	
