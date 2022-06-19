package mark;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.DBConnection;

//业务处理Bean
public class markDB
{
	private Connection con = null;
  
	//获取所有成绩信息
	public ArrayList<markInfo> getAll() 
	{
		ResultSet rs=null;
	    Statement sql=null;
	    ArrayList<markInfo> markList=new ArrayList<markInfo>();
	    try 
	    {
	    	con=DBConnection.getConnection();
	        sql=con.createStatement();
	        //TODO 1 执行查询语句获取所有成绩信息
	        rs=sql.executeQuery("SELECT * FROM zyyj_student_score");
	        //TODO 2 循环遍历成绩信息结果集，将每条记录保存为一个成绩信息对象，并添加到数组中
	        while(rs.next())
	        {
	        	markInfo mark =new markInfo();
	        	mark.setStudent_id(rs.getString("student_id"));
	        	mark.setScore(rs.getInt("score"));
	        	markList.add(mark);	    		
	        }  
	        rs.close();
	        sql.close();
	    } 
	    catch (Exception e) 
	    {
	    	System.out.println("获取所有成绩信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
		}		
	    return markList;
	 }

}