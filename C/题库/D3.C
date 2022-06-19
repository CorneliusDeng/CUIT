#include<stdio.h>

int main(void)
{
        /*********Found************/
        char *yy = "ok??\n";//储存字符，有两种形式，字符数组或者指针

        /*********Found************/
        for (;*yy; yy++)
        {
			putchar(*yy);
        }

	return 0;
}
