#include<stdio.h>

#define NOT_FIND -1
#define TOTAL_STU 8

/* 函数aver的功能为：求学号为stuNo的学生的6门课课程之平均成绩，并通过函数值返回
		若未找到学生stuNo，则返回NOT_FIND */	
float aver(int (*pStu)[7], int stuNo);

int main(void)
{
	int student[TOTAL_STU][7]; /* the first column save student's number */
	float averScore;
	int i, j, stuNumber;

	printf("Input the %d student's number and score: \n", TOTAL_STU);
	/* 本部分代码功能建议：从键盘读入的8个学生的6门课成绩存放在二维数组student中 */	
	/* User Code Begin(Limit: lines<=6, lineLen<=50, 考生可在本行后添加代码、最多6行、行长<=50字符) */
	for (i = 0; i < TOTAL_STU; i++)
	{
		printf("%d: ", i + 1);
		for (j = 0; j < 7; j++)
		{
			scanf("%d", &student[i][j]);
		}
	}	
	/* User Code End(考生添加代码结束。注意：空行和单独为一行的{与}均不计行数、行长不计行首tab缩进) */

	printf("\nInput a student's number to compute: ");
	scanf("%d", &stuNumber);

	/* 本部分代码功能建议：调用函数aver()求平均值 */	
	/* User Code Begin(Limit: lines<=1, lineLen<=50, 考生可在本行后添加代码、最多1行、行长<=50字符) */
	averScore = aver(student, stuNumber);
	/* User Code End(考生添加代码结束。注意：空行和单独为一行的{与}均不计行数、行长不计行首tab缩进) */
	if (NOT_FIND == averScore)
	{
		printf("\nstudent of No.%d not Find!\n", stuNumber);
	}
	else
	{
		printf("\nThe No.%d student's average is %.2f\n", stuNumber, averScore);
	}

	return 0;
}

/* User Code Begin(考生在此后根据设计需要完成程序的其它部分，如函数aver，行数不限) */
float aver(int (*pStu)[7], int stuNo)
{
	int i, flag = -1;//flag作为标记，判断是否找到相同学号
	float aver, sum = 0;

	for (i = 0; i < TOTAL_STU; i++)//不要在一个for循环内部写return，这样返回多次，不合理
	{
		if (pStu[i][0] == stuNo)
		{
			flag = i;
		}
	}

	if (flag != -1)
	{
		for (i=1; i<7; i++)
		{
			sum = sum + pStu[flag][i];
		}
		aver = sum / 6;
		return aver;
	}
	else
	{
		return NOT_FIND;
	}
}

/*
参考数据
1: 20011 100 80 90 78 85 92
2: 20012 90 83 88 76 80 93
3: 20015 85 50 73 75 83 90
4: 20013 89 80 78 83 75 52
5: 20021 60 82 85 98 75 76
6: 20031 70 70 63 68 96 66
7: 20035 78 60 72 82 88 57
8: 20026 92 85 99 95 65 81
*/