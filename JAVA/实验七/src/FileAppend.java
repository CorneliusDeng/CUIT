import java.io.*;

//将一个文件的内容追加到另一个文件之后
public class FileAppend 
{

	public static void main(String[] args) 
	{
		String AppendDestination = args[0];
		String AppendSource = args[1];
		try 
		{
			BufferedReader source = new BufferedReader(new FileReader(AppendSource));
			BufferedWriter destination = new BufferedWriter(new FileWriter(AppendDestination, true));
			
			String s = null;
			destination.newLine();//追加时先换一行
			
			//写入文件
			while((s= source.readLine())!=null)
			{
				destination.write(s);
				destination.newLine();
				System.out.println("追加的内容:"+s);
			}
			source.close();
			destination.flush();
			destination.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

}
