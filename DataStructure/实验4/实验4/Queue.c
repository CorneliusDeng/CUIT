#include  "Queue.h"

Status  InitQueue(SqQueue *Q, int size)
{//����һ������Ϊsize�Ŀ�˳��ѭ������Q

	Q->base = (QElemType)malloc(sizeof(QElemType) * (size + 1));//Ϊ���з���һ���������Ϊ������ռ�
	if (!Q->base) exit(Error);//�洢����ʧ��
	Q->front = Q->rear = 0;//ͷ�±��β�±�Ϊ�㣬����Ϊ��
	Q->qsize = size + 1;
	//ѭ������ʵ�ʷ���ռ�Ϊsize+1����Ԫ����Ԫ��Ϊ��λ��
	//MAXQSIZE = size + 1(Ϊ�����ֿպ�����ʹ����ʱ��ͷβ�±겻Ϊͬһ��λ��)
	return OK;
}

Status EnQueue(SqQueue* Q, QElemType e)
{//����Ԫ��eΪQ���µĶ�βԪ�ء�

	//β�±���ѭ��������1�����ͷָ�룬��ʾ�������Լ����Լ��������0����ͷ�±꣩
	if ((Q->rear + 1) % Q->qsize == Q->front)
	{
		return Error;
	}

	Q->base[Q->rear] = e;//��Ԫ�ز��ڶ�β

	Q->rear = (Q->rear + 1) % Q->qsize;//��β�±��1

	return OK;
}

Status DeQueue(SqQueue *Q, QElemType *e)
{//ɾ��Q�Ķ�ͷԪ�ز�����Ԫ��e
		
	if (Q->front == Q->rear) return Error; //�ӿ�

	*e = Q->base[Q->front];//�����ͷԪ��

	Q->front = (Q->front + 1) % Q->qsize;//��ͷָ���1

	return OK;
}

Status QueueEmpty(SqQueue Q)
{//�ж϶���Q�Ƿ�Ϊ��

	if (Q.front == Q.rear)//Ϊ��
	{
		return True;
	}
	else
	{
		return False;
	}
}

QElemType GetHead(SqQueue Q)
{//������Q�ǿգ����ض�ͷԪ�ص�ֵ

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
{//������еĳ���
	return (Q.rear - Q.front + Q.qsize) % Q.qsize;
}

Status JosephCircle(QElemType n, QElemType m, QElemType i)// nΪ��������mΪѡ��������iΪ�ӵڼ����˿�ʼ����
{
	SqQueue Q;
	QElemType e;
	InitQueue(&Q, n);//����һ������Ϊn+1��˳��ѭ������

	int pos;

	for (int j = 0, pos = i; j < n; j++)//ֱ�ӽ�pos��λ�ö�λ����һ����������,pos����β�±�
	{
		EnQueue(&Q, pos++);//˳��ز��뵽��������Ӧ��λ����
		if (pos == n + 1)
		{
			//�������Ѿ����ˣ���β�����˵�n��λ�ã���β�±��Ѿ���n+1�ˣ��ͽ�pos��Ϊ1������һ�β���ֱ�ӵ���ͷ
			pos = 1;
		}
			
	}
	while (n-- && n >= 0)//��������һ�����˳���
	{
		for (int j = 0; j < m - 1; j++) 
		{
			DeQueue(&Q, &e);//���Ӻ�������ӣ����Ͽ�λ,�γ��޷�Ļ�
			EnQueue(&Q, e);
		}
		DeQueue(&Q, &e);//j = m��ʱ�򣬳��ӣ�jͬʱ���˼Ʋ�����ѭ�����Ʊ�־
		printf("%-4d", e);
	}
	return OK;
}
