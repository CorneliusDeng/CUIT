#include <stdio.h>
 
int main(void)
{
	char c;

	printf("Input a lowercase letter: ");
	scanf("%c", &c);

	printf("\n%c(%d)", c, c);
	c -= 32;     //��Сд��ĸ���ɴ�д��ĸ
	printf("\n%c(%d)", c, c);
	return 0;
}
