#include<stdio.h>
#include<malloc.h>

#define LEN sizeof(struct student)

int sum = 0;
/* User Code Begin(考生可在本行后添加代码，定义程序中使用的结构体类型、声明自定义函数的原型，行数不限) */
struct student
{
	int num, score;
	struct student *next;
};
struct student *creat(void);
struct student *merge(struct student *ah, struct student *bh);

/* User Code End(考生添加代码结束) */

/* print以规定的格式完成遍历显示指定的链表 */
void print(struct student *Head);

int main(void)
{
	struct student *ah, *bh, *ac;
	
	printf("创建链表A，请输入学号及成绩(均输入为0时表示停止)：\n");
	ah = creat();
	printf("\n创建链表B，请输入学号及成绩(均输入为0时表示停止)：\n");
	bh = creat();

	printf("\n链表A：");
	print(ah);
	printf("\n链表B：");
	print(bh);
	
	ac = merge(ah, bh);
	printf("\n两个链表共有%d个人\n链表C：", sum);
	print(ac);
	
	return 0;
}

void print(struct student *Head)
{
	while (Head != NULL)
	{
		printf("%d,%d  ", Head->num, Head->score);
		Head = Head->next;
	}
}

/* User Code Begin(考生在此后完成自定义函数的设计，行数不限) */
struct student *creat(void)
{
	struct student *Head, *p1, *p2;
	int flag = 0;
	
	Head = p1 = p2 = (struct student*)malloc(LEN);
	while(1)
	{
		sum++;
		printf("学生 %d: ", sum);
		scanf("%d%d", &p1->num, &p1->score);
		if(p1->num ==0&&p1->score==0)
		{
			break;
		}
		if(Head == NULL)
		{
			Head = p1;
		}
		else
		{
			p2->next = p1;
		}
		p2 = p1;
		p1 = (struct student*)malloc(LEN);
		flag = 1; 
	}
	sum--;
	p2->next = NULL;
	if(flag==0)
	{
		return NULL;
	}
	return Head;
}

struct student *merge(struct student *ah, struct student *bh)
{
	int i, tmpnum, tmpscore;
	struct student *Head, *p0;
	
	if(ah==NULL&&bh==NULL)
	{
		return NULL;
	}
	else if(ah!=NULL&&bh==NULL)
	{
		Head = ah;
	}
	else if(ah==NULL&&bh!=NULL)
	{
		Head = bh;
	}
	else
	{
		Head = p0 = ah;
		while(p0->next!=NULL)
		{
			p0 = p0->next;
		}
		p0->next = bh;
	}
	for(i = 1; i < sum; i++)
	{
		p0 = Head;
		while(p0->next!=NULL)
		{
			if(p0->num > p0->next->num)
			{
				tmpnum = p0->num;
				p0->num = p0->next->num;
				p0->next->num = tmpnum;
				
				tmpscore = p0->score;
				p0->score = p0->next->score;
				p0->next->score = tmpscore;
			}
			p0 = p0->next;
		}
	}
	
	return Head;
}





