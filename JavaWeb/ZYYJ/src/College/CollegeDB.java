package College;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.DBConnection;
import College.CollegeInfo;

//业务处理Bean
public class CollegeDB
{
	private Connection con = null;
  
	//获取所有学院信息
	public ArrayList<CollegeInfo> getAll() 
	{
		ResultSet rs=null;
	    Statement sql=null;
	    ArrayList<CollegeInfo> collegeList=new ArrayList<CollegeInfo>();
	    try 
	    {
	    	con=DBConnection.getConnection();
	        sql=con.createStatement();
	        rs=sql.executeQuery("SELECT * FROM zyyj_college");
	        while(rs.next())
	        {
	        	CollegeInfo college =new CollegeInfo();
	        	college.setCollegid(rs.getString("college_id"));
	        	college.setCollegename(rs.getString("name"));
	        	college.setCollegedetail(rs.getString("comment"));
	        	collegeList.add(college);	    		
	        }  
	        rs.close();
	        sql.close();
	    } 
	    catch (Exception e) 
	    {
	    	System.out.println("获取所有学院信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
		}		
	    return collegeList;
	 }
  
  //添加学院信息
	public int Collegeinsert(CollegeInfo college) 
	{
		PreparedStatement pStmt = null; 
  		int count = 0;
	    try 
	    {
	      	con = DBConnection.getConnection();
	      	String sql = "insert into zyyj_college (college_id,name,comment) values (?,?,?)";
	      	pStmt = con.prepareStatement(sql);
	  		pStmt.setString(1,college.getCollegid());		
	  		pStmt.setString(2,college.getCollegename());		
	  		pStmt.setString(3,college.getCollegedetail());	
	  		count = pStmt.executeUpdate();  
	  		pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("添加学院失败！");
	    } 
	    finally
	    {
	      	DBConnection.closeConnection();
	  	}		
	    return count;
	}
  
	//更新学院信息各项内容
	public int update(CollegeInfo college) 
	{
		PreparedStatement pStmt = null; 
	  	int count = 0;
	    try 
	    {
	    	con = DBConnection.getConnection();
	      	String sql = "update zyyj_college set name=?,comment=? where college_id = ?";	
	  		pStmt = con.prepareStatement(sql);
	  		pStmt.setString(1,college.getCollegename());		
	  		pStmt.setString(2,college.getCollegedetail());
	  		pStmt.setString(3, college.getCollegid());
	  		count = pStmt.executeUpdate();
			pStmt.close();
	      } 
	      catch (Exception e) 
	      {
	    	  e.printStackTrace();
	          System.out.println("修改指定学院信息失败！");
	      } 
	      finally
	      {
	    	  DBConnection.closeConnection();
	      }		
	      return count;
	  }
  
	//通过指定学院号查询某学院的所有信息
	public CollegeInfo getCollegeById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	CollegeInfo college = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_college where college_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	college = new CollegeInfo();
		    	college.setCollegid(rs.getString("college_id"));
		    	college.setCollegename(rs.getString("name"));
		    	college.setCollegedetail(rs.getString("comment"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("获取指定学院信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    return college;
	  }
  
	  //通过学院号删除指定学院信息
	  public int deleteCollege(String id) 
	  {
		  PreparedStatement pStmt=null; 
		  int count=0;
	      try 
	      {
	      	con=DBConnection.getConnection();
	  		pStmt = con.prepareStatement("delete from zyyj_college where college_id=?");
	  		pStmt.setString(1,id);		
	  		count = pStmt.executeUpdate();
	  		pStmt.close();    		
	      } 
	      catch (Exception e) 
	      {
	         	e.printStackTrace();
	          System.out.println("删除指定学院失败！");
	      } 
	      finally
	      {
	    	  DBConnection.closeConnection();
	      }		
	      return count;
	  }   
  
  //通过学院号更新指定学院信息
  public String UpdategetCollegeById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	CollegeInfo college = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_college where college_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	college = new CollegeInfo();
		    	college.setCollegid(rs.getString("college_id"));
		    	college.setCollegename(rs.getString("name"));
		    	college.setCollegedetail(rs.getString("comment"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("获取指定学院信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    String json;
	    json = "{\"id\":\""+college.getCollegid()+"\", \"name\":\""+college.getCollegename()+"\", \"detail\":\""+college.getCollegedetail()+"\"}";
	    return json;
	  }

}
