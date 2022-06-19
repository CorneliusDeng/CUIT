#include <stdio.h>
#include<stdlib.h>
#include<math.h>
void four_test2_1();
void four_test2_2();
void four_Feb_days();
void four_testTax1();
void four_testTax2();
void four_testTax3();
void four_test5();
void Triangle();
int add();
int minus();
int multiply();
int divide();
void MathLearn();

int eight_Menu()
{
	int iSelect;

	printf("\n***********************\n");
	printf("\n1. 运行函数 four_test2_1");
	printf("\n2. 运行函数 four_test2_2");
	printf("\n3. 运行函数 four_Feb_days");
	printf("\n4. 运行函数 four_Tax1");
	printf("\n5. 运行函数 four_Tax2");
	printf("\n6. 运行函数 four_Tax3");
	printf("\n7. 运行函数 four_test5");
	printf("\n8. 运行函数 Triangle");
	printf("\n9. 运行函数 MathLearn");
	printf("\n0. 退出");
	printf("\n*********************\n");
	printf("\n\n 请输入你的选项:");
	scanf("%d",&iSelect);
	return iSelect;		
}

void four_test2_1()
{
	int iNum1,iNum2,iNum3,iMax;
	srand(time(0));
	iNum1=rand();
	iNum2=rand();
	iNum3=rand();//要确定随机数的范围的话就写成iNum3=rand()%x;
	printf("The three numbers are:%d  %d  %d\n",iNum1,iNum2,iNum3);
	if(iNum1>iNum2)
	{
		if(iNum1>iNum3)iMax=iNum1;
		else iMax=iNum3;
	}
	else
	{
		if(iNum2>iNum3)iMax=iNum2;
		else iMax=iNum3;
	}
	printf("The maximum is %d\n",iMax);
}

void four_test2_2()
{
	int iNum1,iNum2,iNum3,iMax;
	srand(time(0));
	iNum1=rand();
	iNum2=rand();
	iNum3=rand();
	printf("The three numbers are:%d  %d  %d\n",iNum1,iNum2,iNum3);
	iMax=iNum1;  //假定iNum1为最大
	if(iMax>iNum2)
	{
		if(iMax<iNum3) iMax=iNum3;
	}
	else
	{
		iMax=iNum2;
		if(iMax<iNum3) iMax=iNum3;
	}
	printf("The maximum is %d\n",iMax);
}

void four_Feb_days()
{
	int year;

	printf("Please enter a year:");
	scanf("%d",&year);
	if(year%400==0)
	{
		printf("In this year,the February has 29 days\n");
	}
	else
	{
		printf("In this year,the February has 28 days\n");
	}
}


void four_Tax1()
{
	double bonus,tax,profit,rate;

	printf("Please enter your bonus:");
	scanf("%lf",&bonus);

	if(bonus<500)rate=0.00;
	if(bonus>=500 && bonus<1000)rate=0.05;
	if(bonus>=1000 && bonus<2000)rate=0.08;
	if(bonus>=2000 && bonus<5000)rate=0.10;
	if(bonus>=5000)rate=0.15;

	tax=bonus*rate;
	profit=bonus-tax;
	

	printf("bonus=%.2lf\n",bonus);
	printf("rate=%.2lf\n",rate);
	printf("tax=%.2lf\n",tax);
	printf("profit=%.2lf\n",profit);
}

void four_Tax2()
{
	double bonus,tax,profit,rate;

	printf("Please enter your bonus:");
	scanf("%lf",&bonus);

	if(bonus<500)
		rate=0.00;
	else if(bonus<1000)
		rate=0.05;
	else if(bonus<2000)
		rate=0.08;
	else if(bonus<5000)
		rate=0.10;
	else 
		rate=0.15;

	tax=bonus*rate;
	profit=bonus-tax;
	

	printf("bonus=%.2lf\n",bonus);
	printf("rate=%.2lf\n",rate);
	printf("tax=%.2lf\n",tax);
	printf("profit=%.2lf\n",profit);
}

void four_Tax3()
{
	double tax,profit,rate;
	int bonus;
	int a=1;

	printf("Please enter your bonus:");
	scanf("%d",&bonus);

	if(bonus<500)a=1;
	if(bonus>=500 && bonus<1000)a=2;
	if(bonus>=1000 && bonus<2000)a=3;
	if(bonus>=2000 && bonus<5000)a=4;
	if(bonus>=5000)a=5;
	
	switch(a)
		{
		case 1: rate=0.00;break;
		case 2: rate=0.05;break;
		case 3: rate=0.08;break;
		case 4: rate=0.10;break;
		case 5: rate=0.15;break;
		default: printf("\n The select is ERROR\n");
		}

	tax=bonus*rate;
	profit=bonus-tax;
	
	printf("bonus=%.2d\n",bonus);
	printf("rate=%.2lf\n",rate);
	printf("tax=%.2lf\n",tax);
	printf("profit=%.2lf\n",profit);
}

void four_test5()
{
	float x,y,e;
	e=2.7;
	printf("Please enter x= ");
	scanf("%f",&x);

	if(x>0)
	{
		y=pow(e,-x);
		printf("y=%f\n",y);
	}
	else if(x=0)
	{
		printf("y=1\n");
	}
	else
	{
		y=pow(-e,x);
		printf("y=%f\n",y);
	}
}

void Triangle()
{
	int a,b,c;
	printf("please enter number a,b,c, and please make sure a<=b<=c:");
	scanf("%d,%d,%d",&a,&b,&c);

	if(a+b>c && c-b<a)
	{
		if(a==b || b==c || a==c)
		{
			if(a==b && b==c)
			{
				printf("This is a equilateral triangle.\n");
				return 2;
			}
			printf("This is a isosceles triangle.\n");
			return 1;
		}
		
		if(a*a+b*b==c*c)
		{
			printf("This is a right angled triangle.\n");
			return 3;
		}
		else
		{
			printf("This is a common triangle.\n");
			return 4;
		}
	}
	else
	{
		printf("This isn't a triangle.\n");
		return 0;
	}
}

int add()
{
	int a, b, sum, answer;
	a = rand() % 10 + 1;
	b = rand() % 10 + 1;
	printf("%d + %d = ", a, b);
	sum = a + b;
	scanf("%d", &answer);
	if (answer == sum)
		return 1;
	else
		return 0;
}

int minus()
{
	int a, b, result, answer;
	while (1)
	{
		a = rand() % 10 + 1;
		b = rand() % 10 + 1;
		if (a - b >= 0) 
		{
			break;
		}
	}
	result = a - b;
	printf("%d - %d =",a,b);
	scanf("%d", &answer);
	if (answer == result)
		return 1;
	else
		return 0;
}


int multiply()
{
	int a, b, result, answer;
	srand(time(0));
	a = rand() % 10 + 1;
	b = rand() % 10 + 1;
	result = a * b;
	printf("%d x %d =",a,b);
	scanf("%d", &answer);
	if (answer == result)
	{
		return 1;
	}
	else
	{
		return 0;
	}
	
}

int divide()
{
	int a, b, result, answer;
	while (1)
	{
		a = rand() % 10 + 1;
		b = rand() % 10 + 1;
		if (a % b == 0) 
			break;
	}
	result = a / b;
	printf("%d / %d =",a,b);
	scanf("%d", &answer);
	if (answer == result)
		return 1;
	else 
		return 0;
}

void MathLearn()
{
	int type,result;
	srand(time(0));
	type = rand() % 4 + 1;
	switch (type) 
	{
	case 1:result = add(); break;
	case 2:result = minus(); break;
	case 3:result = multiply(); break;
	case 4:result = divide(); break;
	}
	if (result == 1)
	{
		printf("正确\n");
	}
	else 
	{
		printf("错误\n");
	}
}

void main()
{
	int iChoice;

	iChoice=eight_Menu();
	switch(iChoice)
	{
		case 1:four_test2_1();break;
		case 2:four_test2_2();break;
		case 3:four_Feb_days();break;
		case 4:four_Tax1();break;
		case 5:four_Tax2();break;
		case 6:four_Tax3();break;
		case 7:four_test5();break;
		case 8:Triangle();break;
		case 9:MathLearn();break;
		case 0:break;
		default: printf("\n The select is ERROR\n");
	}
}