#include "Stack.h"

void main() 
{

	SqStack* Pi;  //运算符栈
	Status result;
	int n;

	Pi = (SqStack*)malloc(sizeof(SqStack*));


	result = InitStack(Pi);
	printf("%s\n", result == OK ? "运算符栈初始化成功" : "运算符栈初始化失败");

	printf("请输入要计算的t(n)函数的n值：\t");
	int temp = scanf("%d", &n);
	Push(Pi, 0);//t(0)=0
	for (int i = 1; i <= n; i++) //n直接从1开始算
	{
		Push(Pi, 2 * GetElem(Pi, i / 2) + i);
	}
	printf("\n\n采用栈的形式算出的结果是:%d\n\n", GetTop(Pi));	//采用栈的形式算出的结果

	printf("采用递归算出的结果是:%d\n\n", function(n));	//采用递归算出的结果
}

