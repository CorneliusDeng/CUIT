package UDP编程;
import java.io.*;
import java.net.*;
import java.util.*;

//服务器线程
public class QuoteServerThread extends Thread
{
	protected DatagramSocket socket = null;
	//记录和本对象相关联的DatagramSocket对象
	protected BufferedReader in = null;
	//用来读文件的一个Reader
	protected boolean moreQuotes = true;
	//标志变量，是否继续操作
	public QuoteServerThread() throws IOException 
	{
		//无参数的构造函数
		this("QuoteServerThread");
		//以QuoteServerThread为默认值调用带参数的构造函数
	}
	public QuoteServerThread(String name) throws IOException 
	{
		super(name); //调用父类的构造函数
		socket = new DatagramSocket(50000);
		//在端口5000创建数据报套接字
		try
		{
//			in= new BufferedReader(new FileReader(path+"one-liners.txt"));
			in= new BufferedReader(new InputStreamReader(new FileInputStream("D:\\ALL SourceCode\\JAVAsourcecode\\文老师参考文件\\src\\UDP编程\\test.txt"),"UTF-8"));
			//打开一个文件，构造相应的BufferReader对象
		}
		catch(FileNotFoundException e) 
		{ //异常处理
		    System.err.println("Could not open quote file. Serving time instead.");
		    //打印出错信息
		}
	}
	
	public void run()
	{ //线程主体
	    System.out.println("server starting...");
		while(moreQuotes) 
		{
			try
			{
				byte[] buf=new byte[256]; //创建缓冲区
				DatagramPacket packet=new DatagramPacket(buf,buf.length);
				//由缓冲区构造DatagramPacket对象
				socket.receive(packet); //接收数据报
				String dString=null;
				if(in==null) dString=new Date().toString();
				//如果初始化的时候打开文件失败了
				//则使用日期作为要传送的字符串
				else dString=getNextQuotes();
				//否则调用成员函数从文件中读出字符串
				buf = dString.getBytes("UTF-8");
				//把String转换成字节数组，以便传送
				InetAddress address = packet.getAddress();
				//从Client端传来的Packet中得到Client地址
				int port=packet.getPort(); //和端口号
				packet=new DatagramPacket(buf,buf.length,address,port);
				//根据客户端信息构建DatagramPacket
				System.out.println(new String(buf,"UTF-8"));
				socket.send(packet); //发送数据报
			}
			catch(IOException e) 
			{ //异常处理
			   	e.printStackTrace(); //打印错误栈
			   	moreQuotes=false; //标志变量置false，以结束循环
			}
		}
		socket.close(); //关闭数据报套接字
	}
	
	protected String getNextQuotes()
	{
		//成员函数，从文件中读数据
		String returnValue=null;
		try
		{
			if((returnValue=in.readLine())==null) 
			{
				//从文件中读一行，如果读到了文件尾
				in.close( ); //关闭输入流
				moreQuotes=false;
				//标志变量置false，以结束循环
				returnValue="No more quotes. Goodbye.";
				//置返回值
			} //否则返回字符串即为从文件读出的字符串
		}
		catch(IOException e) 
		{ //异常处理
   		returnValue="IOException occurred in server";
   		//置异常返回值
   	}
   	return returnValue; //返回字符串
   }
}
