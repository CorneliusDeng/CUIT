#include <stdio.h>

/* userCode(<70字符): 自定义函数之原型声明 */
int Min(int Arry[], int N, int n);

int main(void)
{
	int arrA[5], arrB[8], num, minA, minB;

	printf("请输入5个数：");
	scanf("%d%d%d%d%d", &arrA[0], &arrA[1], &arrA[2], &arrA[3], &arrA[4]);
	printf("请输入8个数：");
	scanf("%d%d%d%d%d%d%d%d", &arrB[0], &arrB[1], &arrB[2], &arrB[3], &arrB[4], &arrB[5], &arrB[6], &arrB[7]);
	printf("请再输入一个数：");
	scanf("%d", &num);

	minA = Min(arrA, 5, num);  /* userCode(<50字符): 调用函数查找在arrA中大于num的最小数 */
	if (-1 == minA)
	{
		printf("\narrA: not Find!");
	}
	else
	{
		printf("\nMin(arrA) = %d", minA);
	}

	minB = Min(arrB, 8, num); /* userCode(<50字符): 调用函数查找在arrB中大于num的最小数 */
	if (-1 == minB)
	{
		printf("\narrB: not Find!\n");
	}
	else
	{
		printf("\nMin(arrB) = %d\n", minB);
	}

	return 0;
}

/* User Code Begin：考生在此后完成自定义函数的设计，行数不限 */
int Min(int Arry[], int N, int n)
{
	int i;
	int min = -1;
	int count = 0;

	for (i = 0; i < N; i++)
	{
		if (count == 0)
		{
			if (Arry[i] > n)
			{
				min = Arry[i];
				count++;//若执行此步，证明已经有存在大于num的数
			}
			continue;//若上一步执行了count++，跳过循环体中下面尚未执行的语句，然后进行下一次是否执行循环的判定，i++
		}
		else 
		{
			if (Arry[i] > n)
			{
				if (Arry[i] < min)
				{
					min = Arry[i];
				}
			}
		}
		
	}
	return min;
}






