#include<stdio.h>

void Sort(char str[], int num);

int main(void)
{
	char Str[128];
	int i = 0, j;

	printf("input the string: ");
	while (i < 127)
	{
		Str[i] = getchar();
		if ('\n' == Str[i])//�������ϰ���enterʱ�������
		{
			break;
		}
		i++;//i���ڴ������ĸ���
	}

	Sort(Str, i);

	printf("\nResult:");
	for (j = 0; j < i; j++)
	{
		printf("%c", Str[j]);
	}
	printf("\n");

	return 0;
}

void Sort(char str[], int num)//��������ַ���С��������
{
	int i, j;
	char tmp;

	for (i = 0; i < num - 1; i++)
	{
		for (j = 0; j < num - 1 - i; j++)
		{	
			if (str[j] > str[j+1])
			{
				tmp = str[j];
				str[j] = str[j+1];
				str[j+1] = tmp;
			}
		}
	}
}


 
