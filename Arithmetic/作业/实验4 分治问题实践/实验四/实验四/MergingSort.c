#include "head.h"

void Merge(int R[], int T[], int low, int mid, int high)
{//�������R[low...mid]��R[mid+1...high]�鲢Ϊ�����T[low...high]
	int i = low, j = mid + 1, k = low;

	while (i <= mid && j <= high)//��R�еļ�¼��С����ز���T��(�����������ӱ���ǿ�)
	{
		if (R[i] <= R[j])//�ж����ӱ��Ӧ�ļ�¼С�����ӱ��Ӧ�ļ�¼
		{
			T[k] = R[i];//�ǵĻ������ӱ�Ķ�Ӧ��¼�鲢��T��
			k++, i++;
		}
		else//���ӱ��Ӧ�ļ�¼��С�����ӱ��Ӧ�ļ�¼
		{
			T[k] = R[j];//�������ӱ�Ķ�Ӧ��¼�鲢��T��
			k++, j++;
		}

	}
	while (i <= mid)//���ӱ��ѹ鲢��ϣ���ʣ���R[i...mid]���Ƶ�T��
	{
		T[k] = R[i];
		k++, i++;
	}
	while (j <= high)//���ӱ��ѹ鲢��ϣ���ʣ���R[j...high]���Ƶ�T��
	{
		T[k] = R[j];
		k++, j++;
	}
}

void MergingSort(int R[], int T[], int low, int high)
{//R[low...high]�鲢��������T[low...high]��

	int S[1000];
	if (low == high) T[low] = R[low];//�жϵ�ǰ�����Ƿ�ֻ��һ��Ԫ��
	else
	{
		int mid = (low + high) / 2;//����ǰ����һ��Ϊ����������ѵ�mid
		MergingSort(R, S, low, mid);//��������R[low...mid]�ݹ�鲢���򣬽������S[low...mid]
		MergingSort(R, S, mid + 1, high);//��������R[mid+1...high]�ݹ�鲢���򣬽������S[mid+1...high]
		Merge(S, T, low, mid, high);//��S[low...mid]��S[mid+1...high]�鲢��T[low...high]
	}
}