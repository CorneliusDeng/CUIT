#include <stdio.h>
#include <stdlib.h>

#define LEN sizeof(struct student)

typedef struct student
{
	long num;
	float score;
	struct student *next;
}STU;

int n;//全局变量，一个标志，判断到底到了哪个结点

STU *creat(void)
{
	STU *head, *p1, *p2;

	n = 0;

	p1 = p2 = (STU *)malloc(LEN);//开辟一个新单元，使此时的p1和p2都指向这个结点
	printf("请输入一位同学的学号、成绩，中间用空格隔开，若想结束链表，则输入0 0\n");
	scanf("%ld%f", &p1->num, &p1->score);
	head = NULL;

	while(p1->num != 0)//设置判断条件，使输入的学号都不为0
	{
		n++;//先自增1，使结点的序数与自然序数相匹配
		if (n == 1) head = p1;//如果是第一个结点，使head也指向新开辟的结点
		else p2->next = p1;//否则就将新结构体的地址赋给p2，一个链接的过程

		p2 = p1;//使p2代替p1的位置，一个移动过程
		p1 = (STU*)malloc(LEN); //开辟新的动态储存区
		printf("请输入一位同学的学号、成绩，中间用空格隔开，若想结束链表，则输入0 0\n");
		scanf("%ld%f", &p1->num, &p1->score);
	}

	p2->next = NULL;//如果输入的学号都为0了，直接将p2的地址赋为NULL

	return head;//函数返回链表第一个结点的地址
}

int main()
{
	STU *pt;
	pt = creat(); 
	printf("输入的结果为：\n");
	do
	{
		printf("num:%ld  score:%5.1f\n", pt->num, pt->score);
		pt = pt->next;//使其指向下一个结点，使输出延续
	}while(pt != NULL);
	
	return 0;
}
