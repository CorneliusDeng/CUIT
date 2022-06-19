
import java.util.*;
public class Main20
{
	public static void main(String argv[]) 
	{
		Scanner reader = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("请输入数据");
		try
		{
			String num = reader.nextLine();
			while(!num.equals("end")) 
			{
				int n = Integer.valueOf(num);
				list.add(n);
				num = reader.nextLine();
			}
		}
		catch (NumberFormatException e) 
		{
			System.out.println("输入了非数字，数字格式转换异常");
		}
		if(list.size()>0) 
		{
			int max = list.get(0);
			int j = 0;
			for (int i = 0; i < list.size(); i++) 
			{
				if(max < list.get(i)) 
				{
					max = list.get(i);
					j = i;
				}
			}
			System.out.println("最大值为"+max+"，索引号为"+j);
		}
		else
		{
			System.out.println("无数据输入");
		}
		reader.close();
	}
}
