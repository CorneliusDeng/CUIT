#include <stdio.h>
#include <stdlib.h>

/*
说明：下面代码为实验1、实验2共用，完成实验1时，需将所有注释标志//去掉
*/
int ShowDynamicMem(int iNum)
{
	int i;
	int *pDMArray=NULL;

	pDMArray=(int *)malloc(iNum*sizeof(int));    /*分配内存区域，存放iNum个整型数*/
	if (pDMArray) 
	{
		printf("\nFirst area Address:%p",pDMArray);
	 	printf("\nData:");
	 	for (i=0; i<iNum; i++)
	 		printf("%d ",pDMArray[i]);
	}
	else return 0;
//    free(pDMArray);                             /*释放pDMArray所指存储区域*/

    pDMArray=NULL;
	pDMArray=(int *)calloc(iNum,sizeof(int));    /*分配内存区域，存放iNum个整型数*/
	if (pDMArray) 
	{
		printf("\nSecond area Address:%p",pDMArray);
//	 	printf("\nData:");
//	 	for (i=0; i<iNum; i++)
//	 		printf("%d ",pDMArray[i]);
	}
	else return 0;

    pDMArray=(int *)realloc(pDMArray,2*iNum*sizeof(int));    /*释放并重新分配2倍大小内存区域*/
	if (pDMArray) 
	{
		printf("\nThird area Address:%p",pDMArray);
//		printf("\nData:");
//	 	for (i=0; i<iNum*2; i++)
//	 		printf("%d ",pDMArray[i]);
	}
	else return 0;
//    free(pDMArray);                                         /*释放pDMArray所指存储区域*/
    printf("\n");

	return 1;
}