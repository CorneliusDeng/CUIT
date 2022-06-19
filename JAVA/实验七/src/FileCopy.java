import java.io.*;

//文本文件复制程序
public class FileCopy 
{

	public static void main(String[] args)
	{
		String soufilename = args[0];
		String desfilename = args[1];
		
		try
		{
//			这里不要直接用FileReader，这个类不能添加参数转码成utf-8类型，InputStreamReader类是过滤流，字节流->字符流
			//BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(soufilename), "utf-8"));
			BufferedReader in = new BufferedReader(new FileReader(soufilename));
	        BufferedWriter out= new BufferedWriter(new FileWriter(desfilename));
	         
	         //定义一个字符串变量来记录读取的内容
	         String s = null;
	         while( (s = in.readLine()) != null)
	         {
	        	 //把读取一行的内容写进目标文本
	             out.write(s);
	             
	             //写入一个换行符,BufferedWriter的一个独特方法
	             out.newLine();
	             System.out.println("内容：" +s);
	         }
	         //立刻冲洗当前缓冲区，即将当前缓冲区的内容写到目的地
	         out.flush();
	         //关闭流
	         in.close();
	         out.close();
		 }
		catch(IOException e)
		{
			System.out.println(e.toString());
		} 
	
	}
}
