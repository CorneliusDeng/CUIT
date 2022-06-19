#include <stdio.h>
#include <string.h>

#define N 128

void conj(char *string1, char *string2);

int main(void)
{
	char str1[N * 2], str2[N];

	printf("Please input string1:");
	gets(str1);
	printf("Please input string2:");
	gets(str2);

	/* 本部分代码功能建议：调用函数conj()完成str1和str2的合并 */	
	/* User Code Begin(Limit: lines<=1, lineLen<=50, 考生可在本行后添加代码、最多1行、行长<=50字符) */
	conj(str1, str2);
	/* User Code End(考生添加代码结束。注意：空行和单独为一行的{与}均不计行数、行长不计行首tab缩进) */

	printf("\nstring1:%s\n", str1);

	return 0;
}

/* User Code Begin(考生在此后根据设计需要完成程序的其它部分，如函数conj，行数不限) */
void conj(char *string1, char *string2)
{
	int i, j; 
	char string3[N * 2];
	
	/* 将字符串s2中的字符依次插入字符串s1的相应字符后，合并后的新字符串存放在数组s3中 */
	for (i = 0, j = 0; (string1[i] != '\0') && (string2[i] != '\0'); i++, j += 2)
	{
		string3[j] = string1[i];
		string3[j+1] = string2[i];//此处j已增大1，循环末尾应增大2
	}

	/* 如果数组s2中的字符串比数组s1中的字符串长，将s2中剩余的字符复制到数组s3中的字符串末尾*/
	if (string2[i] != '\0')
	{
		for (; string2[i] != '\0'; i++, j++)
		{
			string3[j] = string2[i];
		}
		string3[j] = '\0'; //在字符串末尾添加字符串结束标志'\0'
	}

	/* 如果数组s1中的字符串比数组s2中的字符串长，将s1中剩余的字符复制到数组s3中的字符串末尾*/
	else if (string1[i] != '\0')
	{
		for (; string1[i] != '\0'; i++, j++)
		{
			string3[j] = string1[i];
		}
		string3[j] = '\0'; //在字符串末尾添加字符串结束标志'\0'
	}

	strcpy(string1, string3); //将数组s3中的字符串复制到数组s1中

}
