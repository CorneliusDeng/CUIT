#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main(void)
{
	int a, b;
	a = 0;

	system("color f5");
	/*�ı䱳�����������ɫ����һ�����ִ�����ɫ���ڶ������ִ���������ɫ���������ֶ���ʮ������
	  ���ֻ��һ�����֣���ֻ������������ɫ*/

	while(a <= 80)
	{
		system("cls");

		b = 1;
		while(b <= a)
		{
			printf(" ");
			b++;
		}
		printf(" O\n");

		b = 1;
		while(b <= a)
		{
			printf(" ");
			b++;
		}
		printf("<H>\n");

		b = 1;
		while(b <= a)
		{
			printf(" ");
			b++;
		}
		printf("I I\n");

		Sleep(100);
		a++;
	}

	system("pause");
	return 0;
}

/*
Ҫ����С�˴��������ܣ�ֻ��Ҫ��a��b�ĸ�ֵ��һЩ���жϾ�д��a>=0
a--��b--����
*/

