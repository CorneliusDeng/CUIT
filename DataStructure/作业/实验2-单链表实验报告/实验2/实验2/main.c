#include "List.h"

int main()
{
	LNode L;//用LinkList就是一个野指针，不可取
	/*e存放专家信息, e1存放插入的专家信息，e2存放删除操作取出的专家信息，
	e3存放直接取出来的专家信息，e4表示要查找前驱信息的元素，pre_e储存查找的前驱元素*/
	ET e, e1, e2, e3, e4, pre_e;
	//n表示第一次输入专家信息个数，length存放链表长度，n1、n2分别为La、Lb长度
	int n, length, n1, n2;
	//index1表示要插入专家信息的位置,index2表示要删除专家信息的位置,index3表示直接取出专家信息的位置
	int index1, index2, index3;

	/*构造一个带头结点的空单链表L,并在其中插入专家信息，显示链表长度*/
	InitList_L(&L);
	printf("[链表创建成功]\n\n");
	printf("你想输入几个专家信息？\t");
	int temp1 = scanf("%d", &n);//VS用scanf会提示一个警告没有返回值。
	putchar('\n');
	for (int i = 1; i <= n; i++)
	{
		printf("请输入专家信息(专家号与姓名请用空格隔开，回车键结束)\n");
		int temp2 = scanf("%d", &e.num);
		char ch = getchar();//用来接收输入之间的空格
		gets(e.name);
		ListInsert_L(&L, i, e);
	}
	putchar('\n');
	printf("[专家信息如下]\n");
	printf("专家号\t姓名\n");
	PrintList_L(&L);
	putchar('\n');
	length = ListLength_L(&L);//求链表的长度
	printf("此时的链表长度为%d\n", length);

	/*在链表指定位置插入专家信息，插入后显示长度*/
	putchar('\n');
	printf("请问您想在哪个位置插入专家信息？\t");
	int temp3 = scanf("%d", &index1);
	putchar('\n');
	printf("请输入专家信息(专家号与姓名请用空格隔开，回车键结束)\n");
	int temp4 = scanf("%d", &e1.num);
	char ch1 = getchar();//用来接收输入之间的空格
	gets(e1.name);
	ListInsert_L(&L, index1, e1);
	putchar('\n');
	printf("[专家信息如下]\n");
	printf("专家号\t姓名\n");
	PrintList_L(&L);
	putchar('\n');
	length = ListLength_L(&L);//求链表的长度
	printf("此时的链表长度为%d\n", length);


	/*在链表指定位置删除专家信息，插入后显示长度*/
	putchar('\n');
	printf("请问您想在哪个位置删除专家信息？\t");
	int temp5 = scanf("%d", &index2);
	putchar('\n');
	ListDelete_L(&L, index2, &e2);
	putchar('\n');
	printf("[专家信息如下]\n");
	printf("专家号\t姓名\n");
	PrintList_L(&L);
	putchar('\n');
	length = ListLength_L(&L);//求链表的长度
	printf("此时的链表长度为%d\n", length);
	printf("被删除的专家信息是;%d\t%s\n", e2.num, e2.name);


	/*取表L中的第i个结点值赋值给参数e*/
	putchar('\n');
	printf("现在可以直接取出某一位专家的信息，请输入其位置信息\t");
	int temp6 = scanf("%d", &index3);
	putchar('\n');
	GetElem_L(&L, index3, &e3);
	printf("取出信息操作结果如下\n");
	printf("%d\t%s\n\n", e3.num, e3.name);

	/*查前驱*/
	printf("请问您想查找的某专家信息的编号是什么，以输出前驱元素\t");
	int temp7 = scanf("%d", &e4.num);
	PriorElem_L(&L, e4, &pre_e);
	printf("取出元素的前驱信息为：\n");
	printf("%d\t%s\n", pre_e.num, pre_e.name); 


	/*思考与提高*/
	putchar('\n');
	printf("*******************************思考与提高*******************************\n");
	LNode La, Lb, Lc;
	InitList_L(&Lc);
	printf("请输入想要创建的单链表La、Lb长度（中间用空格隔开）\t");
	int temp8 = scanf("%d%d", &n1, &n2);
	putchar('\n');
	printf("请输入La的元素\n");
	INLIST(&La, n1);
	putchar('\n');
	printf("请输入Lb的元素\n");
	INLIST(&Lb, n2);
	
	/*将La和Lb合并成一个有序单链表Lc*/
	putchar('\n');
	MerList(&La, &Lb, &Lc);
	printf("合并并输出这两个链表;\n");
	PrintList_L(&Lc);
	putchar('\n');


	FreeL(&Lb);//释放掉Lb与Lc，不让其影响拆分操作
	FreeL(&Lc);
	/*La拆分成同样结构的单链表Lb，Lc，Lb中全为La的奇数结点，Lc为为偶数结点*/
	putchar('\n');
	PartList(&La, &Lb, &Lc);
	printf("需要拆分的单链表La如下;\n");
	PrintList_L(&La);
	putchar('\n');
	printf("拆分之后La的奇数结点如下;\n");
	PrintList_L(&Lb);
	putchar('\n');
	printf("拆分之后La的偶数结点如下;\n");
	PrintList_L(&Lc);

	/*将La倒置*/
	putchar('\n');
	Reverse(&La);
	printf("将La倒置后的结果如下\n");
	PrintList_L(&La);
	putchar('\n');

	





	/*参考输入信息
	6745 溥仪
	5321 乾隆
	8091 康熙
	1344 赵匡胤
	7809 刘邦
	1356 李世民
	8012 李治
	5478 李隆基
	4238 嬴政
	4213 杨广
	1089 朱元璋
	9908 朱棣
	9816 雍正
	0812 刘秀
	1287 朱佑樘
	*/
}