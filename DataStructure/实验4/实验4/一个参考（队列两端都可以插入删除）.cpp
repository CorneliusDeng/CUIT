/*允许在循环队列的两端都可以进行插入和删除操作
写出这样的循环队列类型定义+从队尾删除+从队头插入的算法
//私はあの弱い自分を認めない
#ifndef PCH_H
#define PCH_H
#include<stdio.h>
#include<iostream>
#include<malloc.h>
#include<cstdlib>//包含exit头文件
#include<math.h>
#define MAXSIZE 6
constexpr auto OK = 1;
constexpr auto ERROR = 0;
typedef int Status;
typedef struct
{
	double* base;//数组，顺序表队列
	int front;//队头
	int rear;//队尾
}TuQueue;
Status InitQueue(TuQueue& Q);
Status EnQueue_F(TuQueue& Q, double e);//队头插入
Status EnQueue_R(TuQueue& Q, double e);//队尾插入
Status DeQueue_F(TuQueue& Q, double& e);//队头删除
Status DeQueue_R(TuQueue& Q, double& e);//队尾删除
Status TravelQueue(TuQueue Q);//遍历检测

#endif
------------------------------------------------------
// pch.cpp: 与预编译标头对应的源文件；编译成功所必需的

#include "pch.h"

// 一般情况下，忽略此文件，但如果你使用的是预编译标头，请保留它。

Status InitQueue(TuQueue& Q)
{
	Q.base = (double*)malloc(MAXSIZE * sizeof(double));
	if (!Q.base) exit(OVERFLOW);
	Q.front = Q.rear = 0;
	return OK;
}

Status EnQueue_R(TuQueue& Q, double e)
{//尾插
	if ((Q.rear + 1) % MAXSIZE == Q.front) return ERROR;//队满
	Q.base[Q.rear] = e;
	Q.rear = (Q.rear + 1) % MAXSIZE;
	return OK;
}

Status EnQueue_F(TuQueue& Q, double e)
{//头插
	if ((Q.front + MAXSIZE - 1) % MAXSIZE == Q.rear)return ERROR;
	Q.front = (Q.front + MAXSIZE - 1) % MAXSIZE;
	Q.base[Q.front] = e;
	return OK;
}

Status DeQueue_F(TuQueue& Q, double& e)
{//头删
	if (Q.front == Q.rear) return ERROR;
	e = Q.base[Q.front];
	Q.front = (Q.front + 1) % MAXSIZE;
	return OK;
}

Status DeQueue_R(TuQueue& Q, double& e)
{//尾删
	if (Q.front == Q.rear)return ERROR;
	e = Q.base[(Q.rear + MAXSIZE - 1) % MAXSIZE];
	Q.rear = (Q.rear + MAXSIZE - 1) % MAXSIZE;
	return OK;
}

Status TravelQueue(TuQueue Q)
{
	if (Q.front == Q.rear)return ERROR;
	double e;
	while (Q.front != Q.rear)
	{
		DeQueue_R(Q, e);//尾删遍历
		std::cout << e << " ";
	}
	std::cout << "\n";
	return OK;
}
--------------------------------------------
// ConsoleApplication8.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include "pch.h"
#include <iostream>

int main()
{
	TuQueue Q;
	double e;
	InitQueue(Q);
	EnQueue_F(Q, 1.1);
	EnQueue_R(Q, 2.2);
	EnQueue_R(Q, 3.2);
	EnQueue_F(Q, 4.2);
	EnQueue_R(Q, 5.2);
	TravelQueue(Q);
	DeQueue_F(Q, e);
	std::cout << "delete " << e;
	TravelQueue(Q);
	DeQueue_R(Q, e);
	std::cout << "then delete " << e;
	TravelQueue(Q);

	system("pause");
}
*/