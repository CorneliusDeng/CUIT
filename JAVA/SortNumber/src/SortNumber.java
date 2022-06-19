import java.util.Scanner;
public class SortNumber 
{
	static void sort(int a, int b, int c)
	{
		int count = 0;
		int temp = 0;
		
		if (b < a)
		{
			temp = a;
			a = b;
			b = temp;
			count++;
			System.out.println("排序的第"+count+"次操作结果："+a+","+b+","+c+",");
		}
		
		if (c < a)
		{
			temp = a;
			a = c;
			c = temp;
			count++;
			System.out.println("排序的第"+count+"次操作结果："+a+","+b+","+c+",");
		}
		
		if (c < b)
		{
			temp = b;
			b = c;
			c =  temp;
			count++;
			System.out.println("排序的第"+count+"次操作结果："+a+","+b+","+c+",");
		}
		
		if (count == 0)
		{
			System.out.println("排序的第"+count+"次操作结果："+a+","+b+","+c+",");
		}
	}
	
	public static void main(String args[])
	{
		Scanner reader = new Scanner(System.in);
		int []a = new int[3];
		
		System.out.println("输入三个整数，每输入一个需回车确认");
		
		
		a[0] = reader.nextInt();
		a[1] = reader.nextInt();
		a[2] = reader.nextInt();
		
		sort(a[0], a[1], a[2]);
		
		reader.close();
	}
}
