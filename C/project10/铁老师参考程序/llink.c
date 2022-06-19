#include "ten.h"


//β���뷨����������
LIST *CreateLList(int n)
{ 
	LIST *pHead=NULL, *newNode, *pTail;
    int i=0;      	/*�����еĽڵ����(��ֵΪ0)*/
        
	for(i=0; i<n; i++)         	
    {   /*1������һ���½ڵ�Ŀռ�*/
        newNode=(LIST *)malloc(sizeof(LIST));	
        /*2������ڵ�������ĸ�������*/
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
        /*3�����½ڵ��ָ����Ϊ��*/
        newNode->next=NULL;
        /*4�����½ڵ���뵽����β���������µ�βָ��*/
        if (i==0)  pHead=newNode;  /*�ǵ�һ���ڵ�, ��ͷָ��*/
        else  pTail->next=newNode;   /*���׽ڵ�, ���½ڵ���뵽����β*/
        pTail=newNode;          /*�����µ�β�ڵ�*/
    }
    return(pHead);  /*����ͷָ��*/
}	

//ͷ���뷨��������Ĳο�����
LIST *CreateLList1(int n)
{ 
   LIST *pHead = NULL, *newNode;
   int i=0;      	/*�����еĽڵ����(��ֵΪ0)*/
        
   for(i=0; i<n; i++)         	
   {    /*1������һ���½ڵ�Ŀռ�*/
        newNode = (LIST *)malloc(sizeof(LIST));	
        /*2������ڵ�������ĸ�������*/
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
        /*3�����½ڵ��ָ����Ϊ��*/
        newNode->next = NULL;
       /*4�����½ڵ���뵽����ͷ���������µ�ͷָ��*/
       newNode ->next = pHead;  /*�½ڵ�����ͷ*/
       pHead=newNode;         /*�����µ�ͷ�ڵ�*/
    }
    return(pHead);  /*����ͷָ��*/
}

//�������
void  OutputLList(LIST *pHead)
{
	LIST *p=pHead;
    
	while (p!=NULL) {
             printf("\n%d  %s  %c  %d", p->num,p->name,p->ginder, p->age);
             p=p->next;
    }
	printf("\n");
}

//�������iPos��λ�ò����¼newNode
LIST *InsertLListNode(LIST *pHead, LIST *newNode, int iPos)
{
	LIST *p;
   
	if (pHead == NULL)  
	{   /*���½����뵽һ����������*/
		pHead=newNode;    
		newNode->next=NULL; 	
	}
	else  /*�ǿ�����*/
	{
       if (iPos==0)  /*ʹ�½���Ϊ�����µ��׽��*/
	   { 
		   newNode->next=pHead;  
		   pHead=newNode; 	
	   }
       else  /*����λ��*/
       {  
		   p = pHead;
           /*���ҵ�����ĵ�iPos-1����㣬��pָ����*/
           for(  ;  p!=NULL && iPos>1;  p=p->next,  iPos--)  ; 
           if (p == NULL)   		/*Խ���*/
               printf("Out of the range, can't insert new node!\n");
           else     	/*һ�������pָ���i����� */
   		   { 
			   newNode->next=p->next;
		       p->next=newNode;   
		   }
       }
    } 
	return(pHead);
}

//ɾ�������λ��iPos��ͬ��һ�����
LIST *DeleteLListNode(LIST *pHead,int iPos)
{
    LIST *p,*q;

	p=pHead;
	if (iPos==0)  /*ɾ����һ�����*/
	{ 
		   pHead=p->next;  
		   free(p); 	
	}
    else  /*����λ��*/
    {  
		   q=p;
		   /*���ҵ�����ĵ�iPos����㣬��pָ����,qָ��p��ǰ��*/
           for(  ;  p!=NULL && iPos>0;   iPos--)
		   {
			   q=p;
			   p=p->next;
		   }
	  
           if (p == NULL)   		/*Խ���*/
               printf("Out of the range, can't delete the node!\n");
           else     	/*һ�������pָ���i����� */
   		   { 
			   q->next=p->next;  //pΪ��ɾ���ڵ�
		       free(p);   
		   }
     }
	return pHead;
}

//�������������age��ͬ�ĵ�һ����¼��λ��
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


//ɾ�����������age��ͬ��һ����¼
LIST *DeleteLListOne(LIST *pHead,int age)
{
    LIST *p,*q;

	p=q=pHead;
    if  ( p->age==age) //ɾ����һ�����
	{ 
		pHead=p->next; 
		free(p); 
	}  
    else 
	{  
		p=p->next;
		while ((p!=NULL)&&(p->age!=age))  //ע��������ϵ���ʽ��λ��˳��
		{                        
                 q=p;    
				 p=p->next;     //qָʾpǰһ���ڵ�
		}
		if (p==NULL) 
			printf("\nThere isn't the node,exit.");
		else 
		{    
			q->next=p->next;   //pΪ��ɾ���ڵ�
			free(p);      
		}
	}
    return pHead;
}

//ɾ�����������age��ͬ�����м�¼
LIST *DeleteLListAll(LIST *pHead,int age)
{
    LIST *p,*q;

	p=q=pHead;
    if  ( p->age==age) //ɾ����һ�����
	{ 
		pHead=p->next; 
		free(p); 
	}  
    else 
	{  
		p=p->next;
		do{	
			while ((p!=NULL)&&(p->age!=age))  //ע��������ϵ���ʽ��λ��˳��
			{                        
                 q=p;    
				 p=p->next;     //qָʾpǰһ���ڵ�
			}
			if (p==NULL) 
			{
				printf("\nThere isn't the node,exit.");
				break;
			}
			else 
			{    
				q->next=p->next;   //pΪ��ɾ���ڵ�
				free(p);      
			}
		}while(p=q->next);
     }
     return pHead;
}

//ͷ���뷨���ýڵ���뺯����������
LIST *CreateLList2(int n)
{
	LIST *pHead = NULL, *newNode;
    int i=0;      	/*�����еĽڵ����(��ֵΪ0)*/
        
	for(i=0; i<n; i++)         	
    {    /*1������һ���½ڵ�Ŀռ�*/
        newNode = (LIST *)malloc(sizeof(LIST));	
        /*2������ڵ�������ĸ�������*/
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
        /*3�����½ڵ��ָ����Ϊ��*/
        newNode->next = NULL;
       /*4�����½ڵ���뵽����ͷ���������µ�ͷָ��*/
        pHead=InsertLListNode(pHead,newNode,0);
	}
    return(pHead);  /*����ͷָ��*/
}

//ɾ�������ͷ��ڴ�ռ�
int  DeleteLList(LIST *pHead)
{
	LIST *p;

	if (!pHead) return 0;       //�ձ����ͷ�
	while(pHead!=NULL)      
	{  
		p=pHead;               //pָ��ǰͷ�ڵ�
		pHead=pHead->next;    //��һ���ڵ㽫��Ϊͷ�ڵ�
		free(p);             //ɾ����ǰ�ڵ�
	}
	return 1;
}