package 字符流;
import java.io.*;

//字节流不能很好地操作Unicode字符，引入字符流
//类似地FileReader和FileWriter分别是Reader和Writer的子类
public class FileReaderDemo 
{

	public static void main(String[] args) 
	{
		BufferedWriter bw = null; // 定义一个BufferedWriter类型的变量
		try 
		{
			// 利用FileWriter对象创建一个输出缓冲流
			bw = new BufferedWriter(new FileWriter("d:\\test.txt"));
			System.out.println("输出结果如下：");
			String line = System.getProperty("line.separator");
			// 把一行内容写入到文件中
			bw.write("hello world" + line);
			bw.flush();
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
				bw.close();
			} 
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		}
	}

}
