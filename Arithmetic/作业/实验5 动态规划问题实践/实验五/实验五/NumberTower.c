#include "head.h"

int max(int a, int b)
{//����a��b��ֵ�ϴ��һ��
	return a >= b ? a : b;
}

int NumberTower()
{//��̬�滮����
	for (int i = 0; i < nc; i++)
	{
		temp[nc - 1][i] = numbertower[nc - 1][i];//��������ײ�����ݷ�����ʱ��������
	}
	int temp_max;
	//�Ե����ϱ���
	for (int i = nc - 2; i >= 0; i--)
	{
		for (int j = 0; j <= i; j++)
		{
			// ʹ�õ��ƹ�ʽ����temp��ֵ
			temp_max = max(temp[i + 1][j], temp[i + 1][j + 1]);//�ȼ������ײ�����ֵ
			temp[i][j] = temp_max + numbertower[i][j];
		}
	}
}

void print_result()
{//���ݴ�ӡ������ѡ��·��
	printf("���·����Ϊ��%d\n", temp[0][0]);
	int node_value;
	// �����������Ԫ��
	printf("���·����%d", numbertower[0][0]);
	int j = 0;
	for (int i = 1; i < nc; ++i)
	{
		node_value = temp[i - 1][j] - numbertower[i - 1][j];
		/* ���node_value == temp[i][j]��˵����һ��Ӧ����numbertower[i][j]��
		���node_value == temp[i][j + 1]��˵����һ��Ӧ����numbertower[i][j + 1]*/
		if (node_value == temp[i][j + 1])
		{
			j++;
		}
		
		printf(" -> %d", numbertower[i][j]);
	}
	putchar('\n');
}