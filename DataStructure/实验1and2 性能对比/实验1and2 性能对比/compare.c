#include "compare.h"

/*顺序表操作*/

//定位元素
int LocateElem(SqList La, int e, int *index)
{//在顺序表La中查找值为e的数据元素
	int flag = -1;
	for (int i = 0; i < La.length; i++)
	{
		if (La.elem[i] == e)
		{
			flag = 1;
			*index = i + 1;
		}
	}
	return flag;
}

//插入元素
int ListInsert(SqList* La, int i, int e)
{//在顺序表La中第i个位置插入新的元素e，i值得合法范围是1<=i<=La.length+1
	if ((i < 1) || (i > La->length + 1)) return False;//i值不合法

	if (La->length == MAXSIZE) return False;//当前储存空间已满

	for (int j = La->length - 1; j >= i - 1; j--)//插入位置及之后的元素后移
	{
		La->elem[j + 1] = La->elem[j];
	}

	La->elem[i - 1] = e;//将新元素e放入第i个位置
	++La->length;		//表长加1
	return 1;
}

//删除元素
int LiseDelete(SqList* La, int i)
{//在顺序表La中删除第i个元素，i值的合法范围是1<=i<=La.length
	if ((i < 1) || (i > La->length)) return False; //i值不合法

	for (int j = i; j <= La->length - 1; j++)
	{
		La->elem[j - 1] = La->elem[j];//被删除元素之后的元素转移
	}

	--La->length;//表长减1

	return 1;
}

//附带基本操作
int InitList(SqList* La)
{//构造一个空的顺序表La
	La->elem = (int*)malloc(sizeof(int) * MAXSIZE);//为顺序表分配一个大小为MAXSIZE的数组空间
	if (!La->elem) exit(0);		//储存分配失败退出
	La->length = 0;					//空表长度为0
	return 1;
}
int CalcueList(SqList* La)
{//求La的表长
	printf("当前顺序表的长度为：%d\n", La->length);
}
void PrintList(SqList La)
{//打印La中的元素值
	for (int i = 0; i < La.length; i++)
	{
		printf("%-4d", La.elem[i]);
	}
	putchar('\n');
}


/*************************************************************************************************************/


/*链表操作*/

//定位元素
int ListLocate(LinkList L, int e, int *location)
{//在链表L中查找值为e的数据元素，返回其序号
	p = L;
	int flag = -1;
	*location = 0;
	while (p != NULL && e != p->data)  
	{
		p = p->next;
		(*location)++;
	}
	if (p == NULL) return Error; 
	if (p->data == e)
	{
		flag = 1;
	}
	
	return flag;
}

//插入元素
int ListInsert_L(LinkList L, int i, int e)
{//在表L的第i个位置上插入一个值为e的数据元素
	p = L;
	int step = 0;		  //step为计数器
	while (p != NULL && step < i - 1)  //寻找第i－1个结点，令p指向它
	{
		p = p->next;
		step++;
	}
	if (p == NULL || step > i - 1) return Error; 	//i大于表长+1或者i小于1
	LinkList s = (LinkList)malloc(sizeof(LNode)); //申请新结点s
	if (s == NULL)  exit(Error);
	s->data = e;
	s->next = p->next;        // 在 p结点之后插入新结点s
	p->next = s;

	return OK;
}

//删除元素
int ListDelete_L(LinkList L, int i)
{//在表L中删除位序为 i 的数据元素
	p = L;
	int step = 0;		  //step为计数器
	while (p->next && step < i - 1)  //寻找第i－1个结点，由p指向它
	{
		p = p->next;
		step++;
	}
	if (!(p->next) || step > i - 1) return Error; //i大于表长或者i小于1
	LinkList q = p->next;		      //q指向要删除的结点i
	p->next = q->next;      // 删除结点i
	free(q);			        //释放结点q的存储空间
	return OK;
}

//附带基本操作
int InitList_L(LinkList L)
{//构造一个头结点为空的单链表L
	 //L = (LinkList)malloc(sizeof(LNode));//C里面，形参已经有了内存空间，再开辟空间，就会使得形参无用
	if (L == NULL)
	{
		printf("申请空间失败！\n");
		exit(Error);
	}
	L->next = NULL;

	return OK;
}
int ListLength_L(LinkList L)
{//求链表的长度
	p = L->next;
	int length = 0;
	while (p != NULL)
	{
		length++;
		p = p->next;//将p移动到下一个结点
	}
	return length;
}
void PrintList_L(LinkList L)
{//打印输出单链表中的结点元素值
	if (L->next == NULL) return Error;
	p = L->next;

	while (p != NULL)
	{
		printf("%d\t", p->data);
		p = p->next;
	}
}