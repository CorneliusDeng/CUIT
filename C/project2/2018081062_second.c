#include<stdio.h>
#define STR1 "computer"
#define STR2 "english"

void prog1_1()
{
	int k;
	float x=3.6f;

	printf("[k=x]=%d  [x]=%f  [k]=%d\n",k=x,x,k);
	printf("[k=x]=%d  [x]=%0.1f  [k]=%d\n",k=x,x,k);
}

void prog1_2()
{
	int a;
	short int b;
	long int c;
	unsigned int d;
	float e;
	double f;
	char g;
	
	printf("Var1=%d\n",a=-1);
	printf("Var2=%d\n",b=65535);
	printf("Var3=%d\n",c=98300);
	printf("Var4=%d\n",d=98);
	printf("Var5=%0.7f\n",e=36.5387215);
	printf("Var6=%0.9f\n",f=127.753405213);
	printf("Var7=%c\n",g=65);
}

int prog3_1()
{
	float x=2.5;
	float y=4.7;
	int z=7;
	int a=12;
	
	printf("\n%f\n",x+z%3*(int)(x+y)%2/4);

	printf("\n%d\n",a+=a);
	printf("\n%d\n",a*=2+3);
    printf("\n%d\n",a%=(5%2));
	printf("\n%d\n",a+=a-=a*=a);
}


void FahrToCelsius()
{
	float F,C;
    F=64.0;
	C=(5.0f/9)*(F-32);
	printf("F=%f\nC=%f\n",F,C);
}

int prog6_1()
{
	int a=0x64;
	int*pa;
	char ch='A';
	char*pch=&ch;

	pa=&a;
	printf("整型变量a的值：a=%d\n",a);
	printf("整型变量a的指针：&a=%p\n",&a);
	printf("指针变量pa的值:pa=%p\n",pa);
	printf("指针变量pa的指针:&pa=%p\n",pa);

	printf("字符变量ch的值：ch=%c\n",ch);
	printf("字符变量ch的指针：&ch=%p\n",ch);
	printf("指针变量pch的值：pch=%d\n",pch);
	printf("指针变量pch的指针：&pch=%p\n",pch);
	printf("指针变量pch占内存%d字节\n",sizeof(pch));
}

int prog6_2()
{
	int a=3,b=4,sum=0;
	int *pa,*pb,*psum;
	char ch;
	char *pch=&ch;

	pa=&a;
	pb=&b;
	psum=&sum;
	printf("指针变量的值：pa=%x pb=%x psum=%x\n",pa,pb,psum);
	printf("目标变量的值：a=%d pb=%d sum=%d\n",*pa,*pb,*psum);
	*psum=*pa+*pb;
	*pch='A';
	printf("运算结果：sum=%d\tch=%c",*(&sum),ch);
	printf("整型指针变量的+运算:pa=%x pa+1=%x",pa,pa+1);
	printf("字符型指针变量的+运算:pch=%x pch+1=%x",pch,pch+1);
}

void prog7_1()
{
	char c1,c2,c3;

	printf("Input three characters:\n");
	scanf("%c",&c1);
	scanf("%c",&c2);
	scanf("%c",&c3);
	printf("c1=%c\tASCII=%d\n",c1,c1);
	printf("c2=%c\tASCII=%d\n",c2,c2);
	printf("c3=%c\tASCII=%d\n",c3,c3);
}

void prog7_2()
{
	int iNumA,iNumB;
	printf("Input two integers:\n");
	scanf("%d%d",&iNumA,&iNumB);
	printf("iNumA=%d,iNumB=%d\n",iNumA,iNumB);
}

void prog7_4()
{
	printf("1:  %d\n",1065/(24*13));
	printf("2:  %f\n",23.582/(7.39/3.67));
	printf("--------------------\n");
    printf("1:  %f\n",1065/(24*13));
	printf("2:  %1d\n",23.582/(7.39/3.67));
}

void prog7_5()
{
	int a=5,b=7;
	float x=67.8546f,y=-789.124f;
	long n=1234567;
	unsigned int u=65535;
	printf("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#\n");
	printf("a,b%3d%3d\n",a,b);
	printf("x,y:%f,%f\n",x,y);
	printf("x,y:%-15f,%f\n",x,y);
	printf("x,y:%3f,%f\n",x,y);
	printf("x,y:%e,%e\n",x,y);
	printf("n,n,n:%d,%o,%x\n",n,n,n);
	printf("u,u,u:%d,%o,%x\n",u,u,u);
	printf("STR1,STR2:%s,%3s\n",STR1,STR2);
}

void MathLearn()
{
	int a,b,sum;
	
	printf("\n请输入第一个加数：");
	fflush(stdin);
	scanf("%d",&a);
	printf("\n请输入第二个加数：");
	scanf("%d",&b);
	sum=a+b;
	printf("\n  加数1+加数2=%d\n",sum);
}



int main(void)
{
	prog1_1();
	prog1_2();
	FahrToCelsius();
	prog3_1();
	prog6_1();
	prog6_2();
	prog7_1();
	prog7_2();
	prog7_4();
	prog7_5();
	MathLearn();
	return 0;
}