#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N 3

//��struct student���Ͷ������LIST�������п���LIST����struct student
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
	char cLetter;     //�ַ����е��ַ�
	int  iTime;       //�ַ����ִ���
	struct node *next;
}NODE;

int ShowDynamicMem(int iNum);

//����ͷ�ڵ�����Ļ�������
LIST *CreateLList(int n);    //β���뷨����������
LIST *CreateLList1(int n);   //ͷ���뷨��������
void  OutputLList(LIST *pHead);  //�������
LIST *InsertLListNode(LIST *pHead, LIST *newNode, int iPos);   //�������iPos��λ�ò����¼newNode
LIST *DeleteLListNode(LIST *pHead,int iPos);  //ɾ�������λ��iPos��ͬ��һ�����
int FindLListNode(LIST *pHead,int age);    //�������������age��ͬ�ĵ�һ����¼��λ��
LIST *DeleteLListOne(LIST *pHead,int age);    //ɾ�����������age��ͬ��һ����¼
LIST *DeleteLListAll(LIST *pHead,int age);   //ɾ�����������age��ͬ�����м�¼
LIST *CreateLList2(int n);    //���ýڵ���뺯��,ͷ���뷨��������
int  DeleteLList(LIST *pHead); //ɾ�������ͷ��ڴ�ռ�

//��ͷ�ڵ�����Ļ�������
void InsertNodeToHL(LIST *pHead,LIST *newNode,int iPos);  //��ͷ�ڵ�ĵ�����ָ��λ�ò���ڵ�
LIST *FindPreNodeHL(LIST *pHead,char *pName);   //��ͷ�ڵ�ĵ�����ֵ��������Ϊ�������ҽڵ��ǰ��
int DeleteNodeHL(LIST *pHead,char *pName);   //��ֵ��������Ϊ����ɾ���ڵ�Ĳ���

//��ͷ�ڵ��˳������Ļ�������
void InsertNodeToSL(LIST *pHead,LIST *newNode);  //˳����������½ڵ�
LIST *CreateSeqList(int n);                      //����˳������

//ϰ��4 ����ͷ�ڵ������ַ���ͳ��
void ShowLink(NODE *pHead);       //���������Ϣ
NODE *SortLink(NODE *pHead);      //��������
NODE *InputStr();                 //����������������ַ�����Ϣ
void DeleteLink(NODE *pHead);     //ɾ������ 