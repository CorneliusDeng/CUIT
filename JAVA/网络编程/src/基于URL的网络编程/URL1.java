package 基于URL的网络编程;
import java.net.*;

/*java中定义了URL类。URL类有六个构造函数,其中最常用的有以下四种 :
1)  URL(String spec)
     例：
     URL  u=new URL(“http://java.sun.com:80/docs/books/tutorial.intro.html#downloading”);
     
2）URL(String protocol, String host, String file)
3）URL(String protocol, String host, int port, String file)
      上两种方法将一个URL地址分解，按不同部分分别指定协议、主机、
       端口、文件。例如：
      URL  u=new URL(“http”, ”java.sun.com”,
                                             80, “docs/books/tutorial.intro.html”);
4）URL(URL context, String spec) 
     URL  u=new URL(“http://java.sun.com:80/docs/books/”);
       URL  u1=new URL(u, ”tutorial.intro.html”);
       URL  u2=new URL(u, ”tutorial.super.html”);
*/

public class URL1
{

	public static void main(String[] args) 
	{
		URL url = null;
		try 
		{
			url = new URL("http://www.cuit.edu.cn");
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Authority = " + url.getAuthority());
		System.out.println("Default port = " + url.getDefaultPort());
		System.out.println("File = " + url.getFile());
		System.out.println("Host = " + url.getHost());
		System.out.println("Path = " + url.getPath());
		System.out.println("Port = " + url.getPort());
		System.out.println("Protocol = " + url.getProtocol());
		System.out.println("Query = " + url.getQuery());
		System.out.println("Ref = " + url.getRef());
		System.out.println("User Info = " + url.getUserInfo());
		
	}
}
