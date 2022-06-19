#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main(void)
{
	int a, b;
	a = 0;

	system("color f5");
	/*改变背景板和文字颜色，第一个数字代表背景色，第二个数字代表文字颜色，两个数字都是十六进制
	  如果只有一个数字，则只设置了文字颜色*/

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
要是让小人从右往左跑，只需要对a，b的赋值大一些，判断句写成a>=0
a--，b--即可
*/

