#include <stdio.h>

int main()
{
	int n;
	int i, j;

	printf("Please input n:");
	scanf("%d", &n);

	//������ε��ϰ벿�֣���n+1�У� 
	for (i = 1; i <= n + 1; i++)  // ���ǰn+1��# 
	{
		for (j = i; j <= n; j++)  // �����i��ʱ��������ո�,��������Ŀո���
		{
			printf(" ");
		}
		for (j = 1; j <= 2 * i - 1; j++)  //�����i�е�#
		{
			printf("#");
		}
		printf("\n");
	}
	
	//������ε��°벿�֣���n�У� 
	for (i = 1; i <= n; i++)  
	{
		for (j = 1; j <= i; j++)
		{
			printf(" ");
		}
		for (j = 1; j <= 2 * (n - i) + 1; j++)
		{
			printf("#");
		}
		printf("\n");
	}
	
	return 0;

}