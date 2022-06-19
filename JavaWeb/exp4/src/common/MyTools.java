package common;

//通用工具Bean，处理字符编码格式转换
public class MyTools 
{
	public static String toChinese(String str)
	{//将String字符串编码格式转换为国标
		if (str == null || str.equals(""))
			str = "";
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
	
	public static int toint(String str)
	{//将String型数据转换为int型数据的方法
		if(str == null || str.equals(""))
			str="0";
		int i = 0;
		try
		{
			i = Integer.parseInt(str);
		}
		catch(NumberFormatException e)
		{
			i = 0;
			e.printStackTrace();
		}
		return i;		
	}
	public static float toFloat(String str)
	{//将String型数据转换为float型数据的方法
		if(str==null||str.equals(""))
			str = "0";
		float f = 0.0f;
		try
		{
			f = Float.parseFloat(str);
		}
		catch(NumberFormatException e)
		{
			f = 0.0f;
			e.printStackTrace();
		}
		return f;		
	}
}
