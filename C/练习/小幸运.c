#include <stdio.h>
#include <stdlib.h>
#include <time.h>

char prozone[35] = {'01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12', '13', '14', '15', 
				'16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', 
				'30', '31', '32', '33', '34', '35'};

char backzone[12] = {'01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'};

int main()
{
	int n, i, j, p, q;

	srand((unsigned)time(NULL));//�����������
	
	for (i = 5; i >= 1; i--)
	{
		p = rand()%35;//����±����
		printf("%d\n", p);
		//printf("%c", prozone[p]);
	}
	for (j = 2; j >= 1; j--)
	{
		q = rand()%12;
		printf("%-4c", backzone[q]);
	}
	putchar('\n');

	
	
	
	
	
	
	/*printf("��ӭ�����Ʊ���ѡ��ϵͳ\n");
	printf("����������ѡ��\n");
	printf("1: ���һע\n");
	printf("2: �����ע\n");*/

}