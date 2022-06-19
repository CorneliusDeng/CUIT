package 基于UDP的Socket编程;
import java.util.*;
import java.net.*;


/*基于UDP的socket编程
接收端程序编写：
①调用DatagramSocket(int port)创建一个数据报套接字，并绑定到指定端口上；
②调用DatagramPacket(byte[] buf, int length)，建立一个字节数组以接收UDP包 。
③调用DatagramSocket类的receive()，接收UDP包。
④最后关闭数据报套接字。
发送端程序编写：
①调用DatagramSocket()创建一个数据报套接字； 
②调用DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port)，建立要发送的UDP包。 
③调用DatagramSocket类的send()，发送UDP包。
④最后关闭数据报套接字。
*/
public class Send 
{
	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		
		try 
		{
			//发送数据报
			byte[] informationsend = new byte[50];
			
			System.out.print("输入要发送的字符串：");
			String message1 = reader.nextLine();
			informationsend = message1.getBytes();//将字符串转化为字符数组
			
			InetAddress myaddress = InetAddress.getByName("192.168.111.1"); //确定主机名称的IP地址
			DatagramPacket datapack1 = new DatagramPacket(informationsend, informationsend.length, 
					myaddress, 50000);//DatagramPacket类似信件
			DatagramSocket datapost1 = new DatagramSocket();//DatagramSocket类似信箱
			
			datapost1.send(datapack1);
			
			//接收数据报
			byte [] informationreceive = new byte[50];
			
			DatagramPacket datapack2 = new DatagramPacket(informationreceive, informationreceive.length);
			DatagramSocket datapost2 = new DatagramSocket(50001);
			
			datapost2.receive(datapack2);
			
			String message2 = new String(datapack2.getData(), 0, datapack2.getLength());
			System.out.println("服务器端返回的信息："+message2);
			
			reader.close();
			datapost1.close();
			datapost2.close();
			
		} 
		catch (Exception e) 
		{
			System.out.println("发送端程序出现异常，请维护后重试！");
		}
		
	}

}
