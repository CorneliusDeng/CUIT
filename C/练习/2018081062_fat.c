#include <stdio.h>
int main()
{
	float t,w,h;

	printf("Please input w and h:");
	scanf("%f,%f",&w,&h);
	t=w/(h*h);

	if (t<18)
	{
		printf("your BodyFatPercentage is %f\nplease increase your diet!\n",t);
	}
	else if (18<=t && t<25)
	{
		printf("your BodyFatPercentage is %f\nPlease maintain!\n",t);
	}
	else if (25<=t && t<27)
	{
		printf("your BodyFatPercentage is %f\nPlease reduce your diet!\n",t);
	}
	else 
	{
		printf("your BodyFatPercentage is %f\nPlease go on a diet,you are too fat!\n",t);
	}
	
	return 0;
}