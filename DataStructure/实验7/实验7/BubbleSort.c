#include "head.h"

void BubbleSort(int array[], int n)
{//冒泡排序
	int i, j, flag = 1;
	int temp;
	i = n - 1;
	while (i > 0 && flag == 1)	//这种冒泡排序的最优时间复杂度只有O(n) 
	{
		flag = 0;                        /* 每趟排序前标志flag置0 */
		for (j = 0; j < i; j++)
			if (array[j] > array[j + 1])
			{
				swap(&array[j], &array[j+1]);		/* 交换两个元素的位置 */
				flag = 1;              /* 标志flag置1 */
			}
		i--;
	}
}
