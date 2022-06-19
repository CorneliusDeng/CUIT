#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int FindMax(int a, int b)
{
	if (a > b) {
		return a;
	}
	else {
		return b;
	}
}

void Point_Array()
{
	int iArray[] = { 1,2,3,4,5 };
	int *p = NULL;

	p = iArray;
	printf("%d\t", p[0]);
	printf("%d\t", *(++p));
	printf("%d\t", *(p + 2));
	printf("%d\n", *(p--));
	printf("%d\t", *p++);
	printf("%d\t", *p);
	printf("%d\t", ++(*p));
	printf("%d\n", *p);
}

void PerfectNum()
{
	int sum = 0, m = 2,k,j,n,count;
	printf("1000以内的完数：\n");
	for (m; m <= 1000; m++)
	{
		k = m / 2;
		n = 0;s
		count = 0;
		int nums[31];
		for (j = 1; j <= k; j++)
		{
			if (m % j == 0) {
				nums[count] = j;
				count++;
				n = n + j;
			}
		}
		if (m == n) {
			printf("%d = ", m);
			printf("%d", nums[0]);
			for (int y = 1; y < count; y++)
			{
				printf(" + %d", nums[y]);
			}
			putchar('\n');
			sum += m;
		}
	}
}

void swap(int *pa, int *pb)
{
	int temp = *pa;
	*pa = *pb;
	*pb = temp;
}
void ReverseArray(int iArray[], int iCount)
{
	int i;
	printf("原序数组：");
	for (i = 0; i < iCount; i++) {
		printf("%d\t", iArray[i]);
	}
	putchar('\n');
	for (i = 0; i < iCount / 2; i++) {
		swap(&iArray[i], &iArray[iCount - i - 1]);
	}
	printf("逆序数组：");
	for (i = 0; i < iCount; i++) {
		printf("%d\t", iArray[i]);
	}
	putchar('\n');
}

void randomArray(int *array, int n)
{
	int i;

	for (i = 0; i < n; i++)
	{
		*(array + i) = rand() % 100 + 1;
	}
}

void BubbleSort(int iSortArray[], int iSize)
{
	int i, j, k=1;
	printf("排序前数组：");
	for (i = 0; i < iSize; i++) {
		printf("%d\t", iSortArray[i]);
	}
	putchar('\n');

	for (i = 0; i < iSize - 1; i++)
	{
		for (j = iSize - 1; j >= k; j--) {
			if (iSortArray[j - 1] > iSortArray[j]) {
				swap(&iSortArray[j - 1], &iSortArray[j]);
			}
		}
		k++;
	}
	printf("排序后数组：");
	for (i = 0; i < iSize; i++) {
		printf("%d\t", iSortArray[i]);
	}
	putchar('\n');

}

int lenOfStr(char *str)
{
	int i = 0;
	while (*(str + i) != '\0') {
		i++;
	}
	return i;
}



int strCpy(char *dest, char *src) 
{
	int i = 0;
	if (lenOfStr(dest) >= lenOfStr(src))
	{
		while (*(src + i) != '\0')
		{
			*(dest + i) = *(src + i);
			i++;
		}
		*(dest + i) = *(src + i);
		return 1;
	}
	else
	{
		return 0;
	}
}

int strCmp(char *str1, char *str2)
{
	int size = FindMax(lenOfStr(str1), lenOfStr(str2));
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
	else {
		return -1;
	}
}

char *strCat(char *str1, char *str2)
{
	char *str;
	int len1 = lenOfStr(str1), len2 = lenOfStr(str2);
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

void swapChar(char *ch1, char *ch2)
{
	char temp;

	temp = *ch1;
	*ch1 = *ch2;
	*ch2 = temp;
}

void strReverse(char *str)
{
	int i;
	int length = lenOfStr(str);

	for (i = 0; i < length / 2; i++)
	{
		swapChar((str + i), (str + length - i - 1));
	}
}

int main(void)
{
	char str1[] = "Hello world.";
	char str2[13];
	int array[6] = {1, 3, 5, 2, 4, 8};

	srand(time(0));

	Point_Array();

	PerfectNum();

	ReverseArray(array, 6);

	randomArray(array, 6);
	BubbleSort(array, 6);

	// * 字符串长度
	printf("字符串长度: %d\n", lenOfStr(str1));

	// * 字符串复制
	strCpy(str2, str1);

	// * 字符串连接
	printf("连接字符串：“%s” + “%s” = “%s”\n", "Hello", " world", strCat("Hello", " world"));

	// * 字符串比较
	printf("字符串比较结果：%d\n", strCmp("Hello", "Hello"));

	// * 字符串逆序存放
	printf("原字符串：  %s\n", str2);
	strReverse(str2);
	printf("逆序字符串：%s\n", str2);
	return 0;
}