#include  <stdio.h>
int main()
{ 
	int i,j,k=0,a;
	char space=' ';	
		for(i=1;i<10;i++)
		printf("%4d",i); //´òÓ¡±íÍ·
	
    	printf("\n---------------------------------------\n");
    	for(i=1;i<10;i++)
		{
			for(a=1;a<=k;a++)
			{
			printf("%4c",space);
			}
			for(j=i;j<10;j++)
				printf("%4d",i*j);
			printf("\n");
			k+=1;
		}
		
	return 0;
}