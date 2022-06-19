package 基于URL的网络编程;
import java.net.*;
import java.io.*;

/*URL对象创建后，就可以通过它来访问指定的WWW资源。这时需要调用URL类的openStream()方法，
该方法与指定的URL建立连接并返回一个InputStream类的对象，这样访问网络资源的操作就变成了我们熟悉的I/O操作，
接下来就可以用字节流的方式读取资源数据。 

InputStreamReader类是一个过滤流（字节->字符）
OutputStreamReader类是一个过滤流（字符->字节）

*/

public class URLopenStream 
{

	public static void main(String[] args) 
	{
		URL url = null;
		try 
		{
			url = new URL ("https://www.cuit.edu.cn");
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream ()));
			String s;
			while ((s = br.readLine ()) != null)
			    System.out.println (s);
			br.close ();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
