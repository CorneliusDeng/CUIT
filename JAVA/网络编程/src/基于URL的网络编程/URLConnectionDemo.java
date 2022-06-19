package 基于URL的网络编程;
import java.net.*;
import java.io.*;
import java.util.*;

//实际应用中，只能读取数据是不够的，很多情况下，我们都需要将一些信息发送到服务器中去，
//这就要求我们能够实现同网络资源的双向通信，URLConnection类就是用来解决这一问题的。
//类URLConnection也是定义在包java.net里，它表示Java程序和URL在网络上的通信连接。
//当与一个URL建立连接时，首先要在一个URL对象上通过方法openConnection（）生成对应的URLConnection对象。
//URLConnection是以HTTP协议为中心的类，其中很多方法只有在处理HTTP的URL时才起作用。

/*URLConnection是一个抽象类，代表与URL指定的数据源的动态连接
URLConnection类提供比URL类更强的服务器交互控制。
URLConnection允许用POST或PUT和其他HTTP请求方法将数据送回服务器。
使用URLConnection 对象的一般方法：
 （1）创建一个URL对象。   
（2）调用URL对象的openConnection()方法创建这个URL的URLConnection对象。   
（3）配置URLConnection    
（4）读首部字段。  
（5）获取输入流并读数据。   
（6）获取输出流并写数据。
（7）关闭连接。 
*/


public class URLConnectionDemo 
{

	public static void main(String[] args) throws IOException
	{
		URL url = new URL("https://www.cuit.edu.cn/");
		URLConnection uc = url.openConnection();
		Map m = uc.getHeaderFields();
		Iterator i = m.entrySet().iterator();
		while (i.hasNext())
			System.out.println(i.next());
		System.out.println("Input allowed = " + uc.getDoInput());
		System.out.println("Output allowed = " + uc.getDoOutput());

		BufferedReader br = new BufferedReader(new InputStreamReader(
				uc.getInputStream()));
		String s;
		while ((s = br.readLine()) != null)
			System.out.println(s);
		br.close();
		
	}
}
