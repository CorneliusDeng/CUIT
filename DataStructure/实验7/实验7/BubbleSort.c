#include "head.h"

void BubbleSort(int array[], int n)
{//ð������
	int i, j, flag = 1;
	int temp;
	i = n - 1;
	while (i > 0 && flag == 1)	//����ð�����������ʱ�临�Ӷ�ֻ��O(n) 
	{
		flag = 0;                        /* ÿ������ǰ��־flag��0 */
		for (j = 0; j < i; j++)
			if (array[j] > array[j + 1])
			{
				swap(&array[j], &array[j+1]);		/* ��������Ԫ�ص�λ�� */
				flag = 1;              /* ��־flag��1 */
			}
		i--;
	}
}
