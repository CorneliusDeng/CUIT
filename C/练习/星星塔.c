#include <stdio.h>
#include <stdlib.h>

int main()

{
int i,j,k;
char space=' ';
for(i=1;i<=4;i++)
{
	for(j=3;j>=i;j--)
	{
		printf("%c",space);

    }
	for(k=1;k<=(2*i-1);k=k+1)
	{
		printf("*");
	}
	printf("\n");
}
}