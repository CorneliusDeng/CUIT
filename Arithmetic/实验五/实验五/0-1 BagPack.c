#include "head.h"

int KnapSack(int n, int w[], int v[], int x[], int C)
{//��̬�滮0/1�������⣬����������������ֵ

	int V[50][50];//ǰi����Ʒװ������Ϊj�ı����л�õ�����ֵ
	int i, j;
	//���,���е�һ�к͵�һ��ȫΪ0
	for (i = 0; i <= n; i++)
	{
		V[i][0] = 0;
	}
	for (j = 0; j <= C; j++)
	{
		V[0][j] = 0;
	}
	
	printf("��̬�滮�����������£�\n");
	for (i = 1; i <= n; i++)
	{
		for (j = 1; j <= C; j++)
		{
			if (j < w[i - 1])
			{
				V[i][j] = V[i - 1][j];
				printf("[%d][%d]=%2d  ", i, j, V[i][j]);
			}

			else
			{
				V[i][j] = max(V[i - 1][j], V[i - 1][j - w[i - 1]] + v[i - 1]);
				printf("[%d][%d]=%2d  ", i, j, V[i][j]);
			}
		}
		putchar('\n');
	}
	//�ж���Щ��Ʒ��ѡ��
	j = C;
	for (i = n; i >= 1; i--)
	{
		if (V[i][j] > V[i - 1][j])
		{
			x[i] = 1;
			j = j - w[i - 1];
		}
		else
			x[i] = 0;
	}
	printf("��������%d����Ʒ��ѡ������ã�0/1��չʾ:\n", n);
	for (i = 1; i <= n; i++)
	{
		printf("%d ", x[i]);
	}
		
	printf("\n");
	return V[n][C];

}
