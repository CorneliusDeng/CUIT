#include <stdio.h>

int main(void)
{
	int x;
	double y;//将y表示为F（x）的值，因为y完全可能超过int的表示范围，所以定义成double

	printf("Please input x:");
	scanf("%d", &x);

	if (x < 0)
	{
		y = (-5) * (double)x + 27;//因为int转换成double会有警告，在运算过程中将x强制转换成double类型
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