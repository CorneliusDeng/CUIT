#pragma once
#define _CRT_SECURE_NO_WARNINGS//����ʹ��scanf����ʱ����
#include <stdio.h>
#include <stdlib.h>

#define True  11 
#define False  0 
#define OK  111 
#define Error  -111 
#define Stack_Init_Size 10 
#define StackIncrement 10

typedef int Status;		//״̬����
typedef int SElemType;	//Ԫ������

typedef struct {
	SElemType* base;  //��̬�ռ��ַ
	int num;        //ʵ��Ԫ�ظ��� 
	int stacksize;   //��ǰ�洢����
}SqStack;


Status InitStack(SqStack* S);
Status Push(SqStack* S, SElemType e);
Status Pop(SqStack* S, SElemType* e);
SElemType GetTop(SqStack* S);
SElemType GetElem(SqStack* S, int i);
int function(int i);
