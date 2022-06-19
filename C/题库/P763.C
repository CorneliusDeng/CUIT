#include <stdio.h>

/* User Code Begin(考生可在本行后添加代码，例如全局变量的定义、函数原型声明等，行数不限) */

/* 定义结构体类型struct student */
struct student
{
	int num;
	char name[20];
	float score1;
	float score2;
	float score3;
	float aver;
}; 

void average(struct student stuScore[], int n); //函数原型声明
int maxAver(struct student stuScore[], int n); //函数原型声明


/* User Code End(考生添加代码结束) */

int main(void)
{
	int high;  /* high记录平均分最高的学生的序号，具体使用参考后面的代码 */

	/* User Code Begin(考生可在本行后添加代码，行数不限) */

	struct student myClass[5]; //定义结构体数组myClass
	int i;

	/* 从键盘输入各位学生的数据，并存放到结构体数组myClass中 */
	printf("Please input students  info:Num Name score1 score2 score3\n");
	for (i=0; i<5; i++)
	{
		printf("%d:", i + 1); 
		scanf("%d %s %f %f %f", &myClass[i].num, myClass[i].name,
			&myClass[i].score1, &myClass[i].score2, &myClass[i].score3);
	}

	average(myClass, 5); //调用average函数求每位学生的平均分
	high = maxAver(myClass, 5); // 调用maxAver求平均分最高的学生的数组元素下标，该下标作为函数值赋给变量high


	/* User Code End(考生添加代码结束) */

	printf("\nThe Highest is %s(%d)\nscore1=%.2f  score2=%.2f  score3=%.2f  aver=%.2f\n",
		myClass[high].name, myClass[high].num,
		myClass[high].score1, myClass[high].score2, myClass[high].score3, myClass[high].aver);

	return 0;
}

/* User Code Begin(考生在此后根据设计需要完成程序的其它部分，行数不限) */
/* 该函数功能是求每位学生的平均分 */
void average(struct student stuScore[], int n)
{
	int i;
	float sum;

	for (i=0; i<n; i++)
	{
		sum = stuScore[i].score1 + stuScore[i].score2 + stuScore[i].score3;
		stuScore[i].aver = sum / 3;
	}
	
}
/* 该函数功能是求平均分最高的学生在数组中的位置，该位置信息作为函数值返回 */
int maxAver(struct student stuScore[], int n)
{
	int i, maxi;
	float max;

	max = stuScore[0].aver;
	maxi = 0;
	for (i=1; i<n; i++)
	{
		if (stuScore[i].aver > max)
		{
			max = stuScore[i].aver;
			maxi = i;
		}
		
	}

	return maxi;
}


