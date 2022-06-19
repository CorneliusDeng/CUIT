import java.util.Scanner;
public class Fibonacci 
{
	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		System.out.print("请确定即将输出的斐波那契数列的长度:");
		int n = reader.nextInt();
		
		long [] arr = new long[n];
		
		System.out.println("方法一");
		arr[0] = 1L;
		arr[1] = 1L;
		for (int i = 0; i < n; i++)
		{
			if (i > 1)
			{
				arr[i] = arr[i-1] + arr[i-2];
			}
			System.out.printf("%d\t", arr[i]);
		}
		
		System.out.println("");
		
		//方法二:
		System.out.println("方法二");
		long index = 1L, position = 1L,  sum = 0L;
		
		for (int i = 1; i <= n; i++) 
		 {  
			if (i == 1 || i == 2) 
			{
				System.out.printf("%d\t", 1);
			}
			else
			{
				sum = index + position;
				System.out.printf("%d\t", sum);  
				index = position;
				position = sum;
			}
			
		 }  
		
		reader.close();
	}
}
