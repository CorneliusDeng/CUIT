package 读取线程中的值并打印;
import java.util.*;

public class Storage 
{
	ArrayList<Integer> num = new ArrayList<Integer>();
	
	public Storage()
	{
		
	}
	
	public void setNum(int number)
	{
		num.add(number);//将指定的元素追加到此列表的末尾。 
	}
	public Integer GetNum(int pos)
	{
		return num.get(pos);//返回此列表中指定位置的元素。 
	}

}
