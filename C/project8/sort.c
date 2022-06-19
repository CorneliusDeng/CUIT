#include<stdio.h>
#include<string.h>

void StringBubbleSort(char *MyStrings[], int iCount, int iSortType)
{
	int i, j;
	char **pp, *temp = NULL; //tempΪ��ָ��
	pp = MyStrings;
	for(i = 0; i < iCount - 2; i++)
	{
		for(j = 2; j < iCount - i - 1; j++)
		{
			if(iSortType == 1)  //��С����,������
			{
				if(strcmp(pp[j],pp[j+1]) > 0)//�ַ����ĵ�ַ��������ĸ�ĵ�ַ
				{
					temp = pp[j];
					pp[j] = pp[j+1];
					pp[j+1] = temp;
				}
			}
			else if(iSortType == 0)  //�Ӵ�С˳��������
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

	if(argc < 4)   //�����������������ַ���
	{
		printf("Parameters are not enough. Order Format:\n");
		printf("sort type string1 string2 string...\n");
		return 0;
	}
	iSortType = atoi(argv[1]);//��һ������ ����ʽ

	StringBubbleSort(argv, argc, iSortType);//������

	for(i = 2; i < argc; i++)
	{
		printf("%s\n", argv[i]);
	}
	return 1;
}
