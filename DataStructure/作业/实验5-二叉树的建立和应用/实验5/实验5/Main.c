#include "Tree.h"

void main()
{
	int depth, leafcount, count;

	/*二叉树的递归操作*/
	printf("现在开始创建二叉树，请您依次从键盘输入内容(以“#”为设为空树的标志)\n\n");
	BiTree Tree = CreatBiTree();
	char temp = getchar();		//读入回车键
	printf("\n[二叉树创建成功]");

	printf("\n\n接下来是前序遍历二叉树的结果\n");
	PreOrderTraverse(Tree);

	printf("\n\n接下来是中序遍历二叉树的结果\n");
	InOrderTraverse(Tree);

	printf("\n\n接下来是后序遍历二叉树的结果\n");
	PostOrderTraverse(Tree);

	printf("\n\n创建的二叉树的深度为：%d", Depth(Tree));

	printf("\n\n创建的二叉树的叶子结点个数为：%d", LeafCount(Tree));

	printf("\n\n创建的二叉树的结点总数为：%d", Count(Tree));

	/*二叉树的非递归操作*/
	printf("\n\n现在重新创建二叉树，请您依次从键盘输入内容(以“#”为设为空树的标志)\n\n");
	char temp1 = getchar();
	BiTree Tree1 = CreatBiTree();
	printf("\n[二叉树创建成功]");

	printf("\n\n以下是前序遍历该二叉树的非递归算法结果：\n");
	NotRecursionPreOrderTraverse(Tree1);

	printf("\n\n以下是中序遍历该二叉树的非递归算法结果：\n");
	NotRecursionInOrderTraverse(Tree1);

	printf("\n\n以下是后序遍历该二叉树的非递归算法结果：\n");
	NotRecursionPostOrderTraverse(Tree1);

	/*哈夫曼编码*/
	putchar('\n');
	putchar('\n');
	char temp3 = getchar();
	char array[100];
	printf("请输入您想要编码的字符串：\t");
	gets(array);
	int n;
	HuffmanTree HT = CreateHuffmanTree(array, &n);

	printf("\n哈夫曼编码之后为：\n");
	HuffmanCode HC = CreateHuffmanCode(HT, n);
	for (int j = 1; j <= n; j++)
	{
		printf("%c:%s\n", HT[j].elem, HC[j]);
	}
	putchar('\n');

	printf("输入的字符串编码后为：\n%s\n", EnCode(array));
}

/*
二叉树实例
								A
						B					F
				C			D
						E		G
ABC##DE##G##F###



								1
						2				3
									4		5
								6
12##346###5##
*/