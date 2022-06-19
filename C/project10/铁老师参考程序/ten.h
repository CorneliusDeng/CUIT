#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N 3

//将struct student类型定义别名LIST，程序中可用LIST代替struct student
typedef struct student
{
	int num;
	char name[20];
	char ginder;
	int age;
	struct student *next;
}LIST; 


typedef struct node
{
	char cLetter;     //字符串中的字符
	int  iTime;       //字符出现次数
	struct node *next;
}NODE;

int ShowDynamicMem(int iNum);

//不带头节点链表的基本操作
LIST *CreateLList(int n);    //尾插入法，建立链表
LIST *CreateLList1(int n);   //头插入法建立链表
void  OutputLList(LIST *pHead);  //输出链表
LIST *InsertLListNode(LIST *pHead, LIST *newNode, int iPos);   //向链表第iPos个位置插入记录newNode
LIST *DeleteLListNode(LIST *pHead,int iPos);  //删除与给定位置iPos相同的一个结点
int FindLListNode(LIST *pHead,int age);    //查找与给定年龄age相同的第一个记录的位置
LIST *DeleteLListOne(LIST *pHead,int age);    //删除与给定年龄age相同的一个记录
LIST *DeleteLListAll(LIST *pHead,int age);   //删除与给定年龄age相同的所有记录
LIST *CreateLList2(int n);    //调用节点插入函数,头插入法创建链表
int  DeleteLList(LIST *pHead); //删除链表，释放内存空间

//带头节点链表的基本操作
void InsertNodeToHL(LIST *pHead,LIST *newNode,int iPos);  //表头节点的单链表指定位置插入节点
LIST *FindPreNodeHL(LIST *pHead,char *pName);   //表头节点的单链表按值（以姓名为例）查找节点的前驱
int DeleteNodeHL(LIST *pHead,char *pName);   //按值（以姓名为例）删除节点的操作

//带头节点的顺序链表的基本操作
void InsertNodeToSL(LIST *pHead,LIST *newNode);  //顺序单链表插入新节点
LIST *CreateSeqList(int n);                      //创建顺序单链表

//习题4 ：带头节点链表，字符串统计
void ShowLink(NODE *pHead);       //输出链表信息
NODE *SortLink(NODE *pHead);      //链表排序
NODE *InputStr();                 //创建链表保存输入的字符串信息
void DeleteLink(NODE *pHead);     //删除链表 