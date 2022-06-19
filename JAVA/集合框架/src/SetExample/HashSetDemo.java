package SetExample;

import java.util.*;

public class HashSetDemo 
{

	public static void main(String[] args) 
	{
		//HashSet能快速定位一个元素。该结构使用散列表进行存储。
		HashSet<String> hashSet = new HashSet<String>();
		// 添加元素
		hashSet.add("first");
		hashSet.add("second");
		hashSet.add("third");
		hashSet.add("forth");
		System.out.println(hashSet);
		// 遍历
		for(String str : hashSet)
		{
			System.out.println(str);
		}
	}

}
