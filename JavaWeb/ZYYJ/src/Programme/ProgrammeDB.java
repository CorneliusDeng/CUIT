package Programme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import College.CollegeInfo;
import common.DBConnection;
import Programme.ProgrammeInfo;
//ҵ����Bean
public class ProgrammeDB
{
	private Connection con = null;
	//ͨ��ָ����Ŀ�Ų�ѯ����Ŀ��������Ϣ
	
	public ArrayList<ProgrammeInfo> getAll() 
	{
		ResultSet rs=null;
	    Statement sql=null;
	    ArrayList<ProgrammeInfo> ProgrammeList=new ArrayList<ProgrammeInfo>();
	    try 
	    {
	    	con=DBConnection.getConnection();
	        sql=con.createStatement();
	        rs=sql.executeQuery("SELECT * FROM zyyj_programme");
	        while(rs.next())
	        {
	        	ProgrammeInfo Programme =new ProgrammeInfo();
	        	Programme.setProgramme_id(rs.getString("programme_id"));
	        	Programme.setName(rs.getString("name"));
	        	Programme.setCreatedate(rs.getString("createdate"));
	        	Programme.setScore(rs.getInt("score"));
	        	Programme.setComment(rs.getString("comment"));
	        	
	        	ProgrammeList.add(Programme);	    		
	        }  
	        rs.close();
	        sql.close();
	    } 
	    catch (Exception e) 
	    {
	    	System.out.println("��ȡ����ʧ�ܣ�");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
		}		
	    return ProgrammeList;
	 }
	
	public ProgrammeInfo getNameById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	ProgrammeInfo Programme = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_programme where programme_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	Programme = new ProgrammeInfo();
		    	Programme.setProgramme_id(rs.getString("programme_id"));
		    	Programme.setName(rs.getString("name"));
		    	Programme.setCreatedate(rs.getString("createdate"));
		    	Programme.setScore(rs.getInt("score"));
		    	Programme.setComment(rs.getString("comment"));
	        	
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("��ȡָ����������ʧ�ܣ�");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    return Programme;
	  }
  
  

}