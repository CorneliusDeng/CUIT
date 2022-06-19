#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void swap(int *a, int *b)
{
	int basket;

	basket = *a;
	*a = *b;
	*b = basket;
}

int FindMax(int a, int b)
{
	if (a > b) 
	{
		return a;
	}
	else 
	{
		return b;
	}
}

void Point_Array()
{
	int iArray[]={1,2,3,4,5};
	int *p = NULL;

	p=iArray;

	printf("%d\n", p[0]);
	printf("%d\n", *(++p));
	printf("%d\n", *(p+2));
	printf("%d\n", *(p--));
	printf("%d\n", *p++);
	printf("%d\n", *p);
	printf("%d\n", ++(*p));
	printf("%d\n", *p);

}

void PerfectNum()
{
	int i, j, k, s, factor[100];
    for(i=2; i<=1000; ++i)
	{
        s = k = 0;
        for(j=1; j<i; ++j)
		{
            if(i%j==0)
			{
                s += j;
                factor[k++] = j;
            }
        }
        if(s!=i)continue;
        
		printf("%d=%d", i, factor[0]);
        
		for(j=1; j<k; ++j)
		{
            printf("+%d", factor[j]);
		}
        putchar('\n');
    }
}

void ReverseArray(int iArray[],int iCount)
{
	int t, i, k;
	k = iCount/2;

	printf("ÇëÈÎÒâÊäÈëÊ®¸öÕûÊý£º");
	for(i = 0; i < iCount; i++)
	{
		scanf("%d",&iArray[i]);
	}
	
	for(i = 0; i < k; i++)
	{
		t = iArray[i];
		iArray[i] = iArray[iCount-1-i];
		iArray[iCount-1-i] = t;

	}
	printf("ÄæÐò·ÅÖÃºóµÄ½á¹ûÎª£º");
	for(i = 0; i < iCount; i++)
	{
		printf("%-3d",iArray[i]);
	}

	putchar('\n');
	putchar('\n');
}

void randomArray(int *Array, int n)
{
	int i;

	for (i = 0; i < n; i++)
	{
		*(Array + i) = rand() % 100 + 1;
	}
}

void BubbleSort(int iSortArray[], int iSize)
{
	int i, j, k=1;
	
	printf("ÅÅÐòÇ°Êý×é£º");
	for (i = 0; i < iSize; i++) 
	{
		printf("%-4d", iSortArray[i]);
	}
	putchar('\n');

	for (i = 0; i < iSize - 1; i++)
	{
		for (j = 0;j < iSize - 1 -i; j++) 
		{
			if (iSortArray[j] > iSortArray[j + 1]) 
			{
				swap(&iSortArray[j], &iSortArray[j + 1]);
			}
		}
		k++;
	}
	
	printf("Ã°ÅÝÅÅÐòºóÊý£º");
	for (i = 0; i < iSize; i++) {
		printf("%-4d", iSortArray[i]);
	}

	putchar('\n');

}

int lengthStr(char *str)//Çó×Ö·û´®³¤¶È
{
	int i = 0;
	while (*(str + i) != '\0') 
	{
		i++;
	}
	return i;
}

int Copystr(char *str1, char *str2) //×Ö·û´®¸´ÖÆ
{
	int i = 0;
	if (lengthStr(str1) >= lengthStr(str2))
	{
		while (*(str2 + i) != '\0')
		{
			*(str1 + i) = *(str2 + i);
			i++;
		}
		*(str1 + i) = *(str2 + i);
		return 1;
	}
	else
	{
		return 0;
	}
}

char swapChar(char *ch1, char *ch2)//×Ö·û´®½»»»
{
	char temp;

	temp = *ch1;
	*ch1 = *ch2;
	*ch2 = temp;
}

int Cmpstr(char *str1, char *str2)//×Ö·û´®±È½Ï
{
	int size = FindMax(lengthStr(str1), lengthStr(str2));
	int i, big = 0, small = 0, equal = 0;
	
	for (i = 0; i < size; i++)
	{
		if (str1[i] > str2[i])
		{
			big += 1;
		}
		else if (str1[i] < str2[i])
		{
			small += 1;
		}
		else
		{
			equal += 1;
		}
	}
	
	if (big == 0 && small == 0 && equal != 0)
	{
		return 0;
	}
	else if (big > small)
	{
		return 1;
	}
	else 
	{
		return 2;
	}
}

char *Catstr(char *str1, char *str2)//×Ö·û´®Á¬½Ó
{
	char *str;
	int len1 = lengthStr(str1), len2 = lengthStr(str2);
	int i, j;

	str = malloc(sizeof(char) * (len1 + len2 + 1));
	for (i = 0; i < len1; i++)
	{
		*(str + i) = *(str1 + i);
	}
	for (j = 0; j < len2; j++)
	{
		*(str + j + i) = *(str2 + j);
	}
	*(str + j + i) = '\0';

	return str;
}

void strReverse(char *str)//×Ö·û´®ÄæÐò´æ·Å
{
	int i;
	int length = lengthStr(str);

	for (i = 0; i < length / 2; i++)
	{
		swapChar((str + i), (str + length - i - 1));
	}
}

int main()
{
	int Array[10];
	char str1[] = "Cornelius Deng";
	char str2[20];
	char str3[] = "Monkey King";
	char str4[] = "Aron Man";

	Point_Array();

	putchar('\n');
	PerfectNum();
	
	putchar('\n');
	ReverseArray(Array[10], 10);

	srand(time(0));
	randomArray(Array, 10);
	BubbleSort(Array, 10);

	putchar('\n');
	printf("×Ö·û´®µÄ³¤¶È£º%d\n",lengthStr(str1));

	printf("×Ö·û´®¸´ÖÆ  \n");
	Copystr(str2, str1);
	printf("%s\n",str2);

	printf("×Ö·û´®½»»»£º");
	swapChar(str1, str3);
	printf("%s,%s\n",str1,str3);

	printf("×Ö·û´®±È½Ï£º%d\n", Cmpstr(str1, str3));

	printf("×Ö·û´®Á¬½Ó£º%s + %s = %s\n", "Cornelius", "Deng", Catstr("Cornelius ", "Deng"));

	printf("Ô­Ðò×Ö·û´®£º%s\n", str4);
	strReverse(str4);
	printf("ÄæÐò×Ö·û´®£º%s\n", str4);

	return 0;
}