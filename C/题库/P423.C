#include <stdio.h>

#define maxNums 10000
#define endFlag -222

/* userCode(<50字符): 自定义函数之原型声明 */
int min(int data[], int n, int m);

int main(void)
{
	int i, mini, tmp;
	int inputData[maxNums] = {0}, dataCount=0;  /* inputData用于保存输入的数据，dataCount记录输入数据的个数 */

	printf("Please input numbers:");
	for (i=0; i<maxNums; i++)
	{
		scanf("%d", &inputData[i]);
		if (endFlag == inputData[i])
		{
			break;
		}
		dataCount++;
	}

	for (i=0; i<dataCount-1; i++)
	{
		mini = min(inputData, dataCount, i+1); /* userCode(<50字符): 调用函数寻找第i个较小的数 */
		if (mini != i)
		{
			tmp = inputData[mini];
			inputData[mini] = inputData[i];
			inputData[i] = tmp;
		}
	}

	printf("\nOutput:\n");
	for (i=0; i<dataCount; i++)
	{
		printf("%-6d", inputData[i]);

		if (((i + 1) % 6) != 0 && i != dataCount - 1)
		{
			printf(",");
		}
		else
		{
			printf("\n");
		}
	}

	return 0;
}

/* User Code Begin：考生在此后完成自定义函数的设计，行数不限 */
int min(int data[], int n, int m)
{	
	int mina = m, minb = data[m], j;
	
	for (j = m; j < n; j++)
	{
		if (data[j] < minb)
		{
			mina = j;
			minb = data[j];
		}
	}
	
	return mina;
}
