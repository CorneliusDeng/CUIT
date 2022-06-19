#pragma once//��֤ͷ�ļ�ֻ������һ��
#define _CRT_SECURE_NO_WARNINGS//����ʹ��scanf����ʱ����
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
	int num;          //ר�Һţ����ظ��������ڲ���ר��
	char name[30];   //ר�������������ظ�
}ExpertInformation;

typedef ExpertInformation ET;

typedef struct Lnode
{
	ET data;
	struct Lnode* next;
}LNode, * LinkList;  //���������Ͷ���

LinkList p;//�����ڸ��ֺ����д���L��ָ��

int InitList_L(LinkList L);//����һ����ͷ���Ŀյ�����L

int ListLength_L(LinkList L);//������ĳ���

int GetElem_L(LinkList L, int i, ET* e);//ȡ��L�еĵ�i�����ֵ��ֵ������e

int ListInsert_L(LinkList L, int i, ET e);//�ڱ�L�ĵ�i��λ���ϲ���һ��ֵΪe������Ԫ��

int ListDelete_L(LinkList L, int i, ET* e);//�ڱ�L��ɾ��λ��Ϊ i ������Ԫ�أ�����ɾ����Ԫ�ظ�ֵ��e

int PriorElem_L(LinkList L, ET e, ET* pre_e);//�ڱ�L����Ԫ��e��ֱ��ǰ��Ԫ�أ�����ֵ��pre_e

void PrintList_L(LinkList L);//��ӡ����

void INLIST(LinkList L, int n);//��λ������n��Ԫ�ص�ֵ���������б�ͷ���ĵ�������Ϊһ�����뺯����

int MerList(LinkList La, LinkList Lb, LinkList Lc);//�ϲ�����������

int Reverse(LinkList head);//��������

int PartList(LinkList La, LinkList Lb, LinkList Lc);//������

void FreeL(LinkList Lb);//�ͷ�������Ϣ