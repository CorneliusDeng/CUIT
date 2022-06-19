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
		sum += 1 / c;//务必注意：若c是整型，sum是双精度浮点数，赋值的过程中会取整
	}

	printf("S=1/1!+1/2!+...+1/%d!=%.16f\n", n, sum);
	
	return 0;
}