#include "head.h"

void StraightInsertionSort(int array[], int n)
{//ֱ�Ӳ������򣨼򵥲�������
	for (int i = 1; i < n; i++)
	{
		if (array[i] < array[i - 1])//ÿһ�β������ݶ���ǰһ�������Ƚϣ�ÿһ�����е����һ����һ���ǵ�ǰ����
		{
			int j = i - 1;//��¼��ǰһ������λ��
			int temp = array[i];//��¼����������Ĵ�С

			while (temp < array[j])
			{
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
		}
	}
}