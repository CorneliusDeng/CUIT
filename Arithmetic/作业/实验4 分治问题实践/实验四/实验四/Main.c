#include "head.h"

void main()
{
	int array1[100], n, array2[100];

	printf("��������������ٸ����ݣ�\t");
	int temp1 = scanf("%d", &n);
	printf("\n��������������%d��Ԫ��\n", n);
	for (int i = 0; i < n; i++)
	{
		int temp = scanf("%d", &array1[i]);
	}

	for (int i = 0; i < n; i++)//��������
	{
		array2[i] = array1[i];
	}

	QuickSort(array1, 0, n-1);
	printf("\n���ڲ��Կ������򣬽���ǣ�\n");
	for (int i = 0; i < n; i++)
	{
		printf("%d\t", array1[i]);
	}
	putchar('\n');

	MergingSort(array2, array2, 0, n - 1);
	printf("\n���ڲ��Թ鲢���򣬽���ǣ�\n");
	for (int i = 0; i < n; i++)
	{
		printf("%d\t", array2[i]);
	}

	putchar('\n');



/*
ʵ������
15�����֣� 90 67 34 45 89 23 1 9 6 32 99 63 97 27 19
*/

}