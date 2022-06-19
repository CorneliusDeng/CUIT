package 字节流;
import java.io.*;


//利用FileInputStream把d盘中test.txt文件中的内容读取并打印在控制台上
public class InputStreamDemo1 
{

	public static void main(String[] args) 
	{
		// InputStream、OutputStream专门提供了读写文件的子类：FileInputStream和FileOutputStream
		FileInputStream fi = null;
		try 
		{
			// 利用路径创建一个FileInputStream类型的对象
			fi = new FileInputStream("d:\\test.txt");
			// 从流对象中读取内容
			int value = fi.read();
			System.out.println("文件中的内容是：" + (char) value);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				// 关闭流对象
				fi.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
