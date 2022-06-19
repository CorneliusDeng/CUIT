#include "Stack.h"


Status InitStack(SqStack* S) 
{//��ʼ��ջ
	S->base = (SElemType*)malloc(sizeof(SElemType*) * Stack_Init_Size);
	if (!S || !(S->base))
	{
		return Error;
	}
	S->stacksize = 10;//ջ�洢����Ϊ10
	S->num = 0;
	return OK;
}

Status Push(SqStack* S, SElemType e) 
{//������eԪ�ؽ�ջ
	if (S->num == S->stacksize)//ջ��
	{
		int temp = realloc(S->base, sizeof(SElemType*) * (Stack_Init_Size * 2));//�ڴ����������·��������ڴ�
	}
	*(S->base + S->num) = e;
	S->num++;
	return OK;
}

Status Pop(SqStack* S, SElemType* e)
{//Ԫ�س�ջ
	if (S->num <= 0) 
	{
		return False;
	}
	S->num--;
	*e = *(S->base + S->num);

	return True;
}

SElemType GetTop(SqStack* S) 
{//��ȡջ��
	if (S->num == 0) 
	{
		return Error;
	}

	return *(S->base + S->num - 1);
}

SElemType GetElem(SqStack* S, int i) 
{//��ȡԪ��
	if (S->num == 0) 
	{
		return Error;
	}

	return *(S->base + i);
}

int function(int i) 
{//Ԫ�صݹ�ʵ��  t(n)=2*t(n/2)+n
	if (i == 0)
	{
		return 0;
	}
	else
	{
		return 2 * function(i / 2) + i;
	}
		
}