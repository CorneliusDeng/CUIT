package File类实例;
import java.io.*;

public class ListFileDemo1 
{
	/*
	 * 在File类中，可以使用列表（list）方法，把某个目录中的文件或目录依次列举出来
	 * String[] list(),当File对象为目录时，返回该目录下的所有文件及子目录   
	 * File[] listFiles(), 返回File对象对应的路径下的所有文件对象数组    
	 * */

	public static void main(String[] args) 
	{
		// 根据路径名称创建File对象
		File file = new File("D:\\ALL SourceCode\\Javasourcecode\\文件操作");
		// 得到文件名列表
		if (file.isDirectory()) 
		{
			File[ ] files = file.listFiles();
			
			// 利用for-each获取每个File对象
			for (File f : files) 
			{
				if (f.isFile()) 
				{
					System.out.println("文件：" + f);
				} 
				else 
				{
					System.out.println("目录：" + f);
				}
			}
		}
	}
}
