import java.util.TreeSet;

public class TreeSetTest 
{
	public static void main(String[] args) 
	{
		TreeSet<String> treeSet = new TreeSet<String>();
		// 添加元素
		treeSet.add("first");
		treeSet.add("second");
		treeSet.add("third");
		treeSet.add("forth");
		
		for (String str : treeSet)
		{
			System.out.println(str);
		}
	}
	
}
