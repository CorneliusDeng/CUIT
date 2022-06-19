#include<stdio.h>
#include<string.h>

/* GetString的功能是从键盘读入最多n个字符(遇到由endFlag指定的字符或回车则结束读并且该字符和回车
	均视为有效字符)存放在buf所指向的内存中并加上字符串结束符’\0’
	函数返回值为读入的字符个数 */
int GetString(char *buf, char endFlag, int n);

/* CompDigit 的功能是分别统计指针s1、s2、s3、s4所指向的字符串中数字字符的个数，
	将包含最多数字字符(不考虑存在包含相同个数数字字符的情况)的字符串的长度放在指针mLen所指向的
	内存单元中，并通过函数返回值返回该字符串中第1个数字字符的地址 */
char *CompDigit(char *s1, char *s2, char *s3, char *s4, int *mLen);

/* clearRestInput的功能是将前一次读字符后到回车(含回车)之间的字符废弃 */
void clearRestInput(char lastInput);

/* 本部分代码功能建议：考生新增函数原型声明(非必须新增) */
/* User Code Begin(Limit: lines<=2, lineLen<=80, 考生可在本行后添加代码、最多2行、每行长<=80字符) */


/* User Code End(考生添加代码结束。注意：空行和单独为一行的{与}均不计行数、行长不计行首tab缩进) */

int main(void)
{
	char str[4][30], strM[30], endChar, lastChar;
	int totalLen = 0, maxLen = -1, i;
	const int N = 29;

	printf("\ninput endFlag char: ");
	scanf("%c", &endChar);

	for (i=0, lastChar=endChar; i<4; i++)
	{
		clearRestInput(lastChar);
		printf("input string-%d: ", i+1);
		totalLen += GetString(str[i], endChar, N);
		lastChar = str[i][strlen(str[i]) - 1];
	}

	strcpy(strM, CompDigit(str[0], str[1], str[2], str[3], &maxLen));
	printf("\n--------------------------------------------------\n");
	printf("%s, 4Len=%d,  mLen=%d\n", strM, totalLen, maxLen);

	return 0;
}

void clearRestInput(char lastInput)
{
	while (lastInput != '\n')
	{
		lastInput = getchar();
	}
}

/* User Code Begin(考生在此后完成函数GetString和CompDigit的设计，在其中不要使用printf函数，行数不限) */

/* 函数GetString的功能是从键盘读入最多n个字符(遇到由endFlag指定的字符或回车则结束读并且该字符和回车
	均视为有效字符)存放在buf所指向的内存中并加上字符串结束符'\0'，函数返回值为读入的字符个数 */
int GetString(char *buf, char endFlag, int n)
{
	int num = 0;
	char ch;

	scanf("%c", &ch); //从键盘读入一个字符到变量ch中
	/* 从键盘读入最多n个字符并存放到buf指向的内存中, 遇到由endFlag指定的字符或回车则结束读 */
	while ((ch != endFlag) && (ch != '\n'))
	{
		*buf = ch;
		buf++;
		num++; //字符数加1
		if (num >= n)
		{
			break;
		}
		scanf("%c", &ch);
	}
	/* 将endFlag指定的字符或回车存放到buf指向的内存中 */
	if (ch == endFlag || ch == '\n')
	{
		*buf = ch;
		buf++;
		num++;
	}
	*buf = '\0'; //在字符串末尾添加结束标志'\0'
	return num; //返回从键盘读入的字符个数num
}
/* 函数CompDigit的功能是分别统计指针s1、s2、s3、s4所指向的字符串中数字字符的个数，
	将包含最多数字字符(不考虑存在包含相同个数数字字符的情况)的字符串的长度放在指针mLen所指向的
	内存单元中，并通过函数返回值返回该字符串中第1个数字字符的地址 */
char *CompDigit(char *s1, char *s2, char *s3, char *s4, int *mLen)
{
	int i, j, num, max = 0; //变量num用来记录一个字符串中出现的数字字符的个数
	char *first, *maxStr, *str[4] = {s1, s2, s3, s4};
	
	
	for (i=0; i<4; i++)
	{
		/* 统计一个字符串中数字字符的个数 */
		for (num=0, j=0; str[i][j] != '\0'; j++)
		{
			if ((str[i][j] >= '0') && (str[i][j] <= '9'))
			{
				num++; 
				if (1 == num)
				{
					first = &str[i][j]; //将字符串中第1个数字字符的地址赋给指针变量first
				}
			}			
		}
		/* 查找包含最多数字字符个数的字符串 */
		if (num > max)
		{
			max = num;  //将数字字符个数赋给变量max
			*mLen = strlen(str[i]); //将字符串长度赋给指针变量mLen指向的变量
			maxStr = first; //将字符串中第1个数字字符的地址赋给maxStr
		}
	}

	return maxStr;	//返回包含最多数字字符的字符串中第1个数字字符的地址 
}


