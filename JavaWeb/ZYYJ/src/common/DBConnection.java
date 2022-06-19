package common;
import java.sql.*;

//通用工具Bean，处理数据库链接
public class DBConnection 
{
	public static Connection conn = null;
	
	//创建数据库链接
	public static Connection getConnection()
	{
		//1、加载驱动程序
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (Exception e) 
		{
			System.out.println("驱动程序com.mysql.jdbc.Driver加载失败");
		}
		
		//2、链接数据库
		try 
		{
			conn = DriverManager.getConnection("jdbc:mysql://120.26.173.96:3306/db_zyyj?useUnicode=false&useSSL=false&characterEncoding=UTF-8",
					"root",
					"CorneliusDeng7");
		} 
		catch(Exception e)
		{
			System.out.println("获取数据库链接失败");
		}
		
		return conn;
	}
	
	//关闭数据库链接
	public static void closeConnection()
	{
		try 
		{
			if (conn != null)//链接已经创建好
			{
				conn.close();
				conn = null;
			}
		} 
		catch (Exception e) 
		{
			System.out.println("关闭数据库链接失败！");
		}
	}
}
