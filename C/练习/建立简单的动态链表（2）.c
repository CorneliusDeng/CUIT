#include <stdio.h>
#include <malloc.h>

#define LEN sizeof(struct student)

typedef struct student
{
	long num;
	float score;
	struct student *next;
}STU;

int n;

STU *creat()
{
	STU *head, *p1, *p2;

	n = 0;

	p1 = p1 = (STU*)malloc(LEN);
	printf("请输入一位同学的学号、成绩，中间用空格隔开，若想结束链表，则输入0 0\n");
	scanf("%ld%f", &p1->num, &p1->score);
	head = NULL;
	
	while (p1->num != 0)
	{
		n++;
		if (n == 1) head = p1;
		else p2->next = p1;
		
		p2 = p1;

		p1 = (STU*)malloc(LEN);
		printf("请输入一位同学的学号、成绩，中间用空格隔开，若想结束链表，则输入0 0\n");
		scanf("%ld%f", &p1->num, &p1->score);
	}

	p2->next = NULL;

	return head;
}

void print(STU *head)
{
	STU *p;

	printf("\n Now, These %d records are:\n", n);
	p = head;

	if(head != NULL)
	{
		do
		{
			printf("num:%ld  score:%5.1f\n", p->num, p->score);
			p = p->next;
		}while (p != NULL);
	}
}

int main()
{
	STU *head;
	head = creat();
	print(head);

	return 0;
}