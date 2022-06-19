#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>

struct student {
	int iNum;
	char cName[16];
	float fChineseScore;
	float fMathScore;
	float fEnglishScore;
};

typedef struct student STUDENT;

int MenuSelect(void);
int MenuHandle(int option);

void DisplayTranscript();
void InputTranscript(STUDENT MyClass[], int num);
void DisplayTranscriptOne(STUDENT MyScore);
void DisplayTranscriptAll(STUDENT *MyClass, int num);
void ModifyOne(STUDENT *MyInfo);

STUDENT FindTop(STUDENT *MyClass, int num);
STUDENT *FindByName(STUDENT *MyClass, int num, char *name);

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


int MenuSelect(void)
{
	int option;
	int input;

	system("cls");
	printf("\n\n\n");
	printf("==================================================\n");
	printf("|                                                |\n");
	printf("|                                                |\n");
	printf("|             3. 实验 9-3                        |\n");
	printf("|             4. 实验 9-4                        |\n");
	printf("|             5. 实验 9-5                        |\n");
	printf("|             6. 实验 9-5(3)                     |\n");
	printf("|             7. 退出                            |\n");
	printf("|                                                |\n");
	printf("|                                                |\n");
	printf("==================================================\n");
	printf("\n\t数字对应实验题号，请选择：");
	while (1)
	{
		input = scanf("%d", &option);
		if (input != 1)
		{
			printf("\n\t 输入错误，重选:");
			fflush(stdin);
		}
		else if ((option < 1) || (option > 7))
			printf("\n\t 选择错误，重选：");
		else break;
	}
	return option;
}


int MenuHandle(int option)
{
	int quit = 0;
	static STUDENT sTranscript[10];
	STUDENT TopOne, *pStudent = NULL;
	char name[16];
	int yon = 0;

	system("cls");
	switch (option)
	{
	case 3: printf("\t\t\t\t 实验 9-3\n\n");
		DisplayTranscript();
		printf("\t\t\t\t按任意键继续...\n");
		getch();
		break;
	case 4: printf("\t\t\t\t 实验 9-4\n\n");
		InputTranscript(sTranscript, 10);
		printf("\t\t\t\t按任意键显示学生成绩\n");
		getch();
		system("cls");
		DisplayTranscriptAll(sTranscript, 10);
		printf("\t\t\t\t按任意键继续...\n");
		getch();
		break;
	case 5: printf("\t\t\t\t 实验 9-5\n\n");
		TopOne = FindTop(sTranscript, 10);
		printf("最高分学生: \n");
		DisplayTranscriptOne(TopOne);
		printf("\n\n\t\t\t\t按任意键继续...\n");
		getch();
		break;
	case 6: printf("\t\t\t\t 实验 9-5(3)\n\n");
		printf("输入要查询的学生姓名：");
		scanf("%s", name);
		pStudent = FindByName(sTranscript, 10, name);
		if (pStudent)
		{
			fflush(stdin);
			DisplayTranscriptOne(*pStudent);
			printf("是否修改该学生信息(1/0): ");
			scanf("%d", &yon);
			if (yon)
			{
				printf("修改该学生信息: \n");
				ModifyOne(pStudent);
				printf("修改后数据： \n");
				DisplayTranscriptOne(*pStudent);
			}
		}
		else {
			printf("未找到该学生信息\n");
			DisplayTranscriptAll(sTranscript, 10);
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


// *************************************************************
// * 实验 9-3
// *************************************************************
void DisplayTranscript()
{
	STUDENT sTranscript[] = {
		{1001, "张三丰", 69.5, 61.5, 91.5},
		{1002, "李云龙", 92.5, 67.5, 81.5},
		{1003, "郭  靖", 79.5, 67.5, 85.5},
		{1004, "苗翠花", 83.0, 75.5, 84.0},
		{1005, "张无忌", 65.5, 81.5, 71.0}
	};
	STUDENT *pStu = sTranscript;
	int i;

	printf(" No.   Name   Chinese   Math   English\n");
	for (i = 0; i < sizeof(sTranscript) / sizeof(STUDENT); i++)
	{
		printf("%4d  %6s   %7.2f   %4.2f   %7.2f\n", pStu[i].iNum, pStu[i].cName, 
			pStu[i].fChineseScore, pStu[i].fMathScore, pStu[i].fEnglishScore);
	}
}


// *************************************************************
// * 实验 9-4（1）
// *************************************************************
void InputTranscript(STUDENT MyClass[], int num)
{
	int i;

	for (i = 0; i < num; i++)
	{
		printf("请输入第%d个学生的信息：", i + 1);
		scanf("%d%s%f%f%f", &MyClass[i].iNum, MyClass[i].cName, &MyClass[i].fChineseScore, 
			&MyClass[i].fMathScore, &MyClass[i].fEnglishScore);
	}
}
/*	测试用数据：
101 daf 100 90 100
102 fef 90 83 77
103 fda 99 10 12
104 dfe 90 88 77
105 kef 90 10 22
106 daf 88 77 67
107 fek 90 99 10
108 iik 99 30 66
109 jkj 89 88 77
110 dff 88 77 87
*/


// *************************************************************
// * 实验 9-4（2）
// *************************************************************
void DisplayTranscriptOne(STUDENT MyScore)
{
	printf(" No.   Name   Chinese   Math   English\n");
	printf("%4d  %6s   %7.2f   %4.2f   %7.2f\n", MyScore.iNum, MyScore.cName, MyScore.fChineseScore, 
		MyScore.fMathScore, MyScore.fEnglishScore);
}


// *************************************************************
// * 实验 9-4（3)
// *************************************************************
void DisplayTranscriptAll(STUDENT *MyClass, int num)
{
	int i;

	printf("No\tName\tChinese\tMath\tEnglish\n");
	for (i = 0; i < num; i++)
	{
		printf("%2d\t%4s\t%7.0f\t%4.0f\t%7.0f\n", (MyClass + i)->iNum, (MyClass + i)->cName, (MyClass + i)->fChineseScore, 
			(MyClass + i)->fMathScore, (MyClass + i)->fEnglishScore);
	}
}


// *************************************************************
// * 实验 9-4（4）
// *************************************************************
void ModifyOne(STUDENT *MyInfo)
{
	printf("请输入该学生的信息：学号，姓名，语文成绩，数学成绩，英语成绩\n");
	scanf("%d%s%f%f%f", &MyInfo->iNum, MyInfo->cName, &MyInfo->fChineseScore, &MyInfo->fMathScore, &MyInfo->fEnglishScore);
}


// *************************************************************
// * 实验 9-5（1）
// *************************************************************
STUDENT FindTop(STUDENT *MyClass, int num)
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

// *************************************************************
// 实验 9-5（2）
// *************************************************************
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