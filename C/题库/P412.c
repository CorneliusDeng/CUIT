#include<stdio.h>

int main(void)
{
	int i, j, n = 0, tmp, Arry[10000];

	printf("Please input numbers:"); 
	for (i = 0; i < 10000; i++)
	{
		scanf("%d", &tmp);
		if (tmp != -222)    //�����������-222ʱ����������ŵ�����Arry��
		{
			Arry[i] = tmp;
			n++;//n����ͳ���������Ч����
		}
		else   //���������-222���������
		{
			break;
		}
	}
	
	for (i = 0; i < n - 1; i++)//������Arry�е�n������ð�ݷ�����С��������
	{
		for (j = 0; j < n - i - 1 ; j++)//j��0��ʼ����һ��Ҳֻ��Ҫ�Ƚ�n-1�Σ��������мǣ�����
		{
			if (Arry[j] > Arry[j+1])
			{
				tmp = Arry[j];
				Arry[j] = Arry[j+1];
				Arry[j+1] = tmp;
			}
		}
	}

	printf("\nOutput:\n");//���������������У�6����һ�У�����֮���ж��ţ���ĩβ����û�ж���
	
	for (i = 0; i < n; i++)
	{
		if((i+1)%6 != 0)
		{
			printf("%-6d,", Arry[i]);
		}
		if((i+1)%6 == 0)
		{
			printf("%-6d\n", Arry[i]);
		}
	}
	printf("%-6d\n",Arry[n-1]);

	return 0;
}




