package File类实例;
import java.io.*;

public class ListFileDemo2 
{

	public static void main(String[] args) 
	{
		File file = new File("D:\\jdk1.8");
		// 得到文件名列表
		if (file.exists() && file.isDirectory()) 
		{
			// 创建FileNameFilter类型的匿名类，并作为参数传入到list方法中
			//String[] list(),当File对象为目录时，返回该目录下的所有文件及子目录
			//使用list方法时，需要向该方法传递一个实现FilenameFilter接口的对象
			String[] fileNames = file.list(new FilenameFilter() 
			{
				public boolean accept(File dir, String name) 
				{
				// 如果文件的后缀为.html或.htm则满足条件
				return (name.endsWith(".html") || name.endsWith(".htm"));
				}
			});
			
			for (String fileName : fileNames) 
			{
				System.out.println(fileName);
			}
		}

	}

}
