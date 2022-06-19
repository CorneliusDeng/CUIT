#include <stdio.h>
#include <stdlib.h>

/* User Code Begin(考生可在本行后添加代码，行数不限) */
typedef struct student
{
	int num;
	char name[20];
	int math;
	int english;
	int computer;
	float average;
} STUDENT;

void average(STUDENT *stuScore, int n); //该函数功能是求每位学生的平均分
void sort(STUDENT *stuScore, int n); //该函数功能是按学生的平均分从高到低排序
/* User Code End(考生添加代码结束) */

int main(void)
{
	STUDENT myclass[5], *pStu = myclass;
	int i;
	const int N = 5;

	/* User Code Begin(考生可在本行后添加代码，行数不限) */
	printf("Please input info of students:No Name Math English Computer\n");
	/* 从键盘输入N位学生的数据到数组myclass中 */
	for (i=0; i<N; i++)
	{
		printf("%d:", i + 1); 
		scanf("%d %s %d %d %d", &myclass[i].num, myclass[i].name,
			&myclass[i].math, &myclass[i].english, &myclass[i].computer);
	}
	average(pStu, N); //求每位学生的平均分
	sort(pStu, N); //按学生的平均分从高到低排序
	/* User Code End(考生添加代码结束) */
	
	printf("\nResult of sort:\n");
	printf("Num   Name                 Math     English  Computer Average\n");
	for (i=0; i<N; i++)
	{
		printf("%-5d %-20s %-8d %-8d %-8d %-.2f\n", (pStu+i)->num, (pStu+i)->name,
			(pStu+i)->math, (pStu+i)->english, (pStu+i)->computer, (pStu+i)->average);
	}

	return 0;
}

/* User Code Begin(考生在此后根据设计需要完成程序的其它部分，行数不限) */
void average(STUDENT *stuScore, int n)  //求每位学生的平均分
{
	int i;
	float sum;

	for (i = 0; i < n; i++)
	{
		sum = (float)(stuScore[i].math + stuScore[i].english + stuScore[i].computer);
		stuScore[i].average = sum / 3;
	}
	
}

void sort(STUDENT *stuScore, int n)  //按学生的平均分从高到低排序(气泡法)
{
	int i, j;
	STUDENT tmp;
	
	for (i = 1; i <= n - 1; i++)
	{
		for (j = 1; j <= n - i; j++)
		{
			if (stuScore[j-1].average < stuScore[j].average)
			{
				tmp = stuScore[j];
				stuScore[j] = stuScore[j-1];
				stuScore[j-1] = tmp;
			}
		}
	}
}

