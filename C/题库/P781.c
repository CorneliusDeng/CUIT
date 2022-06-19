#include <stdio.h>

int StringComp(char str1[], char str2[]);
void StringCopy(char to[], char from[]);
void Sort(char str[][81], int n);

int main(void)
{
	char str[5][81];
	int i;

	/* 输入5个字符串存放到数组str中，每行存放一个字符串 */
	printf("Input 5 strings:\n");
	for (i=0; i<5; i++)
	{
		gets(str[i]);
	}

	Sort(str, 5); //调用函数sort对数组str中的5个字符串进行升序排序

	printf("---------------------------\n");
	/* 输出排序后的字符串 */
	for (i=0; i<5; i++)
	{
		puts(str[i]);
	}

	return 0;
}

/* 函数StringComp的功能是：比较两个字符串的大小，
	如果字符串str1大于str2,函数值为1，
	如果字符串str1小于str2,函数值为-1，
	如果字符串str1等于str2,函数值为0
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

/*函数StringCopy的功能是：将数组from中的字符串复制到数组to中*/
void StringCopy(char to[], char from[])
{
	int i;

	/* 将数组from中的字符逐个复制到数组to中，不包括'\0' */
	for (i=0; from[i]!='\0'; i++)
	{
		to[i] = from[i];
	}
	to[i] = '\0'; //在字符串的末尾添加'\0'
}

/* 函数Sort的功能是：对数组str中的n个字符串升序排序 */
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