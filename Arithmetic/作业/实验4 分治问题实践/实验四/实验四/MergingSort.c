#include "head.h"

void Merge(int R[], int T[], int low, int mid, int high)
{//将有序地R[low...mid]和R[mid+1...high]归并为有序的T[low...high]
	int i = low, j = mid + 1, k = low;

	while (i <= mid && j <= high)//将R中的记录由小到大地并入T中(条件是左右子表均非空)
	{
		if (R[i] <= R[j])//判断左子表对应的记录小于右子表对应的记录
		{
			T[k] = R[i];//是的话将左子表的对应记录归并到T中
			k++, i++;
		}
		else//左子表对应的记录不小于右子表对应的记录
		{
			T[k] = R[j];//否则将右子表的对应记录归并到T中
			k++, j++;
		}

	}
	while (i <= mid)//右子表已归并完毕，将剩余的R[i...mid]复制到T中
	{
		T[k] = R[i];
		k++, i++;
	}
	while (j <= high)//左子表已归并完毕，将剩余的R[j...high]复制到T中
	{
		T[k] = R[j];
		k++, j++;
	}
}

void MergingSort(int R[], int T[], int low, int high)
{//R[low...high]归并排序后放入T[low...high]中

	int S[1000];
	if (low == high) T[low] = R[low];//判断当前序列是否只有一个元素
	else
	{
		int mid = (low + high) / 2;//将当前序列一分为二，求出分裂点mid
		MergingSort(R, S, low, mid);//对子序列R[low...mid]递归归并排序，结果放入S[low...mid]
		MergingSort(R, S, mid + 1, high);//对子序列R[mid+1...high]递归归并排序，结果放入S[mid+1...high]
		Merge(S, T, low, mid, high);//将S[low...mid]和S[mid+1...high]归并到T[low...high]
	}
}