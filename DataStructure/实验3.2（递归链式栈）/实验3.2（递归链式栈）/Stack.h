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

typedef struct {
	SElemType* base;  //动态空间基址
	int num;        //实际元素个数 
	int stacksize;   //当前存储容量
}SqStack;


Status InitStack(SqStack* S);
Status Push(SqStack* S, SElemType e);
Status Pop(SqStack* S, SElemType* e);
SElemType GetTop(SqStack* S);
SElemType GetElem(SqStack* S, int i);
int function(int i);
