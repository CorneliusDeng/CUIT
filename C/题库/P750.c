#include<stdio.h>

int main(void)
{
	char str1[101], str2[101];
	int i, j;

	printf("Please input a string: ");
	gets(str1);
	putchar('\n');

	for (i = 0, j = 0; str1[i] != '\0'; i++)//�ַ�����str1��û��������ɵ������
	{
		if (str1[i] != '*')//����ַ�����str1��û���ַ�*����ô��������Ӧ��ֵ���ݸ��ַ�����str2
		{
			str2[j] = str1[i];//
			j++;
		}
		
	}
	str2[j] = '\0';//��ѭ��ĩβ�ֶ�Ϊ�ַ�����str2���Ͻ�������

	printf("The Result is:");
	puts(str2);
	putchar('\n');

	return 0;
}
