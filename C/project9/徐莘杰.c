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
	printf("|             3. ʵ�� 9-3                        |\n");
	printf("|             4. ʵ�� 9-4                        |\n");
	printf("|             5. ʵ�� 9-5                        |\n");
	printf("|             6. ʵ�� 9-5(3)                     |\n");
	printf("|             7. �˳�                            |\n");
	printf("|                                                |\n");
	printf("|                                                |\n");
	printf("==================================================\n");
	printf("\n\t���ֶ�Ӧʵ����ţ���ѡ��");
	while (1)
	{
		input = scanf("%d", &option);
		if (input != 1)
		{
			printf("\n\t ���������ѡ:");
			fflush(stdin);
		}
		else if ((option < 1) || (option > 7))
			printf("\n\t ѡ�������ѡ��");
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
	case 3: printf("\t\t\t\t ʵ�� 9-3\n\n");
		DisplayTranscript();
		printf("\t\t\t\t�����������...\n");
		getch();
		break;
	case 4: printf("\t\t\t\t ʵ�� 9-4\n\n");
		InputTranscript(sTranscript, 10);
		printf("\t\t\t\t���������ʾѧ���ɼ�\n");
		getch();
		system("cls");
		DisplayTranscriptAll(sTranscript, 10);
		printf("\t\t\t\t�����������...\n");
		getch();
		break;
	case 5: printf("\t\t\t\t ʵ�� 9-5\n\n");
		TopOne = FindTop(sTranscript, 10);
		printf("��߷�ѧ��: \n");
		DisplayTranscriptOne(TopOne);
		printf("\n\n\t\t\t\t�����������...\n");
		getch();
		break;
	case 6: printf("\t\t\t\t ʵ�� 9-5(3)\n\n");
		printf("����Ҫ��ѯ��ѧ��������");
		scanf("%s", name);
		pStudent = FindByName(sTranscript, 10, name);
		if (pStudent)
		{
			fflush(stdin);
			DisplayTranscriptOne(*pStudent);
			printf("�Ƿ��޸ĸ�ѧ����Ϣ(1/0): ");
			scanf("%d", &yon);
			if (yon)
			{
				printf("�޸ĸ�ѧ����Ϣ: \n");
				ModifyOne(pStudent);
				printf("�޸ĺ����ݣ� \n");
				DisplayTranscriptOne(*pStudent);
			}
		}
		else {
			printf("δ�ҵ���ѧ����Ϣ\n");
			DisplayTranscriptAll(sTranscript, 10);
		}
		printf("\t\t\t\t�����������...\n");
		getch();
		break;
	case 7:
		quit = 1;
		break;
	}
	return quit;
}


// *************************************************************
// * ʵ�� 9-3
// *************************************************************
void DisplayTranscript()
{
	STUDENT sTranscript[] = {
		{1001, "������", 69.5, 61.5, 91.5},
		{1002, "������", 92.5, 67.5, 81.5},
		{1003, "��  ��", 79.5, 67.5, 85.5},
		{1004, "��仨", 83.0, 75.5, 84.0},
		{1005, "���޼�", 65.5, 81.5, 71.0}
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
// * ʵ�� 9-4��1��
// *************************************************************
void InputTranscript(STUDENT MyClass[], int num)
{
	int i;

	for (i = 0; i < num; i++)
	{
		printf("�������%d��ѧ������Ϣ��", i + 1);
		scanf("%d%s%f%f%f", &MyClass[i].iNum, MyClass[i].cName, &MyClass[i].fChineseScore, 
			&MyClass[i].fMathScore, &MyClass[i].fEnglishScore);
	}
}
/*	���������ݣ�
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
// * ʵ�� 9-4��2��
// *************************************************************
void DisplayTranscriptOne(STUDENT MyScore)
{
	printf(" No.   Name   Chinese   Math   English\n");
	printf("%4d  %6s   %7.2f   %4.2f   %7.2f\n", MyScore.iNum, MyScore.cName, MyScore.fChineseScore, 
		MyScore.fMathScore, MyScore.fEnglishScore);
}


// *************************************************************
// * ʵ�� 9-4��3)
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
// * ʵ�� 9-4��4��
// *************************************************************
void ModifyOne(STUDENT *MyInfo)
{
	printf("�������ѧ������Ϣ��ѧ�ţ����������ĳɼ�����ѧ�ɼ���Ӣ��ɼ�\n");
	scanf("%d%s%f%f%f", &MyInfo->iNum, MyInfo->cName, &MyInfo->fChineseScore, &MyInfo->fMathScore, &MyInfo->fEnglishScore);
}


// *************************************************************
// * ʵ�� 9-5��1��
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
// ʵ�� 9-5��2��
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