#include<stdio.h>
#include<string.h>

int main(void)
{
	char a[128];
	int i, length;
	
	printf("Input a string: ");
    gets(a);
 
	length = strlen(a);

	printf("\nThe result is: ");
	for (i = length - 1; i >= 0; i--)
	{
		printf("%c", a[i]);
	}

	putchar('\n');

	return 0;
}