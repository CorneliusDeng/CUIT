#include<stdio.h>

double Fuction(int k);

int main(void)
{
	int n;

	printf("Input n (13>=n>=2): ");
	scanf("%d", &n);

	printf("\nf(%d)=%.0lf\n", n, Fuction(n));

	return 0;
}

double Fuction(int k)
{
	double a[14] = {0, 1, 2};//对这个数组的前三个数进行赋值
	int i;
	
	for (i = 3; i < 14; i++)  //根据公式依次计算数列项f(3)~f(13)的值，并将该值放到相应的数组元素fn[3]~fn[13]中
	{
		a[i] = 2 * a[i-1] + a[i-2] * a[i-3];//运用题设递推公式可依次计算a[3]~a[13]的值
	}

    return a[k];

}