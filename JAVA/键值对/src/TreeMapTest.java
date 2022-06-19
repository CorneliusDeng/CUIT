import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class TreeMapTest 
{

	public static void main(String[] args) 
	{
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		treeMap.put("Tom", new Integer(23));
		treeMap.put("Rose", new Integer(18));
		treeMap.put("Jane", new Integer(26));
		treeMap.put("Black", new Integer(24));
		treeMap.put("Smith", new Integer(21));
		
		Set<Map.Entry<String, Integer>> set = treeMap.entrySet();
		for (Entry<String, Integer> entry : set)
		{
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
		
		Set<String> keySet = treeMap.keySet();
		
		StringBuffer buffer = new StringBuffer("");
		
		for (String str : keySet) 
		{
			buffer.append(str + ",");
		}
		String str = buffer.substring(0, buffer.length() - 1);
		
		System.out.println(str);
	}

}
