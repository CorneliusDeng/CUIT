#include<stdio.h>

int main()
{
	int benjin,cunqi;
	double lixi,lilv;

	printf("Please input benjin,cunqi: ");
	scanf("%d,%d",&benjin,&cunqi);

	if(cunqi == 1)lilv=3.15/100;
	if(cunqi == 2)lilv=3.63/100;
	if(cunqi == 3)lilv=4.02/100;
	if(cunqi == 5)lilv=4.69/100;
	if(cunqi == 8)lilv=5.36/100;

	lixi=benjin*lilv*cunqi;

	printf("\nlixi = %.2f yuan\n",lixi);

	return 0;
}