#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "ten.h"      

//ʵ��5�Ĳ��Գ���
void TestLLinkFuncs()
{
  LIST *pHead,*newNode;
  int  i,age, pos;
   
  pHead=CreateLList(N);   //��������
  OutputLList(pHead);     //���������֤���������Ƿ���ȷ
  printf("\nInsert the new student to end: ");
  newNode=(LIST *)malloc(sizeof(LIST)); //Ϊ�½ڵ�����ڴ�ռ�
  printf("\nInput the infomation of new student: \n");  //Ϊ�½ڵ㸳ֵ
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
  pos=3;          //����λ��Ϊ3β�ڵ�
  pHead=InsertLListNode(pHead,newNode,pos);
  OutputLList(pHead);  //���������֤��������β�Ƿ���ȷ

  printf("\nInsert the new student to beginning: ");
  newNode=(LIST *)malloc(sizeof(LIST)); //Ϊ�½ڵ�����ڴ�ռ�
  printf("\nInput the infomation of new student: \n");  //Ϊ�½ڵ㸳ֵ
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
  pos=0;          //����λ��Ϊͷ�ڵ�
  pHead=InsertLListNode(pHead,newNode,pos);
  OutputLList(pHead);  //���������֤��������ͷ�Ƿ���ȷ
 
  printf("\nInsert the new student to middle: ");
  newNode=(LIST *)malloc(sizeof(LIST)); //Ϊ�½ڵ�����ڴ�ռ�
  printf("\nInput the infomation of new student: \n");  //Ϊ�½ڵ㸳ֵ
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
  pos=2;          //����λ��Ϊ�м�ڵ�
  pHead=InsertLListNode(pHead,newNode,pos);
  OutputLList(pHead);  //���������֤���������м��Ƿ���ȷ
  
  for (i=0; i<4; i++)   //����֤ɾ��λ��Ϊ��ͷ�����С���β�����
  {                    
	 printf("\nInput an age:"); 
     scanf("%d",&age); //�ֱ�����Ϊ��ͷ�����С���β�ڵ㼰���в����ڵ�age
	 pos=FindLListNode(pHead,age);  //��������������Ϊage�Ľڵ�
	 if (pos != -1) {
		 pHead=DeleteLListNode(pHead,pos);  //ɾ������������Ϊage�Ľڵ�
	     OutputLList(pHead);    //���������֤����ɾ���Ƿ���ȷ
     }
	 else printf("\nDon't find."); //����ʧ�ܵ����
  }

  DeleteLList(pHead);   //ɾ��������
}


//��չ2�Ĳ��Գ���
void  TestHLinkFuncs()
{
	LIST *pHead,*pNode;
   int i;
	char pName[20];

	pHead=(LIST *)malloc(sizeof(LIST));    //����ͷ�ڵ�
	pHead->next=NULL;

	for (i=1; i<=N; i++)  //���ýڵ���뺯��������ͷ�ڵ�ĵ�����
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
		InsertNodeToHL(pHead,pNode,1); //����ͷ�ڵ�֮��
	}
	OutputLList(pHead->next); //��ͷ�ڵ��ʼ��ʾ�������ݣ������������Ƿ�ɹ�
   
   //���԰�ֵ�����ڵ㺯��
	printf("\nInput a name to find:");  
	scanf("%s",pName);
	pNode=FindPreNodeHL(pHead,pName);   //����Ŀ��ڵ��ǰ��
	if (pNode!=NULL) {
	  pNode=pNode->next;
     printf("\nfind:%d %s %c %d",pNode->num,pNode->name,pNode->ginder,pNode->age);
	}
   else printf("\nDon't find.");
  
  //���԰�ֵɾ���ڵ㺯��
  if (DeleteNodeHL(pHead,pName))     
    OutputLList(pHead->next);

   DeleteLList(pHead);  //������ϣ�ɾ������
}

//��̬�ڴ�����Ӧ�á����������

int JagArray(void)
{
		int a1 = 5;		//�ַ�������
		int a2[] = {7,10,8,7,9};			//ÿ���ַ����ĳ���+1
		int i,j;
		char **jag = NULL;		//���ڷ��ʶ�̬�ַ�������Ķ���ָ��

		jag = (char **)malloc(a1*sizeof(char *));	//��̬�����ַ�ָ������
		if (jag == NULL) return 1;
		for (i = 0; i < a1; i++)		
		{
			jag[i] = (char *)malloc(a2[i]*sizeof(char));	//��̬�������ַ����Ŀռ�
			for (j = 0; j<a2[i]-1; j++)			//�Ըÿռ丳ֵ�����ڲ��Գ���
				*(jag[i]+j) = 'A'+j;
			*(jag[i]+j) = '\0';
		}
		for (i = 0; i < a1; i++)	//��������ַ������ͷ��ַ�����ռ�ռ�
		{
			printf("%s\n",jag[i]);		
			free(jag[i]);
		}
		free(jag);		//�ͷ��ַ�ָ��������ռ�ռ�
		return 0;
}


void main()
{

	//ʵ����1-2
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

    //ʵ����3-5����
	//TestLLinkFuncs();

/*  //��չ1
    LIST *pHead = NULL;
    pHead=CreateLList2(N);
	OutputLList(pHead);
	DeleteLList(pHead);
*/

	//��չ2����
    //TestHLinkFuncs();
	
/*    //ϰ��3���� 
	LIST *pHead = NULL;
    pHead=CreateSeqList(N);
	OutputLList(pHead->next);
	DeleteLList(pHead);
*/
    
	//ϰ��4���� 
/*	NODE *pHead=NULL,*newHead;
	pHead=InputStr();
	ShowLink(pHead);
	printf("\nSorted:\n");
    newHead=SortLink(pHead);
    ShowLink(newHead);
	DeleteLink(newHead);
*/
}