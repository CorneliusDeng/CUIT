#include "Queue.h"

void main()
{
	SqQueue Q;
	/*
		size为顺序循环队列的容量
		e为接收器，接收每次出队的元素值
		value也为接收器，接收每次取队头的元素值
		length为顺序循环队列的长度
	*/
	int size, e, value, length;

	printf("请问您想构造容量为多少的顺序循环队列？\t");
	int tmep1 = scanf("%d", &size);
	if (OK == InitQueue(&Q, size))
	{
		printf("\n[一个容量为%d的空顺序循环队列Q已构造成功！]\n\n", size);
	}
	
	printf("为了简化数据，根据您构造的队列容量，顺序递增地插入自然数到队列中直至占用一半的空间，结果如下\n");
	int key = 1;
	for (int i = 0; i < size/2; i++)
	{
		EnQueue(&Q, key);
		key++;
	}
	for (int i = 0; i < size/2; i++)
	{
		printf("%-4d", Q.base[i]);
	}
	length = QueueLength(Q);
	printf("\n此时队列的长度是：%d", length);

	printf("\n\n现在进行出队操作直至队列剩一个数据,并依次打印出队的队列元素\n");
	for (int j = 0; j < size/2 - 1; j++)
	{
		DeQueue(&Q, &e);
		printf("%-4d", e);
	}
	length = QueueLength(Q);
	printf("\n此时队列的长度是：%d", length);
	
	printf("\n\n现在让我们来看看是否已出队完毕，队列是否为空\n");
	if (True == QueueEmpty(Q)) 
	{
		printf("This queue is empty!");
	}
	else
	{
		printf("This queue is not empty!");
	}
	length = QueueLength(Q);
	printf("\n此时队列的长度是：%d", length);

	printf("\n\n现在让我们来看看取队头操作（出队操作中剩余的唯一一个数据）\n");
	value = GetHead(Q);
	printf("其值为：%d", value);
	length = QueueLength(Q);
	printf("\n此时队列的长度是：%d\n\n", length); 

	printf("[顺序循环队列测试完毕！]\n\n接下来玩三次“约瑟夫环”模型为基础的游戏\n");
	printf("\n8个人玩，从第1个人开始报数，报到4出队，他们的出队顺序如下：\n");
	JosephCircle(8, 4, 1);
	putchar('\n');
	printf("\n9个人玩，从第3个人开始报数，报到4出队，他们的出队顺序如下：\n");
	JosephCircle(9, 4, 3);
	putchar('\n');
	printf("\n19个人玩，从第5个人开始报数，报到3出队，他们的出队顺序如下：\n");
	JosephCircle(19, 3, 5);
	putchar('\n');
	

}