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

	printf("������ʮ���˵���ߣ�");
    for(i=0;i<10;i++)
	{
		scanf("%f",&a[i]);
	}

	for(i=0;i<9;i++)//һ����Ҫ�Ƚ�10-1=9��
	{
		for(j=0;j<9-i;j++)//j��0��ʼ����һ��Ҳֻ����Ҫ�Ƚ�10-1=9��
			if(a[j]>a[j+1])
			{
				swap(&a[j],&a[j+1]);
			}
	}

	printf("����ɰ����ߵ�����˳������\n");
	for(i=0;i<10;i++)printf("%.2f\n",a[i]);
	
	return 0;
}