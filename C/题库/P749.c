#include <stdio.h>

int main(void)
{
	int N, i, j, a[5][5]; 

	printf("Please input an integer: ");
	scanf("%d", &N);

	for (i = 0; i < 5; i++)
	{
		for (j = 0; j < 5; j++)
		{
			a[i][j] = N + i + j; 
		}
	}
	for (i = 0; i < 5; i++)
	{
		for (j = 0; j < 5; j++) //��forѭ���Ĺ��������һ��
		{
			printf("%4d", a[i][j]);
		}
		printf("\n"); //����һ�����ݺ���
	}
	
	return 0;
}