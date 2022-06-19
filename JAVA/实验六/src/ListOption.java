import java.util.*;

public class ListOption 
{
	static List<String> names = new ArrayList<String>();
	
	static void AddOption()
	{
		names.add("张三");
		names.add("李四");
		names.add("王五");
		names.add("马六");
		names.add("赵七");
	}
	
	
	static void TraverseOption()
	{
		Iterator<String> iterator = names.iterator();
		int i = 0;
		System.out.println("遍历前的列表输出如下");
		while (iterator.hasNext()) 
		{
			String str = iterator.next();
			i++;
			System.out.printf("第%d个元素是：%s\n", i, str);
			
		}
		
	}
	
	static void DeleteOption()
	{
		System.out.println("第一次计算集合的大小是：" + names.size());
		
		Iterator<String> iterator = names.iterator();
		int j = 0, k = 0;
		
		while (iterator.hasNext()) //删除第三个元素
		{
			
			String str = iterator.next();
			j++;
			if (j == 3) 
			{
				System.out.println("此时要删除的第三个元素是："+str);
				iterator.remove();
			}
		}
		iterator = names.iterator();//重新初始化
		while (iterator.hasNext()) //打印第三个元素
		{
			
			String bbq = iterator.next();
			k++;
			if (k ==  3) 
			{
				System.out.printf("\n删除之后目前集合中的第三个元素是：%s\n", bbq);
			}
		}
		
		System.out.println("第二次计算集合的大小是：" + names.size());	
	}
	
	
	public static void main(String[] args) 
	{
		AddOption();
		TraverseOption();
		DeleteOption();
	}

}
