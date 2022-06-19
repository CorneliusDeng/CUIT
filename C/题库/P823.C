#include <stdio.h>

#define MAX 20

/* userCode(<80字符): 自定义函数之原型声明 */
void change(int a[MAX][MAX],int b[MAX][MAX],int n);

int main(void)
{
	int arrayA[MAX][MAX], arrayB[MAX][MAX], i, j, m;

	printf("Please input m: ");
	scanf("%d", &m);

	printf("Please input arrayA:\n");
	for (i=0; i<m; i++)
	{
		for (j=0; j<m; j++)
		{
			scanf("%d", &arrayA[i][j]);
		}
	}

	change(arrayA,arrayB,m);  /* userCode(<60字符): 调用函数实现数组内容变换 */
	printf("\nafter rotate:\n");
	for (i=0; i<m; i++)
	{
		for (j=0; j<m; j++)
		{
			printf("%6d", arrayB[i][j]);
		}
		putchar('\n');
	}

	return 0;
}

/* User Code Begin：考生在此后完成自定义函数的设计，行数不限 */
void change(int a[MAX][MAX],int b[MAX][MAX],int n)
{
	int i,j;
	
	for (i=0; i<n; i++)
	{
		for (j=0; j<n; j++)
		{
			b[i][j]=a[i][j];
		}
	}
	for(i=0,j=0;i<n,j<n;i++,j++)
	{
		b[i][0]=a[n-1][j];
	}
	for(i=0,j=0;i<n,j<n;i++,j++)
	{
		b[i][n-1]=a[0][j];
	}
}


