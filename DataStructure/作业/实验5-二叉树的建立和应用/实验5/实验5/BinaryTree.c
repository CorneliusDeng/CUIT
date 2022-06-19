#include "Tree.h"

BiTree CreatBiTree()
{//根据给定的结点个数建立二叉链表
	char value;
	value = getchar();
	if (value == '#') return NULL;   //如果输入#，递归结束，建空树
	else
	{
		BiTree T = (BiTree)malloc(sizeof(BiTNode)); //生成根结点
		if (T == NULL) return NULL;
		T->data = value;				//根结点数据域置为value
		T->lchild = CreatBiTree();		//递归创建左子树
		T->rchild = CreatBiTree();		//递归创建右子树
		return T;
	}

}

void PreOrderTraverse(BiTree T)
{//前序遍历二叉树的递归算法
	if (T != NULL)
	{
		printf("%c\t", T->data);
		PreOrderTraverse(T->lchild);  //前序遍历左子树 
		PreOrderTraverse(T->rchild);  //前序遍历右子树 
	}
}

void InOrderTraverse(BiTree T)
{//中序遍历二叉树的递归算法
	if (T != NULL)
	{
		InOrderTraverse(T->lchild);  //中序遍历左子树 
		printf("%c\t", T->data);
		InOrderTraverse(T->rchild);  //中序遍历右子树 
	}
}

void PostOrderTraverse(BiTree T)
{//后序遍历二叉树的递归算法
	if (T != NULL)
	{
		PostOrderTraverse(T->lchild);  //后序遍历左子树 
		PostOrderTraverse(T->rchild);  //后序遍历右子树 
		printf("%c\t", T->data);
	}
}

Status Depth(BiTree T)
{//计算二叉树的深度
	if (T == NULL) return 0;  //如果是空树，深度为0，递归结束
	else
	{
		int ldepth = Depth(T->lchild);		//递归计算左子树的深度
		int	rdepth = Depth(T->rchild);		//递归计算右子树的深度
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
{//统计二叉树的叶子结点个数
	if (T == NULL) return 0;

	if (T->lchild == NULL && T->rchild == NULL)
	{
		return 1;
	}
	else
	{
		int leftleaf = LeafCount(T->lchild);		//递归统计左子树的叶子结点数目
		int rightleaf = LeafCount(T->rchild);		//递归统计右子树的叶子结点数目

		return leftleaf + rightleaf;
	}

}

Status Count(BiTree T)
{//统计二叉树的结点总数
	if (T == NULL) return 0;

	if (T->lchild == NULL && T->rchild == NULL)
	{
		return 1;
	}
	else
	{
		int leftcount = Count(T->lchild);		//递归统计左子树的结点数目
		int rightcount = Count(T->rchild);		//递归统计右子树的结点数目

		return leftcount + rightcount + 1;
	}
}

int	NotRecursionPreOrderTraverse(BiTree T)
{//前序遍历二叉树的非递归算法

	/*根结点进栈，栈非空，弹出；
	接着根结点的右结点进栈，之后左结点进栈，
	接着弹出栈顶元素并输出
	直到栈为空*/

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
{//中序遍历二叉树T的非递归算法

	/*初始化一个空栈S，指针p指向二叉树的根结点。
	申请一个结点空间q，用来存放栈顶弹出的元素。
	当p非空或者栈S非空时，循环执行以下操作：
		如果p非空，则将p进栈，p指向该结点的左孩子；
		如果p为空，则弹出栈顶元素并访问，将p指向该结点的右孩子。*/
	if (T == NULL) return 0;

	SqStack S;
	int n = InitStack(&S);

	BiTree p = T;
	BiTree q = (BiTree)malloc(sizeof(BiTNode));

	while (p != NULL || StackEmpty(&S) != Error)
	{
		if (p != NULL)
		{
			Push(&S, p);	//根指针进栈
			p = p->lchild;	//遍历根指针左子树
		}
		else
		{
			Pop(&S, &q);		//一层一层叶子结点出栈
			if (q == NULL) return NULL;
			printf("%c\t", q->data);
			p = q->rchild;	//遍历右子树
		}
	}
	return 1;
}

int	NotRecursionPostOrderTraverse(BiTree T)
{//后序遍历二叉树的非递归算法

	/*如果我们把后序遍历逆序后的结果称为逆后序遍历，那么逆后序遍历不过是先序遍历中对左右子树遍历顺序交换的结果
	因此，只需要将先序遍历的非递归算法中对左右子树的遍历顺序交换就可以得到逆后序遍历的序列
	然后再将逆后序遍历的结果逆序就可以得到后序遍历的结果，因此需要两个栈*/

	if (T == NULL) return 0;

	SqStack S;
	int n = InitStack(&S);		//存放逆后序遍历的结果
	SqStack result;
	int m = InitStack(&result);  //用来存放最终的结果

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