#include<stdio.h>

int main()
{
	int n, i, j;

	printf("Please input n: ");
	scanf("%d",&n);

		
	for (i = 1; i <= n; i++)//���ͼ�ε��ϰ벿�֣���n�У�
	{
		for (j = 1; j <= (i - 1); j++) //�����i�е�һ��@ǰ�Ŀո�
		{
			printf(" ");
		}
		printf("%c", '@'); //�����i�е�һ��@
		if (i != n) //�����ǰ�в��ǵ�n��
		{
			for (j = 1; j <= 2 * (n - i) - 1; j++) //�����i�еڶ���@ǰ�Ŀո�
			{
				printf(" ");
			}
			printf("%c", '@'); //�����i�еڶ���@
		}
		printf("\n");
	}
	
	for (i = n - 1; i >= 1; i--)//���ͼ�ε��°벿�֣���n-1�У�
	{
		for (j = 1; j <= (i - 1); j++)
		{
			printf(" ");//�����n+x��ǰ��Ŀո�
		}
		printf("%c", '@');
		for (j = 1; j <= 2 * (n - i) - 1; j++)
		{
			printf(" ");
		}
		printf("%c", '@');
	
		printf("\n");
	}
	
	return 0;
}