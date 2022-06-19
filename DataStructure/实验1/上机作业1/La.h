#pragma once//保证头文件只被编译一次
#define _CRT_SECURE_NO_WARNINGS//避免使用scanf函数时出错
#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 100
#define True 1
#define False 0


typedef struct
{
	int *elem; //存储空间的基地址
	int length;		//当前长度
}SqList;

SqList La;

int InitList(SqList *La);//初始化

void KongList(SqList *La);//置空

void FreeList(SqList *La);//销毁

int CalcueList(SqList* La);//求表长

int ListInsert(SqList *La, int i, int e);//插入

int LiseDelete(SqList *La, int i);//删除

int LocateElem(SqList La, int e);//查找

void PrintList(SqList La);//打印

void MergeList(SqList *La, SqList *Lb, SqList *Lc);//归并

void union_Sq(SqList *La, SqList *Lb, SqList *Lc);//求并集

void intersection_Sq(SqList* La, SqList* Lb, SqList* Lc);//求交集