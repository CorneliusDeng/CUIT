#include <stdio.h>

int main(void)
{
	int x;
	double y;//��y��ʾΪF��x����ֵ����Ϊy��ȫ���ܳ���int�ı�ʾ��Χ�����Զ����double

	printf("Please input x:");
	scanf("%d", &x);

	if (x < 0)
	{
		y = (-5) * (double)x + 27;//��Ϊintת����double���о��棬����������н�xǿ��ת����double����
	}
	else if (x == 0)
	{
		y = 7909;
	}
	else
	{
		y = 2 * (double)x - 1;
	}

	printf("\nF(%d) = %.0f\n", x, y);

	return 0;
}