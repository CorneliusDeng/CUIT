#include "head.h"

void swap(int* a, int* b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}

void QuickSort(int a[], int low, int high)
{//快速排序
	int i = low;
	int j = high;
	int temp = a[low];//枢轴记录
	
	if (low > high)
	{
		return;
	}
	while (i != j)
	{
		//从右向左找一个小于temp代表的值
		while (a[j] >= temp && i < j)
		{
			j--;
		}
		//从左向右找一个大于temp所代表的值
		while (a[i] <= temp && i < j)
		{
			i++;
		}

		if (i < j)
		{
			swap(&a[i], &a[j]);
		}
	}
	//temp归位
	a[low] = a[i];
	a[i] = temp;

	QuickSort(a, low, i - 1);//左子表递归排序
	QuickSort(a, i + 1, high);//右子表递归排序
}