#include<stdio.h>

double Fuction(int k);

int main(void)
{
	int n;

	printf("Input n (13>=n>=2): ");
	scanf("%d", &n);

	printf("\nf(%d)=%.0lf\n", n, Fuction(n));

	return 0;
}

double Fuction(int k)
{
	double a[14] = {0, 1, 2};//����������ǰ���������и�ֵ
	int i;
	
	for (i = 3; i < 14; i++)  //���ݹ�ʽ���μ���������f(3)~f(13)��ֵ��������ֵ�ŵ���Ӧ������Ԫ��fn[3]~fn[13]��
	{
		a[i] = 2 * a[i-1] + a[i-2] * a[i-3];//����������ƹ�ʽ�����μ���a[3]~a[13]��ֵ
	}

    return a[k];

}