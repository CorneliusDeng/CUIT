#include<math.h>
#include<stdio.h>

int main(void)
{
	int a,b,c;
	float s,area;

	printf("\n����������,���Զ��Ÿ���:");
    scanf("%d,%d,%d",&a,&b,&c);
	s=1.0f/2*(a+b+c);
	area=sqrt(s*(s-a)*(s-b)*(s-c));
	printf("���Ϊ%.2f\n",area);

	return 0;
}

double Area(int a,int b,int c)
{
	double s,area;
	
	s=(double)1.0/2*(a+b+c);
	area=sqrt(s*(s-a)*(s-b)*(s-c));
    return(area);
}