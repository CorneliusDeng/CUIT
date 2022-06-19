#pragma once
#define _CRT_SECURE_NO_WARNINGS//避免使用scanf函数时出错
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define True  11 
#define False  0 
#define OK  111 
#define Error  -111 
#define Stack_Init_Size 10 
#define StackIncrement 10
#define MAX_WEIGHT 10000
#define MAX_SIZE 10000
#define NULL_CHAR '*'

typedef int Status;		//状态类型
typedef int SElemType;	//元素类型
typedef char** HuffmanCode;//动态分配数组存储哈夫曼编码表
typedef char HuffType;


typedef struct BiTNode
{
	char data;		//结点数据域
	struct BiTNode* lchild;
	struct BiTNode* rchild;	//左右孩子指针
}BiTNode, * BiTree;

typedef struct
{
	SElemType* base;		//栈底指针
	SElemType* top;		//栈顶指针
	int stacksize;	//栈可用的最大容量
}SqStack;

typedef struct 
{
	char key;
	int value;
}HuffmanKV, * HuffmanKVSet;             // （字符:频数）键值对

typedef struct 
{
	int weight;//结点的权值
	HuffType elem;          // 字符元素，空结点字符暂时定为'*'
	int parent, lchild, rchild;//结点的双亲、左右孩子下标
}HTNode, * HuffmanTree;


BiTree CreatBiTree();//根据给定的结点个数建立二叉链表

void PreOrderTraverse(BiTree T);//前序遍历二叉树的递归算法

void InOrderTraverse(BiTree T);//中序遍历二叉树的递归算法

void PostOrderTraverse(BiTree T);//后序遍历二叉树的递归算法

int Depth(BiTree T);//计算二叉树的深度

int LeafCount(BiTree T);//统计二叉树的叶子结点数目

int Count(BiTree T);//统计二叉树的结点总数

int	NotRecursionPreOrderTraverse(BiTree T);//前序遍历二叉树T的非递归算法

int NotRecursionInOrderTraverse(BiTree T);//中序遍历二叉树T的非递归算法

int	NotRecursionPostOrderTraverse(BiTree T);//后序遍历二叉树的非递归算法

Status InitStack(SqStack* S);//຅构造一个初始容量为Stack_Init_Size的空顺序栈S

Status StackEmpty(SqStack* S);//判断栈是否为空

Status Push(SqStack* S, SElemType e);//将值为e的数据压入栈S

Status Pop(SqStack* S, SElemType* e);//从栈S中弹出一个元素赋给e

HuffmanKVSet getHuffmanCharSet(char* array, int* size);// 获得字符串中每个字符的频数并储存在一个（字符:频数）键值对集合中
									 
HuffmanTree CreateHuffmanTree(HuffType* array, int* size);// 通过字符串创建Huffman树，并返回结点个数
									 
HuffmanCode CreateHuffmanCode(HuffmanTree HT, int n);//通过哈夫曼树得出每个字符的编码

char* EnCode(char* message);

									 
/*void Select(HuffmanTree HT, int n, int *s1, int *s2);//在叶子结点中找最小的两个数据

void CreatHuffmanTree(HuffmanTree HT, int n);//构造哈夫曼树

void CreatHuffmanCode(HuffmanTree HT, HuffmanCode HC, int n);//从叶子到根逆向求每个字符的哈夫曼编码，存储在编码表HC中

void Huffmantrans(HuffmanTree HT, int n, char* ch);//哈夫曼树解码*/
