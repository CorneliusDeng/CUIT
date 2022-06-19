#include "head.h"

//用双重指针，T是指向结构体的指针，我要改变T，就得再加一重指针
int InsertBST(BSTree *T, int e)
{//二叉排序树中插入元素e
	if (*T == NULL)
	{
		*T = (BSTree)malloc(sizeof(BSTNode));
		if (*T == NULL) exit(0);
		(*T)->data = e;//新结点的数据域置为e
		(*T)->lchild = (*T)->rchild = NULL;//新结点作为叶子结点
	}
	else if (e < (*T)->data)
	{
		InsertBST(&((*T)->lchild), e);
	}
	else if (e > (*T)->data)
	{
		InsertBST(&((*T)->rchild), e);
	}
}

BSTree CreatBST(int array[], int n)
{//依次读入数据，将此结点插入到二叉排序树T中
	BSTree T;
	T = NULL;//先把二叉排序树初始化为空树
	for (int i = 0; i < n; i++)
	{
		InsertBST(&T, array[i]);
	}
	return T;
}

BSTree SearchBSTree(BSTree T, int e)
{//二叉排序树的查找算法
	if (T == NULL)
	{
		return NULL;
	}
	else
	{
		if (e == T->data)
		{
			return T;
		}
		else if (e < T->data)
		{
			return SearchBSTree(T->lchild, e);
		}
		else if (e > T->data)
		{
			return SearchBSTree(T->rchild, e);
		}
	}
}