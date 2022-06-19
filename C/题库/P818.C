#include <stdio.h>

#define N 20

/* userCode(<50字符): 自定义函数之原型声明 */
void maxLie(int array[N][N], int hshu, int lshu);

int main(void)
{
	int m, n;
	int hang, lie, juZhen[N][N];

	printf("Please input m and n: ");
	scanf("%d%d", &m, &n);

	printf("Please input a juZhen(%d hang, %d lie):\n", m, n);
	for (hang = 0; hang < m; hang++)
	{
		for (lie = 0; lie < n; lie++)
		{
			scanf("%d", &juZhen[hang][lie]);
		}
	}
	puts("");

	maxLie(juZhen, m, n);  /* userCode(<50字符): 调用函数找出每一行上的最大值的列下标并按示例格式要求显示 */
	return 0;
}

/* User Code Begin：考生在此后完成自定义函数的设计，行数不限 */
void maxLie(int array[N][N], int hshu, int lshu)
{
	int i, j, max, maxlie; //变量max用来存放行的最大值，变量maxlie用来存放行最大值的列标

	
	for (i=0; i<hshu; i++)
	{
		max = array[i][0]; //将第i行的第一个元素赋给变量max
		maxlie = 0; //将第i行第一个元素的列标赋给变量maxlie
		/* 查找第i行的最大值及最大值的列标 */
		for (j=1; j<lshu; j++)
		{
			if (array[i][j] > max)
			{
				max = array[i][j];
				maxlie = j;
			}
		}
		printf("The max value in line %d is %d\n", i, maxlie); //输出第i行最大值及其列标
	}
}