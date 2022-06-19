#include "Tree.h"

Status InitStack(SqStack* S)
{//຅构造一个初始容量为Stack_Init_Size的空顺序栈S
	S->base = (SElemType*)malloc(Stack_Init_Size * sizeof(SElemType));
	//为顺序栈分配一个最大容量为Stack_Init_Size的数组空间
	if (!S->base) exit(Error);//分配空间失败退出

	S->top = S->base;//top初始为base，空栈
	S->stacksize = Stack_Init_Size;//stacksize置为栈的最大容量

	return OK;
}

Status StackEmpty(SqStack* S)
{//判断栈是否为空
	if (S->top != S->base)//栈非空
	{
		return OK;
	}
	else
	{
		return Error;
	}
}

Status Push(SqStack* S, SElemType e)
{//将值为e的数据压入栈S
	if (S->top - S->base == S->stacksize)//栈满
	{
		return Error;
	}

	*S->top = e;//元素e压栈，栈顶指针加1
	S->top++;

	return OK;
}

Status Pop(SqStack* S, SElemType* e)
{//从栈S中弹出一个元素赋给e
	if (S->top != S->base)//栈非空
	{
		*e = *(S->top - 1);
		S->top--;
		return OK;
	}
	else
	{
		return Error;
	}
}