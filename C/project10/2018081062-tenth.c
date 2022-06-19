#include<stdio.h>
#include<stdlib.h>
#define LEN sizeof(LIST)

typedef struct student
{
	int num;				//ѧ��
	char name[20];			//����
	char ginder[5];			//�Ա�
	int age;				//����
	struct student *next;	//ָ����һ���ڵ��ָ��
}LIST;

int JagArray(void)
{
	int a1 = 5;  //�ַ�������
	int a2[]= {7, 10, 8, 7, 9};  //ÿ���ַ����ĳ���+1
	int i, j;
	char **jag = NULL;//���ڷ��ʶ�̬�ַ�������Ķ���ָ��

	jag = (char**)malloc(a1 * sizeof(char*));//��̬�����ַ�ָ������
	if(jag == NULL) return 1;
	for(i = 0; i < a1; i++)
	{
		jag[i] = (char*)malloc(a2[i]);	//Ϊÿ���ַ�������һ���ڴ棬 ��С��a2�л�ȡ
		for(j = 0; j < a2[i] - 1; j++)	 //�Ըÿռ丳ֵ�����ڲ��Գ���
			*(jag[i]+j) = 'A' + j;//�����ַ���
		*(jag[i]+j) = '\0';//�ַ���������־
	}
	
	for(i = 0; i < a1; i++)
	{
		printf("%s\n", jag[i]);
		free(jag[i]);
	}
	free(jag);  //�ͷ��ַ�ָ��������ռ�ռ�
	return 0;
}


/*LIST *CreatList(int n)    
{
	LIST *head = NULL, *p1, *p2;
	int i;
	for(i = 0; i < n - 1; i++)
	{	
		if(i == 0)
		{
			p1 = p2 = (LIST*)malloc(LEN);
			printf("�������һλѧ������Ϣ������ѧ�š��������Ա�����\n", n);
			scanf("%d%s%s%d", &p1->num, &p1->name, &p1->ginder, &p1->age);
			head = p1;
		}
		p2->next = p1;
		p2 = p1;
		p1 = (LIST*)malloc(LEN);
		printf("��������һλѧ������Ϣ������ѧ�š��������Ա�����\n", n);
		scanf("%d%s%s%d", &p1->num, &p1->name, &p1->ginder, &p1->age);
		
	}
	p2->next = NULL;
	return head;
}*/

/*****************************************************
	�������ܣ�������n���ڵ�ĵ�����
	����������nΪѧ��������
	  ����ֵ�������ɹ������ص�����ͷָ�룬���򷵻�NULL
******************************************************/
LIST *CreatList(int n)
{
	int i = 0;
	LIST *head, *node;

	head = (LIST*)malloc(LEN);
	node = head;
	while (i < n)
	{
		printf("������һλѧ������Ϣ������ѧ�š��������Ա�����\n", n);
		scanf("%d%s%s%d", &node->num, &node->name, &node->ginder, &node->age);
		if (i == n - 1)
			node->next = NULL;
		else
		{
			node->next = (LIST*)malloc(LEN);
			node = node->next;
		}
		i++;
	}
	return head;
}

/***************************************************
	�������ܣ��������
	����������pΪ������ͷָ��
	  ����ֵ����
****************************************************/
void OutputList(LIST *p)
{
	LIST *node = p;

	printf("Num\tName\tginder\tAge\n\n");
	while (node != NULL)
	{	
		printf("%-7d%-9s%-4s\t%-3d\n", node->num, node->name, node->ginder, node->age);
		node = node->next;
	}
}

/***************************************************
	�������ܣ��������������age��ͬ�ļ�¼
	����������pΪ������ͷָ�룬ageΪ��������
	  ����ֵ�����ҳɹ������ظý������λ����Ϣ��ͷ���λ��Ϊ0������ʧ�ܣ�����-1
****************************************************/
int FindList(LIST *p, int age)
{
	LIST *p1 = p;
	int pos = 0;

	while(p1 != NULL)
	{
		if(p1->age == age)
		{
			return pos;
		}
		p1 = p1->next;
		pos++;
	}

	return -1;
}


/***************************************************
	�������ܣ�ͳ�Ƶ����������
	����������pΪ������ͷָ��
	  ����ֵ�����ظ����������������������0
****************************************************/
int CountList(LIST *p)
{ 
    int nLength = 0; 
	LIST *pCurrent;
	
	if(p == NULL)return 0;  
	
	pCurrent = p;  
    while(pCurrent != NULL)  
    {  
        nLength++;  
        pCurrent = pCurrent->next;  
    }  
    return nLength;  
}

/***************************************************
	�������ܣ��ͷ�����
	����������pΪ������ͷָ��
	  ����ֵ����
****************************************************/
void FreeList(LIST *p)
{
	free(p);
	p = NULL;
}


int main()
{
	LIST *p;
	int nLength, b;

	int a = JagArray();
	putchar('\n');

	p = CreatList(5);
	putchar('\n');
	OutputList(p);
	putchar('\n');

	printf("���������������Ϣ�Ľڵ�λ����ϢΪ��");
	b = FindList(p, 18);
	printf("%d", b);
	
	putchar('\n');
	nLength = CountList(p);
	printf("������Ľ�����Ϊ��%d\n", nLength);
	FreeList(p);


	return 0;
}


/*���вο�����
101 dengqi boy 19
102 linyuan girl 19
103 shunzhao boy 20
104 jiquan boy 19
105 jialin girl 20
*/