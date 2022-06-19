#include <stdio.h>
int read(int *num);  /* userCode(<50字符): 自定义函数1之原型声明 */
int check(int num[], int start, int end);  /* userCode(<50字符): 自定义函数2之原型声明 */

int main(void)
{
	int num[100], n, min;
	
	printf("请输入若干个数: ");
	n = read(num);  /* userCode(<30字符): 调用函数读入数据到num中并统计个数 */

	min = check(num, 0, n );    /* userCode(<40字符): 调用函数查找第0～n-1个数中最小数的下标 */
	printf("\n第0～%d个数中最小的是%d", n-1, num[min]);
	min = check(num, 3, n );    /* userCode(<40字符): 调用函数查找第3～n-1个数中最小数的下标 */
	printf("\n第3～%d个数中最小的是%d\n", n-1, num[min]);

	return 0;
}

/* User Code Begin：考生在此后完成自定义函数的设计，行数不限 */
int read(int *num)
{
	int i, n;

	for(i = 0; ; i++)
	{
		scanf("%d", &num[i]);

		if (num[i] == -888 || i == 100)
		{
			break;
		}
	}
		
	n = i;

	return n;

}

int check(int num[], int start, int end)
{
	int i, minTag = start, min = num[start];

	for (i = start + 1; i < end; i++)
	{
		if (num[i] < min)
		{
			min = num[i];
			minTag = i;
		}
	}

	return minTag;//返回寻找到的最小数的下标
}



