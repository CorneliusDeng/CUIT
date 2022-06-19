#include<stdio.h>
#include<stdlib.h>

#define LEN sizeof(struct Data)

struct Data
{
	int num;
	float score;
	struct Data *next;
};	

void printChain(struct Data *cur);
/* userCode(<100字符): 自定义函数之原型声明 */
struct Data *insert(struct Data *p,int a, float b);

int main(void)
{	
	struct Data *head = NULL;
	int num;
	float score;

	printf("Please input node data:\n");
	scanf("%d %f", &num, &score);
	while (num != 0)
	{
		head = insert(head, num, score);
		scanf("%d %f", &num, &score); 
	}
	
	printf("\nOutput whole nodes of the chain:\n");
	printChain(head);
	
	return 0;
}

void printChain(struct Data *cur)
{
	printf("Result: ");
	while (cur != NULL)
	{
		printf("%d-%.2f  ", cur->num, cur->score);
		cur = cur->next;
	}
	putchar('\n');
}

/* User Code Begin：考生在此后完成自定义函数的设计，行数不限 */
struct Data *insert(struct Data *p,int a, float b)
{
	  struct Data *p1,*p2=p,*p3=p;
	  struct Data *head=p;
	  p1 = (struct Data *)malloc(LEN);
	  p1->num = a;
	  p1->score = b; 
	  p1->next = NULL;

	  if( p == NULL )//链表为空的情况
	  {
		 head = p1;
	  }
	  else  if(p->next == NULL)//链表只有一个节点的情况
	  {
			 if(p1->num >= p2->num)
				 p2->next=p1;//插在之后
			 else
			 {
				 p1->next=p2;//插在头
				 head=p1;
			 }
		}
	  else//链表有多个节点的情况
	  {
		  if(head->num > p1->num)//插到头的情况
		  {
			  p1->next=head;
			  head=p1;
		  }
		 else
		 {
			 p3=p2->next;
			 while(p1->num >= p2->num)
			 {
				 
				 if(p3 == NULL)//插入到尾
				 {
					 p2->next=p1;
					 break;
				 }
				 if(p1->num < p3->num)//到插入位置，即p2与p3之间
				 {
					 p1->next=p3;
					 p2->next=p1;
					
					break;
				}
				 p2=p2->next;
				 p3=p2->next;
				 
			}
		 }
	  }
	 return head;
}
