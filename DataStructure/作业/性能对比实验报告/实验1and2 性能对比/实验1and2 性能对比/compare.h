#pragma once//保证头文件只被编译一次
#define _CRT_SECURE_NO_WARNINGS//避免使用scanf函数时出错
#include <stdio.h>
#include <stdlib.h>

#include<time.h>

#define True  1
#define False  0
#define OK  111
#define Error  -111
#define List_Init_Size   10
#define ListIncrement   10
#define MAXSIZE 10000000000000

//顺序表
typedef struct
{
	int* elem; //存储空间的基地址
	int length;		//当前长度
}SqList;

SqList La;


//链表
typedef struct Lnode
{
	int data;
	struct Lnode* next;
}LNode, * LinkList;  //链表结点类型定义
LinkList p;//用于在各种函数中代替L的指针

/*顺序表函数声明*/
int LocateElem(SqList La, int e, int *index);//定位元素

int ListInsert(SqList* La, int i, int e);//插入元素

int LiseDelete(SqList* La, int i);//删除元素

int InitList(SqList* La);//初始化

int CalcueList(SqList* La);//求顺序表长度

void PrintList(SqList La);//打印顺序表

/*链表函数声明*/
int ListLocate(LinkList L, int e, int *location);//定位元素

int ListInsert_L(LinkList L, int i, int e);//插入元素

int ListDelete_L(LinkList L, int i);//删除元素

int InitList_L(LinkList L);//初始化

int ListLength_L(LinkList L);//求链表长度

void PrintList_L(LinkList L);//打印结点元素值