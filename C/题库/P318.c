#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*ʹ��fread,sizeof(�ṹ��)�ķ����϶����ԣ�Ӧ�����������fread��*/

int main(void)
{
	
	char pinming[18]; //Ʒ��
	char guige[12];   //���
	long shuliang;    //����
	float danjia;     //����
	
	int flag = 0; // flagֵΪ0����ʾû���ҵ���Ʒ��Ϊ1����ʾ�ҵ���Ʒ

	int a, b, c, d; //�������fread�ĺ���ֵ
	char FindName[18]; //������������ŴӼ��������Ҫ��ѯ����Ʒ��
	FILE *fp;

	printf("Please input shang pin pin ming:");
	scanf("%s", FindName); //����Ҫ��ѯ����Ʒ��
	
	printf("\ncha zhao qing kuang:\n");
	if((fp = fopen("sp38.dat", "rb")) == NULL) //�򿪶������ļ�sp38.dat
	{
		printf("can not open file!\n");
		exit(0);
	}
	
	/* �����������Ĺ��ܣ����ļ�sp38.dat�ж����� */	
	a = fread(pinming, 18, 1, fp); 
	b = fread(guige, 12, 1, fp);
	c = fread(&shuliang, sizeof(long), 1, fp);
	d = fread(&danjia, sizeof(float), 1, fp);

	while (feof(fp) == 0)//�ж��ļ��Ƿ����,Ϊ0��ʾ��û�н���
	{
		/* fread������д�ɹ�������count�е�ֵ���˴�����Ϊ1�������������Ϊ�棬˵�����ļ�����ȷ���������� */
		if ((a == 1) && (b == 1) && (c == 1) && (d == 1))
		{
			if (strcmp(pinming, FindName) == 0)//�Ƚ�sp38.dat�е���Ϣ���������Ϣ�Ƿ���ͬ
			{
				printf("%s,%s,%ld,%.2f\n", pinming, guige, shuliang, danjia);
				flag = 1; //����־������ֵ��Ϊ1��˵���Ѿ��ҵ�Ҫ��ѯ����Ʒ
			}
		}
		/* һ�αȽ���ϣ�ѭ�����ٴε��������д */
		a = fread(pinming, 18, 1, fp); 
		b = fread(guige, 12, 1, fp);
		c = fread(&shuliang, sizeof(long), 1, fp);
		d = fread(&danjia, sizeof(float), 1, fp);
	}
	if (flag == 0)
	{
		printf("mei you shang pin :%s", FindName);
	}
	fclose(fp); 

	return 0;
}