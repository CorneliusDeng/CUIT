#include "List.h"

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

int GetElem_L(LinkList L, int i, ET* e)
{//取表L中的第i个结点值赋值给参数e
	p = L->next;
	int step = 1;	         //step为计数器		
	while (p && step < i)	//查找第i个元素
	{
		p = p->next;
		step++;
	}
	if (p == NULL || step > i)  //第i个元素不存在
	{
		return Error;
	}
	*e = p->data;         //取出第i个元素的值赋给e         
	return OK;
}

int ListInsert_L(LinkList L, int i, ET e)
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

int ListDelete_L(LinkList L, int i, ET* e)
{//在表L中删除位序为 i 的数据元素，并将删除的元素赋值给e
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
	*e = q->data;
	free(q);			        //释放结点q的存储空间
	return OK;
}

int PriorElem_L(LinkList L, ET e, ET* pre_e)
{//在表L中求元素e的直接前驱元素，并赋值给pre_e
	LinkList q = L;
	p = L->next;

	while (p && p->data.num != e.num)
	{
		q = p;
		p = q->next;
	}

	if (!p) return Error;

	*pre_e = q->data;//p->data为当前元素，要去前驱，用q

	return OK;
}

void PrintList_L(LinkList L)
{//打印输出单链表中的结点元素值
	if (L->next == NULL) return Error;
	p = L->next;

	while (p != NULL)
	{
		printf("%d\t%s\n", p->data.num, p->data.name);
		p = p->next;
	}
}


void INLIST(LinkList L, int n)
{//正位序输入n个元素的值，建立带有表头结点的单链表
	//L = (LinkList)malloc(sizeof(LNode));
	//L->next = NULL;//先建立一个带头结点的空链表

	/*前面的都注释掉，就是一个创建链表改成依序输入信息的函数*/

	LinkList r = L;//尾指针r指向头结点

	for (int i = 0; i < n; i++)
	{
		p = (LinkList)malloc(sizeof(LNode));//生成新节点
		if (p == NULL) return Error;
		printf("请输入专家信息(专家号与姓名请用空格隔开，回车键结束)\n");
		int temp = scanf("%d%s", &p->data.num, &p->data.name);//输入元素值赋给新结点p的数据域
		p->next = NULL;
		r->next = p;//将新结点p插入尾结点r之后
		r = p;//r指向新的尾结点p
	}
}


int MerList(LinkList La, LinkList Lb, LinkList Lc)
{//合并两个链表
	int k = 0;
	int c = 1;//c用来计数，每次插入后增1，确保每次插入的都是链表的末尾

	LinkList pa, pb;

	pa = La->next;//pa，pb分别指向La表与Lb表中当前待比较插入的结点
	pb = Lb->next;

	while (pa && pb)
	{

		if ((pa->data.num) <= (pb->data.num))//按标号有序地插入Lc中
		{
			ListInsert_L(Lc, c, pa->data);
			c++;
			pa = pa->next;
		}
		else
		{
			ListInsert_L(Lc, c, pb->data);
			c++;
			pb = pb->next;
		}
	}
	while (pa)//pb插完了
	{
		ListInsert_L(Lc, c++, pa->data);
		pa = pa->next;
	}
	while (pb)//pa插完了
	{
		ListInsert_L(Lc, c++, pb->data);
		pb = pb->next;
	}
	return OK;
}

int Reverse(LinkList L)
{//单链表倒置 
	
	LinkList tp = L->next;
	p = L;
	int i = 1, j, c;
	ET e;

	while (tp->next)
	{
		tp = tp->next;
		i++;//tp在L上滑动，用来计数，i表示此时的链表长度
	}
	c = i + 1;
	for (j = 1; j < i; j++)
	{
		GetElem_L(L, 1, &e);//依次取出链表中的元素
		ListInsert_L(L, c, e);//插入到末尾
		L->next = L->next->next;//位置定位到下一个元素
		c--;//不断往前插入
	}
	return OK;
}

int PartList(LinkList La, LinkList Lb, LinkList Lc)
{//拆分La
	if (La->next == NULL) return Error;
	LNode* p1 = La->next;//用LinkList定义的p总是运行出错，可能是前面有数据残留
	int index = 1;
	int a = 1, b = 1;

	while (p1 != NULL)
	{
		if (index % 2 == 0)
		{
			ListInsert_L(Lc, a, p1->data);//Lc中含有La表的偶数结点
			a++;
		}
		else
		{
			ListInsert_L(Lb, b, p1->data);//Lb中只含La表中奇数结点
			b++;
		}
		index++;
		p1 = p1->next;
	}
	return OK;
}

void FreeL(LinkList Lb)
{
	Lb->next = NULL;
}