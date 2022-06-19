package InetAddress类;
import java.net.*;

//public static InetAddress[] getAllByName(String host) throws UnknownHostException 
//有些计算机具有一个以上的Internet地址，若给定一个主机名，该静态方法InetAddress.getAllByName(host)，
//将会返回一个包含了与该主机名相对应的所有地址的InetAddress对象数组。


public class getAllByNameTest 
{

	public static void main(String[] args) 
	{
		//[] myName = null;
		
		try 
		{
			InetAddress[] myName = InetAddress.getAllByName("Cornelius");
			System.out.println(myName.toString());
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		}
		
		
	}

}
