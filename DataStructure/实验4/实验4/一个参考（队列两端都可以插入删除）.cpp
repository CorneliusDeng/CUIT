/*������ѭ�����е����˶����Խ��в����ɾ������
д��������ѭ���������Ͷ���+�Ӷ�βɾ��+�Ӷ�ͷ������㷨
//˽�Ϥ��������Է֤��J��ʤ�
#ifndef PCH_H
#define PCH_H
#include<stdio.h>
#include<iostream>
#include<malloc.h>
#include<cstdlib>//����exitͷ�ļ�
#include<math.h>
#define MAXSIZE 6
constexpr auto OK = 1;
constexpr auto ERROR = 0;
typedef int Status;
typedef struct
{
	double* base;//���飬˳������
	int front;//��ͷ
	int rear;//��β
}TuQueue;
Status InitQueue(TuQueue& Q);
Status EnQueue_F(TuQueue& Q, double e);//��ͷ����
Status EnQueue_R(TuQueue& Q, double e);//��β����
Status DeQueue_F(TuQueue& Q, double& e);//��ͷɾ��
Status DeQueue_R(TuQueue& Q, double& e);//��βɾ��
Status TravelQueue(TuQueue Q);//�������

#endif
------------------------------------------------------
// pch.cpp: ��Ԥ�����ͷ��Ӧ��Դ�ļ�������ɹ��������

#include "pch.h"

// һ������£����Դ��ļ����������ʹ�õ���Ԥ�����ͷ���뱣������

Status InitQueue(TuQueue& Q)
{
	Q.base = (double*)malloc(MAXSIZE * sizeof(double));
	if (!Q.base) exit(OVERFLOW);
	Q.front = Q.rear = 0;
	return OK;
}

Status EnQueue_R(TuQueue& Q, double e)
{//β��
	if ((Q.rear + 1) % MAXSIZE == Q.front) return ERROR;//����
	Q.base[Q.rear] = e;
	Q.rear = (Q.rear + 1) % MAXSIZE;
	return OK;
}

Status EnQueue_F(TuQueue& Q, double e)
{//ͷ��
	if ((Q.front + MAXSIZE - 1) % MAXSIZE == Q.rear)return ERROR;
	Q.front = (Q.front + MAXSIZE - 1) % MAXSIZE;
	Q.base[Q.front] = e;
	return OK;
}

Status DeQueue_F(TuQueue& Q, double& e)
{//ͷɾ
	if (Q.front == Q.rear) return ERROR;
	e = Q.base[Q.front];
	Q.front = (Q.front + 1) % MAXSIZE;
	return OK;
}

Status DeQueue_R(TuQueue& Q, double& e)
{//βɾ
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
		DeQueue_R(Q, e);//βɾ����
		std::cout << e << " ";
	}
	std::cout << "\n";
	return OK;
}
--------------------------------------------
// ConsoleApplication8.cpp : ���ļ����� "main" ����������ִ�н��ڴ˴���ʼ��������
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