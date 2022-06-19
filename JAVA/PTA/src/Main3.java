
import java.util.*;
public class Main3 
{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		int [] a = new int[5];
		
		for (int i = 0; i < 5; i++)
		{
			a[i] = reader.nextInt();
		}
		
		int max = a[0]; 
		int index = 0;
		
		for (int i = 1; i < 5; i++)
		{
			if (a[i] > max)
			{
				max = a[i];
				index = i;
			}
		}
		System.out.printf("最大值为%d，索引号为%d", max, index);
		
		
		
		reader.close();
	}

}
