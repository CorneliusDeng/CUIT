#include<stdio.h>
#include<math.h>

void StatisticsNum()
{
	int i,n=0,a[10],sum=0;
	
	printf("����������ʮ������");
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

	printf("\n�����������ַ���");
	
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

	printf("���ַ�����Ϊ%d\n",x);
	printf("Сд��ĸ����Ϊ%d\n",y);
}

void apple()
{
	float appleprice;
	int iNum,iDay;

	for(iNum=2,iDay=1;iNum<=100;iNum=iNum*2-1,iDay++)
	{
		appleprice=iNum*0.8;
		printf("\n ��%d�죺%d��ƻ����%.2fԪ\n",iDay,iNum,appleprice);
	}
}

void Count_e()
{

	float e=1;
	float a=0,b=1;//aΪǰ�ۼ��bΪ���ۼ���
	int i=2;//�ۼ�����

	while(fabs(b-a)>=1.0e-5)
	{
		e=e+b;
		a=b;
		b=a/i;
		i++;
	}
	
	printf("\neֵ=%f�����ۼ�����=%d\n",e,i);
}

int SumPolynomial(int n)//�����β�
{
	int i,j,sum;
	sum=0;
	
	for(i=1;i<=n;i++)//�����ۼӵ�����
	{
		for(j=0;j<i;j++)//��������ۼ����ֵ
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
			printf("����%d:%d\n",count,m);//ȷ��������x+����ʽ���
		}
	}
	for(i=1;i<count; i++)//Ϊ����x+��ʽ����ṩѭ������
	{
		printf("����%d + ", i);
	}
	printf("����%d = %d\n", i, sum);
}

void GetBall()
{
	int redball,whiteball,blackball;
	int i=0;

	printf("\n�ڴ�����12��������3������3������6�����򣬴�����ȡ8����,�����¼��ֲ�ͬȡ����\n");
	
	for(blackball=0;blackball<=6;blackball++)
	{
		for(whiteball=0;whiteball<=3;whiteball++)
		{
			redball=8-blackball-whiteball;
			if(redball>=0 && redball<=3)
			{
				printf("ȡ����%d��,ȡ����%d��,ȡ����%d��\n",redball,whiteball,blackball);
				i++;
			}
		
		}
	}

	printf("\n����%d��ȡ�򷽷�\n",i);
}



int main()
{
	StatisticsNum();
	StatisticsChar();
	apple();
	Count_e();
	SumPolynomial(5);//ȷ��ʵ��
	TimesTable();
	PerfectNum();
	GetBall();
	return 0;
}