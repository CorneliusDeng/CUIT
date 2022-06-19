#include "ten.h"


//��ͷ�ڵ�ĵ�����ָ��λ�ò���ڵ�
void InsertNodeToHL(LIST *pHead,LIST *newNode,int iPos)
{
	LIST *p,*q;    //Ϊ����ͷָ��pHead�����ƻ�������p,q��Ϊ����ָ��

	q=pHead;
	p=pHead->next;   
	if (!p) { //ԭΪ�ձ�
		pHead->next=newNode;
	    newNode->next=p;
	}
	else {
		while (--iPos) //���Ҳ���λ�ò���pָʾ��qΪǰ���ڵ�
		{
			q=p;
			p=p->next;
			if (p==NULL) break; //����������β
		}
		if ((p==NULL) && iPos)  //�����޴˽ڵ�
		{
			printf("Out of the range, can't insert new node!\n");
		}
		else {
			q->next=newNode;   //���½ڵ����q֮��p֮ǰ
		    newNode->next=p;
		}
	}
}
         
//��ͷ�ڵ�ĵ�����ֵ��������Ϊ�������ҽڵ��ǰ��	
LIST *FindPreNodeHL(LIST *pHead,char *pName)
{
	LIST *p,*q;         //Ϊ����ͷָ��pHead�����ƻ�������p,q��Ϊ����ָ��

	q = pHead;		    //��ʼ������ָ��q
	p = pHead->next;    //��ʼ������ָ��p

    while(p)
	{
	  if (strcmp(p->name,pName)==0)
		  return q;   //�����ɹ������ؽڵ��ǰ��
	  q=p;
	  p=p->next;
	}
	return NULL;   //����ʧ�ܣ�����NULL
}

//��ֵ��������Ϊ����ɾ���ڵ�Ĳ���
int DeleteNodeHL(LIST *pHead,char *pName)
{
	LIST *p=NULL,*q;

	p=FindPreNodeHL(pHead,pName);
	if (p)   //�ҵ�Ŀ��ڵ��ǰ��
	{
		q=p->next;  
		p->next=q->next;
		free(q);
		return 1;
	}   
    else return 0;
}