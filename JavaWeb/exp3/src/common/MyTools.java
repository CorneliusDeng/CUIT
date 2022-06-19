package common;

//通用工具Bean，处理字符串编码格式转换
public class MyTools 
{
	public static String toChinese(String str)
	{
		if (str == null || str.equals(""))
		{
			str = "";
		}
		
		try 
		{
			str = new String(str.getBytes("ISO-8859-1"), "GBK");
		} 
		catch (Exception e) 
		{
			str = "";
		}
		
		return str;
	}
}
