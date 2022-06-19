#pragma once//保证头文件只被编译一次
#define _CRT_SECURE_NO_WARNINGS//避免使用scanf函数时出错
#include <stdio.h>
#include <stdlib.h>

#define True  1
#define False  0
#define OK  111
#define Error  -111
#define List_Init_Size   10
#define ListIncrement   10
#define MAXSIZE 100

typedef int ET;
typedef int Status;

typedef struct LNode
{
	ET data;
	struct LNode* next;
}LNode, *LinkList;

Status InitList_L(LinkList L);

Status ListInsert_L(LinkList L, int i, ET e);

void PrintList_L(LinkList L);

Status SelectList_L(LinkList L, int minK, int maxK);