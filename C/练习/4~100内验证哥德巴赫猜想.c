/*
哥德巴赫原话：任一大于2的整数都可以写成3个质数之和
欧拉回信陈述：任一大于2的偶数都可以写成2个质数之和
哥德巴赫猜想的现代表述：任一大于5的整数都可以写成3个质数之和
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
	int a, b, i, k, count1, count2;

	for (k = 4; k <= 100; k += 2)//k代表需要验证的数的区间范围
	{
		for (a = 2; a <= k / 2; a++)//a为其中一个质数因子
		{
			//判断a是否为质数
			count1 = 0;
			for (i = 2; i <= a - 1; i++)
			{
				if (a % i ==0)
				{
					count1++;
					break;
				}
			}

			if (count1 == 0)//如果a为质数
			{
				b = k - a;
				//判断b是否为质数
				count2 = 0;
				for (i = 2; i <= b - 1; i++)
				{
					if (b % i ==0)
					{
						count2++;
						break;
					}
				}

				if (count2 == 0)//如果b也是质数
				{
					printf("%3d = %3d + %-3d\n", k, a, b);
					break;
				}
			}
		}
	}

	return 0;
}