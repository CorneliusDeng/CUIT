#pragma once
#define _CRT_SECURE_NO_WARNINGS//����ʹ��scanf����ʱ����
#include <stdio.h>
#include <stdlib.h>

#define endflag -1111

typedef struct BSTNode
{
	int data;	//ÿ������������
	struct BSTNode* lchild, * rchild;//���Һ���ָ��
}BSTNode, *BSTree;

void HeapAdjust(int K[], int i, int n);//����һ�����б�ɴ󶥶ѵķǵݹ��㷨

void HeapSort(int K[], int n);//�������ɵ���������

int BinarySearch(int array[], int n, int key);//��n�����ݴ�С��array�����У�����ֵΪkey��Ԫ�أ����������±�

void SelectSort(int array[], int n);//ѡ���������б�ɵ�����

BSTree CreatBST();//���ζ������ݣ����˽����뵽����������T��

int InsertBST(BSTree *T, int e);//�����������в���Ԫ��e

BSTree SearchBSTree(BSTree T, int e);//�����������Ĳ����㷨