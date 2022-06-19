#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>

struct student
{
	int iNum;					//学号
	char cName[16];				//姓名
	float fChineseScore;		//语文成绩
	float fMathScore;			//数学成绩
	float fEnglishScore;		//英语成绩
};
typedef struct student STUDENT;//对结构体进行更名

//实验9-3-1
//用“指针名+下标”的方式，利用结构体指针变量pStu访问结构体
void DisplayTranscript1()//
{
	STUDENT sTranscript[] = {{1001, "张三丰", 69.5, 61.5, 91.5},
							{1002, "李云龙", 92.5, 67.5, 81.5},
							{1003, "郭  靖", 79.5, 67.5, 86.5},
							{1004, "苗翠花", 83.0, 75.5, 84.0},
							{1005, "张无忌", 65.5, 81.5, 71.0}};
	STUDENT *pStu = sTranscript;//对指针结构体的初始化，pStu指向成绩表
	int i;

	printf("NO.   Name   Chinese   Math   English\n");
	for(i = 0; i < sizeof(sTranscript)/sizeof(STUDENT); i++)
	{
		printf("%4d %s  %6.1f  %6.1f  %6.1f\n", pStu[i].iNum, pStu[i].cName,
			pStu[i].fChineseScore, pStu[i].fMathScore, pStu[i].fEnglishScore);
	}
}

//实验9-3-2
//用“指针名+偏移量”的方式，利用结构体指针变量pStu访问结构体
void DisplayTranscript2()
{
	STUDENT sTranscript[] = {{1001, "张三丰", 69.5, 61.5, 91.5},
							{1002, "李云龙", 92.5, 67.5, 81.5},
							{1003, "郭  靖", 79.5, 67.5, 86.5},
							{1004, "苗翠花", 83.0, 75.5, 84.0},
							{1005, "张无忌", 65.5, 81.5, 71.0}};
	STUDENT *pStu = sTranscript;//对指针结构体的初始化，pStu指向成绩表
	int i;

	printf("NO.   Name   Chinese   Math   English\n");
	for(i = 0; i < sizeof(sTranscript)/sizeof(STUDENT); i++)
	{
		printf("%4d %s  %6.1f  %6.1f  %6.1f\n", (pStu + i)->iNum, (pStu + i)->cName,
			(pStu + i)->fChineseScore, (pStu + i)->fMathScore, (pStu + i)->fEnglishScore);
	}
}

//实验9-3-3
//用“指针移动”的方式，利用结构体指针变量pStu访问结构体
void DisplayTranscript3()
{
	STUDENT sTranscript[] = {{1001, "张三丰", 69.5, 61.5, 91.5},
							{1002, "李云龙", 92.5, 67.5, 81.5},
							{1003, "郭  靖", 79.5, 67.5, 86.5},
							{1004, "苗翠花", 83.0, 75.5, 84.0},
							{1005, "张无忌", 65.5, 81.5, 71.0}};
	STUDENT *pStu;

	printf("NO.   Name   Chinese   Math   English\n");
	for(pStu = sTranscript; pStu < sTranscript + 5; pStu++)
	{
		printf("%4d %s  %6.1f  %6.1f  %6.1f\n", pStu->iNum, pStu->cName,
			pStu->fChineseScore, pStu->fMathScore, pStu->fEnglishScore);
	}
}

//实验9-4(1)    函数功能：输入学生信息，存放在结构体数组中
void InputTranscript(STUDENT MyClass[], int num)//MyClass为存放成绩表的数组，num为学生总人数
{
	int i;
	printf("请输入%d名学生的学号、姓名、语数英三科成绩：\n", num);
	for(i = 0; i < num; i++)
	{
		scanf("%d%s%f%f%f", &MyClass[i].iNum, MyClass[i].cName, &MyClass[i].fChineseScore, 
							&MyClass[i].fMathScore, &MyClass[i].fEnglishScore);
	}
}

//实验9-4(2)    函数功能：显示某个学生的信息
void DisplayTranscriptOne(STUDENT MyScore)//MyScore为存放单个学生信息的结构体
{
	printf(" No.   Name   Chinese   Math   English\n");
	printf("%4d  %6s   %7.2f   %4.2f   %7.2f\n", MyScore.iNum, MyScore.cName, MyScore.fChineseScore, 
		MyScore.fMathScore, MyScore.fEnglishScore);
}

//实验9-4(3)    函数功能：显示所有学生的信息
void DisplayTranscriptAll(STUDENT *MyClass, int num)//MyClass指向存放学生信息的结构体数组，num为学生总人数
{
	int i;
	printf("所有学生的信息如下所示\n");
	for(i = 0; i < num; i++)
	{
		printf("%d\t%s\t%.2f\t%.2f\t%.2f\n", MyClass[i].iNum, MyClass[i].cName, MyClass[i].fChineseScore, 
							MyClass[i].fMathScore, MyClass[i].fEnglishScore);
	}
}


//实验9-4(4)    函数功能：重新输入数据，修改学生的信息
void ModifyOne(STUDENT *MyInfo)//MyInfo指向存放学生信息的结构体
{
	printf("请输入该学生的信息：学号，姓名，语文成绩，数学成绩，英语成绩\n");
	scanf("%d%s%f%f%f", &MyInfo->iNum, MyInfo->cName, &MyInfo->fChineseScore, &MyInfo->fMathScore, &MyInfo->fEnglishScore);
}

// 实验 9-5(1)  函数功能: 返回学生成绩表中总分最高的学生信息
STUDENT FindTop(STUDENT *MyClass, int num)//MyClass指向存放学生信息的结构体数组，num为学生总人数
{
	int i;
	float topScore = MyClass->fChineseScore + MyClass->fMathScore + MyClass->fEnglishScore;
	STUDENT top = *MyClass;

	for (i = 1; i < num; i++)
	{
		if (MyClass[i].fChineseScore + MyClass[i].fMathScore + MyClass[i].fEnglishScore > topScore)
		{
			top = MyClass[i];
			topScore = MyClass[i].fChineseScore + MyClass[i].fMathScore + MyClass[i].fEnglishScore;
		}
	}
	return top;
}

// 实验 9-5(2)  函数功能：根据“姓名”信息查询，返回学生成绩表中该学生的信息
//MyClass指向存放学生信息的结构体数组，num为学生总人数，pName为要查找的学生信息
STUDENT *FindByName(STUDENT *MyClass, int num, char *name)
{
	int i;

	for (i = 0; i < num; i++)
	{
		if (strcmp(MyClass[i].cName, name) == 0)
			return &MyClass[i];
	}
	return NULL;
}

int MenuSelect(void)
{
	int option;
	int input;

	system("cls");//清屏
	printf("\n\n\n");
	printf("==================================================\n");
	printf("|                                                |\n");
	printf("|                                                |\n");
	printf("|                                                |\n");
	printf("|             1. 实验 9-3-1                      |\n");
	printf("|             2. 实验 9-3-2                      |\n");
	printf("|             3. 实验 9-3-3                      |\n");
	printf("|             4. 实验 9-4                        |\n");
	printf("|             5. 实验 9-5                        |\n");
	printf("|             6. 实验 9-5(3)                     |\n");
	printf("|             7. 退出                            |\n");
	printf("|                                                |\n");
	printf("|                                                |\n");
	printf("|                                                |\n");
	printf("==================================================\n");
	printf("\n\t数字对应实验题号，请选择：");
	while (1)
	{
		input = scanf("%d", &option);
		if ((option < 1) || (option > 7))
			printf("\n\t 选择错误，重选：");
		else break;
	}
	return option;
}

int MenuHandle(int option)
{
	int quit = 0, yes = 0;
	static STUDENT sTranscript[5];//定义五个学生的信息
	STUDENT TopOne, *pStudent = NULL;
	char name[16];

	system("cls");
	switch (option)
	{
	case 1: printf("\t\t\t\t 实验 9-3-1\n\n");
		DisplayTranscript1();
		printf("\t\t\t\t按任意键继续...\n");
		getch();//getche或者getch的作用于getchar类似，但前者读入不在屏幕显示，应包含头文件conio.h
		break;
	case 2: printf("\t\t\t\t 实验 9-3-2\n\n");
		DisplayTranscript2();
		printf("\t\t\t\t按任意键继续...\n");
		getch();
		break;
	case 3: printf("\t\t\t\t 实验 9-3-3\n\n");
		DisplayTranscript3();
		printf("\t\t\t\t按任意键继续...\n");
		getch();
		break;
	case 4: printf("\t\t\t\t 实验 9-4\n\n");
		InputTranscript(sTranscript, 5);
		printf("\t\t\t\t按任意键显示学生成绩\n");
		getch();
		system("cls");
		DisplayTranscriptAll(sTranscript, 5);
		printf("\t\t\t\t按任意键继续...\n");
		getch();
		break;
	case 5: printf("\t\t\t\t 实验 9-5\n\n");
		TopOne = FindTop(sTranscript, 5);
		printf("最高分学生: \n");
		DisplayTranscriptOne(TopOne);
		printf("\n\n\t\t\t\t按任意键继续...\n");
		getch();
		break;
	case 6: printf("\t\t\t\t 实验 9-5(3)\n\n");
		printf("输入要查询的学生姓名：");
		scanf("%s", name);
		pStudent = FindByName(sTranscript, 5, name);
		if (pStudent != NULL)
		{
			fflush(stdin);
			DisplayTranscriptOne(*pStudent);
			printf("是否修改该学生信息(1/0): ");//用1/0来标记是否要修改学生的信息
			scanf("%d", &yes);
			if (yes == 1)
			{
				printf("修改该学生信息: \n");
				ModifyOne(pStudent);
				printf("修改后数据： \n");
				DisplayTranscriptOne(*pStudent);
			}
		}
		else {
			printf("未找到该学生信息\n");
			DisplayTranscriptAll(sTranscript, 5);
		}
		printf("\t\t\t\t按任意键继续...\n");
		getch();
		break;
	case 7:
		quit = 1;
		break;
	}
	return quit;
}

int main(void)
{
	int option, quit;

	do
	{
		option = MenuSelect();
		quit = MenuHandle(option);
	} while (quit != 1);
	
	return 0;
}