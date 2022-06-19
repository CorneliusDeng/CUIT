#include "Stack.h"


Status InitStack(SqStack* S) 
{//初始化栈
	S->base = (SElemType*)malloc(sizeof(SElemType*) * Stack_Init_Size);
	if (!S || !(S->base))
	{
		return Error;
	}
	S->stacksize = 10;//栈存储容量为10
	S->num = 0;
	return OK;
}

Status Push(SqStack* S, SElemType e) 
{//将数据e元素进栈
	if (S->num == S->stacksize)//栈满
	{
		int temp = realloc(S->base, sizeof(SElemType*) * (Stack_Init_Size * 2));//内存已满，重新分配两倍内存
	}
	*(S->base + S->num) = e;
	S->num++;
	return OK;
}

Status Pop(SqStack* S, SElemType* e)
{//元素出栈
	if (S->num <= 0) 
	{
		return False;
	}
	S->num--;
	*e = *(S->base + S->num);

	return True;
}

SElemType GetTop(SqStack* S) 
{//获取栈顶
	if (S->num == 0) 
	{
		return Error;
	}

	return *(S->base + S->num - 1);
}

SElemType GetElem(SqStack* S, int i) 
{//获取元素
	if (S->num == 0) 
	{
		return Error;
	}

	return *(S->base + i);
}

int function(int i) 
{//元素递归实现  t(n)=2*t(n/2)+n
	if (i == 0)
	{
		return 0;
	}
	else
	{
		return 2 * function(i / 2) + i;
	}
		
}