#include<stdio.h>

int CheckHigh(int arry[]);
int CheckLow(int arry[]);
float Find(int arry[]);
float Calculate(int arry[]);

int main(void)
{
	int highest, lowest;
	int a[40], i;
	float PassRate, average;

	printf("������40λͬѧ�ĳɼ���");
	for (i = 0; i < 40; i++)
	{
		scanf("%d", &a[i]);
	}

	highest = CheckHigh(a);
	lowest = CheckLow(a);
	average = Find(a);
	PassRate = Calculate(a);

	
	printf("\n��߷֣�%d\n��ͷ֣�%d\nƽ���֣�%.1f\n�����ʣ�%.0f%%\n", highest, lowest, average , PassRate);
}

int CheckHigh(int arry[])//������߷֣������ص�h
{
	int i, h;
	
	h = arry[0];
	for (i = 1; i < 40; i++)
	{
		if (arry[i] > h)
		{
			h = arry[i];
		}
	}

	return h;
}

int CheckLow(int arry[])//������߷֣������ص�l
{
	int  i ,l;

	l = arry[0];
	for (i = 1; i <40; i++)
	{
		if (arry[i] < l)
		{
			l = arry[i];
		}
	}

	return l;
}

float Find(int arry[])//����ƽ���֣����ص�aver
{
	int i, sum = 0;
	float aver;

	for (i = 0; i < 40; i++)
	{
		sum += arry[i];
	}
	
	aver = (float)sum / 40;

	return aver;
}

float Calculate(int arry[])//���㼰���ʣ����ص�p
{
	int i,  count = 0;
	float p;

	for (i = 0; i < 40; i++)
	{
		if (arry[i] >= 60)
		{
			count++;
		}
	}

	p = (float)count / 40 * 100;

	return p;
}

