package 字节流;
import java.io.*;

public class FilterOutputStreamDemo 
{
	public static void main(String[] args) 
	{
		// 定义一个BufferedOutputStream类型的变量
		BufferedOutputStream bo = null;
		try 
		{
			// 利用FileOutputStream对象创建一个输出缓冲流
			bo = new BufferedOutputStream(new FileOutputStream("d:\\test.txt"));
			for (int i = 0; i < 10; i++)
			{
				bo.write(65);
			}
				
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				// 关闭缓冲流
				bo.close();
			} 
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		}
	}
}
