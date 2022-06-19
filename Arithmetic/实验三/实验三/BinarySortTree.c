#include "head.h"

//��˫��ָ�룬T��ָ��ṹ���ָ�룬��Ҫ�ı�T���͵��ټ�һ��ָ��
int InsertBST(BSTree *T, int e)
{//�����������в���Ԫ��e
	if (*T == NULL)
	{
		*T = (BSTree)malloc(sizeof(BSTNode));
		if (*T == NULL) exit(0);
		(*T)->data = e;//�½�����������Ϊe
		(*T)->lchild = (*T)->rchild = NULL;//�½����ΪҶ�ӽ��
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
{//���ζ������ݣ����˽����뵽����������T��
	BSTree T;
	T = NULL;//�ȰѶ�����������ʼ��Ϊ����
	for (int i = 0; i < n; i++)
	{
		InsertBST(&T, array[i]);
	}
	return T;
}

BSTree SearchBSTree(BSTree T, int e)
{//�����������Ĳ����㷨
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