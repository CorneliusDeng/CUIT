package mark;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.DBConnection;

//ҵ����Bean
public class markDB
{
	private Connection con = null;
  
	//��ȡ���гɼ���Ϣ
	public ArrayList<markInfo> getAll() 
	{
		ResultSet rs=null;
	    Statement sql=null;
	    ArrayList<markInfo> markList=new ArrayList<markInfo>();
	    try 
	    {
	    	con=DBConnection.getConnection();
	        sql=con.createStatement();
	        //TODO 1 ִ�в�ѯ����ȡ���гɼ���Ϣ
	        rs=sql.executeQuery("SELECT * FROM zyyj_student_score");
	        //TODO 2 ѭ�������ɼ���Ϣ���������ÿ����¼����Ϊһ���ɼ���Ϣ���󣬲���ӵ�������
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
	    	System.out.println("��ȡ���гɼ���Ϣʧ�ܣ�");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
		}		
	    return markList;
	 }

}