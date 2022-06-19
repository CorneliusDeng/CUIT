#include<stdio.h>
int Add(int a,int b)
{
	return(a+b);
}
int main()
{
	int a=7,b=9,sum=0;
	sum=Add(a,b);
	printf("sum=%d\n",sum);
	return 0;
}
