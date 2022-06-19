#include "head.h"

void StraightInsertionSort(int array[], int n)
{//直接插入排序（简单插入排序）
	for (int i = 1; i < n; i++)
	{
		if (array[i] < array[i - 1])//每一次插入数据都和前一个数作比较，每一次序列的最后一个数一定是当前最大的
		{
			int j = i - 1;//记录它前一个数的位置
			int temp = array[i];//记录现在这个数的大小

			while (temp < array[j])
			{
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
		}
	}
}