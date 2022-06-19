#include "ten.h"


//设计一个链表插入节点函数，利用该函数创建一个带头节点的按学生学号从小到大排序的逻辑顺序链表
void InsertNodeToSL(LIST *pHead,LIST *newNode)
{
	LIST *p,*q;  //p指示当前比较节点，q是当前节点的前驱
	
	q=pHead;
	p=pHead->next;   
   	while(p)  //搜索适当插入位置p
	{
		if (newNode->num >= p->num)
		{
			q=p;        
		    p=p->next;
		}
		else break;
	}
	q->next=newNode;   //将新节点插在q之后,p之前
	newNode->next=p;
}

LIST *CreateSeqList(int n)
{
    LIST *pHead,*pNode;
    int i;
	
	pHead=(LIST *)malloc(sizeof(LIST));    //建立头节点
	pHead->next=NULL;

	for (i=0; i<n; i++)  //调用节点插入函数建立带头节点的顺序单链表
	{
		pNode=(LIST *)malloc(sizeof(LIST)); //为新节点分配内存空间
		printf("\nInput the infomation of new student: \n");  //为新节点赋值
		printf("name:");
		scanf("%s",pNode->name);
		printf("num:");
		scanf("%d",&pNode->num);
		printf("ginder:");
		getchar();
		scanf("%c",&pNode->ginder);
		printf("age:");
		scanf("%d",&pNode->age);
		InsertNodeToSL(pHead,pNode); //插新节点到顺序单链表
	}
	return pHead;
}



