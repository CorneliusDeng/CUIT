#include<stdio.h>
#define N 80
int main()
{
	struct student
	{
		int studentID;       //学号
		char name[20];         //姓名
		float score[5];     //5门课成绩
		float average;      //平均成绩
	}stu[N];
	struct student temp;//定义结构体变量temp用于交换
	int n, i, j;
	printf("请输入需要录入信息的学生人数：");
	scanf("%d", &n);	
	printf("请输入各学生的信息：学号、姓名、五门课成绩：\n");
	for(i = 0; i < n; i++)
	{
		scanf("%d%s%f%f%f%f%f", &stu[i].studentID, stu[i].name, &stu[i].score[0], &stu[i].score[1],                
			&stu[i].score[2], &stu[i].score[3], &stu[i].score[4]);					//输入数据
		stu[i].average = (stu[i].score[0] + stu[i].score[1] + stu[i].score[2] + stu[i].score[3] +stu[i].score[4] ) / 5; //求平均成绩
	}

	for(i = 0; i < n - 1; i++)//平均成绩从高到低排序
	{
		for(j = 0; j < n - 1 - i; j++)
		{
			if(stu[j].average < stu[j+1].average)
			{
				temp = stu[j];
				stu[j] = stu[j+1];
				stu[j+1] = temp;
			}
		}
	}

	printf("学生成绩由高到低排列：\n");
	for(i = 0; i < n; i++)
	{
		printf("%d\t%s\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t", stu[i].studentID, stu[i].name, stu[i].score[0], stu[i].score[1],                
			stu[i].score[2], stu[i].score[3], stu[i].score[4]);	
		putchar('\n');
	}

	return 0;
	
}