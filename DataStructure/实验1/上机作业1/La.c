#include "La.h"

int InitList(SqList *La)
{//构造一个空的顺序表La
	La->elem = (int*)malloc(sizeof(int) * MAXSIZE);//为顺序表分配一个大小为MAXSIZE的数组空间
	if (!La->elem) exit(0);		//储存分配失败退出
	La->length = 0;					//空表长度为0
	return 1;
}
void KongList(SqList *La)
{//将La置为空表
	La->length = 0;
}

void FreeList(SqList *La)
{//销毁La
	free(La->elem);
}

int CalcueList(SqList* La)
{//求La的表长
	printf("当前顺序表的长度为：%d\n", La->length);
}

int ListInsert(SqList *La, int i, int e)
{//在顺序表La中第i个位置插入新的元素e
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

int LiseDelete(SqList *La, int i)
{//在顺序表La中删除第i个元素，i值的合法范围是1<=i<=La.length
	if ((i < 1) || (i > La->length)) return False; //i值不合法
	
	for (int j = i; j <= La->length - 1; j++)
	{
		La->elem[j-1] = La->elem[j];//被删除元素之后的元素转移
	}

	--La->length;//表长减1

	return 1;
}

int LocateElem(SqList La, int e)
{//在顺序表La中查找值为e的数据元素，返回其序号
	int flag = -1;
	for (int i = 0; i < La.length; i++)
	{
		if (La.elem[i] == e)
		{
			flag = 1;
			return i;//查找成功（return之后便退出了循环，所以不需要break）
		}	
	}
	return flag;
}

void PrintList(SqList La)
{//打印La中的元素值
	for (int i = 0; i < La.length; i++)
	{
		printf("%-4d", La.elem[i]);
	}
	putchar('\n');
}

void MergeList(SqList *La, SqList *Lb, SqList *Lc)
{//归并La和Lb得到新的顺序线性表Lc 
	int * pa, * pa_last, * pb, * pb_last, * pc;//
	pa = La->elem;  //pa指向La第一个元素
	pb = Lb->elem;  //pb指向Lb第二个元素
	Lc->length = La->length + Lb->length;//求得La和Lb长度赋给Lc
	pc = Lc->elem = (int*)malloc(Lc->length * sizeof(int));//分配所需空间
	if (!Lc->elem)   //分配失败
	{
		exit(0);
	}	 
	pa_last = La->elem + La->length - 1; //指向La最后一个元素
	pb_last = Lb->elem + Lb->length - 1; //指向Lb最后一个元素
	while (pa <= pa_last && pb <= pb_last)   //表La和表Lb均有元素没有归并
	{
		if (*pa <= *pb)   //La的当前元素不大于Lb当前的元素
		{
			*pc++ = *pa++;  //将pa指向的元素赋给pc 后指向下一个单元
		}
		else
		{
			*pc++ = *pb++;  //将pb指向的元素赋给Pc 后指向下一个单元
		}
	}
	while (pa <= pa_last)    //表La的元素全都归并
	{
		*pc++ = *pa++;  //插入La的剩余元素
	}
	while (pb <= pb_last)    //表Lb的元素全都归并
	{
		*pc++ = *pb++;  //插入Lb的剩余元素
	}
}

void union_Sq(SqList *La, SqList *Lb, SqList  *Lc) 
{//求La和Lb的并集Lc
	int i, index;
	Lc->length = La->length;
	for (i = 0; i < La->length; i++)
	{
		Lc->elem[i] = La->elem[i];//将La的数据全部赋值给Lc
	}
	for (i = 0; i < Lb->length; i++) 
	{
		index = LocateElem(*La, Lb->elem[i]);//查找Lb中与La不同的数据，查找到了返回-1给index
		if (index == -1)
		{
			ListInsert(Lc, Lc->length + 1, Lb->elem[i]);
		}
			
	}
}

void intersection_Sq(SqList* La, SqList* Lb, SqList* Lc)
{//求La和Lb的交集
	int i, index;
	for (i = 0; i < Lb->length; i++)
	{
		index = LocateElem(*La, Lb->elem[i]);//查找Lb中与La相同的数据，查找到了返回其下标给index
		if (index != -1)
		{
			ListInsert(Lc,Lc->length+1,Lb->elem[i]);
		}
	}
}

