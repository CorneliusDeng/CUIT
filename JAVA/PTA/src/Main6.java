
import java.util.*;
public class Main6 
{

	public static void main(String[] args) 
	{
		List<Integer> mylist = new ArrayList<Integer>();
		for (int i = 101; i <= 200; i++)
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
						mylist.add(i);
					}
				}
			}
		}
		
		for (int i = 0; i < mylist.size(); i++)
		{
			System.out.print(mylist.get(i)+" ");
		}
		System.out.println();
		System.out.println("共有"+mylist.size()+"个素数");

	}

}
