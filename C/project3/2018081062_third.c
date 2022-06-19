#include<stdio.h>
#include<stdlib.h>
#include<time.h>
double fun(double x);
int RandInt(int max,int min);//申明函数
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
	printf("任意一个随机数是%d\n",RandInt(200,10));
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
	/*srand(time(0));//设置随机种子，初始化一个数(整个程序只需要有一个srand(time(0)),有两个，间隔时间过短，生成两个随机数相同)*/
    Number=rand()%(max-min+1)+min;
	return Number;
}



	
