#include<stdio.h>
#define ROW 3
#define COL 3

void ScoreTable()
{
	int score[40][3], i, j, num;
	float av[40];				//���ÿ��ѧ����ƽ���ɼ�

	printf("����ʵ��ѧ��������40���ڣ���");
	scanf("%d", &num);

	for(i = 0; i < num; i++)
	{
		printf("�����%d��ѧ�������ĳɼ�����ѧ�ɼ���", i + 1);
		for(j = 0; j < 2; j++)
		{
			scanf("%d", &score[i][j]);
		}

	}

	for(i = 0; i < num; i++)
	{
		score[i][2] = 0;         //score[i][2]����ܳɼ�
		score[i][2] = score[i][0] + score[i][1];     //���ܳɼ�
		av[i] = score[i][2] / 2.0;				     //��ƽ���ɼ�
	}

	printf("%8s%10s%10s%10s%10s\n", "���", "���ĳɼ�", "��ѧ�ɼ�", "�ܳɼ�", "ƽ���ɼ�");
	for(i = 0; i < num; i++)
	{
		printf("%8d",i);      //������
		for(j = 0; j < 3; j++)
		{
			printf("%10d", score[i][j]);  //������ġ���ѧ���ܳɼ�
		}
		printf("%10.1f\n", av[i]);        //���ƽ���ɼ�
	}
}

void MatrixTranspositon1()
{
	int iArray[3][3], *piPtr;   //��ָ����ʶ�ά����
	int i, j, temp;

	piPtr = *iArray;
	printf("Input 3x3 matrix: \n");
	for(i = 0; i < 3; i++)
	{
		scanf("%d %d %d", piPtr + i * 3 + 0, piPtr + i * 3 + 1, piPtr + i * 3 + 2);  //��ָ��ƫ������
	}

	for(i = 0; i < 3; i++)      //����ת������
	{
		for(j = i; j < 3; j++)
		{
			temp = piPtr[i * 3 +j];    //��ָ��"�±���ʽ"��ʾ��ά����ľ���ֵ
			piPtr[i * 3 +j] = piPtr[j * 3 +i];
			piPtr[j * 3 +i] = temp;
		}
	}

	printf("Transposition Matrix:\n");    //���ת��������
	for(i = 0; i < 3; i++)
	{
		for(j = 0; j < 3; j++)
		{
			printf("%-3d", *(piPtr + i * 3 + j));   //��ָ��"ָ����ʽ"��ʾ��ά����ľ���ֵ
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
						{21, 22, 23, 24, 25}}; //��ά�����ʼ��
	int i, sum, (*pia)[5];                    //������ʶ�ά�������ָ��

	sum = 0;          //��ʼ��sum
	pia = iArray;             //��ʼ��pia
	for(i = 0; i < 5; i++)    //�ۼ����Խ��ߺͷ��Խ����ϵ�Ԫ��
	{
		sum += *(*(pia + i)+ i) + *(pia[i] + 4 - i);//��ά������ָ��ָ����ֵ����ά������ָ����ָ���е�ַ����ָ����ֵ
	}
	sum -= pia[2][2];//ȥ���ظ��ۼӵ�������Ԫ��

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
	char *cMyStrings[] = {"Software", "Engineering", "CUIT", "Chengdu", "China"};//�ַ����飬Ҳ�൱��˫��ָ��
	char **pp, *temp = NULL;
	pp = cMyStrings;//˫��ָ�������
	iCount = sizeof(cMyStrings)/sizeof(cMyStrings[0]);  //�����ַ�������
	for(i = 1; i < iCount; i++)
	{
		for(j = 0; j < iCount - i; j++)
		{
			if(iSortType != 0)  //��С����˳��
			{
				if(**(pp + j) > **(pp + j + 1))//��**���Ƚ�����ĸ��С
				{
					temp = pp[j];
					pp[j] = pp[j+1];
					pp[j+1] = temp;
				}
			}
			else  //�Ӵ�С˳��
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

void InputMatrix(int iMatrix[ROW][COL])//��Ϊ��ž������ݵ�����
{
	int i, j;
	printf("������3x3�ľ���:\n");
	for(i = 0; i < ROW; i++)
	{
		for(j = 0; j < COL; j++)
		{
			scanf("%d", &iMatrix[i][j]);
		}
	}
}

void DisplaySource(int iMatrix[][COL], int iRow)//��ʾ��������
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

void TranspositionMatrix(int (*iSMatrix)[COL], int (*iTMatrix)[ROW])//ʵ�־���ת��
{ 
	int i, j, temp;

	for(i = 0; i < ROW; i++)      //����ת������
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
	
	//4.ͨ�����������ʶ�ά����Ԫ��
	ScoreTable();
	putchar('\n');

	//5.1��ָͨ����ʶ�ά����
	MatrixTranspositon1();
	putchar('\n');

	//5.2��������ָ�루��ָ�룩���ʶ�ά����
	sum = AddDiagonalLine();
	printf("sum = %d\n", sum);
	putchar('\n');

	//6.1��ָ������Ͷ���ָ�봦�����ַ���
	MonthName1 = GetMonthName1(7);										
	printf("monthname1=%s\n", MonthName1);
	MonthName2 = GetMonthName2(11);
	printf("monthname2=%s\n", MonthName2);
	putchar('\n');
	
	//6.2����ַ�������
	StringBubbleSort(5);
	putchar('\n');
	
	//7.��ά��������������
	InputMatrix(iSourceMatrix); 
	putchar('\n');
	printf("��ʾ����ľ���\n");
	DisplaySource(iSourceMatrix, ROW);
	putchar('\n');
	printf("��ʾת�ú�ľ���:\n");
	TranspositionMatrix(iSourceMatrix, iTargetMatrix);
	
	return 0;
}