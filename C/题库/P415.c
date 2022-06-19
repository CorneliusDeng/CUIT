#include <stdio.h>
#define N 10 //N为参赛歌手的人数

typedef struct person  
{
	int number; //歌手的编号
	int score[6]; //六位评委的打分
	float finalScore; //歌手的最终成绩
}AAA;

int main(void)
{
	int i, j, sum, max, min;
	AAA tmp, singer[N];  //数组singer[N]用来存放N位歌手的数据
	
	printf("Please input singer's score:\n");
	/* 依次输入N位歌手的数据 */
	for (i = 0; i < N; i++)
	{
		singer[i].number = i + 1; //输入编号
		/* 输入六位评委的打分 */
		for (j = 0; j < 6; j++)
		{
			scanf("%d", &singer[i].score[j]);
		}
	}

	/* 依次计算N位歌手的最终得分 */
	for (i = 0; i < N; i++)
	{
		max = min = singer[i].score[0]; 
		sum = singer[i].score[0];
		for (j = 1; j < 6; j++)
		{
			/* 计算最高分 */
			if (singer[i].score[j] > max)
			{
				max = singer[i].score[j];
			}
			/* 计算最低分 */
			else if (singer[i].score[j] < min)
			{
				min = singer[i].score[j];
			}
			/* 计算总分 */
			sum +=  singer[i].score[j];
		}

		sum = sum - min - max; //扣除一个最高分和一个最低分后的得分
		singer[i].finalScore = (float)sum / 4; //计算出最终得分
	}

	/* 使用气泡法，按每位歌手的最终得分从高到低排序 */
	for (i = 1; i <= N - 1; i++)
	{
		for (j = 1; j <= N - i; j++)
		{
			if (singer[j].finalScore  > singer[j-1].finalScore)
			{
				tmp = singer[j];
				singer[j] = singer[j-1];
				singer[j-1] = tmp;
			
			}
		}
	}

	printf("\nscores:\n");
	/* 输出每位歌手的编号和最终得分 */
	for (i = 0; i < N; i++)
	{
		printf("No.%-2d: %.2f\n", singer[i].number, singer[i].finalScore);
	}

	return 0;
}













