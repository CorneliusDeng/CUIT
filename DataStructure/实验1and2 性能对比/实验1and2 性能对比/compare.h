#pragma once//��֤ͷ�ļ�ֻ������һ��
#define _CRT_SECURE_NO_WARNINGS//����ʹ��scanf����ʱ����
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

//˳���
typedef struct
{
	int* elem; //�洢�ռ�Ļ���ַ
	int length;		//��ǰ����
}SqList;

SqList La;


//����
typedef struct Lnode
{
	int data;
	struct Lnode* next;
}LNode, * LinkList;  //���������Ͷ���
LinkList p;//�����ڸ��ֺ����д���L��ָ��

/*˳���������*/
int LocateElem(SqList La, int e, int *index);//��λԪ��

int ListInsert(SqList* La, int i, int e);//����Ԫ��

int LiseDelete(SqList* La, int i);//ɾ��Ԫ��

int InitList(SqList* La);//��ʼ��

int CalcueList(SqList* La);//��˳�����

void PrintList(SqList La);//��ӡ˳���

/*����������*/
int ListLocate(LinkList L, int e, int *location);//��λԪ��

int ListInsert_L(LinkList L, int i, int e);//����Ԫ��

int ListDelete_L(LinkList L, int i);//ɾ��Ԫ��

int InitList_L(LinkList L);//��ʼ��

int ListLength_L(LinkList L);//��������

void PrintList_L(LinkList L);//��ӡ���Ԫ��ֵ