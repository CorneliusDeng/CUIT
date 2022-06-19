#include "head.h"

int BinarySearch(int array[], int n, int key)
{//在n个数据大小的array数组中，查找值为key的元素，返回它的下标
	
	int low = 0;
	int high = n - 1;
	int mid = 0;

	while (low <= high)
	{
		mid = (low + high) / 2;
		if (key < array[mid])
		{
			high = mid - 1;
		}
		else if (key > array[mid])
		{
			low = mid + 1;
		}
		else 
		{
			return mid;
		}
	}

	return -1;
}

void SelectSort(int array[], int n)
{//选择排序将数列变成递增的
	int i, j, d;
	int temp;
	for (i = 0; i < n - 1; i++)
	{
		d = i;
		for (j = i + 1; j < n; j++)
		{
			if (array[j] < array[d])
			{
				d = j;
			}
		}
		if (d != i)
		{
			temp = array[d];
			array[d] = array[i];
			array[i] = temp;
		}
	}
}