#include<stdio.h>
#include<string.h>

/* GetString�Ĺ����ǴӼ��̶������n���ַ�(������endFlagָ�����ַ���س�����������Ҹ��ַ��ͻس�
	����Ϊ��Ч�ַ�)�����buf��ָ����ڴ��в������ַ�����������\0��
	��������ֵΪ������ַ����� */
int GetString(char *buf, char endFlag, int n);

/* CompDigit �Ĺ����Ƿֱ�ͳ��ָ��s1��s2��s3��s4��ָ����ַ����������ַ��ĸ�����
	��������������ַ�(�����Ǵ��ڰ�����ͬ���������ַ������)���ַ����ĳ��ȷ���ָ��mLen��ָ���
	�ڴ浥Ԫ�У���ͨ����������ֵ���ظ��ַ����е�1�������ַ��ĵ�ַ */
char *CompDigit(char *s1, char *s2, char *s3, char *s4, int *mLen);

/* clearRestInput�Ĺ����ǽ�ǰһ�ζ��ַ��󵽻س�(���س�)֮����ַ����� */
void clearRestInput(char lastInput);

/* �����ִ��빦�ܽ��飺������������ԭ������(�Ǳ�������) */
/* User Code Begin(Limit: lines<=2, lineLen<=80, �������ڱ��к���Ӵ��롢���2�С�ÿ�г�<=80�ַ�) */


/* User Code End(������Ӵ��������ע�⣺���к͵���Ϊһ�е�{��}�������������г���������tab����) */

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

/* User Code Begin(�����ڴ˺���ɺ���GetString��CompDigit����ƣ������в�Ҫʹ��printf��������������) */

/* ����GetString�Ĺ����ǴӼ��̶������n���ַ�(������endFlagָ�����ַ���س�����������Ҹ��ַ��ͻس�
	����Ϊ��Ч�ַ�)�����buf��ָ����ڴ��в������ַ���������'\0'����������ֵΪ������ַ����� */
int GetString(char *buf, char endFlag, int n)
{
	int num = 0;
	char ch;

	scanf("%c", &ch); //�Ӽ��̶���һ���ַ�������ch��
	/* �Ӽ��̶������n���ַ�����ŵ�bufָ����ڴ���, ������endFlagָ�����ַ���س�������� */
	while ((ch != endFlag) && (ch != '\n'))
	{
		*buf = ch;
		buf++;
		num++; //�ַ�����1
		if (num >= n)
		{
			break;
		}
		scanf("%c", &ch);
	}
	/* ��endFlagָ�����ַ���س���ŵ�bufָ����ڴ��� */
	if (ch == endFlag || ch == '\n')
	{
		*buf = ch;
		buf++;
		num++;
	}
	*buf = '\0'; //���ַ���ĩβ��ӽ�����־'\0'
	return num; //���شӼ��̶�����ַ�����num
}
/* ����CompDigit�Ĺ����Ƿֱ�ͳ��ָ��s1��s2��s3��s4��ָ����ַ����������ַ��ĸ�����
	��������������ַ�(�����Ǵ��ڰ�����ͬ���������ַ������)���ַ����ĳ��ȷ���ָ��mLen��ָ���
	�ڴ浥Ԫ�У���ͨ����������ֵ���ظ��ַ����е�1�������ַ��ĵ�ַ */
char *CompDigit(char *s1, char *s2, char *s3, char *s4, int *mLen)
{
	int i, j, num, max = 0; //����num������¼һ���ַ����г��ֵ������ַ��ĸ���
	char *first, *maxStr, *str[4] = {s1, s2, s3, s4};
	
	
	for (i=0; i<4; i++)
	{
		/* ͳ��һ���ַ����������ַ��ĸ��� */
		for (num=0, j=0; str[i][j] != '\0'; j++)
		{
			if ((str[i][j] >= '0') && (str[i][j] <= '9'))
			{
				num++; 
				if (1 == num)
				{
					first = &str[i][j]; //���ַ����е�1�������ַ��ĵ�ַ����ָ�����first
				}
			}			
		}
		/* ���Ұ�����������ַ��������ַ��� */
		if (num > max)
		{
			max = num;  //�������ַ�������������max
			*mLen = strlen(str[i]); //���ַ������ȸ���ָ�����mLenָ��ı���
			maxStr = first; //���ַ����е�1�������ַ��ĵ�ַ����maxStr
		}
	}

	return maxStr;	//���ذ�����������ַ����ַ����е�1�������ַ��ĵ�ַ 
}


