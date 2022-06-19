#pragma once
#define _CRT_SECURE_NO_WARNINGS//避免使用scanf函数时出错
#include <stdio.h>
#include <stdlib.h>

#define True  11
#define False  0
#define OK  111
#define Error  -111


typedef  int  Status;//状态类型
typedef  int  QElemType; //元素类型
typedef struct
{
	QElemType* base;  //动态存储空间首址
	int  front;       //头下标，队头元素下标
	int  rear;       //尾下标，队尾元素的下一个位置
	int  qsize;		//队列占用的空间（以元素为单位）
}SqQueue;

Status  InitQueue(SqQueue* Q, int size);//构造一个容量为size的空顺序循环队列Q

Status EnQueue(SqQueue* Q, QElemType e);//插入元素e为Q的新的队尾元素

Status DeQueue(SqQueue* Q, QElemType *e);//删除Q的队头元素并赋给元素e

Status QueueEmpty(SqQueue Q);//判断队列Q是否为空

QElemType GetHead(SqQueue Q);//若队列Q非空，返回队头元素的值

Status QueueLength(SqQueue Q);//计算队列的长度

Status JosephCircle(QElemType n, QElemType m, QElemType i);//约瑟夫环问题
