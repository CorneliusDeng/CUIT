package 套接字socket;
import java.net.*;
import java.io.*;

public class Client 
{
	public static void main(String args[])
	{
		String[] mess = {"2010世界杯在哪举行?", "巴西进入世界杯了吗？", "中国进入世界杯了吗?"};
		
		try
		{
			Socket mysocket = new Socket("192.168.171.1", 65530);
			DataInputStream in = new DataInputStream(mysocket.getInputStream());
			DataOutputStream out = new DataOutputStream(mysocket.getOutputStream());
			
			for (int i = 0; i < mess.length; i++)
			{
				out.writeUTF(mess[i]);
				String s = in.readUTF();  	//in读取信息，堵塞状态
				System.out.println("客户端收到服务器的回答：" + s);
				Thread.sleep(500);
			}
		}
		catch(Exception e)
		{
			System.out.println("客户端程序出现异常，请维护后重试！");
		}
	}
}
