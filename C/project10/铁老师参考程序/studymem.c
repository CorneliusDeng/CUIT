#include <stdio.h>
#include <stdlib.h>

/*
˵�����������Ϊʵ��1��ʵ��2���ã����ʵ��1ʱ���轫����ע�ͱ�־//ȥ��
*/
int ShowDynamicMem(int iNum)
{
	int i;
	int *pDMArray=NULL;

	pDMArray=(int *)malloc(iNum*sizeof(int));    /*�����ڴ����򣬴��iNum��������*/
	if (pDMArray) 
	{
		printf("\nFirst area Address:%p",pDMArray);
	 	printf("\nData:");
	 	for (i=0; i<iNum; i++)
	 		printf("%d ",pDMArray[i]);
	}
	else return 0;
//    free(pDMArray);                             /*�ͷ�pDMArray��ָ�洢����*/

    pDMArray=NULL;
	pDMArray=(int *)calloc(iNum,sizeof(int));    /*�����ڴ����򣬴��iNum��������*/
	if (pDMArray) 
	{
		printf("\nSecond area Address:%p",pDMArray);
//	 	printf("\nData:");
//	 	for (i=0; i<iNum; i++)
//	 		printf("%d ",pDMArray[i]);
	}
	else return 0;

    pDMArray=(int *)realloc(pDMArray,2*iNum*sizeof(int));    /*�ͷŲ����·���2����С�ڴ�����*/
	if (pDMArray) 
	{
		printf("\nThird area Address:%p",pDMArray);
//		printf("\nData:");
//	 	for (i=0; i<iNum*2; i++)
//	 		printf("%d ",pDMArray[i]);
	}
	else return 0;
//    free(pDMArray);                                         /*�ͷ�pDMArray��ָ�洢����*/
    printf("\n");

	return 1;
}