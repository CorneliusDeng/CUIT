#include<stdio.h>

int main(void)
{
	int i, j, tmp, a[100], n = 0;

	printf("Input: ");
	for (i = 0; i < 100; i++)//�������ִ�Ž����鲢����
	{
		scanf("%d", &tmp);
		if (tmp != -888)
		{
			a[i] = tmp;
			n++;
		}
		else
		{
			break;
		}
	}

	for (i = 0; i < n -1; i++)//�������ڵ����ֽ��д�С�����ð������
	{
		for (j = 0; j < n - 1 - i; j++)
		{
			if (a[j] > a [j+1])
			{
				tmp = a[j];
				a[j] = a[j+1];
				a[j+1] = tmp;
			}
		}
	}

	printf("\nResult: ");
	for (i = 0; i < n; i++)
	{
		printf("%d ", a[i]);
	}
	putchar('\n');

	return 0;
}