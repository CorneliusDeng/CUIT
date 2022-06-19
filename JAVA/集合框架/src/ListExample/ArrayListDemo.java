package ListExample;

import java.util.*;

public class ArrayListDemo 
{
	static List<String> arrayList = new ArrayList<String>();
	
	 public static void init() 
	 {
		 arrayList.add("First");
		 arrayList.add("Second");
		 arrayList.add("Third");
		 arrayList.add("Fourth");
		 arrayList.add("Fifth");
	 }
	
	public static void travel()
	{
			
		System.out.println("遍历前的长度: " + arrayList.size());
		// 使用迭代器进行遍历
		Iterator<String> iterator = arrayList.iterator();
		int i = 0;
		System.out.println("遍历前的列表输出如下");
		while (iterator.hasNext()) 
		{
			String str = iterator.next();
			i++;
			System.out.println(str);
			if (i % 3 == 0) 
			      // 通过迭代器删除元素
			      iterator.remove();
		}
		
		System.out.println("遍历后的列表输出如下");
		for (String str : arrayList)//for-each可以遍历实现Iterable接口的任何对象的集合，其操作形式比迭代器更方便有效
		{
			System.out.println(str);
		}
		
		System.out.println("删除后的长度: " + arrayList.size());
	}
	
   

	public static void main(String args[]) 
	{
		init();
		travel();
	}

}
