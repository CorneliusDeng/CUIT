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


typedef  struct
{
	int num;          //专家号，不重复，可用于查找专家
	char name[30];   //专家姓名，可能重复
}ExpertInformation;

typedef ExpertInformation ET;

typedef struct Lnode
{
	ET data;
	struct Lnode* next;
}LNode, * LinkList;  //链表结点类型定义

LinkList p;//用于在各种函数中代替L的指针

int InitList_L(LinkList L);//构造一个带头结点的空单链表L

int ListLength_L(LinkList L);//求链表的长度

int GetElem_L(LinkList L, int i, ET* e);//取表L中的第i个结点值赋值给参数e

int ListInsert_L(LinkList L, int i, ET e);//在表L的第i个位置上插入一个值为e的数据元素

int ListDelete_L(LinkList L, int i, ET* e);//在表L中删除位序为 i 的数据元素，并将删除的元素赋值给e

int PriorElem_L(LinkList L, ET e, ET* pre_e);//在表L中求元素e的直接前驱元素，并赋值给pre_e

void PrintList_L(LinkList L);//打印链表

void INLIST(LinkList L, int n);//正位序输入n个元素的值，建立带有表头结点的单链表（改为一个输入函数）

int MerList(LinkList La, LinkList Lb, LinkList Lc);//合并两个单链表

int Reverse(LinkList head);//单链表倒置

int PartList(LinkList La, LinkList Lb, LinkList Lc);//链表拆分

void FreeL(LinkList Lb);//释放链表信息