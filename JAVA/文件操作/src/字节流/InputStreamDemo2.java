package 字节流;
import java.io.*;


public class InputStreamDemo2 
{

	public static void main(String[] args) 
	{
		// 定义一个FileOutputStream类型的变量
		FileOutputStream fo = null;
		try 
		{
			// 利用绝对路径创建一个FileInputStream类型的对象
			fo = new FileOutputStream("d:\\test.txt", true);//写了true，就是在文件中添加（append），false或者不写是刷新
			
			byte[] b = "文字输入测试".getBytes();
			//getBytes()方法将字符串转化为字节数组，因为write方法中写入文字都是以字节数组为基础的
			
			fo.write(b);
			
			/*for (int i = 0; i < 10; i++) 
			{
				fo.write(66);// 字符A的ASCII码,向文件中输入十个B
			}*/
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		} 
		finally 
		{
			try 
			{
				fo.close();
			} 
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		}
	}
}
