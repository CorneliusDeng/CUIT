#include<stdio.h>
#include<malloc.h>

/* User Code Begin(考生可在本行后添加代码，定义程序中使用的结构体类型、声明自定义函数的原型，行数不限) */
struct link
{
	int data;
	struct link *next;
};

struct link *creatlink(int num);
struct link *delodd(struct link *head);

/* User Code End(考生添加代码结束) */

/* print以规定的格式完成遍历显示指定的链表 */
void printlink(struct link *Head);

int main(void)
{
	struct link *Head;
	int n;
	
	printf("input the number: ");
	scanf("%d", &n);

	Head = creatlink(n);
	printf("\nold list: ");
	printlink(Head);

	Head = delodd(Head);
	printf("\nnew list: ");
	printlink(Head);	   
	
	return 0;
}

void printlink(struct link *Head)
{
	while (Head != NULL)
	{
		printf("%d -> ", Head->data);
		Head = Head->next;
	}
	puts("NULL");
}

/* User Code Begin(考生在此后完成自定义函数的设计，行数不限) */
struct link *creatlink(int num)
{
	struct link *head,*p1,*p2;
	int i;
	if(num==0)
	{
		return NULL;
	}

	head=p1=p2=(struct link*)malloc(sizeof(struct link));
	
	printf("Please input the data : ");
	for(i=0; i<num; i++)
	{
		scanf("%d",&p1->data);
		if(head==NULL)
		{
			head=p1;
		}
		else
		{
			p2->next=p1;
		}
		p2=p1;
		p1=(struct link*)malloc(sizeof(struct link));

	}
	p2->next=NULL;
	return head;
}

struct link *delodd(struct link *head)
{
	struct link *p1,*p2;
	if(head==NULL)
	{
		printf("List is null!\n");
		return head;
	}

	p1=head->next;
	p2=head;
	while(p1 != NULL )
	{
		if(p1->data%2 != 0)
		{
			p2->next=p1->next;
			free(p1);
			p1=p2->next;
		}
		else
		{
			p2=p1;
			p1=p2->next;
		}
	}

	//判断第一个数字是否可以整除2
	if(head->data%2!=0)
	{
		p2=head;
		head=head->next;
		free(p2);
	}

	return head;
}