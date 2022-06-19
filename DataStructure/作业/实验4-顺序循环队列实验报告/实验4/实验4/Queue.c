#include  "Queue.h"

Status  InitQueue(SqQueue *Q, int size)
{//构造一个容量为size的空顺序循环队列Q

	Q->base = (QElemType)malloc(sizeof(QElemType) * (size + 1));//为队列分配一个最大容量为的数组空间
	if (!Q->base) exit(Error);//存储分配失败
	Q->front = Q->rear = 0;//头下标和尾下标为零，队列为空
	Q->qsize = size + 1;
	//循环队列实际分配空间为size+1个单元（以元素为单位）
	//MAXQSIZE = size + 1(为了区分空和满，使满的时候头尾下标不为同一个位置)
	return OK;
}

Status EnQueue(SqQueue* Q, QElemType e)
{//插入元素e为Q的新的队尾元素。

	//尾下标在循环意义后加1后等于头指针，表示队满（自己对自己求余等于0，即头下标）
	if ((Q->rear + 1) % Q->qsize == Q->front)
	{
		return Error;
	}

	Q->base[Q->rear] = e;//新元素插在队尾

	Q->rear = (Q->rear + 1) % Q->qsize;//队尾下标加1

	return OK;
}

Status DeQueue(SqQueue *Q, QElemType *e)
{//删除Q的队头元素并赋给元素e
		
	if (Q->front == Q->rear) return Error; //队空

	*e = Q->base[Q->front];//保存队头元素

	Q->front = (Q->front + 1) % Q->qsize;//队头指针加1

	return OK;
}

Status QueueEmpty(SqQueue Q)
{//判断队列Q是否为空

	if (Q.front == Q.rear)//为空
	{
		return True;
	}
	else
	{
		return False;
	}
}

QElemType GetHead(SqQueue Q)
{//若队列Q非空，返回队头元素的值

	if (Q.front != Q.rear)
	{
		return Q.base[Q.front];
	}
	else
	{
		printf("Because this queue is empty, machine can't return the value of the front of this queue!");
	}
}

Status QueueLength(SqQueue Q)
{//计算队列的长度
	return (Q.rear - Q.front + Q.qsize) % Q.qsize;
}

Status JosephCircle(QElemType n, QElemType m, QElemType i)// n为总人数，m为选定的数，i为从第几个人开始报数
{
	SqQueue Q;
	QElemType e;
	InitQueue(&Q, n);//创建一个容量为n+1的顺序循环队列

	int pos;

	for (int j = 0, pos = i; j < n; j++)//直接将pos的位置定位到第一个报数的人,pos即队尾下标
	{
		EnQueue(&Q, pos++);//顺序地插入到各自所对应的位置中
		if (pos == n + 1)
		{
			//当队列已经满了，队尾插在了第n个位置，队尾下标已经是n+1了，就将pos置为1，让下一次插入直接到队头
			pos = 1;
		}
			
	}
	while (n-- && n >= 0)//人数减少一定有人出队
	{
		for (int j = 0; j < m - 1; j++) 
		{
			DeQueue(&Q, &e);//出队后立马入队，补上空位,形成无缝的环
			EnQueue(&Q, e);
		}
		DeQueue(&Q, &e);//j = m的时候，出队，j同时当了计步器与循环控制标志
		printf("%-4d", e);
	}
	return OK;
}
