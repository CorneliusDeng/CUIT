#pragma once//��֤ͷ�ļ�ֻ������һ��
#define _CRT_SECURE_NO_WARNINGS//����ʹ��scanf����ʱ����
#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 100
#define True 1
#define False 0


typedef struct
{
	int *elem; //�洢�ռ�Ļ���ַ
	int length;		//��ǰ����
}SqList;

SqList La;

int InitList(SqList *La);//��ʼ��

void KongList(SqList *La);//�ÿ�

void FreeList(SqList *La);//����

int CalcueList(SqList* La);//���

int ListInsert(SqList *La, int i, int e);//����

int LiseDelete(SqList *La, int i);//ɾ��

int LocateElem(SqList La, int e);//����

void PrintList(SqList La);//��ӡ

void MergeList(SqList *La, SqList *Lb, SqList *Lc);//�鲢

void union_Sq(SqList *La, SqList *Lb, SqList *Lc);//�󲢼�

void intersection_Sq(SqList* La, SqList* Lb, SqList* Lc);//�󽻼�