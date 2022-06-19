package InetAddress类;
import java.net.*;

/*
 * public static InetAddress getByName(String host) throws UnknownHostException
  该静态方法InetAddress.getByName(host)，将需要寻找地主机名作为参数，
  使用DNS查找主机地IP地址。返回一个包含主机名和IP地址的InetAddress对象。
	*/

public class getByNameTest 
{

	public static void main(String[] args) 
	{
		InetAddress myName = null;
		
		try 
		{
			myName = InetAddress.getByName("Cornelius");
		} 
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		
		System.out.println(myName);
	}

}
