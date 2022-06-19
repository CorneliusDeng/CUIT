package File类实例;
import java.io.*;

public class FileOption 
{

	public static void main(String[] args) 
	{
		// 根据路径字符串创建一个File对象
		File file = new File("D:\\All SourceCode\\Javasourcecode");
		//路径名是D:\All SourceCode\Javasourcecode,第一个\是转义字符
		
		// 如果文件不存在，则创建一个
		if (!file.exists()) 
		{
			try 
			{
				file.createNewFile();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		System.out.println("文件是否存在：" + file.exists());
		System.out.println("是文件吗：" + file.isFile());
		System.out.println("是目录吗：" + file.isDirectory());
		System.out.println("名称：" + file.getName());
		System.out.println("路径：" + file.getPath());
		System.out.println("绝对路径：" + file.getAbsolutePath());
		System.out.println("最后修改时间：" + file.lastModified());//值表示上次修改文件的时间，以时间为单位（1970年1月1日00:00:00 GMT）测量
		System.out.println("文件大小：" + file.length());
	}

}
