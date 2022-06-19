#include<stdio.h>

void swap(float *a,float *b)
{
	float basket;
	basket = *a;
	*a = *b;
	*b = basket;
}

int main()
{
	int i,j;
	float a[10];

	printf("请输入十个人的身高：");
    for(i=0;i<10;i++)
	{
		scanf("%f",&a[i]);
	}

	for(i=0;i<9;i++)//一共需要比较10-1=9轮
	{
		for(j=0;j<9-i;j++)//j从0开始，第一次也只是需要比较10-1=9次
			if(a[j]>a[j+1])
			{
				swap(&a[j],&a[j+1]);
			}
	}

	printf("身高由矮到高的排列顺序如下\n");
	for(i=0;i<10;i++)printf("%.2f\n",a[i]);
	
	return 0;
}