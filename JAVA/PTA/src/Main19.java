
import java.util.*;
public class Main19 
{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("请输入两个整数");
		int a = reader.nextInt();
		int b = reader.nextInt();
		int x = 0;
		
		for (int i = a; i <= b; i++)
		{
			for (int j = 2; j < i; j++)
			{
				if (i % j == 0)
				{
					break;
				}
				else
				{
					if (j == i - 1)
					{
						System.out.print(i+" ");
						x += 1;
					}
				}
			}
		}
		
		System.out.println();
		System.out.println("共有"+x+"个素数");
		reader.close();
	}

}



