#include "Stack.h"

void main() 
{

	SqStack* Pi;  //�����ջ
	Status result;
	int n;

	Pi = (SqStack*)malloc(sizeof(SqStack*));


	result = InitStack(Pi);
	printf("%s\n", result == OK ? "�����ջ��ʼ���ɹ�" : "�����ջ��ʼ��ʧ��");

	printf("������Ҫ�����t(n)������nֵ��\t");
	int temp = scanf("%d", &n);
	Push(Pi, 0);//t(0)=0
	for (int i = 1; i <= n; i++) //nֱ�Ӵ�1��ʼ��
	{
		Push(Pi, 2 * GetElem(Pi, i / 2) + i);
	}
	printf("\n\n����ջ����ʽ����Ľ����:%d\n\n", GetTop(Pi));	//����ջ����ʽ����Ľ��

	printf("���õݹ�����Ľ����:%d\n\n", function(n));	//���õݹ�����Ľ��
}

