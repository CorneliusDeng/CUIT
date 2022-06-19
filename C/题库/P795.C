#include <stdio.h>

/* userCode(<80字符): 自定义函数之原型声明 */
int split(char *str, char **pStr);

int main(void)
{
	char str[200], *pStr[101];
	int i=0, count;

	printf("Please input a string: ");
	gets(str);

	count = split(str,  pStr);
	printf("\n%d Words: ", count);
	for (i=0; i<count; i++)
	{
		printf("%s-", pStr[i]);
	}
	putchar('\n');

	return 0;
}

/* User Code Begin：考生在此后完成自定义函数的设计，行数不限 */
int split(char *str, char **pStr)
{
	int i;
	int flag = 0;

	for (i=0; *(str + i); i++)
	{
		while (*(str + i) == ' ')
		{
			i++;
		}
		if (*(str + i) == '\0')
		{
			break;
		}
		else
		{
			*(pStr + flag) = &*(str + i);
			flag++;
			while (*(str + i) != ' ')
			{
				i++;
				if (*(str + i) == '\0')
				{
					break;
				}
			}
			if (*(str + i) == '\0')
			{
				break;
			}
			if (*(str + i) == ' ')
			{
				*(str + i) = '\0';
			}
		}
	}

	return flag;
}