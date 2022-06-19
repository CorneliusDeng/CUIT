#include "head.h"

void HeapAdjust(int K[], int i, int n)
{//����һ�����б�ɴ󶥶ѵķǵݹ��㷨
	int j;
	int temp;
	temp = K[i];
	j = 2 * i;
	while (j <= n)
	{
		if (j < n && K[j] < K[j + 1])//jָ�����Ҷ����������Ǹ�
		{
			j++;
		}
		if (temp >= K[j]) //����ѵ�ԭ������
		{
			break;
		}
		else
		{
			K[j / 2] = K[j];//������ѵ�ԭ�����Ķ��ӵ����� 
			j = 2 * j;//�Ҷ��ӵĶ��ӣ�һֱ������
		}
	}
	K[j / 2] = temp;//ֱ��������󣬰�һ��ʼ���ϸ�ĸ��׷ŵ����÷ŵ�λ�ã�������ϸ�Ҳ�ǰ��������ֵ��������
}

void HeapSort(int K[], int n)
{//�������ɵ���������
	int i;
	int temp;
	for (i = n / 2; i >= 1; i--)//�Ȱ����б��һ���󶥶�
	{
		HeapAdjust(K, i, n);
	}
	for (i = n - 1; i >= 1; i--)
	{
		swap(&K[i+1], &K[1]);;//���󶥶ѵ��׸�Ԫ�أ�ֵ��������һ��Ԫ�ؽ���λ��
		
		HeapAdjust(K, 1, i);//Ȼ��ÿ���Խ�����ĵ�һ��Ԫ��Ϊ�����±�ɴ󶥶�
	}
}