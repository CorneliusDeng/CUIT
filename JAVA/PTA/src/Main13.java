
import java.util.*;
public class Main13 
{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("请输入字符串：");
		String str = reader.nextLine();
		int flag = 0;
		
		for (int i = 0, j = str.length() - 1; i <= j; i++, j--)
		{
			
			if (str.charAt(i) == str.charAt(j))
			{
				flag = 1;
			}
			else
			{
				flag = 0;
				break;
			}
		}
		
		if (flag == 1)
		{
			System.out.println("yes");
		}
		else
		{
			System.out.println("no");
		}
		reader.close();
	}

}
