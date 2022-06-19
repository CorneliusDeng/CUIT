#include <stdio.h>
 
int main(void)
{
	char c;

	printf("Input a lowercase letter: ");
	scanf("%c", &c);

	printf("\n%c(%d)", c, c);
	c -= 32;     //将小写字母换成大写字母
	printf("\n%c(%d)", c, c);
	return 0;
}
