#include "head.h"

void SelectSort(int array[], int n)
{//—°‘Ò≈≈–Ú
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
			swap(&array[d], &array[i]);
		}
	}
}