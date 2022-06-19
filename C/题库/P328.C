#include <stdio.h>
#include <stdlib.h>

int main (void)
{
	FILE *fp;
	char filename[128];
	char ch;

	printf("input the file's name: ");
	gets (filename);
	fp = fopen (filename, "r");
	if (fp == NULL)
	{
		printf("\nfile open error!");
		exit (0);
	}
	printf("------------------------File Begin:----------------------\n");
	ch = fgetc (fp);
	while (!feof (fp))
	{
		putchar (ch);
		ch = fgetc (fp);
	}
	printf("\n------------------------ File End. ----------------------\n");
	fclose (fp);
	return 0;
}
