#include<stdio.h>
#include<math.h>

void StatisticsNum()
{
	int i,n=0,a[10],sum=0;
	
	printf("请任意输入十个数：");
	for(i=0;i<10;i++)
	{
		scanf("%d",&a[i]);
	}

	for(i=0;i<10;i++)
	{
		if(a[i]>0)
		{
			sum=sum+a[i];
		}
		if(a[i]%2==0)
		{
			n+=1;
		}
	}

	printf("sum=%d\nn=%d\n",sum,n);
}

void StatisticsChar()
{
	char a[100];
	int n=0,x=0,y=0;

	printf("\n请任意输入字符：");
	
	while(n<100)
	{
		scanf("%c",&a[n]);
		if(a[n]=='#') 
		{
			break;
		}
		else x+=1,n++;
	}
	
	for(n=0;n<x;n++)
	{
		if(a[n]>='a' && a[n]<='z')
			y+=1;
	}

	printf("总字符个数为%d\n",x);
	printf("小写字母个数为%d\n",y);
}

void apple()
{
	float appleprice;
	int iNum,iDay;

	for(iNum=2,iDay=1;iNum<=100;iNum=iNum*2-1,iDay++)
	{
		appleprice=iNum*0.8;
		printf("\n 第%d天：%d个苹果，%.2f元\n",iDay,iNum,appleprice);
	}
}

void Count_e()
{

	float e=1;
	float a=0,b=1;//a为前累加项，b为现累加项
	int i=2;//累加项数

	while(fabs(b-a)>=1.0e-5)
	{
		e=e+b;
		a=b;
		b=a/i;
		i++;
	}
	
	printf("\ne值=%f，总累加项数=%d\n",e,i);
}

int SumPolynomial(int n)//定义形参
{
	int i,j,sum;
	sum=0;
	
	for(i=1;i<=n;i++)//控制累加的项数
	{
		for(j=0;j<i;j++)//计算各个累加项的值
		{
			sum+=i*pow(10,j);
		}
	}
	printf("\nsum=%d\n",sum);
	return sum;
}

void TimesTable()
{
	int i,j;
	putchar('\n');
	
	for(i=1;i<=9;i++)
	{
		for(j=1;j<=i;j++)
			printf("%d*%d=%-5d",i,j,i*j);
		putchar('\n');
	}
}

void PerfectNum()
{
	int m,n,i,k,j,count=0,sum=0;

	putchar('\n');
	for(m=2;m<=1000;m++)
	{
		k=m/2,n=0;
		for(j=1;j<=k;j++)
		{
			if(m%j==0)n=n+j;
		}
		if(m==n)
		{
			sum+=m;
			count++;
			printf("完数%d:%d\n",count,m);//确保以完数x+的形式输出
		}
	}
	for(i=1;i<count; i++)//为完数x+形式输出提供循环条件
	{
		printf("完数%d + ", i);
	}
	printf("完数%d = %d\n", i, sum);
}

void GetBall()
{
	int redball,whiteball,blackball;
	int i=0;

	printf("\n口袋中有12个球，其中3个红球，3个白球，6个黑球，从中任取8个球,有以下几种不同取法：\n");
	
	for(blackball=0;blackball<=6;blackball++)
	{
		for(whiteball=0;whiteball<=3;whiteball++)
		{
			redball=8-blackball-whiteball;
			if(redball>=0 && redball<=3)
			{
				printf("取红球%d个,取白球%d个,取黑球%d个\n",redball,whiteball,blackball);
				i++;
			}
		
		}
	}

	printf("\n共有%d种取球方法\n",i);
}



int main()
{
	StatisticsNum();
	StatisticsChar();
	apple();
	Count_e();
	SumPolynomial(5);//确定实参
	TimesTable();
	PerfectNum();
	GetBall();
	return 0;
}