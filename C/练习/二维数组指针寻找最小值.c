#include<stdio.h>

int FindMin1(int *p, int m, int n, int *pRow, int *pCol) //列指针
{
	int  i, j, min;
	min = *p; 
	*pRow = 0; 
	*pCol = 0;                   
	for (i = 0; i < m; i++)
	{
		for (j = 0; j < n; j++)
    	{
			if (p[i * n + j] < min)  //*(p + i * n +j) 等价于 p[i * n + j]
			{
				min = p[i * n + j]; 
				*pRow = i; 
				*pCol = j;           
			}
		} 	
	} 

	return min;
} 

int  FindMin2(int (*p)[4], int m, int n,  int *pRow, int *pCol) //行指针
{
	int  i, j, min;
	min = p[0][0]; 
	*pRow = 0; 
	*pCol = 0;                   
	for (i = 0; i < m; i++)
	{
		for (j = 0; j < n; j++)
		{
		    if (*(*(p + i) + j) < min)  //*(*(p + i) + j) 等价于 p[i][j] 
			{
				min = *(*(p + i) + j); 
				*pRow = i; 
				*pCol = j;           
            } 
	           } 	
	} 
	return (min);
}

int FindMin3(int a[3][4], int m, int n, int *pRow, int *pCol) //二维数组名
{
	int  i, j, min;
	min = a[0][0]; 
	*pRow = 0; 
	*pCol = 0;                   
	for (i = 0; i < m; i++)
	{
		for (j = 0; j < n; j++)
    	{
			if (a[i][j] < min)  
			{
				min = a[j][j]; 
				*pRow = i; 
				*pCol = j;           
			}
		} 	
	} 

	return min;
} 

int main()
{

	int a[3][4], x, y, i, j, min1, min2, min3;

	for (i = 0; i < 3; i++)
	{
		for (j = 0; j < 4; j++)
    	{
			scanf("%d", &a[i][j]);
		}
	}
	
	putchar('\n');
	min1 = FindMin1(*a, 3, 4, &x, &y);//列指针
	min2 = FindMin2(*a, 3, 4, &x, &y);//行指针
	min3 = FindMin2(a, 3, 4, &x, &y);//二维数组名
	printf("min1=%d\ni=%d\nj=%d\n", min1, x, y);
	putchar('\n');
	printf("min2=%d\ni=%d\nj=%d\n", min2, x, y);
	putchar('\n');
	printf("min3=%d\ni=%d\nj=%d\n", min3, x, y);

	return 0;
}



