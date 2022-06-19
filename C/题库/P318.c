#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*使用fread,sizeof(结构体)的方法肯定不对，应单项属性逐个fread！*/

int main(void)
{
	
	char pinming[18]; //品名
	char guige[12];   //规格
	long shuliang;    //数量
	float danjia;     //单价
	
	int flag = 0; // flag值为0，表示没有找到商品，为1，表示找到商品

	int a, b, c, d; //用来存放fread的函数值
	char FindName[18]; //该数组用来存放从键盘输入的要查询的商品名
	FILE *fp;

	printf("Please input shang pin pin ming:");
	scanf("%s", FindName); //输入要查询的商品名
	
	printf("\ncha zhao qing kuang:\n");
	if((fp = fopen("sp38.dat", "rb")) == NULL) //打开二进制文件sp38.dat
	{
		printf("can not open file!\n");
		exit(0);
	}
	
	/* 以下四条语句的功能：从文件sp38.dat中读数据 */	
	a = fread(pinming, 18, 1, fp); 
	b = fread(guige, 12, 1, fp);
	c = fread(&shuliang, sizeof(long), 1, fp);
	d = fread(&danjia, sizeof(float), 1, fp);

	while (feof(fp) == 0)//判断文件是否结束,为0表示还没有结束
	{
		/* fread函数读写成功，返回count中的值，此代码中为1。如果以下条件为真，说明从文件中正确读出了数据 */
		if ((a == 1) && (b == 1) && (c == 1) && (d == 1))
		{
			if (strcmp(pinming, FindName) == 0)//比较sp38.dat中的信息与输入的信息是否相同
			{
				printf("%s,%s,%ld,%.2f\n", pinming, guige, shuliang, danjia);
				flag = 1; //将标志变量的值置为1，说明已经找到要查询的商品
			}
		}
		/* 一次比较完毕，循环中再次单独逐项读写 */
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