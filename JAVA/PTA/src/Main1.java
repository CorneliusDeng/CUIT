import java.util.Scanner; 
import java.util.*;
import java.util.Map.Entry;
public class Main1 
{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		
		TreeMap<String, String> treemap = new TreeMap<String, String>();
		System.out.println("请输入姓名和学号，一行一个数据");
	    String name1 = reader.next();
	    String num1 = reader.next();
	    treemap.put(name1, num1);
	    String name2 = reader.next();
	    String num2 = reader.next();
	    treemap.put(name2, num2);
	    String name3 = reader.next();
	    String num3 = reader.next();
	    treemap.put(name3, num3);
	    
	    Set<Map.Entry<String, String>> set = treemap.entrySet();
		for (Entry<String, String> ch : set)
		{
			System.out.println(ch.getKey() + "---" + ch.getValue());
		}
		
		
		reader.close();
	}

}

/*
zhang
001
li
002
wang
003
 * */
