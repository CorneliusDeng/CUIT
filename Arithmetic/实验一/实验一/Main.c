#include <stdio.h>
void BubbleSort(int r[], int n);

int main()
{
	int i, r[] = { 4,3,9,2,6,1 };
	printf("����ǰ:");
	for (i = 0; i < 6; i++)
		printf("%-4d", r[i]);
	BubbleSort(r, 6);
	putchar('\n');
	printf("�����:");
	for (i = 0; i < 6; i++)
		printf("%-4d", r[i]);
	return 0;
}
void BubbleSort(int r[], int n)
{
	for (int i = 0; i < n - 1; i++)
	{
		for (int j = 0; j < n - 1 - i; j++)
		{
			if (r[j] > r[j + 1])
			{
				int temp = r[j];
				r[j] = r[j + 1];
				r[j + 1] = temp;
			}
		}
	}









	//int bound, exchange = n - 1;          //��һ�����������������[0,n-1]
	//while (exchange != 0)                                //����һ�������м�¼����ʱ
	//{
	//	bound = exchange; exchange = 0;
	//	for (int j = 0; j < bound; j++)   //һ����������������[0, bound]
	//		if (r[j] > r[j + 1])
	//		{
	//			int temp = r[j];
	//			r[j] = r[j + 1];
	//			r[j + 1] = temp;
	//			//������¼
	//			exchange = j + 1;		                           //����ÿһ�μ�¼������λ��
	//		}
	//}
}
