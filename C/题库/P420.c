#include <stdio.h>

void swap(float *pa,float *pb)
{
	float basket;
	basket=*pa;
	*pa=*pb;
	*pb=basket;
}

int main()
{
	float a[100];
	int i,j,k=0;//kΪ��������ּ���

	printf("Input: ");
	for(i=0;i<100;i++)
	{
		scanf("%f",&a[i]);
		if(a[i]==-567)
		{
			k=i-1;
			break;
		}
		k++;
	}
	for(i=0;i<k;i++)//���ƱȽ�������ð�ݷ���
	{
		for(j=0;j<k-i;j++)//���ƱȽϴ���
		{
			if(a[j]<a[j+1])
			{
			swap(&a[j],&a[j+1]);
			}
		}
	}
	printf("\nResult: ");
	for(i=0;i<=k;i++)
	{
		if(i==0)
			printf("%.1f",a[i]);
		else
			printf(" %.1f",a[i]);
	}
	printf("\n");
	return 0;
}