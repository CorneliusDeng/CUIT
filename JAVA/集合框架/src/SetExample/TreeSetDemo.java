package SetExample;

import java.util.*;

public class TreeSetDemo 
{

	public static void main(String[] args)
	{
		/*
		 * TreeSet是使用树结构来进行存储，并且能够保证元素已排序。
		 * 存储大量的需要进行快速检索的排序信息的情况下，TreeSet是一个很好的选择。
		 * */
		TreeSet<String> treeSet = new TreeSet<String>();
		// 添加元素
		treeSet.add("first");
		treeSet.add("second");
		treeSet.add("third");
		treeSet.add("forth");
		System.out.println(treeSet);
		// 遍历
		for(String str: treeSet)
		{
			System.out.println(str);
		}


	}

}
