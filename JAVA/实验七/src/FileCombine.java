import java.io.*;

//任意两个文件合并程序
public class FileCombine 
{

	public static void main(String[] args) 
	{
		String soufilename1 = args[0];
		String soufilename2 = args[1];
		String tarfilename = args[2];
		
		try {
			BufferedReader in1= new BufferedReader(new FileReader(soufilename1));
			BufferedReader in2= new BufferedReader(new FileReader(soufilename2));
			BufferedWriter out= new BufferedWriter(new FileWriter(tarfilename));
			
			String s = null;
			//写入文件1
			while((s = in1.readLine()) != null)
			{
				out.write(s);
				out.newLine();
				System.out.println("内容：" +s);
			}
			in1.close();
			out.flush();
			System.out.println("***文件一写入结束***");
			
			//写入文件二
			while((s = in2.readLine()) != null)
			{
				out.write(s);
				out.newLine();
				System.out.println("内容：" +s);
			}
			in2.close();
			out.flush();
			System.out.println("***文件二写入结束***");
			
			
			out.close();
			System.out.println("***文件合并操作完成***");
		} 
		catch (Exception e) 
		{
			
			System.out.println(e.toString());
		}
	}
}
