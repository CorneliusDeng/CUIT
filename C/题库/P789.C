#include <stdio.h>

/* userCode(<80字符): 自定义函数之原型声明 */
void deleteother(char *Str);

int main(void)
{
	char str[100];

	printf("Please input the string : ");
	gets(str);

	deleteother(str);
	printf("\noutput: %s\n", str);

	return 0;
}

/* User Code Begin：考生在此后完成自定义函数的设计，行数不限 */
void deleteother(char *Str)
{
	int i, j;

	for (i = 0, j = 0; *(Str + i) != '\0'; i++)
	{
		if ((*(Str + i) >= 'a' && *(Str + i) <= 'z') || (*(Str + i) >= 'A' && *(Str + i) <= 'Z'))
		{
			*(Str + j) = *(Str + i);//满足条件，则j会变化，使下一个位置的值覆盖在上一个位置
			j++;
		}
	}
	*(Str + j) = '\0';
}

