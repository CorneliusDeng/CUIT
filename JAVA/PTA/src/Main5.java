
import java.util.Scanner;
public class Main5 
{
	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		int i, n;
		System.out.println("请输入");
		n = reader.nextInt();
		if (n == 0)
		{
			System.out.println("必须输入不小于2的正整数！");
		}
		System.out.print(n+"=");
		i = 2;   
		while(n > i) //从2开始找最小因子
		{
			if ( n % i == 0 )
			{
				System.out.print(i + "*");
				n /= i ; //n缩小i倍后，再次检查i是否是因数
			}
			else
			{
				i++;
			}
		}
		if(n == 0)
		{
			System.out.println(0);
		}
		else
		{
			System.out.println(i);
		}
		
		reader.close();
	}

}