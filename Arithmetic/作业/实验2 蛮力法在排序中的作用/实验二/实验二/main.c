#include "head.h"

void main()
{
	int a[10] = { 9, 8, 4, 89, 90, 23, 78, 34, 1, 67 };
	int b[10] = { 9, 8, 4, 89, 90, 23, 78, 34, 1, 67 };
	int c[10] = { 9, 8, 4, 89, 90, 23, 78, 34, 1, 67 };

	printf("ѡ������֮ǰ���������£�\n");
	for (int i = 0; i < 10; i++)
	{
		printf("%d\t", a[i]);
	}

	SelectSort(a, 10);

	printf("\nѡ������֮����������£�\n");
	for (int i = 0; i < 10; i++)
	{
		printf("%d\t", a[i]);
	}
	

	printf("\n\nð������ǰ���������£�\n");
	for (int i = 0; i < 10; i++)
	{
		printf("%d\t", b[i]);
	}

	BubbleSort(b, 10);

	printf("\nð����������������\n");
	for (int i = 0; i < 10; i++)
	{
		printf("%d\t", b[i]);
	}
	
	printf("\n\n��β������ǰ���������£�\n");
	for (int i = 0; i < 10; i++)
	{
		printf("%d\t", c[i]);
	}

	CockTailSort(c, 10);

	printf("\n��β����������������\n");
	for (int i = 0; i < 10; i++)
	{
		printf("%d\t", c[i]);
	}

	putchar('\n');
}