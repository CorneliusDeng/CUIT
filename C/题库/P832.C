 #include <stdio.h>
#include <string.h>

/* User Code Begin(考生可在本行后添加代码，例如结构体类型的定义、函数原型声明等，行数不限) */
typedef struct information
{
	int iNum;
	char cName[16];
	float fCh;
	float fMath;
	float fEng;
}STUD;

STUD *FindByName(STUD stu[], int num, char name[16]);
/* User Code End(考生添加代码结束) */

int main(void)
{
	STUD sTranscript[] = { {1001, "张三丰", 69.5, 61.5, 91.5},  {1002, "李云龙", 92.5, 67.5, 81.5}, 
		{1003, "郭 靖",  79.5, 67.5, 86.5 },  {1004, "苗翠花", 83.0, 75.5, 84.0}, 
		{1005, "张无忌", 65.5, 81.5, 71.0} };
	STUD *stu;
	char name[16];
	
	printf("请输入你要查找的学生姓名: ");
	gets(name);

	stu = FindByName(sTranscript, 5, name);  //调用函数查找信息
	if (stu)
	{
		printf("\n查找的学生信息为: ");
		printf("%d %s %.1f %.1f %.1f\n", stu->iNum, stu->cName, stu->fCh, stu->fMath, stu->fEng);
	}
	else
	{
		printf("\n你要查找的学生不存在！\n");
	}

	return 0;
}

/* User Code Begin：考生在此后完成自定义函数的设计，行数不限 */
STUD *FindByName(STUD stu[], int n, char name[16])
{
	int i, flag = 0, j;
	for(i = 0; i < n; i++)
	{
		if(strcmp(name, stu[i].cName) == 0)
		{
			flag = 1;
			j = i;
		}
	}
	if(flag == 1) return &stu[j];
	else return NULL;
}