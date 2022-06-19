package 字节流;
import java.io.*;

//FilterInputStream为过滤输入流，其父类为InputStream类 
public class FilterInputStreamDemo 
{

	public static void main(String[] args) 
	{
		BufferedInputStream bi = null; // 定义一个BufferedInputStream类型的变量
		try 
		{
			// 利用FileInputStream对象创建一个输入缓冲流
			bi = new BufferedInputStream(new FileInputStream("d:\\test.txt"));
			int result = 0;
			System.out.println("文件中的结果如下：");
			while ((result = bi.read()) != -1) //读到文件结束
			{
				System.out.print((char) result);
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
				bi.close();
			} 
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		}

	}

}
