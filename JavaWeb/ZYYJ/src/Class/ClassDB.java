package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import common.DBConnection;

public class ClassDB 
{
	private Connection con = null;
	
	//获取所有班级信息
	public ArrayList<ClassInfo> getAll() 
	{
		ResultSet rs=null;
		Statement sql=null;
		ArrayList<ClassInfo> classList = new ArrayList<ClassInfo>();
		try 
		{
			con=DBConnection.getConnection();
	        sql=con.createStatement();
	        rs=sql.executeQuery("SELECT * FROM zyyj_class");
	        while(rs.next())
	        {
	        	ClassInfo testclass = new ClassInfo(); 
	        	testclass.setClassid(rs.getString("class_id"));
	        	testclass.setGradeid(rs.getString("grade_id"));
	        	testclass.setName(rs.getString("name"));
	        	testclass.setComment(rs.getString("comment"));
	        	classList.add(testclass);	    		
	        }  
	        rs.close();
	        sql.close();
	    } 
	    catch (Exception e) 
	    {
	    	System.out.println("获取所有班级信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
		}		
	    return classList;
	 }
	
	//添加班级信息
	public int Classinsert(ClassInfo testclass) 
	{
		PreparedStatement pStmt = null; 
  		int count = 0;
	    try 
	    {
	      	con = DBConnection.getConnection();
	      	String sql = "insert into zyyj_class (class_id,grade_id,name,comment) values (?,?,?,?)";
	      	pStmt = con.prepareStatement(sql);
	      	pStmt.setString(1, testclass.getClassid());
	      	pStmt.setString(2,testclass.getGradeid());
	  		pStmt.setString(3,testclass.getName());		
	  		pStmt.setString(4,testclass.getComment());	
	  		count = pStmt.executeUpdate();  
	  		pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("添加班级失败！");
	    } 
	    finally
	    {
	      	DBConnection.closeConnection();
	  	}		
	    return count;
	}
	
	//更新班级信息各项内容
	public int update(ClassInfo testclass) 
	{
		PreparedStatement pStmt = null; 
	  	int count = 0;
	    try 
	    {
	    	con = DBConnection.getConnection();
	      	String sql = "update zyyj_class set grade_id=?,name=?,comment=? where class_id = ?";	
	  		pStmt = con.prepareStatement(sql);
	  		pStmt.setString(1, testclass.getGradeid());
	  		pStmt.setString(2,testclass.getName());		
	  		pStmt.setString(3,testclass.getComment());
	  		pStmt.setString(4,testclass.getClassid());
	  		count = pStmt.executeUpdate();
			pStmt.close();
	      } 
	      catch (Exception e) 
	      {
	    	  e.printStackTrace();
	          System.out.println("修改指定班级信息失败！");
	      } 
	      finally
	      {
	    	  DBConnection.closeConnection();
	      }		
	      return count;
	}
	
	//通过指定班级号查询某班级的所有信息
	public ClassInfo getClassById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	ClassInfo testclass = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_class where class_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	testclass = new ClassInfo();
		    	testclass.setClassid(rs.getString("class_id"));
		    	testclass.setGradeid(rs.getString("grade_id"));
		    	testclass.setName(rs.getString("name"));
		    	testclass.setComment(rs.getString("comment"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("获取指定班级信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    return testclass;
	}
	
	//通过班级号删除指定班级信息
	public int deleteClass(String id) 
	{
		PreparedStatement pStmt=null; 
		int count=0;
		try 
		{
			con=DBConnection.getConnection();
			pStmt = con.prepareStatement("delete from zyyj_class where class_id=?");
			pStmt.setString(1,id);		
			count = pStmt.executeUpdate();
			pStmt.close();    		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("删除指定班级失败！");
		} 
		finally
		{
			DBConnection.closeConnection();
		}		
		return count;
	}   
	
	//通过班级号更新指定班级信息
	public String UpdategetClassById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	ClassInfo testclass = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_class where class_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	testclass = new ClassInfo();
		    	testclass.setClassid(rs.getString("class_id"));
		    	testclass.setGradeid(rs.getString("grade_id"));
		    	testclass.setName(rs.getString("name"));
		    	testclass.setComment(rs.getString("comment"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("获取指定班级信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    String json;
	    json = "{\"classid\":\""+testclass.getClassid()+"\",\"gradeid\":\""+testclass.getGradeid()+"\", \"name\":\""+testclass.getName()+"\", \"detail\":\""+testclass.getComment()+"\"}";
	    return json;
	  }
}
