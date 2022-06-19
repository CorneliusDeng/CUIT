#include<stdio.h>
#include<string.h>

#define MAX_LINE 5
#define MAX_LINE_LEN 81

/* userCode(<50字符): 自定义函数之原型声明 */
void sortP_Str(char *p[]);

int main(void)        
{
	int i;
	char *pstr[MAX_LINE], str[MAX_LINE][MAX_LINE_LEN];

	for (i=0; i<MAX_LINE; i++)
	{
		pstr[i] = str[i];
	}

	printf("Input 5 strings:\n");
	for (i=0; i<MAX_LINE; i++) 
	{
		gets(pstr[i]);
	}

	sortP_Str(pstr);
	printf("---------------------------\n");
	for (i=0; i<MAX_LINE; i++)
	{
		printf("%s\n", pstr[i]);
	}

	return 0;
}

/* User Code Begin(考生在此后完成自定义函数的设计，行数不限) */
void sortP_Str(char *p[])
{
	int i,j;
	char temp[MAX_LINE_LEN];
	int minid;
	for(i=0;i<MAX_LINE-1;i++)
	{
		minid=i;
		for(j=i+1;j<MAX_LINE;j++)
		{
			if(strcmp(p[j],p[minid])<0)minid=j;
		}
		if(minid != i)//如果后面比前面大的话，就交换位置
		{
			strcpy(temp,p[i]);
            strcpy(p[i],p[minid]);
            strcpy(p[minid],temp);
		}
	}
}