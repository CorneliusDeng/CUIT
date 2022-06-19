package 基于UDP的Socket编程;
import java.net.*;

public class Receive 
{
	public static void main(String[] args) 
	{	
		try 
		{
			//接收数据报
			DatagramPacket datapack1 = null;
			DatagramSocket datapost1 = null;
			byte datareceive[] = new byte[50];
			
			System.out.println("服务器在等待接收数据包....");
			datapack1 = new DatagramPacket(datareceive, datareceive.length);
			datapost1 = new DatagramSocket(50000);
			
			datapost1.receive(datapack1);
			String message = new String(datapack1.getData(), 0, datapack1.getLength()); 
			System.out.println("客户端说：" + message);
			
			//发送数据报
			String upstr = message.toUpperCase();//将所有在此字符 String使用默认语言环境的规则大写。 
			byte[] datasend = new byte[50];
			datasend = upstr.getBytes();
			InetAddress myaddress = InetAddress.getByName("192.168.111.1");
			DatagramPacket datapack2 = new DatagramPacket(datasend, datasend.length, myaddress, 50001);
			DatagramSocket datapost2 = new DatagramSocket();
			
			datapost2.send(datapack2);
			
			datapost1.close();
			datapost2.close();
		} 
		catch (Exception e) 
		{
			System.out.println("接收端程序出现异常，请维护后重试！");
		}

	}

}
