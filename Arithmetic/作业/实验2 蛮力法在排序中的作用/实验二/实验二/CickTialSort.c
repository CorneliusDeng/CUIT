#include "head.h"

void CockTailSort(int array[], int n)
{
	int leftindex = 0;
	int rightindex = n - 1;

	while (leftindex <= rightindex)
	{
		for (int i = leftindex; i < rightindex; i++)
		{
			if (array[i] > array[i + 1])
			{
				int temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
			}
		}
		rightindex--;

		for (int i = rightindex; i > leftindex; i--)
		{
			if (array[i - 1] > array[i])
			{
				int temp = array[i - 1];
				array[i - 1] = array[i];
				array[i] = temp;
			}
		}
		leftindex++;
	}
}