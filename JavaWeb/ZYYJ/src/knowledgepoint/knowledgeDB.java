package knowledgepoint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.DBConnection;

//业务处理Bean
public class knowledgeDB
{
	private Connection con = null;
  
	//获取所有知识点信息
	public ArrayList<knowledgepointInfo> getAll() 
	{
		ResultSet rs=null;
	    Statement sql=null;
	    ArrayList<knowledgepointInfo> knowledgeList=new ArrayList<knowledgepointInfo>();
	    try 
	    {
	    	con=DBConnection.getConnection();
	        sql=con.createStatement();
	        //TODO 1 执行查询语句获取所有知识点信息
	        rs=sql.executeQuery("SELECT * FROM zyyj_knowledgepoint");
	        //TODO 2 循环遍历知识点信息结果集，将每条记录保存为一个知识点信息对象，并添加到数组中
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
	    	System.out.println("获取所有知识点信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
		}		
	    return knowledgeList;
	 }
  
  //添加知识点信息
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
	        System.out.println("添加知识点失败！");
	    } 
	    finally
	    {
	      	DBConnection.closeConnection();
	  	}		
	    return count;
	}
  
	//更新知识点信息各项内容
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
	          System.out.println("修改指定知识点信息失败！");
	      } 
	      finally
	      {
	    	  DBConnection.closeConnection();
	      }		
	      return count;
	  }
  
	//通过指定知识点号查询某知识点的所有信息
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
	        System.out.println("获取指定知识点信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    return knowledgepoint;
	  }
  
  //通过知识点号删除指定知识点信息
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
          System.out.println("删除指定知识点失败！");
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
	        System.out.println("获取指定知识点信息失败！");
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