#include<stdio.h>

int main(void)
{
	char cBegin;
	int iCount, i;

	printf("Please Input a char and a number: ");
	scanf("%c%d", &cBegin, &iCount);
	
	printf("\nResult: ");
	for(i = 0; i < iCount; i++)
	{
		printf("%c", cBegin - i);
	}

	putchar('\n');

	return 0;
}
