#include<stdio.h>
#include<string.h>

void StringBubbleSort(char *MyStrings[], int iCount, int iSortType)
{
	int i, j;
	char **pp, *temp = NULL; //temp为空指针
	pp = MyStrings;
	for(i = 0; i < iCount - 2; i++)
	{
		for(j = 2; j < iCount - i - 1; j++)
		{
			if(iSortType == 1)  //从小到大,正排序
			{
				if(strcmp(pp[j],pp[j+1]) > 0)//字符串的地址就是首字母的地址
				{
					temp = pp[j];
					pp[j] = pp[j+1];
					pp[j+1] = temp;
				}
			}
			else if(iSortType == 0)  //从大到小顺序，逆排序
			{
				if(strcmp(pp[j],pp[j+1]) < 0)
				{
					temp = pp[j];
					pp[j] = pp[j+1];
					pp[j+1] = temp;
				}
			}
		}
	}
}

int main(int argc, char *argv[])
{
	int i, iSortType;

	if(argc < 4)   //至少有两个待排序字符串
	{
		printf("Parameters are not enough. Order Format:\n");
		printf("sort type string1 string2 string...\n");
		return 0;
	}
	iSortType = atoi(argv[1]);//第一个参数 排序方式

	StringBubbleSort(argv, argc, iSortType);//排序处理

	for(i = 2; i < argc; i++)
	{
		printf("%s\n", argv[i]);
	}
	return 1;
}
