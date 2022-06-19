#pragma once
#define _CRT_SECURE_NO_WARNINGS//避免使用scanf函数时出错
#include <stdio.h>
#include <stdlib.h>

#define endflag -1111

typedef struct BSTNode
{
	int data;	//每个结点的数据域
	struct BSTNode* lchild, * rchild;//左右孩子指针
}BSTNode, *BSTree;

void HeapAdjust(int K[], int i, int n);//调整一个数列变成大顶堆的非递归算法

void HeapSort(int K[], int n);//堆排序变成递增的数列

int BinarySearch(int array[], int n, int key);//在n个数据大小的array数组中，查找值为key的元素，返回它的下标

void SelectSort(int array[], int n);//选择排序将数列变成递增的

BSTree CreatBST();//依次读入数据，将此结点插入到二叉排序树T中

int InsertBST(BSTree *T, int e);//二叉排序树中插入元素e

BSTree SearchBSTree(BSTree T, int e);//二叉排序树的查找算法