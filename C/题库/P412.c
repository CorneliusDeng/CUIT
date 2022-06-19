#include<stdio.h>

int main(void)
{
	int i, j, n = 0, tmp, Arry[10000];

	printf("Please input numbers:"); 
	for (i = 0; i < 10000; i++)
	{
		scanf("%d", &tmp);
		if (tmp != -222)    //读入的数不是-222时，将该数存放到数组Arry中
		{
			Arry[i] = tmp;
			n++;//n用来统计输入的有效整数
		}
		else   //读入的数是-222，输入结束
		{
			break;
		}
	}
	
	for (i = 0; i < n - 1; i++)//对数组Arry中的n个数用冒泡法按从小到大排序
	{
		for (j = 0; j < n - i - 1 ; j++)//j从0开始，第一次也只需要比较n-1次！！！！切记！！！
		{
			if (Arry[j] > Arry[j+1])
			{
				tmp = Arry[j];
				Arry[j] = Arry[j+1];
				Arry[j+1] = tmp;
			}
		}
	}

	printf("\nOutput:\n");//对这组数进行排列，6个数一行，两数之间有逗号，行末尾的数没有逗号
	
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




