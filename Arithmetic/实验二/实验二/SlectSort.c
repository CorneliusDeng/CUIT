#include "head.h"

void SelectSort(int array[], int n)
{
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
