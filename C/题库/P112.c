#include<stdio.h>
int main()
{
	int i;
	float chanzhi=5000,x;

	printf("Please input x: ");
	scanf("%f",&x);
	
	for(i=2007;;i++)
	{
		chanzhi=chanzhi*(1+x/100);

		if(chanzhi>10000)
		{
			printf("\nyear = %d nian, chanzhi = %.2f\n",i,chanzhi);break;
		}
	}

}