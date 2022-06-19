#pragma once
#define _CRT_SECURE_NO_WARNINGS//避免使用scanf函数时出错
#include <stdio.h>
#include <stdlib.h>

#define True  11 
#define False  0 
#define OK  111 
#define Error  -111 
#define Stack_Init_Size 10 
#define StackIncrement 10

typedef int Status;		//状态类型
typedef int SElemType;	//元素类型

typedef struct
{
	SElemType* base;	//栈底指针
	SElemType* top;		//栈顶指针
	int stacksize;		//栈可用的最大容量
}SqStack;

int CompareTable[7][7];

Status InitStack(SqStack* S);//构造一个初始容量为Stack_Init_Size的空顺序栈S

Status Push(SqStack* S, SElemType e);//将值为e的数据压入栈S

Status Pop(SqStack* S, SElemType *e);//从栈S中弹出一个元素赋给e

SElemType GetTop(SqStack S);//栈非空时，返回栈顶元素的值，不修改栈顶位置

int Operate(int a, int Operator, int b);//四则运算

Status IsOperator(char c, int* code);//判断字符c是否是运算符

int Precede(int precode, int nextcode);//比较两个运算符优先级

int EvaluateExpression();//接收键盘输入的四则运算表达式字符串（以#结束），计算表达式的值

