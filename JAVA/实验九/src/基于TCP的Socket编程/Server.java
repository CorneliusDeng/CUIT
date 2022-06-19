package 基于TCP的Socket编程;
import java.io.*;
import java.net.*;

public class Server 
{
	public static void main(String[] args) 
	{
		ServerSocket serverForClient = null;
		Socket socketOnServer = null;
		DataOutputStream out = null;
		DataInputStream in = null;
		double a[] = new double[3];
		
		System.out.println("等待客户端输入数据....");
		
		try 
		{
			serverForClient = new ServerSocket(50000);
		} 
		catch (IOException e1) 
		{
		
			System.out.println(e1);
		} 
		
		try 
		{
			socketOnServer = serverForClient.accept();	//堵塞状态，除非有客户呼叫
			out = new DataOutputStream(socketOnServer.getOutputStream());
			in = new DataInputStream(socketOnServer.getInputStream());
			
			System.out.println("从客户端接收三角形的三条边：");
			
			for (int i = 0; i < a.length; i++)
			{
				String line = in.readUTF();
				a[i] = Double.parseDouble(line);
				System.out.printf("%f\t", a[i]);
			}
			
			System.out.printf("\n三角形的面积是：%f\n", Server.countarea(a));
			String str = String.valueOf(Server.countarea(a));
			out.writeUTF(str);
			
			System.out.println("服务结束，中断连接.......");
			
			in.close();//关闭读取流
			out.close();
			socketOnServer.close();//关闭Socket
			serverForClient.close();//关闭ServerSocket

			
		} 
		catch (Exception e) 
		{
			System.out.println("客户已断开"+e);
		}

	}
	
	//计算三角形面积的方法
		public static double countarea(double a[])
		{
			double area;
			double temp = 0.0;
			double aside = a[0];
			double bside = a[1];
			double cside = a[2];
			temp = a[0] + a[1] + a[2];
			temp = temp / 2;
			
			area = Math.sqrt(temp * (temp - aside) * (temp - bside) * (temp - cside));
			
			return area;
		}


}
