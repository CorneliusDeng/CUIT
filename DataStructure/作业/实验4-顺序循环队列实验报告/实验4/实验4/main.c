#include "Queue.h"

void main()
{
	SqQueue Q;
	/*
		sizeΪ˳��ѭ�����е�����
		eΪ������������ÿ�γ��ӵ�Ԫ��ֵ
		valueҲΪ������������ÿ��ȡ��ͷ��Ԫ��ֵ
		lengthΪ˳��ѭ�����еĳ���
	*/
	int size, e, value, length;

	printf("�������빹������Ϊ���ٵ�˳��ѭ�����У�\t");
	int tmep1 = scanf("%d", &size);
	if (OK == InitQueue(&Q, size))
	{
		printf("\n[һ������Ϊ%d�Ŀ�˳��ѭ������Q�ѹ���ɹ���]\n\n", size);
	}
	
	printf("Ϊ�˼����ݣ�����������Ķ���������˳������ز�����Ȼ����������ֱ��ռ��һ��Ŀռ䣬�������\n");
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
	printf("\n��ʱ���еĳ����ǣ�%d", length);

	printf("\n\n���ڽ��г��Ӳ���ֱ������ʣһ������,�����δ�ӡ���ӵĶ���Ԫ��\n");
	for (int j = 0; j < size/2 - 1; j++)
	{
		DeQueue(&Q, &e);
		printf("%-4d", e);
	}
	length = QueueLength(Q);
	printf("\n��ʱ���еĳ����ǣ�%d", length);
	
	printf("\n\n�����������������Ƿ��ѳ�����ϣ������Ƿ�Ϊ��\n");
	if (True == QueueEmpty(Q)) 
	{
		printf("This queue is empty!");
	}
	else
	{
		printf("This queue is not empty!");
	}
	length = QueueLength(Q);
	printf("\n��ʱ���еĳ����ǣ�%d", length);

	printf("\n\n����������������ȡ��ͷ���������Ӳ�����ʣ���Ψһһ�����ݣ�\n");
	value = GetHead(Q);
	printf("��ֵΪ��%d", value);
	length = QueueLength(Q);
	printf("\n��ʱ���еĳ����ǣ�%d\n\n", length); 

	printf("[˳��ѭ�����в�����ϣ�]\n\n�����������Ρ�Լɪ�򻷡�ģ��Ϊ��������Ϸ\n");
	printf("\n8�����棬�ӵ�1���˿�ʼ����������4���ӣ����ǵĳ���˳�����£�\n");
	JosephCircle(8, 4, 1);
	putchar('\n');
	printf("\n9�����棬�ӵ�3���˿�ʼ����������4���ӣ����ǵĳ���˳�����£�\n");
	JosephCircle(9, 4, 3);
	putchar('\n');
	printf("\n19�����棬�ӵ�5���˿�ʼ����������3���ӣ����ǵĳ���˳�����£�\n");
	JosephCircle(19, 3, 5);
	putchar('\n');
	

}