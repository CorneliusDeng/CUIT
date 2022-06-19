#include "ten.h"


//尾插入法，建立链表
LIST *CreateLList(int n)
{ 
	LIST *pHead=NULL, *newNode, *pTail;
    int i=0;      	/*链表中的节点个数(初值为0)*/
        
	for(i=0; i<n; i++)         	
    {   /*1、申请一个新节点的空间*/
        newNode=(LIST *)malloc(sizeof(LIST));	
        /*2、输入节点数据域的各数据项*/
        printf("\nInput the infomation of student %d: \n", i+1);
		printf("name:");
        scanf("%s",newNode->name);
		printf("num:");
        scanf("%d",&newNode->num);
		printf("ginder:");
		getchar();
		scanf("%c",&newNode->ginder);
		printf("age:");
        scanf("%d",&newNode->age);
        /*3、置新节点的指针域为空*/
        newNode->next=NULL;
        /*4、将新节点插入到链表尾，并设置新的尾指针*/
        if (i==0)  pHead=newNode;  /*是第一个节点, 置头指针*/
        else  pTail->next=newNode;   /*非首节点, 将新节点插入到链表尾*/
        pTail=newNode;          /*设置新的尾节点*/
    }
    return(pHead);  /*返回头指针*/
}	

//头插入法建立链表的参考程序
LIST *CreateLList1(int n)
{ 
   LIST *pHead = NULL, *newNode;
   int i=0;      	/*链表中的节点个数(初值为0)*/
        
   for(i=0; i<n; i++)         	
   {    /*1、申请一个新节点的空间*/
        newNode = (LIST *)malloc(sizeof(LIST));	
        /*2、输入节点数据域的各数据项*/
        printf("\nInput the infomation of student %d: \n", i+1);
        printf("name:");
        scanf("%s",newNode->name);
        printf("num:");
        scanf("%d",&newNode->num);
        printf("ginder:");
        getchar();
        scanf("%c",&newNode->ginder);
        printf("age:");
        scanf("%d",&newNode->age);
        /*3、置新节点的指针域为空*/
        newNode->next = NULL;
       /*4、将新节点插入到链表头，并设置新的头指针*/
       newNode ->next = pHead;  /*新节点插入表头*/
       pHead=newNode;         /*设置新的头节点*/
    }
    return(pHead);  /*返回头指针*/
}

//输出链表
void  OutputLList(LIST *pHead)
{
	LIST *p=pHead;
    
	while (p!=NULL) {
             printf("\n%d  %s  %c  %d", p->num,p->name,p->ginder, p->age);
             p=p->next;
    }
	printf("\n");
}

//向链表第iPos个位置插入记录newNode
LIST *InsertLListNode(LIST *pHead, LIST *newNode, int iPos)
{
	LIST *p;
   
	if (pHead == NULL)  
	{   /*将新结点插入到一个空链表中*/
		pHead=newNode;    
		newNode->next=NULL; 	
	}
	else  /*非空链表*/
	{
       if (iPos==0)  /*使新结点成为链表新的首结点*/
	   { 
		   newNode->next=pHead;  
		   pHead=newNode; 	
	   }
       else  /*其他位置*/
       {  
		   p = pHead;
           /*查找单链表的第iPos-1个结点，用p指向它*/
           for(  ;  p!=NULL && iPos>1;  p=p->next,  iPos--)  ; 
           if (p == NULL)   		/*越界错*/
               printf("Out of the range, can't insert new node!\n");
           else     	/*一般情况，p指向第i个结点 */
   		   { 
			   newNode->next=p->next;
		       p->next=newNode;   
		   }
       }
    } 
	return(pHead);
}

//删除与给定位置iPos相同的一个结点
LIST *DeleteLListNode(LIST *pHead,int iPos)
{
    LIST *p,*q;

	p=pHead;
	if (iPos==0)  /*删除第一个结点*/
	{ 
		   pHead=p->next;  
		   free(p); 	
	}
    else  /*其他位置*/
    {  
		   q=p;
		   /*查找单链表的第iPos个结点，用p指向它,q指向p的前驱*/
           for(  ;  p!=NULL && iPos>0;   iPos--)
		   {
			   q=p;
			   p=p->next;
		   }
	  
           if (p == NULL)   		/*越界错*/
               printf("Out of the range, can't delete the node!\n");
           else     	/*一般情况，p指向第i个结点 */
   		   { 
			   q->next=p->next;  //p为被删除节点
		       free(p);   
		   }
     }
	return pHead;
}

//查找与给定年龄age相同的第一个记录的位置
int FindLListNode(LIST *pHead,int age)
{
    LIST *p;
	int iPos=0;

	p=pHead;
 	while (p!=NULL)  
	{      
		 if (p->age!=age) 
		 {   
			 iPos++;
			 p=p->next;
		 }
		 else break;
	}
	if (p==NULL) 
			return -1;
	else 
	    return iPos;
}


//删除与给定年龄age相同的一个记录
LIST *DeleteLListOne(LIST *pHead,int age)
{
    LIST *p,*q;

	p=q=pHead;
    if  ( p->age==age) //删除第一个结点
	{ 
		pHead=p->next; 
		free(p); 
	}  
    else 
	{  
		p=p->next;
		while ((p!=NULL)&&(p->age!=age))  //注意两个关系表达式的位置顺序
		{                        
                 q=p;    
				 p=p->next;     //q指示p前一个节点
		}
		if (p==NULL) 
			printf("\nThere isn't the node,exit.");
		else 
		{    
			q->next=p->next;   //p为被删除节点
			free(p);      
		}
	}
    return pHead;
}

//删除与给定年龄age相同的所有记录
LIST *DeleteLListAll(LIST *pHead,int age)
{
    LIST *p,*q;

	p=q=pHead;
    if  ( p->age==age) //删除第一个结点
	{ 
		pHead=p->next; 
		free(p); 
	}  
    else 
	{  
		p=p->next;
		do{	
			while ((p!=NULL)&&(p->age!=age))  //注意两个关系表达式的位置顺序
			{                        
                 q=p;    
				 p=p->next;     //q指示p前一个节点
			}
			if (p==NULL) 
			{
				printf("\nThere isn't the node,exit.");
				break;
			}
			else 
			{    
				q->next=p->next;   //p为被删除节点
				free(p);      
			}
		}while(p=q->next);
     }
     return pHead;
}

//头插入法调用节点插入函数创建链表
LIST *CreateLList2(int n)
{
	LIST *pHead = NULL, *newNode;
    int i=0;      	/*链表中的节点个数(初值为0)*/
        
	for(i=0; i<n; i++)         	
    {    /*1、申请一个新节点的空间*/
        newNode = (LIST *)malloc(sizeof(LIST));	
        /*2、输入节点数据域的各数据项*/
        printf("\nInput the infomation of student %d: \n", i+1);
        printf("name:");
        scanf("%s",newNode->name);
        printf("num:");
        scanf("%d",&newNode->num);
        printf("ginder:");
        getchar();
        scanf("%c",&newNode->ginder);
        printf("age:");
        scanf("%d",&newNode->age);
        /*3、置新节点的指针域为空*/
        newNode->next = NULL;
       /*4、将新节点插入到链表头，并设置新的头指针*/
        pHead=InsertLListNode(pHead,newNode,0);
	}
    return(pHead);  /*返回头指针*/
}

//删除链表，释放内存空间
int  DeleteLList(LIST *pHead)
{
	LIST *p;

	if (!pHead) return 0;       //空表不能释放
	while(pHead!=NULL)      
	{  
		p=pHead;               //p指向当前头节点
		pHead=pHead->next;    //下一个节点将成为头节点
		free(p);             //删除当前节点
	}
	return 1;
}