#include "head.h"

void HeapAdjust(int K[], int i, int n)
{//调整一个数列变成大顶堆的非递归算法
	int j;
	int temp;
	temp = K[i];
	j = 2 * i;
	while (j <= n)
	{
		if (j < n && K[j] < K[j + 1])//j指向左右儿子中最大的那个
		{
			j++;
		}
		if (temp >= K[j]) //满足堆的原则，跳出
		{
			break;
		}
		else
		{
			K[j / 2] = K[j];//不满足堆的原则，最大的儿子当父亲 
			j = 2 * j;//找儿子的儿子，一直往后走
		}
	}
	K[j / 2] = temp;//直到遍历完后，把一开始不合格的父亲放到他该放的位置（如果他合格，也是把他本身的值赋给他）
}

void HeapSort(int K[], int n)
{//堆排序变成递增的数列
	int i;
	int temp;
	for (i = n / 2; i >= 1; i--)//先把数列变成一个大顶堆
	{
		HeapAdjust(K, i, n);
	}
	for (i = n - 1; i >= 1; i--)
	{
		swap(&K[i+1], &K[1]);;//将大顶堆的首个元素（值最大）与最后一个元素交换位置
		
		HeapAdjust(K, 1, i);//然后每次以交换后的第一个元素为基重新变成大顶堆
	}
}