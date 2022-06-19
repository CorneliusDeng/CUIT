package TestServerThread;
import java.net.*;
import java.io.*;

public class TestClient2 
{

	public static void main(String args[])
	{
		   client();
		}
		public static void client()
		{
			try
			{
				//Socket s=new Socket("10.0.0.4",6000);
				Socket s=new Socket(InetAddress.getByName(null),6000);
				OutputStream os=s.getOutputStream();
				InputStream is=s.getInputStream();
				byte [] buf=new byte[100];
				System.out.println("client2 starting...");
				int len=is.read(buf);
				System.out.println(new String(buf,0,len));
				os.write("Hello,this is the zhangsan.".getBytes());
				os.close();
				is.close();
				s.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

}
