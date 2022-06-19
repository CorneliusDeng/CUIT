package InetAddress类;
import java.net.*;

/*public static InetAddress getLocalHost() throws UnknownHostException
  若执行静态方法InetAddress.getLocalHost()，它将返回一个包含本地计算机的主机名和IP地址的InetAddress对象。
*/

public class getLocalHostTest 
{
	public static void main(String[] args) 
	{
		InetAddress myIP = null;
	      try 
	      {
	          myIP = InetAddress.getLocalHost();
	      }
	      catch(UnknownHostException e)
	      {
	      }
	      System.out.println(myIP);
	}
}
