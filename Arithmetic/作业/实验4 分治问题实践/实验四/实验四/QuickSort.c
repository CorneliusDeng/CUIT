#include "head.h"

void swap(int* a, int* b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}

void QuickSort(int a[], int low, int high)
{//��������
	int i = low;
	int j = high;
	int temp = a[low];//�����¼
	
	if (low > high)
	{
		return;
	}
	while (i != j)
	{
		//����������һ��С��temp�����ֵ
		while (a[j] >= temp && i < j)
		{
			j--;
		}
		//����������һ������temp�������ֵ
		while (a[i] <= temp && i < j)
		{
			i++;
		}

		if (i < j)
		{
			swap(&a[i], &a[j]);
		}
	}
	//temp��λ
	a[low] = a[i];
	a[i] = temp;

	QuickSort(a, low, i - 1);//���ӱ�ݹ�����
	QuickSort(a, i + 1, high);//���ӱ�ݹ�����
}