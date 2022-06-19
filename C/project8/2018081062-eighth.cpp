#include<stdio.h>
#define ROW 3
#define COL 3

void ScoreTable()
{
	int score[40][3], i, j, num;
	float av[40];				//存放每个学生的平均成绩

	printf("输入实际学生个数（40以内）：");
	scanf("%d", &num);

	for(i = 0; i < num; i++)
	{
		printf("输入第%d个学生的语文成绩和数学成绩：", i + 1);
		for(j = 0; j < 2; j++)
		{
			scanf("%d", &score[i][j]);
		}

	}

	for(i = 0; i < num; i++)
	{
		score[i][2] = 0;         //score[i][2]存放总成绩
		score[i][2] = score[i][0] + score[i][1];     //求总成绩
		av[i] = score[i][2] / 2.0;				     //求平均成绩
	}

	printf("%8s%10s%10s%10s%10s\n", "编号", "语文成绩", "数学成绩", "总成绩", "平均成绩");
	for(i = 0; i < num; i++)
	{
		printf("%8d",i);      //输出编号
		for(j = 0; j < 3; j++)
		{
			printf("%10d", score[i][j]);  //输出语文、数学和总成绩
		}
		printf("%10.1f\n", av[i]);        //输出平均成绩
	}
}

void MatrixTranspositon1()
{
	int iArray[3][3], *piPtr;   //列指针访问二维数组
	int i, j, temp;

	piPtr = *iArray;
	printf("Input 3x3 matrix: \n");
	for(i = 0; i < 3; i++)
	{
		scanf("%d %d %d", piPtr + i * 3 + 0, piPtr + i * 3 + 1, piPtr + i * 3 + 2);  //列指针偏移量法
	}

	for(i = 0; i < 3; i++)      //矩阵转置运算
	{
		for(j = i; j < 3; j++)
		{
			temp = piPtr[i * 3 +j];    //列指针"下标形式"表示二维数组的具体值
			piPtr[i * 3 +j] = piPtr[j * 3 +i];
			piPtr[j * 3 +i] = temp;
		}
	}

	printf("Transposition Matrix:\n");    //输出转置运算结果
	for(i = 0; i < 3; i++)
	{
		for(j = 0; j < 3; j++)
		{
			printf("%-3d", *(piPtr + i * 3 + j));   //列指针"指针形式"表示二维数组的具体值
		}
		printf("\n");
	}
}

int AddDiagonalLine()
{
	int iArray[5][5] = {{ 1, 2, 3, 4, 5},      
						{ 6, 7, 8, 9, 10},
						{11, 12, 13, 14, 15},
						{16, 17, 18, 19, 20},
						{21, 22, 23, 24, 25}}; //二维数组初始化
	int i, sum, (*pia)[5];                    //定义访问二维数组的行指针

	sum = 0;          //初始化sum
	pia = iArray;             //初始化pia
	for(i = 0; i < 5; i++)    //累加主对角线和反对角线上的元素
	{
		sum += *(*(pia + i)+ i) + *(pia[i] + 4 - i);//二维数组行指针指向数值，二维数组行指针先指向列地址，再指向数值
	}
	sum -= pia[2][2];//去掉重复累加的最中心元素

	return sum;
	
}

char *GetMonthName1(int n)
{
	static char *MonthName[] = {"ERROR", "Jan.", "Feb.", "March.", "Apr.", 
								"May.", "June", "July", "Agu.", "Sept.", "Oct.", "Nov.", "Dec."};
	if(n < 1 || n > 12)return MonthName[0];
	else return MonthName[n];
}

char *GetMonthName2(int n)
{
	static char *MonthName[] = {"ERROR", "Jan.", "Feb.", "March.", "Apr.", 
								"May.", "June", "July", "Agu.", "Sept.", "Oct.", "Nov.", "Dec."};
	char **ppName = MonthName;
	if(n < 1 || n > 12)return *ppName;
	else return *(ppName + n);
}

void StringBubbleSort(int iSortType)
{
	int i, j, iCount;
	char *cMyStrings[] = {"Software", "Engineering", "CUIT", "Chengdu", "China"};//字符数组，也相当于双重指针
	char **pp, *temp = NULL;
	pp = cMyStrings;//双重指针的体现
	iCount = sizeof(cMyStrings)/sizeof(cMyStrings[0]);  //计算字符串个数
	for(i = 1; i < iCount; i++)
	{
		for(j = 0; j < iCount - i; j++)
		{
			if(iSortType != 0)  //从小到大顺序
			{
				if(**(pp + j) > **(pp + j + 1))//“**”比较首字母大小
				{
					temp = pp[j];
					pp[j] = pp[j+1];
					pp[j+1] = temp;
				}
			}
			else  //从大到小顺序
			{
				if(*(pp + j) < *(pp+ j +1))
				{
					temp = pp[j];
					pp[j] = pp[j+1];
					pp[j+1] = temp;
				}
			}
		}
	}
	for(i = 0; i < iCount; i++)
	{
		printf("%d:%s\n", i + 1, cMyStrings[i]);
	}
}

void InputMatrix(int iMatrix[ROW][COL])//作为存放矩阵数据的数组
{
	int i, j;
	printf("请输入3x3的矩阵:\n");
	for(i = 0; i < ROW; i++)
	{
		for(j = 0; j < COL; j++)
		{
			scanf("%d", &iMatrix[i][j]);
		}
	}
}

void DisplaySource(int iMatrix[][COL], int iRow)//显示矩阵数据
{
	int i, j;
	for(i = 0; i < iRow; i++)
	{
		for(j = 0; j < COL; j++)
		{
			printf("%-3d", iMatrix[i][j]);
		}
		putchar('\n');
	}
}

void TranspositionMatrix(int (*iSMatrix)[COL], int (*iTMatrix)[ROW])//实现矩阵转置
{ 
	int i, j, temp;

	for(i = 0; i < ROW; i++)      //矩阵转置运算
	{
		for(j = i; j < COL; j++)
		{
			temp = iSMatrix[i][j];    
			iSMatrix[i][j] = iSMatrix[j][i];
			iSMatrix[j][i] = temp;
		}
	}
	
	for(i = 0; i < ROW; i++)
	{
		for(j = 0; j < COL; j++)
		{
			iTMatrix[i][j] = iSMatrix[i][j];
		}
	}
	for( i = 0; i <COL; i++)
	{
		for(j = 0; j <ROW; j++)
		{
			printf("%-3d", iTMatrix[i][j]);
		}
		putchar('\n');
	}
}

int main(void)
{
	int sum;
	char *MonthName1, *MonthName2;
	int iSourceMatrix[ROW][COL];
	int iTargetMatrix[COL][ROW];
	
	//4.通过数组名访问二维数组元素
	ScoreTable();
	putchar('\n');

	//5.1普通指针访问二维数组
	MatrixTranspositon1();
	putchar('\n');

	//5.2数组类型指针（行指针）访问二维数组
	sum = AddDiagonalLine();
	printf("sum = %d\n", sum);
	putchar('\n');

	//6.1用指针数组和二级指针处理多个字符串
	MonthName1 = GetMonthName1(7);										
	printf("monthname1=%s\n", MonthName1);
	MonthName2 = GetMonthName2(11);
	printf("monthname2=%s\n", MonthName2);
	putchar('\n');
	
	//6.2多个字符串排序
	StringBubbleSort(5);
	putchar('\n');
	
	//7.二维数组作函数参数
	InputMatrix(iSourceMatrix); 
	putchar('\n');
	printf("显示输入的矩阵：\n");
	DisplaySource(iSourceMatrix, ROW);
	putchar('\n');
	printf("显示转置后的矩阵:\n");
	TranspositionMatrix(iSourceMatrix, iTargetMatrix);
	
	return 0;
}