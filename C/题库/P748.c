#include <stdio.h>

int main(void)
{
	int i, j, n, sum1 = 0, sum2 = 0, array[14][14];

	printf("Enter n:");
	scanf("%d", &n);

	/* ������ֵ���þ���Ԫ�ص�ֵ������λ�õ�����������֮�͵�n����*/
	for (i=0; i<n; i++)
	{
		for (j=0; j<n; j++)
		{
			array[i][j] = n * (i + j);
		}
	}
	/* ����þ���(��ʾʱÿ�������Ϊ4���Ҷ���) */
	for (i=0; i<n; i++)
	{
		for (j=0; j<n; j++)
		{
			printf("%4d", array[i][j]);
		}
		printf("\n");
	}
	/*������������в�����Ԫ��֮��*/
	for (i=1; i<n-1; i++)
	{
		for (j=1; j<n-1; j++)
		{
			sum1 = sum1 + array[i][j];
		}
	} 
	/*�����������Խ���Ԫ��֮��*/
	for (i=0; i<n; i++)
	{
		sum2 = sum2 + array[i][i];
	} 
	
	printf("sum1=%d\n", sum1); //������
	printf("sum2=%d\n", sum2); //������

	return 0;
}
