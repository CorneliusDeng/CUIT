
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Main12 
{
	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		String s = reader.nextLine();
		TreeMapTest test = new TreeMapTest(s);
		System.out.println(test.treemap);
		
		reader.close();
	}
}

class TreeMapTest
{
	public TreeMap<Character, List<Integer>> treemap = new TreeMap<Character, List<Integer>>();
	
	public TreeMapTest(String s)
	{
		for(int i = 0; i < s.length(); i++)
		{
			addEntry(s.charAt(i), i);
		}
			
	}
	void addEntry(char c, int pos)
	{
		Character key = new Character(c);
		List<Integer> list = (List<Integer>) treemap.get(key);//返回到指定键所映射的值，或 null如果此映射包含该键的映射。
		if(list == null)
		{
			list = new ArrayList<Integer>();
			treemap.put(key,list);//将指定的值与此映射中的指定键相关联。
		}
		list.add(new Integer(pos));
	}
}