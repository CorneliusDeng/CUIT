#include <stdio.h>

int StringComp(char str1[], char str2[]);
void StringCopy(char to[], char from[]);
void Sort(char str[][81], int n);

int main(void)
{
	char str[5][81];
	int i;

	/* ����5���ַ�����ŵ�����str�У�ÿ�д��һ���ַ��� */
	printf("Input 5 strings:\n");
	for (i=0; i<5; i++)
	{
		gets(str[i]);
	}

	Sort(str, 5); //���ú���sort������str�е�5���ַ���������������

	printf("---------------------------\n");
	/* ����������ַ��� */
	for (i=0; i<5; i++)
	{
		puts(str[i]);
	}

	return 0;
}

/* ����StringComp�Ĺ����ǣ��Ƚ������ַ����Ĵ�С��
	����ַ���str1����str2,����ֵΪ1��
	����ַ���str1С��str2,����ֵΪ-1��
	����ַ���str1����str2,����ֵΪ0
*/
int StringComp(char str1[], char str2[])
{
	int i;

	for (i = 0; (str1[i] != '\0') && (str2[i] != '\0'); i++)
	{
		if (str1[i] > str2[i]) 
		{
			return 1;
		}
		else if (str1[i] < str2[i])
		{
			return (-1);
		}
	}
	if (str1[i] != '\0')
	{
		return 1;
	}
	else if (str2[i] != '\0')
	{
		return (-1);
	}
	else
	{
		return 0;
	}
}

/*����StringCopy�Ĺ����ǣ�������from�е��ַ������Ƶ�����to��*/
void StringCopy(char to[], char from[])
{
	int i;

	/* ������from�е��ַ�������Ƶ�����to�У�������'\0' */
	for (i=0; from[i]!='\0'; i++)
	{
		to[i] = from[i];
	}
	to[i] = '\0'; //���ַ�����ĩβ���'\0'
}

/* ����Sort�Ĺ����ǣ�������str�е�n���ַ����������� */
void Sort(char str[][81], int n)
{
	int i, j;
	char tmp[81];
	
	for (i = 0; i < n-1; i++)
	{
		for (j = 0; j < n - 1 - i; j++)
		{
			if (StringComp(str[j], str[j+1]) > 0)
			{
				StringCopy(tmp, str[j]);
				StringCopy(str[j], str[j+1]);
				StringCopy(str[j+1], tmp);
			}
		}
	}
}