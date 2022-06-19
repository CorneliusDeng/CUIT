#include <stdio.h>
#include <malloc.h>

int main(void)
{
	char *str;
	
	str = (char *)malloc(sizeof(char) * 81);

	printf("Please input the string : \n");
	gets(str);
	printf("%s\n", str);

	/*********Found************/
	free(str);
	
	return 0;
}

