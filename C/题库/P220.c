#include<stdio.h>

int main(void)
{
	int zimu = 0, shuzi = 0, kongge = 0, qita = 0, i;
	char str[128];
	
	printf("Please input string: ");
	gets(str);

	for (i =0; str[i] != '\0'; i++)
	{
		if((str[i] >= 'a' && str [i] <= 'z') || (str[i] >= 'A' && str[i] <= 'Z'))
		{
			zimu++;
		}
		else if (str[i] >= '0' && str[i] <= '9')
		{
			shuzi++;
		}
		else if (str[i] == ' ')
		{
			kongge++;
		}
		else
		{
			qita++;
		}
	}

	printf("\nzimu=%d,shuzi=%d,kongge=%d,qita=%d\n", zimu, shuzi, kongge, qita);

	return 0;
}