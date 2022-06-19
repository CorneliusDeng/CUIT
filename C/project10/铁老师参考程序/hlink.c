#include "ten.h"


//表头节点的单链表指定位置插入节点
void InsertNodeToHL(LIST *pHead,LIST *newNode,int iPos)
{
	LIST *p,*q;    //为保护头指针pHead不被破坏，定义p,q作为工作指针

	q=pHead;
	p=pHead->next;   
	if (!p) { //原为空表
		pHead->next=newNode;
	    newNode->next=p;
	}
	else {
		while (--iPos) //查找插入位置并用p指示，q为前驱节点
		{
			q=p;
			p=p->next;
			if (p==NULL) break; //已搜索到表尾
		}
		if ((p==NULL) && iPos)  //表中无此节点
		{
			printf("Out of the range, can't insert new node!\n");
		}
		else {
			q->next=newNode;   //将新节点插在q之后，p之前
		    newNode->next=p;
		}
	}
}
         
//表头节点的单链表按值（以姓名为例）查找节点的前驱	
LIST *FindPreNodeHL(LIST *pHead,char *pName)
{
	LIST *p,*q;         //为保护头指针pHead不被破坏，定义p,q作为工作指针

	q = pHead;		    //初始化工作指针q
	p = pHead->next;    //初始化工作指针p

    while(p)
	{
	  if (strcmp(p->name,pName)==0)
		  return q;   //搜索成功，返回节点的前驱
	  q=p;
	  p=p->next;
	}
	return NULL;   //搜索失败，返回NULL
}

//按值（以姓名为例）删除节点的操作
int DeleteNodeHL(LIST *pHead,char *pName)
{
	LIST *p=NULL,*q;

	p=FindPreNodeHL(pHead,pName);
	if (p)   //找到目标节点的前驱
	{
		q=p->next;  
		p->next=q->next;
		free(q);
		return 1;
	}   
    else return 0;
}