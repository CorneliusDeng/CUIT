#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct shangpin
{
	char name[21];
	char guige[11];
	float price;
	int num;
}SP;

int main()
{
	int flag = 0;

	char name[21];
	SP shangpin;
	FILE *fp;
	printf("Please input shang pin pin ming:");
	scanf("%s", name);

	printf("\ncha zhao qing kuang:\n");
	if((fp = fopen("sp.txt","r")) == NULL)
	{
		printf("can not open file!\n");
		exit(0);
	}
	while(fscanf(fp,"%s %s %f %d",shangpin.name,shangpin.guige,&shangpin.price,&shangpin.num) == 4)
	{
		if(strcmp(shangpin.name,name) == 0)
		{
			printf("%s,%s,%d,%.2f\n",shangpin.name,shangpin.guige,shangpin.num,shangpin.price);
			flag = 1;
		}
	}
	if (flag == 0)
	{
		printf("mei you shang pin :%s\n",name);
	}
	fclose(fp);
	return 0;
}