#include<stdio.h>

int main()
{
	int n, i;
	static double sum = 0, c = 1;

	printf("Please input n: ");
	scanf("%d",&n);

	for(i = 1; i <= n; i++)
	{
		c *= i;
		sum += 1 / c;//���ע�⣺��c�����ͣ�sum��˫���ȸ���������ֵ�Ĺ����л�ȡ��
	}

	printf("S=1/1!+1/2!+...+1/%d!=%.16f\n", n, sum);
	
	return 0;
}