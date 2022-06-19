#include "ten.h"

//创建链表，接收用户输入字符串
NODE *InputStr()
{
	NODE *pHead,*newNode,*p;
	char myChar;

    pHead=(NODE *)malloc(sizeof(NODE));   //创建头节点
	pHead->next=NULL;
	printf("Input the string:\n");
	while ((myChar=getchar())!='\n')
	{
		p=pHead;
		while (p->next) //非空链表，搜索链表，将字符信息加入链表
		{
            if ((p->next)->cLetter==myChar) //链表中存在该字符
			{
				(p->next)->iTime++;
				break;
			}
			else p=p->next;
        }
		if (p->next==NULL)//空链表或p为尾节点
		{
            newNode=(NODE *)malloc(sizeof(NODE));   //创建新节点
			newNode->cLetter=myChar;                //为新节点赋值
			newNode->iTime=1;
			newNode->next=NULL;
			p->next=newNode;                        //新节点插入链表尾
		}

	}
	return pHead;
}

NODE *SortLink(NODE *pHead)
{
	NODE *newHead,*p,*q;

	newHead=(NODE *)malloc(sizeof(NODE));   //创建新顺序链表头节点
	newHead->next=NULL;

	while (pHead->next)  //原链表不空
	{   
		p=newHead;        //p为新有序链表工作指针

		q=pHead->next;   //q为原链表工作指针，指向待插入节点
        pHead->next=q->next;  //原链表头节点与q的后继节点链接

        while(p->next)  //搜索q在新链表中的插入位置
		{
			if (q->iTime < (p->next)->iTime)  
			    p=p->next;
			else break;
		}
		q->next=p->next; //q插在p之后
        p->next=q;
	}
	free(pHead);           //释放原链表头节点空间
	return newHead;        //返回新有序链表头指针
}

void ShowLink(NODE *pHead)    
{
	NODE *p;
    int n=0;

	p=pHead->next;

	while(p)
	{
		printf("%c(%d)",p->cLetter,p->iTime);   //输出字符和出现次数
		n++;
		if (n%5==0) printf("\n");   //每行输出5组数据
		else printf("\t");
		p=p->next;
	}
}

void DeleteLink(NODE *pHead)   //释放链表空间
{
     NODE *p,*q;

	 p=pHead;
	 while(p)
	 {
		 q=p->next;
		 free(p);
		 p=q;
	 }
}
