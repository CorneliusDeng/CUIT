#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>

struct student
{
	int iNum;					//ѧ��
	char cName[16];				//����
	float fChineseScore;		//���ĳɼ�
	float fMathScore;			//��ѧ�ɼ�
	float fEnglishScore;		//Ӣ��ɼ�
};
typedef struct student STUDENT;//�Խṹ����и���

//ʵ��9-3-1
//�á�ָ����+�±ꡱ�ķ�ʽ�����ýṹ��ָ�����pStu���ʽṹ��
void DisplayTranscript1()//
{
	STUDENT sTranscript[] = {{1001, "������", 69.5, 61.5, 91.5},
							{1002, "������", 92.5, 67.5, 81.5},
							{1003, "��  ��", 79.5, 67.5, 86.5},
							{1004, "��仨", 83.0, 75.5, 84.0},
							{1005, "���޼�", 65.5, 81.5, 71.0}};
	STUDENT *pStu = sTranscript;//��ָ��ṹ��ĳ�ʼ����pStuָ��ɼ���
	int i;

	printf("NO.   Name   Chinese   Math   English\n");
	for(i = 0; i < sizeof(sTranscript)/sizeof(STUDENT); i++)
	{
		printf("%4d %s  %6.1f  %6.1f  %6.1f\n", pStu[i].iNum, pStu[i].cName,
			pStu[i].fChineseScore, pStu[i].fMathScore, pStu[i].fEnglishScore);
	}
}

//ʵ��9-3-2
//�á�ָ����+ƫ�������ķ�ʽ�����ýṹ��ָ�����pStu���ʽṹ��
void DisplayTranscript2()
{
	STUDENT sTranscript[] = {{1001, "������", 69.5, 61.5, 91.5},
							{1002, "������", 92.5, 67.5, 81.5},
							{1003, "��  ��", 79.5, 67.5, 86.5},
							{1004, "��仨", 83.0, 75.5, 84.0},
							{1005, "���޼�", 65.5, 81.5, 71.0}};
	STUDENT *pStu = sTranscript;//��ָ��ṹ��ĳ�ʼ����pStuָ��ɼ���
	int i;

	printf("NO.   Name   Chinese   Math   English\n");
	for(i = 0; i < sizeof(sTranscript)/sizeof(STUDENT); i++)
	{
		printf("%4d %s  %6.1f  %6.1f  %6.1f\n", (pStu + i)->iNum, (pStu + i)->cName,
			(pStu + i)->fChineseScore, (pStu + i)->fMathScore, (pStu + i)->fEnglishScore);
	}
}

//ʵ��9-3-3
//�á�ָ���ƶ����ķ�ʽ�����ýṹ��ָ�����pStu���ʽṹ��
void DisplayTranscript3()
{
	STUDENT sTranscript[] = {{1001, "������", 69.5, 61.5, 91.5},
							{1002, "������", 92.5, 67.5, 81.5},
							{1003, "��  ��", 79.5, 67.5, 86.5},
							{1004, "��仨", 83.0, 75.5, 84.0},
							{1005, "���޼�", 65.5, 81.5, 71.0}};
	STUDENT *pStu;

	printf("NO.   Name   Chinese   Math   English\n");
	for(pStu = sTranscript; pStu < sTranscript + 5; pStu++)
	{
		printf("%4d %s  %6.1f  %6.1f  %6.1f\n", pStu->iNum, pStu->cName,
			pStu->fChineseScore, pStu->fMathScore, pStu->fEnglishScore);
	}
}

//ʵ��9-4(1)    �������ܣ�����ѧ����Ϣ������ڽṹ��������
void InputTranscript(STUDENT MyClass[], int num)//MyClassΪ��ųɼ�������飬numΪѧ��������
{
	int i;
	printf("������%d��ѧ����ѧ�š�����������Ӣ���Ƴɼ���\n", num);
	for(i = 0; i < num; i++)
	{
		scanf("%d%s%f%f%f", &MyClass[i].iNum, MyClass[i].cName, &MyClass[i].fChineseScore, 
							&MyClass[i].fMathScore, &MyClass[i].fEnglishScore);
	}
}

//ʵ��9-4(2)    �������ܣ���ʾĳ��ѧ������Ϣ
void DisplayTranscriptOne(STUDENT MyScore)//MyScoreΪ��ŵ���ѧ����Ϣ�Ľṹ��
{
	printf(" No.   Name   Chinese   Math   English\n");
	printf("%4d  %6s   %7.2f   %4.2f   %7.2f\n", MyScore.iNum, MyScore.cName, MyScore.fChineseScore, 
		MyScore.fMathScore, MyScore.fEnglishScore);
}

//ʵ��9-4(3)    �������ܣ���ʾ����ѧ������Ϣ
void DisplayTranscriptAll(STUDENT *MyClass, int num)//MyClassָ����ѧ����Ϣ�Ľṹ�����飬numΪѧ��������
{
	int i;
	printf("����ѧ������Ϣ������ʾ\n");
	for(i = 0; i < num; i++)
	{
		printf("%d\t%s\t%.2f\t%.2f\t%.2f\n", MyClass[i].iNum, MyClass[i].cName, MyClass[i].fChineseScore, 
							MyClass[i].fMathScore, MyClass[i].fEnglishScore);
	}
}


//ʵ��9-4(4)    �������ܣ������������ݣ��޸�ѧ������Ϣ
void ModifyOne(STUDENT *MyInfo)//MyInfoָ����ѧ����Ϣ�Ľṹ��
{
	printf("�������ѧ������Ϣ��ѧ�ţ����������ĳɼ�����ѧ�ɼ���Ӣ��ɼ�\n");
	scanf("%d%s%f%f%f", &MyInfo->iNum, MyInfo->cName, &MyInfo->fChineseScore, &MyInfo->fMathScore, &MyInfo->fEnglishScore);
}

// ʵ�� 9-5(1)  ��������: ����ѧ���ɼ������ܷ���ߵ�ѧ����Ϣ
STUDENT FindTop(STUDENT *MyClass, int num)//MyClassָ����ѧ����Ϣ�Ľṹ�����飬numΪѧ��������
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

// ʵ�� 9-5(2)  �������ܣ����ݡ���������Ϣ��ѯ������ѧ���ɼ����и�ѧ������Ϣ
//MyClassָ����ѧ����Ϣ�Ľṹ�����飬numΪѧ����������pNameΪҪ���ҵ�ѧ����Ϣ
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

	system("cls");//����
	printf("\n\n\n");
	printf("==================================================\n");
	printf("|                                                |\n");
	printf("|                                                |\n");
	printf("|                                                |\n");
	printf("|             1. ʵ�� 9-3-1                      |\n");
	printf("|             2. ʵ�� 9-3-2                      |\n");
	printf("|             3. ʵ�� 9-3-3                      |\n");
	printf("|             4. ʵ�� 9-4                        |\n");
	printf("|             5. ʵ�� 9-5                        |\n");
	printf("|             6. ʵ�� 9-5(3)                     |\n");
	printf("|             7. �˳�                            |\n");
	printf("|                                                |\n");
	printf("|                                                |\n");
	printf("|                                                |\n");
	printf("==================================================\n");
	printf("\n\t���ֶ�Ӧʵ����ţ���ѡ��");
	while (1)
	{
		input = scanf("%d", &option);
		if ((option < 1) || (option > 7))
			printf("\n\t ѡ�������ѡ��");
		else break;
	}
	return option;
}

int MenuHandle(int option)
{
	int quit = 0, yes = 0;
	static STUDENT sTranscript[5];//�������ѧ������Ϣ
	STUDENT TopOne, *pStudent = NULL;
	char name[16];

	system("cls");
	switch (option)
	{
	case 1: printf("\t\t\t\t ʵ�� 9-3-1\n\n");
		DisplayTranscript1();
		printf("\t\t\t\t�����������...\n");
		getch();//getche����getch��������getchar���ƣ���ǰ�߶��벻����Ļ��ʾ��Ӧ����ͷ�ļ�conio.h
		break;
	case 2: printf("\t\t\t\t ʵ�� 9-3-2\n\n");
		DisplayTranscript2();
		printf("\t\t\t\t�����������...\n");
		getch();
		break;
	case 3: printf("\t\t\t\t ʵ�� 9-3-3\n\n");
		DisplayTranscript3();
		printf("\t\t\t\t�����������...\n");
		getch();
		break;
	case 4: printf("\t\t\t\t ʵ�� 9-4\n\n");
		InputTranscript(sTranscript, 5);
		printf("\t\t\t\t���������ʾѧ���ɼ�\n");
		getch();
		system("cls");
		DisplayTranscriptAll(sTranscript, 5);
		printf("\t\t\t\t�����������...\n");
		getch();
		break;
	case 5: printf("\t\t\t\t ʵ�� 9-5\n\n");
		TopOne = FindTop(sTranscript, 5);
		printf("��߷�ѧ��: \n");
		DisplayTranscriptOne(TopOne);
		printf("\n\n\t\t\t\t�����������...\n");
		getch();
		break;
	case 6: printf("\t\t\t\t ʵ�� 9-5(3)\n\n");
		printf("����Ҫ��ѯ��ѧ��������");
		scanf("%s", name);
		pStudent = FindByName(sTranscript, 5, name);
		if (pStudent != NULL)
		{
			fflush(stdin);
			DisplayTranscriptOne(*pStudent);
			printf("�Ƿ��޸ĸ�ѧ����Ϣ(1/0): ");//��1/0������Ƿ�Ҫ�޸�ѧ������Ϣ
			scanf("%d", &yes);
			if (yes == 1)
			{
				printf("�޸ĸ�ѧ����Ϣ: \n");
				ModifyOne(pStudent);
				printf("�޸ĺ����ݣ� \n");
				DisplayTranscriptOne(*pStudent);
			}
		}
		else {
			printf("δ�ҵ���ѧ����Ϣ\n");
			DisplayTranscriptAll(sTranscript, 5);
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