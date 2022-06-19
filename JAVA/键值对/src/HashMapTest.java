import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapTest 
{
	public static void main(String args[]) 
	{
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		
		hashMap.put("Tom", new Integer(23));
		
		Set<Map.Entry<String, Integer>> set = hashMap.entrySet();
		
		for (Entry<String, Integer> entry : set)
		{
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
		
		Set<String> keySet = hashMap.keySet();
		
		StringBuffer buffer = new StringBuffer("");
		for (String str : keySet) 
		{
			buffer.append(str + ",");
		}
		String str = buffer.substring(0, buffer.length() - 1);
		System.out.println(str);
	}
}