#include<stdio.h>
#include<malloc.h>

/* User Code Begin(考生可在本行后添加代码，定义程序中使用的结构体类型、声明自定义函数的原型，行数不限) */
#define LEN sizeof(struct student)

int sum = 0;
struct student{
	
	int num;
	int score;
	struct student *next;
};

struct student *creat();
struct student *merge(struct student *p1,struct student *p2);

/* User Code End(考生添加代码结束) */

/* print以规定的格式完成遍历显示指定的链表 */
void print(char *Info, struct student *Head);

int main(void)
{	
	struct student *ah, *bh;
	
	printf("创建链表A，请输入学号及成绩(均输入为0时表示停止)：\n");
	ah = creat();
	printf("\n创建链表B，请输入学号及成绩(均输入为0时表示停止)：\n");
	bh = creat();

	print("\n链表A：", ah);
	print("\n链表B：", bh);
	
	ah = merge(ah, bh);
	print("\n链表A、B合并后：", ah);
	
	return 0;
}

void print(char *Info, struct student *Head)
{
	printf("%s", Info);
	while (Head != NULL)
	{
		printf("%d,%d  ", Head->num, Head->score);
		Head = Head->next;
	}
}

/* User Code Begin(考生在此后完成自定义函数的设计，行数不限) */
struct student *creat()
{
	//int n=0;
	struct student *head;
	struct student *p1,*p2;
	p1=p2=(struct student *)malloc(LEN);
	printf("学生%d:",sum+1);
	scanf("%d %d",&p1->num,&p1->score);
	head=NULL;
	while(p1->num!=0)
	{
		sum=sum+1;
		//n++;
		if(head==NULL)
		{
			head=p1;
		}
		else
		{
			p2->next=p1;
		}
		p2=p1;
		p1=(struct student*)malloc(LEN);
		printf("学生%d:",sum+1);
		scanf("%d %d",&p1->num,&p1->score);

	}

	p2->next=NULL;
	return head;
	
}
struct student *merge(struct student *p1,struct student *p2)
{
	struct student *p,*head;
	p=(struct student *)malloc(LEN);
	if(p1 != NULL)
	{
		head=p=p1;
		p1=p1->next;
	}
	else
	{
		head=p=p2;
		p2=p2->next;
		
	}

	while(p1 !=NULL)
	{
		p->next=p1;
		p=p1;
		p1=p1->next;
	}
	while(p2 !=NULL)		
	{
		p->next=p2;
		p=p2;
		p2=p2->next;
	}
	return head;
}