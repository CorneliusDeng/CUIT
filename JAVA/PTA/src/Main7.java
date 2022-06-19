

import java.util.Scanner;
public class Main7 
{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		int x = reader.nextInt();
		int y = reader.nextInt();
		System.out.println("最大公约数：" +gongyue(x,y));
		System.out.println("最小公倍数：" +gongbei(x,y));
		reader.close();
	}
	public static int gongyue(int x,int y)
	{//最大公约数
		if(x < y)
		{
			int temp = y;
			y = x;
			x = temp;
		}
		while(y != 0)
		{
			int temp = x % y;
			x = y;
			y = temp;
		}
		return x;
	}
	public static int gongbei(int x,int y)
	{//最小公倍数
		int a = x, b = y;
		int g = gongyue(a,b);
		return x * y / g;
	}

}
