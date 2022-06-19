#pragma once
#define _CRT_SECURE_NO_WARNINGS//����ʹ��scanf����ʱ����
#include <stdio.h>
#include <stdlib.h>

#define True  11
#define False  0
#define OK  111
#define Error  -111


typedef  int  Status;//״̬����
typedef  int  QElemType; //Ԫ������
typedef struct
{
	QElemType* base;  //��̬�洢�ռ���ַ
	int  front;       //ͷ�±꣬��ͷԪ���±�
	int  rear;       //β�±꣬��βԪ�ص���һ��λ��
	int  qsize;		//����ռ�õĿռ䣨��Ԫ��Ϊ��λ��
}SqQueue;

Status  InitQueue(SqQueue* Q, int size);//����һ������Ϊsize�Ŀ�˳��ѭ������Q

Status EnQueue(SqQueue* Q, QElemType e);//����Ԫ��eΪQ���µĶ�βԪ��

Status DeQueue(SqQueue* Q, QElemType *e);//ɾ��Q�Ķ�ͷԪ�ز�����Ԫ��e

Status QueueEmpty(SqQueue Q);//�ж϶���Q�Ƿ�Ϊ��

QElemType GetHead(SqQueue Q);//������Q�ǿգ����ض�ͷԪ�ص�ֵ

Status QueueLength(SqQueue Q);//������еĳ���

Status JosephCircle(QElemType n, QElemType m, QElemType i);//Լɪ������
