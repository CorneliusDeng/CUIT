#include "head.h"

int max(int a, int b)
{//返回a、b中值较大的一个
	return a >= b ? a : b;
}

int NumberTower()
{//动态规划数塔
	for (int i = 0; i < nc; i++)
	{
		temp[nc - 1][i] = numbertower[nc - 1][i];//将数塔最底层的数据放在临时数组里面
	}
	int temp_max;
	//自底向上遍历
	for (int i = nc - 2; i >= 0; i--)
	{
		for (int j = 0; j <= i; j++)
		{
			// 使用递推公式计算temp的值
			temp_max = max(temp[i + 1][j], temp[i + 1][j + 1]);//先计算出最底层的最大值
			temp[i][j] = temp_max + numbertower[i][j];
		}
	}
}

void print_result()
{//回溯打印数塔的选择路径
	printf("最大路径和为：%d\n", temp[0][0]);
	int node_value;
	// 首先输出塔顶元素
	printf("最大路径：%d", numbertower[0][0]);
	int j = 0;
	for (int i = 1; i < nc; ++i)
	{
		node_value = temp[i - 1][j] - numbertower[i - 1][j];
		/* 如果node_value == temp[i][j]则说明下一步应该是numbertower[i][j]；
		如果node_value == temp[i][j + 1]则说明下一步应该是numbertower[i][j + 1]*/
		if (node_value == temp[i][j + 1])
		{
			j++;
		}
		
		printf(" -> %d", numbertower[i][j]);
	}
	putchar('\n');
}