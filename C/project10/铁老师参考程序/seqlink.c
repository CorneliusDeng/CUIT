#include "ten.h"


//���һ���������ڵ㺯�������øú�������һ����ͷ�ڵ�İ�ѧ��ѧ�Ŵ�С����������߼�˳������
void InsertNodeToSL(LIST *pHead,LIST *newNode)
{
	LIST *p,*q;  //pָʾ��ǰ�ȽϽڵ㣬q�ǵ�ǰ�ڵ��ǰ��
	
	q=pHead;
	p=pHead->next;   
   	while(p)  //�����ʵ�����λ��p
	{
		if (newNode->num >= p->num)
		{
			q=p;        
		    p=p->next;
		}
		else break;
	}
	q->next=newNode;   //���½ڵ����q֮��,p֮ǰ
	newNode->next=p;
}

LIST *CreateSeqList(int n)
{
    LIST *pHead,*pNode;
    int i;
	
	pHead=(LIST *)malloc(sizeof(LIST));    //����ͷ�ڵ�
	pHead->next=NULL;

	for (i=0; i<n; i++)  //���ýڵ���뺯��������ͷ�ڵ��˳������
	{
		pNode=(LIST *)malloc(sizeof(LIST)); //Ϊ�½ڵ�����ڴ�ռ�
		printf("\nInput the infomation of new student: \n");  //Ϊ�½ڵ㸳ֵ
		printf("name:");
		scanf("%s",pNode->name);
		printf("num:");
		scanf("%d",&pNode->num);
		printf("ginder:");
		getchar();
		scanf("%c",&pNode->ginder);
		printf("age:");
		scanf("%d",&pNode->age);
		InsertNodeToSL(pHead,pNode); //���½ڵ㵽˳������
	}
	return pHead;
}



