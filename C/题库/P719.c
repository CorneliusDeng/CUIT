#include <stdio.h>
#include <string.h>

int main(void)
{
	char arr[5][80], temp[80];
	int i, j;

	printf("Input 5 strings:\n");
	for (i = 0; i < 5; i++)
	{
		gets(arr[i]);
	}

	for (i = 0; i < 4; i++)
	{
		for (j = 0; j < 4 - i; j++)
		{
			if (strcmp(arr[j], arr[j+1]) > 0)
			{
				strcpy(temp, arr[j]);
				strcpy(arr[j], arr[j+1]);
				strcpy(arr[j+1], temp);
			}
		}
	}

	printf("---------------------------\n");
	for (i = 0; i < 5; i++)
	{
		puts(arr[i]);
	}

	return 0;
}