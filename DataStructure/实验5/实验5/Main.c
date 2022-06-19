#include "Tree.h"

void main()
{
	int depth, leafcount, count;

	/*�������ĵݹ����*/
	printf("���ڿ�ʼ�������������������δӼ�����������(�ԡ�#��Ϊ��Ϊ�����ı�־)\n\n");
	BiTree Tree = CreatBiTree();
	char temp = getchar();		//����س���
	printf("\n[�����������ɹ�]");

	printf("\n\n��������ǰ������������Ľ��\n");
	PreOrderTraverse(Tree);

	printf("\n\n����������������������Ľ��\n");
	InOrderTraverse(Tree);

	printf("\n\n�������Ǻ�������������Ľ��\n");
	PostOrderTraverse(Tree);

	printf("\n\n�����Ķ����������Ϊ��%d", Depth(Tree));

	printf("\n\n�����Ķ�������Ҷ�ӽ�����Ϊ��%d", LeafCount(Tree));

	printf("\n\n�����Ķ������Ľ������Ϊ��%d", Count(Tree));

	/*�������ķǵݹ����*/
	printf("\n\n�������´������������������δӼ�����������(�ԡ�#��Ϊ��Ϊ�����ı�־)\n\n");
	char temp1 = getchar();
	BiTree Tree1 = CreatBiTree();
	printf("\n[�����������ɹ�]");

	printf("\n\n������ǰ������ö������ķǵݹ��㷨�����\n");
	NotRecursionPreOrderTraverse(Tree1);

	printf("\n\n��������������ö������ķǵݹ��㷨�����\n");
	NotRecursionInOrderTraverse(Tree1);

	printf("\n\n�����Ǻ�������ö������ķǵݹ��㷨�����\n");
	NotRecursionPostOrderTraverse(Tree1);

	/*����������*/
	putchar('\n');
	putchar('\n');
	char temp3 = getchar();
	char array[100];
	printf("����������Ҫ������ַ�����\t");
	gets(array);
	int n;
	HuffmanTree HT = CreateHuffmanTree(array, &n);

	printf("\n����������֮��Ϊ��\n");
	HuffmanCode HC = CreateHuffmanCode(HT, n);
	for (int j = 1; j <= n; j++)
	{
		printf("%c:%s\n", HT[j].elem, HC[j]);
	}
	putchar('\n');

	printf("������ַ��������Ϊ��\n%s\n", EnCode(array));
}

/*
������ʵ��
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