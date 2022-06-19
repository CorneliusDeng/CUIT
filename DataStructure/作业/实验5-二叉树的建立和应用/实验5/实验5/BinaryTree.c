#include "Tree.h"

BiTree CreatBiTree()
{//���ݸ����Ľ�����������������
	char value;
	value = getchar();
	if (value == '#') return NULL;   //�������#���ݹ������������
	else
	{
		BiTree T = (BiTree)malloc(sizeof(BiTNode)); //���ɸ����
		if (T == NULL) return NULL;
		T->data = value;				//�������������Ϊvalue
		T->lchild = CreatBiTree();		//�ݹ鴴��������
		T->rchild = CreatBiTree();		//�ݹ鴴��������
		return T;
	}

}

void PreOrderTraverse(BiTree T)
{//ǰ������������ĵݹ��㷨
	if (T != NULL)
	{
		printf("%c\t", T->data);
		PreOrderTraverse(T->lchild);  //ǰ����������� 
		PreOrderTraverse(T->rchild);  //ǰ����������� 
	}
}

void InOrderTraverse(BiTree T)
{//��������������ĵݹ��㷨
	if (T != NULL)
	{
		InOrderTraverse(T->lchild);  //������������� 
		printf("%c\t", T->data);
		InOrderTraverse(T->rchild);  //������������� 
	}
}

void PostOrderTraverse(BiTree T)
{//��������������ĵݹ��㷨
	if (T != NULL)
	{
		PostOrderTraverse(T->lchild);  //������������� 
		PostOrderTraverse(T->rchild);  //������������� 
		printf("%c\t", T->data);
	}
}

Status Depth(BiTree T)
{//��������������
	if (T == NULL) return 0;  //����ǿ��������Ϊ0���ݹ����
	else
	{
		int ldepth = Depth(T->lchild);		//�ݹ���������������
		int	rdepth = Depth(T->rchild);		//�ݹ���������������
		if (ldepth > rdepth)
		{
			return ldepth + 1;
		}
		else
		{
			return rdepth + 1;
		}
	}
}

Status LeafCount(BiTree T)
{//ͳ�ƶ�������Ҷ�ӽ�����
	if (T == NULL) return 0;

	if (T->lchild == NULL && T->rchild == NULL)
	{
		return 1;
	}
	else
	{
		int leftleaf = LeafCount(T->lchild);		//�ݹ�ͳ����������Ҷ�ӽ����Ŀ
		int rightleaf = LeafCount(T->rchild);		//�ݹ�ͳ����������Ҷ�ӽ����Ŀ

		return leftleaf + rightleaf;
	}

}

Status Count(BiTree T)
{//ͳ�ƶ������Ľ������
	if (T == NULL) return 0;

	if (T->lchild == NULL && T->rchild == NULL)
	{
		return 1;
	}
	else
	{
		int leftcount = Count(T->lchild);		//�ݹ�ͳ���������Ľ����Ŀ
		int rightcount = Count(T->rchild);		//�ݹ�ͳ���������Ľ����Ŀ

		return leftcount + rightcount + 1;
	}
}

int	NotRecursionPreOrderTraverse(BiTree T)
{//ǰ������������ķǵݹ��㷨

	/*������ջ��ջ�ǿգ�������
	���Ÿ������ҽ���ջ��֮�������ջ��
	���ŵ���ջ��Ԫ�ز����
	ֱ��ջΪ��*/

	if (T == NULL) return 0;

	SqStack S;
	int n = InitStack(&S);

	BiTree p = T;

	if (p != NULL)
	{
		Push(&S, p);
	}

	while (StackEmpty(&S) != Error)
	{
		Pop(&S, &p);
		printf("%c\t", p->data);

		if (p->rchild != NULL)
		{
			Push(&S, p->rchild);
		}
		if (p->lchild != NULL)
		{
			Push(&S, p->lchild);
		}
	}

	return 1;
}

int	NotRecursionInOrderTraverse(BiTree T)
{//�������������T�ķǵݹ��㷨

	/*��ʼ��һ����ջS��ָ��pָ��������ĸ���㡣
	����һ�����ռ�q���������ջ��������Ԫ�ء�
	��p�ǿջ���ջS�ǿ�ʱ��ѭ��ִ�����²�����
		���p�ǿգ���p��ջ��pָ��ý������ӣ�
		���pΪ�գ��򵯳�ջ��Ԫ�ز����ʣ���pָ��ý����Һ��ӡ�*/
	if (T == NULL) return 0;

	SqStack S;
	int n = InitStack(&S);

	BiTree p = T;
	BiTree q = (BiTree)malloc(sizeof(BiTNode));

	while (p != NULL || StackEmpty(&S) != Error)
	{
		if (p != NULL)
		{
			Push(&S, p);	//��ָ���ջ
			p = p->lchild;	//������ָ��������
		}
		else
		{
			Pop(&S, &q);		//һ��һ��Ҷ�ӽ���ջ
			if (q == NULL) return NULL;
			printf("%c\t", q->data);
			p = q->rchild;	//����������
		}
	}
	return 1;
}

int	NotRecursionPostOrderTraverse(BiTree T)
{//��������������ķǵݹ��㷨

	/*������ǰѺ�����������Ľ����Ϊ������������ô����������������������ж�������������˳�򽻻��Ľ��
	��ˣ�ֻ��Ҫ����������ķǵݹ��㷨�ж����������ı���˳�򽻻��Ϳ��Եõ���������������
	Ȼ���ٽ����������Ľ������Ϳ��Եõ���������Ľ���������Ҫ����ջ*/

	if (T == NULL) return 0;

	SqStack S;
	int n = InitStack(&S);		//������������Ľ��
	SqStack result;
	int m = InitStack(&result);  //����������յĽ��

	BiTree p = T;
	BiTree q = (BiTree)malloc(sizeof(BiTNode));
	if (p != NULL)
	{
		Push(&S, p);
	}

	while (StackEmpty(&S) != Error)
	{
		Pop(&S, &q);
		Push(&result, q);

		if (q->lchild != NULL)
		{
			Push(&S, q->lchild);
		}
		if (q->rchild != NULL)
		{
			Push(&S, q->rchild);
		}
		
	}
	while (StackEmpty(&result) != Error)
	{
		Pop(&result, &q);
		printf("%c\t", q->data);
	}

}