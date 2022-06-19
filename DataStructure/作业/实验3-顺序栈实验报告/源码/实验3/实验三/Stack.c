#include "Stack.h"

Status InitStack(SqStack *S)
{//຅构造一个初始容量为Stack_Init_Size的空顺序栈S
	S->base = (SElemType*)malloc(Stack_Init_Size * sizeof(SElemType));//为顺序栈分配一个最大容量为Stack_Init_Size的数组空间
	if (! S->base) exit(Error);//分配空间失败退出

	S->top = S->base;//top初始为base，空栈
	S->stacksize = Stack_Init_Size;//stacksize置为栈的最大容量

	return OK;
}

Status Push(SqStack* S, SElemType e)
{//将值为e的数据压入栈S
	if (S->top - S->base == S->stacksize)//栈满
	{
		return Error;
	}

	*S->top = e;//元素e压栈，栈顶指针加1
	S->top++;

	return OK;
}

Status Pop(SqStack *S, SElemType *e)
{//从栈S中弹出一个元素赋给e
	if (S->top != S->base)//栈非空
	{
		*e = *(S->top-1);
		S->top--;
		return OK;
	}
	else
	{
		return Error;
	}
}

SElemType GetTop(SqStack S)
{//栈非空时，返回栈顶元素的值，不修改栈顶位置
	if (S.top != S.base)//栈非空
	{
		return *(S.top-1);
	}
	else return Error;
}

int Operate(int a, int Operator, int b)
{//实现四则运算
	if (Operator == 0)
	{
		return (a + b);
	}
	if (Operator == 1)
	{
		return (a - b);
	}
	if (Operator == 2)
	{
		return (a * b);
	}
	if (Operator == 3)
	{
		if (b != 0)
		{
			return (a / b);
		}
		else
		{
			printf("除数不能为0！\n");
		}
	}
}

Status IsOperator(char c, int *code)
{//判断字符c是否是运算符
	if (c == '+')
	{
		*code = 0;
		return True;
	}
	else if (c == '-')
	{
		*code = 1;
		return True;
	}
	else if (c == '*')
	{
		*code = 2;
		return True;
	}
	else if (c == '/')
	{
		*code = 3;
		return True;
	}
	else if (c == '(')
	{
		*code = 4;
		return True;
	}
	else if (c == ')')
	{
		*code = 5;
		return True;
	}
	else if (c == '#')
	{
		*code = 6;
		return True;
	}
	else
	{
		if ((47 < c)  && (c < 58))//如果字符c是数字'0'~'9'
		{
			*code = (int)c - 48;
			return False;
		}

		return Error;
	}
}

int Precede(int precode, int nextcode)
{//比较两个运算符的优先级
	/*
	错误	LNK2005	_compareoperator 已经在 main.obj 中定义
	实验三	C:\Users\CorneliusDeng\source\repos\实验三\实验三\Stack.obj	1
	reason:两个实现文件(main.c 和 Statck.c)中重复包含了头文件而造成的
	way:数组放到一个c中
	*/
	int compareoperator[7][7] = {{1, 1, -1, -1, -1, 1, 1},
								{1, 1, -1, -1, -1, 1, 1},
								{1, 1, 1, 1, -1, -1, 1},
								{1, 1, 1, 1, -1, 1, 1},
								{-1, -1, -1, -1, -1, 0, 2},
								{1, 1, 1, 1, 2, 1, 1},
								{-1, -1, -1, -1, -1, 2, 0}};
	if ((0 <= precode) && (precode <= 6) && (0 <= nextcode) && (nextcode <= 6))//表达式连写无效，机器无法判别
	{
		return compareoperator[precode][nextcode];
	}
	else
	{
		return Error;
	}
}

int EvaluateExpression()
{//接收键盘输入的四则运算表达式字符串（以#结束），计算表达式的值

	SqStack OPTR, OPND;//前者寄存运算符，后者寄存操作数或运算结果

	/*code为判断是否为运算符时的转换，numa、numb分别表示从OPND栈顶弹出的两位运算数,
	theta储存自OPTR栈顶弹出的运算符，x储存栈内取出运算级别相同的符号*/
	int code, numa, numb, theta, x;


	InitStack(&OPTR);//初始化
	InitStack(&OPND);

	printf("请输入运算式\t");
	char ch = getchar();
	Push(&OPTR, 6);//将表达式起始符“#”压入OPTR栈
	ch = getchar();//读入运算表达式的第一个非'#'字符
	

	while (ch != '#' || GetTop(OPTR) != 6)//表达式没有扫描完毕或者OPTR的栈顶元素不为“#”
	{
		if (IsOperator(ch, &code) == False) //ch是操作数则进入OPND栈
		{
			Push(&OPND, code);
			ch = getchar();
		}
		else if(IsOperator(ch, &code) == True)//ch是运算符则进入OPTR栈
		{
			if (Precede(GetTop(OPTR), code) == 1)//OPTR栈顶元素比ch的优先级高，进行运算操作
			{
				Pop(&OPND, &numb);//弹出OPND栈顶的两个运算数
				Pop(&OPND, &numa);
				Pop(&OPTR, &theta);//弹出OPTR栈顶的运算符
				Push(&OPND, Operate(numa, theta, numb));//将运算结果压入OPND栈
			}
			else if (Precede(GetTop(OPTR), code) == 0)//运算级别相同
			{
				Pop(&OPTR, &x);
				ch = getchar();
			}
			else if (Precede(GetTop(OPTR), code) == -1)//OPTR栈顶元素比ch的优先级低，压栈,读入下一字符
			{
				Push(&OPTR, code);
				ch = getchar();
			}

		}
		else
		{
			printf("出现语法错误！已经退出系统！");
			exit(0);
		}
	}
	return GetTop(OPND);//OPND栈顶元素即为表达式求值结果
}