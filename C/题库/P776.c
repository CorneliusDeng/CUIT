#include<stdio.h>
#include<malloc.h>

typedef struct Node
{
	int data;
	struct Node *next;
}Quan;

int Remain(int n);

int main(void)
{
	int num;
	
	do
	{
		printf("Please input n: ");
		scanf("%d", &num);
	}while(num<=3||num>=200);
	
	
	printf("\nResult is:\n");
	printf("The remained student is %d.\n", Remain(num));
	
	return 0;
}
int Remain(int n)
{
	int i, j;
	Quan *head, *tail;
	
	head = tail = (Quan*)malloc(sizeof(Quan));
	for(i = 1; i < n; i++)
	{
		tail->data = i;
		tail->next = (Quan*)malloc(sizeof(Quan));
		tail = tail->next;
	}
	tail->data = i;
	tail->next = head;
	
	for(i = 1; tail!=head; i++)
	{
		for(j = 1; j < 3; j++)
		{
			tail = head;
			head = head->next;
		}
		tail->next = head->next;
		printf("delete %d student: %d.\n", i, head->data);
		free(head);
		head = tail->next;
	}
	i = head->data;
	free(head);
	
	return i;
	
}








