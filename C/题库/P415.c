#include <stdio.h>
#define N 10 //NΪ�������ֵ�����

typedef struct person  
{
	int number; //���ֵı��
	int score[6]; //��λ��ί�Ĵ��
	float finalScore; //���ֵ����ճɼ�
}AAA;

int main(void)
{
	int i, j, sum, max, min;
	AAA tmp, singer[N];  //����singer[N]�������Nλ���ֵ�����
	
	printf("Please input singer's score:\n");
	/* ��������Nλ���ֵ����� */
	for (i = 0; i < N; i++)
	{
		singer[i].number = i + 1; //������
		/* ������λ��ί�Ĵ�� */
		for (j = 0; j < 6; j++)
		{
			scanf("%d", &singer[i].score[j]);
		}
	}

	/* ���μ���Nλ���ֵ����յ÷� */
	for (i = 0; i < N; i++)
	{
		max = min = singer[i].score[0]; 
		sum = singer[i].score[0];
		for (j = 1; j < 6; j++)
		{
			/* ������߷� */
			if (singer[i].score[j] > max)
			{
				max = singer[i].score[j];
			}
			/* ������ͷ� */
			else if (singer[i].score[j] < min)
			{
				min = singer[i].score[j];
			}
			/* �����ܷ� */
			sum +=  singer[i].score[j];
		}

		sum = sum - min - max; //�۳�һ����߷ֺ�һ����ͷֺ�ĵ÷�
		singer[i].finalScore = (float)sum / 4; //��������յ÷�
	}

	/* ʹ�����ݷ�����ÿλ���ֵ����յ÷ִӸߵ������� */
	for (i = 1; i <= N - 1; i++)
	{
		for (j = 1; j <= N - i; j++)
		{
			if (singer[j].finalScore  > singer[j-1].finalScore)
			{
				tmp = singer[j];
				singer[j] = singer[j-1];
				singer[j-1] = tmp;
			
			}
		}
	}

	printf("\nscores:\n");
	/* ���ÿλ���ֵı�ź����յ÷� */
	for (i = 0; i < N; i++)
	{
		printf("No.%-2d: %.2f\n", singer[i].number, singer[i].finalScore);
	}

	return 0;
}













