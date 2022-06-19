package 基于TCP的Socket编程;
import java.io.*;
import java.net.*;
import java.util.*;


/*基于TCP的socket编程
服务器程序编写：
①调用ServerSocket(int port)创建一个服务器端套接字，并绑定到指定端口上；
②调用accept()，监听连接请求，如果客户端请求连接，则接受连接，返回通信套接字。
③调用Socket类的getOutputStream()和getInputStream获取输出流和输入流，开始网络数据的发送和接收。
④最后关闭通信套接字。
客户端程序编写：
①调用Socket()创建一个流套接字，并连接到服务器端； 
②调用Socket类的getOutputStream()和getInputStream获取输出流和输入流，开始网络数据的发送和接收。 
③最后关闭通信套接字。
*/

public class Client 
{
	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		Socket mysocket = null;
		DataOutputStream out = null;
		DataInputStream in = null;
		double a[] = new double[3];
		
		try
		{
			mysocket = new Socket("192.168.111.1", 50000);
			in = new DataInputStream(mysocket.getInputStream());
			out = new DataOutputStream(mysocket.getOutputStream());
			
			System.out.println("请输入要计算的三角形的三边面积");
			a[0] = reader.nextDouble();
			a[1] = reader.nextDouble();
			a[2] = reader.nextDouble();
			
			//将从键盘输入的数据写入到服务端
			for (int i = 0; i < a.length; i++)
			{
				String tempvalue = String.valueOf(a[i]);
				out.writeUTF(tempvalue);
			}
			
			
			//读取服务端计算出来的面积
			String value = in.readUTF();
			double area = Double.valueOf(value);
			System.out.println("运算完毕，结果显示如下：");
			System.out.printf("该三角形的面积是：%.2f\n",area);
			
			System.out.println("服务结束，中断连接.......");
			
			mysocket.close();
			reader.close();
			in.close();
			out.close();
		}
		catch(Exception e)
		{
			System.out.println("客户端程序出现异常，请维护后重试！");
		}
		
	}

}
