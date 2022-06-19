package knowledgepoint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.DBConnection;

//ҵ����Bean
public class knowledgeDB
{
	private Connection con = null;
  
	//��ȡ����֪ʶ����Ϣ
	public ArrayList<knowledgepointInfo> getAll() 
	{
		ResultSet rs=null;
	    Statement sql=null;
	    ArrayList<knowledgepointInfo> knowledgeList=new ArrayList<knowledgepointInfo>();
	    try 
	    {
	    	con=DBConnection.getConnection();
	        sql=con.createStatement();
	        //TODO 1 ִ�в�ѯ����ȡ����֪ʶ����Ϣ
	        rs=sql.executeQuery("SELECT * FROM zyyj_knowledgepoint");
	        //TODO 2 ѭ������֪ʶ����Ϣ���������ÿ����¼����Ϊһ��֪ʶ����Ϣ���󣬲���ӵ�������
	        while(rs.next())
	        {
	        	knowledgepointInfo knowledgepoint =new knowledgepointInfo();
	        	knowledgepoint.setKnow_id(rs.getString("know_id"));
	        	knowledgepoint.setCourse_id(rs.getString("course_id"));
	        	knowledgepoint.setName(rs.getString("name"));
	        	knowledgepoint.setComment(rs.getString("comment"));
	        	knowledgeList.add(knowledgepoint);	    		
	        }  
	        rs.close();
	        sql.close();
	    } 
	    catch (Exception e) 
	    {
	    	System.out.println("��ȡ����֪ʶ����Ϣʧ�ܣ�");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
		}		
	    return knowledgeList;
	 }
  
  //���֪ʶ����Ϣ
	public int knowledgepointinsert(knowledgepointInfo knowledgepoint) 
	{
		PreparedStatement pStmt = null; 
  		int count = 0;
	    try 
	    {
	      	con = DBConnection.getConnection();
	      	String sql = "insert into zyyj_knowledgepoint (know_id,course_id,name,comment) values (?,?,?,?)";
	      	pStmt = con.prepareStatement(sql);
	  		pStmt.setString(1,knowledgepoint.getKnow_id());		
	  		pStmt.setString(2,knowledgepoint.getCourse_id());		
	  		pStmt.setString(3,knowledgepoint.getName());	
	  		pStmt.setString(4,knowledgepoint.getComment());
	  		count = pStmt.executeUpdate();  
	  		pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("���֪ʶ��ʧ�ܣ�");
	    } 
	    finally
	    {
	      	DBConnection.closeConnection();
	  	}		
	    return count;
	}
  
	//����֪ʶ����Ϣ��������
	public int update(knowledgepointInfo knowledgepoint) 
	{
		PreparedStatement pStmt = null; 
	  	int count = 0;
	    try 
	    {
	    	con = DBConnection.getConnection();
	      	String sql = "update zyyj_knowledgepoint set course_id=?, name=?,comment=? where know_id = ?";	
	  		pStmt = con.prepareStatement(sql);
	  		pStmt.setString(1,knowledgepoint.getCourse_id());		
	  		pStmt.setString(2,knowledgepoint.getName());	
	  		pStmt.setString(3,knowledgepoint.getComment());
	  		pStmt.setString(4,knowledgepoint.getKnow_id());		
	  		count = pStmt.executeUpdate();
			pStmt.close();
	      } 
	      catch (Exception e) 
	      {
	    	  e.printStackTrace();
	          System.out.println("�޸�ָ��֪ʶ����Ϣʧ�ܣ�");
	      } 
	      finally
	      {
	    	  DBConnection.closeConnection();
	      }		
	      return count;
	  }
  
	//ͨ��ָ��֪ʶ��Ų�ѯĳ֪ʶ���������Ϣ
	public knowledgepointInfo getKnowledgepointById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	knowledgepointInfo knowledgepoint = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_knowledgepoint where know_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	knowledgepoint = new knowledgepointInfo();
		    	knowledgepoint.setKnow_id(rs.getString("know_id"));
		    	knowledgepoint.setCourse_id(rs.getString("course_id"));
		    	knowledgepoint.setName(rs.getString("name"));
		    	knowledgepoint.setComment(rs.getString("comment"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("��ȡָ��֪ʶ����Ϣʧ�ܣ�");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    return knowledgepoint;
	  }
  
  //ͨ��֪ʶ���ɾ��ָ��֪ʶ����Ϣ
  public int deleteKnowledgepoint(String id) 
  {
	  PreparedStatement pStmt=null; 
	  int count=0;
      try 
      {
      	con=DBConnection.getConnection();
  		pStmt = con.prepareStatement("delete from zyyj_knowledgepoint where know_id=?");
  		pStmt.setString(1,id);		
  		count = pStmt.executeUpdate();
  		pStmt.close();    		
      } 
      catch (Exception e) 
      {
         	e.printStackTrace();
          System.out.println("ɾ��ָ��֪ʶ��ʧ�ܣ�");
      } 
      finally
      {
    	  DBConnection.closeConnection();
      }		
      return count;
  }   
  
  public String UpdategetKnowledgepointById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	knowledgepointInfo knowledgepoint = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_knowledgepoint where know_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	knowledgepoint = new knowledgepointInfo();
		    	knowledgepoint.setKnow_id(rs.getString("know_id"));
		    	knowledgepoint.setCourse_id(rs.getString("course_id"));
		    	knowledgepoint.setName(rs.getString("name"));
		    	knowledgepoint.setComment(rs.getString("comment"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("��ȡָ��֪ʶ����Ϣʧ�ܣ�");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    String json;
	    json = "{\"know_id\":\""+knowledgepoint.getKnow_id()+"\", \"course_id\":\""+knowledgepoint.getCourse_id()+"\",\"name\":\""+knowledgepoint.getName()+"\", \"comment\":\""+knowledgepoint.getComment()+"\"}";
	    return json;
	  }

}