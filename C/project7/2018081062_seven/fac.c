int fac()
{
	static int i,s=1;
	for(i=1;i<=5;i++)
	{
		s *= i;
		printf("%d\n",s);
	}
}