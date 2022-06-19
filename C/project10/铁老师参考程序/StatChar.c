#include "ten.h"

//�������������û������ַ���
NODE *InputStr()
{
	NODE *pHead,*newNode,*p;
	char myChar;

    pHead=(NODE *)malloc(sizeof(NODE));   //����ͷ�ڵ�
	pHead->next=NULL;
	printf("Input the string:\n");
	while ((myChar=getchar())!='\n')
	{
		p=pHead;
		while (p->next) //�ǿ����������������ַ���Ϣ��������
		{
            if ((p->next)->cLetter==myChar) //�����д��ڸ��ַ�
			{
				(p->next)->iTime++;
				break;
			}
			else p=p->next;
        }
		if (p->next==NULL)//�������pΪβ�ڵ�
		{
            newNode=(NODE *)malloc(sizeof(NODE));   //�����½ڵ�
			newNode->cLetter=myChar;                //Ϊ�½ڵ㸳ֵ
			newNode->iTime=1;
			newNode->next=NULL;
			p->next=newNode;                        //�½ڵ��������β
		}

	}
	return pHead;
}

NODE *SortLink(NODE *pHead)
{
	NODE *newHead,*p,*q;

	newHead=(NODE *)malloc(sizeof(NODE));   //������˳������ͷ�ڵ�
	newHead->next=NULL;

	while (pHead->next)  //ԭ������
	{   
		p=newHead;        //pΪ������������ָ��

		q=pHead->next;   //qΪԭ������ָ�룬ָ�������ڵ�
        pHead->next=q->next;  //ԭ����ͷ�ڵ���q�ĺ�̽ڵ�����

        while(p->next)  //����q���������еĲ���λ��
		{
			if (q->iTime < (p->next)->iTime)  
			    p=p->next;
			else break;
		}
		q->next=p->next; //q����p֮��
        p->next=q;
	}
	free(pHead);           //�ͷ�ԭ����ͷ�ڵ�ռ�
	return newHead;        //��������������ͷָ��
}

void ShowLink(NODE *pHead)    
{
	NODE *p;
    int n=0;

	p=pHead->next;

	while(p)
	{
		printf("%c(%d)",p->cLetter,p->iTime);   //����ַ��ͳ��ִ���
		n++;
		if (n%5==0) printf("\n");   //ÿ�����5������
		else printf("\t");
		p=p->next;
	}
}

void DeleteLink(NODE *pHead)   //�ͷ�����ռ�
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
