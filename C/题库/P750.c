#include<stdio.h>

int main(void)
{
	char str1[101], str2[101];
	int i, j;

	printf("Please input a string: ");
	gets(str1);
	putchar('\n');

	for (i = 0, j = 0; str1[i] != '\0'; i++)//字符数组str1在没有输入完成的情况下
	{
		if (str1[i] != '*')//如果字符数组str1中没有字符*，那么将其所对应的值传递给字符数组str2
		{
			str2[j] = str1[i];//
			j++;
		}
		
	}
	str2[j] = '\0';//在循环末尾手动为字符数组str2加上结束符号

	printf("The Result is:");
	puts(str2);
	putchar('\n');

	return 0;
}
