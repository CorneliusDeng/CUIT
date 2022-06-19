#include<stdio.h>
#include<stdlib.h>
#define LEN sizeof(LIST)

typedef struct student
{
	int num;				//学号
	char name[20];			//姓名
	char ginder[5];			//性别
	int age;				//年龄
	struct student *next;	//指向下一个节点的指针
}LIST;

int JagArray(void)
{
	int a1 = 5;  //字符串个数
	int a2[]= {7, 10, 8, 7, 9};  //每个字符串的长度+1
	int i, j;
	char **jag = NULL;//用于访问动态字符串数组的二级指针

	jag = (char**)malloc(a1 * sizeof(char*));//动态分配字符指针数组
	if(jag == NULL) return 1;
	for(i = 0; i < a1; i++)
	{
		jag[i] = (char*)malloc(a2[i]);	//为每个字符串分配一个内存， 大小从a2中获取
		for(j = 0; j < a2[i] - 1; j++)	 //对该空间赋值，用于测试程序
			*(jag[i]+j) = 'A' + j;//制造字符串
		*(jag[i]+j) = '\0';//字符串结束标志
	}
	
	for(i = 0; i < a1; i++)
	{
		printf("%s\n", jag[i]);
		free(jag[i]);
	}
	free(jag);  //释放字符指针数组所占空间
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
			printf("请输入第一位学生的信息，包括学号、姓名、性别、年龄\n", n);
			scanf("%d%s%s%d", &p1->num, &p1->name, &p1->ginder, &p1->age);
			head = p1;
		}
		p2->next = p1;
		p2 = p1;
		p1 = (LIST*)malloc(LEN);
		printf("请输入下一位学生的信息，包括学号、姓名、性别、年龄\n", n);
		scanf("%d%s%s%d", &p1->num, &p1->name, &p1->ginder, &p1->age);
		
	}
	p2->next = NULL;
	return head;
}*/

/*****************************************************
	函数功能：建立有n个节点的单链表
	函数参数：n为学生总人数
	  返回值：创建成功，返回单链表头指针，否则返回NULL
******************************************************/
LIST *CreatList(int n)
{
	int i = 0;
	LIST *head, *node;

	head = (LIST*)malloc(LEN);
	node = head;
	while (i < n)
	{
		printf("请输入一位学生的信息，包括学号、姓名、性别、年龄\n", n);
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
	函数功能：输出链表
	函数参数：p为单链表头指针
	  返回值：无
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
	函数功能：查找与给定年龄age相同的记录
	函数参数：p为单链表头指针，age为查找条件
	  返回值：查找成功，返回该结点所在位置信息，头结点位置为0，查找失败，返回-1
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
	函数功能：统计单链表结点个数
	函数参数：p为单链表头指针
	  返回值：返回该链表结点个数，空链表，返回0
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
	函数功能：释放链表
	函数参数：p为单链表头指针
	  返回值：无
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

	printf("与输入数据相关信息的节点位置信息为：");
	b = FindList(p, 18);
	printf("%d", b);
	
	putchar('\n');
	nLength = CountList(p);
	printf("此链表的结点个数为：%d\n", nLength);
	FreeList(p);


	return 0;
}


/*运行参考数据
101 dengqi boy 19
102 linyuan girl 19
103 shunzhao boy 20
104 jiquan boy 19
105 jialin girl 20
*/