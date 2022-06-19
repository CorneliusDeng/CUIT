#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "ten.h"      

//实验5的测试程序
void TestLLinkFuncs()
{
  LIST *pHead,*newNode;
  int  i,age, pos;
   
  pHead=CreateLList(N);   //建立链表
  OutputLList(pHead);     //输出链表，验证建立链表是否正确
  printf("\nInsert the new student to end: ");
  newNode=(LIST *)malloc(sizeof(LIST)); //为新节点分配内存空间
  printf("\nInput the infomation of new student: \n");  //为新节点赋值
  printf("name:");
  scanf("%s",newNode->name);
  printf("num:");
  scanf("%d",&newNode->num);
  printf("ginder:");
  getchar();
  scanf("%c",&newNode->ginder);
  printf("age:");
  scanf("%d",&newNode->age);
  newNode->next=NULL;
  pos=3;          //插入位置为3尾节点
  pHead=InsertLListNode(pHead,newNode,pos);
  OutputLList(pHead);  //输出链表，验证插入链表尾是否正确

  printf("\nInsert the new student to beginning: ");
  newNode=(LIST *)malloc(sizeof(LIST)); //为新节点分配内存空间
  printf("\nInput the infomation of new student: \n");  //为新节点赋值
  printf("name:");
  scanf("%s",newNode->name);
  printf("num:");
  scanf("%d",&newNode->num);
  printf("ginder:");
  getchar();
  scanf("%c",&newNode->ginder);
  printf("age:");
  scanf("%d",&newNode->age);
  newNode->next=NULL;
  pos=0;          //插入位置为头节点
  pHead=InsertLListNode(pHead,newNode,pos);
  OutputLList(pHead);  //输出链表，验证插入链表头是否正确
 
  printf("\nInsert the new student to middle: ");
  newNode=(LIST *)malloc(sizeof(LIST)); //为新节点分配内存空间
  printf("\nInput the infomation of new student: \n");  //为新节点赋值
  printf("name:");
  scanf("%s",newNode->name);
  printf("num:");
  scanf("%d",&newNode->num);
  printf("ginder:");
  getchar();
  scanf("%c",&newNode->ginder);
  printf("age:");
  scanf("%d",&newNode->age);
  newNode->next=NULL;
  pos=2;          //插入位置为中间节点
  pHead=InsertLListNode(pHead,newNode,pos);
  OutputLList(pHead);  //输出链表，验证插入链表中间是否正确
  
  for (i=0; i<4; i++)   //将验证删除位置为表头、表中、表尾的情况
  {                    
	 printf("\nInput an age:"); 
     scanf("%d",&age); //分别输入为表头、表中、表尾节点及表中不存在的age
	 pos=FindLListNode(pHead,age);  //搜索链表中年龄为age的节点
	 if (pos != -1) {
		 pHead=DeleteLListNode(pHead,pos);  //删除链表中年龄为age的节点
	     OutputLList(pHead);    //输出链表，验证链表删除是否正确
     }
	 else printf("\nDon't find."); //搜索失败的情况
  }

  DeleteLList(pHead);   //删除单链表
}


//拓展2的测试程序
void  TestHLinkFuncs()
{
	LIST *pHead,*pNode;
   int i;
	char pName[20];

	pHead=(LIST *)malloc(sizeof(LIST));    //建立头节点
	pHead->next=NULL;

	for (i=1; i<=N; i++)  //调用节点插入函数建立带头节点的单链表
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
		InsertNodeToHL(pHead,pNode,1); //插在头节点之后
	}
	OutputLList(pHead->next); //从头节点后开始显示链表数据，测试链表建立是否成功
   
   //测试按值搜索节点函数
	printf("\nInput a name to find:");  
	scanf("%s",pName);
	pNode=FindPreNodeHL(pHead,pName);   //返回目标节点的前驱
	if (pNode!=NULL) {
	  pNode=pNode->next;
     printf("\nfind:%d %s %c %d",pNode->num,pNode->name,pNode->ginder,pNode->age);
	}
   else printf("\nDon't find.");
  
  //测试按值删除节点函数
  if (DeleteNodeHL(pHead,pName))     
    OutputLList(pHead->next);

   DeleteLList(pHead);  //测试完毕，删除链表
}

//动态内存分配的应用——锯齿数组

int JagArray(void)
{
		int a1 = 5;		//字符串个数
		int a2[] = {7,10,8,7,9};			//每个字符串的长度+1
		int i,j;
		char **jag = NULL;		//用于访问动态字符串数组的二级指针

		jag = (char **)malloc(a1*sizeof(char *));	//动态分配字符指针数组
		if (jag == NULL) return 1;
		for (i = 0; i < a1; i++)		
		{
			jag[i] = (char *)malloc(a2[i]*sizeof(char));	//动态分配存放字符串的空间
			for (j = 0; j<a2[i]-1; j++)			//对该空间赋值，用于测试程序
				*(jag[i]+j) = 'A'+j;
			*(jag[i]+j) = '\0';
		}
		for (i = 0; i < a1; i++)	//依次输出字符串并释放字符串所占空间
		{
			printf("%s\n",jag[i]);		
			free(jag[i]);
		}
		free(jag);		//释放字符指针数组所占空间
		return 0;
}


void main()
{

	//实验题1-2
/*    int i,iNum;

	printf("How many int do you want to store?   ");
	scanf("%d",&iNum);
	for (i=0; i<5000; i++)
	{ 
      printf("\n------------%d times--------------",i+1);
	  if (!ShowDynamicMem(iNum))
		 printf("\n%d times Memory alloc failure.\n",i);
	}
*/
	JagArray();

    //实验题3-5测试
	//TestLLinkFuncs();

/*  //拓展1
    LIST *pHead = NULL;
    pHead=CreateLList2(N);
	OutputLList(pHead);
	DeleteLList(pHead);
*/

	//拓展2测试
    //TestHLinkFuncs();
	
/*    //习题3测试 
	LIST *pHead = NULL;
    pHead=CreateSeqList(N);
	OutputLList(pHead->next);
	DeleteLList(pHead);
*/
    
	//习题4测试 
/*	NODE *pHead=NULL,*newHead;
	pHead=InputStr();
	ShowLink(pHead);
	printf("\nSorted:\n");
    newHead=SortLink(pHead);
    ShowLink(newHead);
	DeleteLink(newHead);
*/
}