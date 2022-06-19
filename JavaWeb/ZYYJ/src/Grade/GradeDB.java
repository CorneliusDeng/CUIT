package Grade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import common.DBConnection;

public class GradeDB 
{
	private Connection con = null;
	
	//获取所有年级信息
	public ArrayList<GradeInfo> getAll() 
	{
		ResultSet rs=null;
		Statement sql=null;
		ArrayList<GradeInfo> gradeList = new ArrayList<GradeInfo>();
		try 
		{
			con=DBConnection.getConnection();
	        sql=con.createStatement();
	        rs=sql.executeQuery("SELECT * FROM zyyj_grade");
	        while(rs.next())
	        {
	        	GradeInfo grade =new GradeInfo();
	        	grade.setGradeid(rs.getString("grade_id"));
	        	grade.setMajorid(rs.getString("major_id"));
	        	grade.setName(rs.getString("name"));
	        	grade.setComment(rs.getString("comment"));
	        	gradeList.add(grade);	    		
	        }  
	        rs.close();
	        sql.close();
	    } 
	    catch (Exception e) 
	    {
	    	System.out.println("获取所有年级信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
		}		
	    return gradeList;
	 }
	
	//添加年级信息
	public int Gradeinsert(GradeInfo grade) 
	{
		PreparedStatement pStmt = null; 
  		int count = 0;
	    try 
	    {
	      	con = DBConnection.getConnection();
	      	String sql = "insert into zyyj_grade (grade_id,major_id,name,comment) values (?,?,?,?)";
	      	pStmt = con.prepareStatement(sql);
	      	pStmt.setString(1, grade.getGradeid());
	      	pStmt.setString(2,grade.getMajorid());
	  		pStmt.setString(3,grade.getName());		
	  		pStmt.setString(4,grade.getComment());	
	  		count = pStmt.executeUpdate();  
	  		pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("添加年级失败！");
	    } 
	    finally
	    {
	      	DBConnection.closeConnection();
	  	}		
	    return count;
	}
	
	//更新年级信息各项内容
	public int update(GradeInfo grade) 
	{
		PreparedStatement pStmt = null; 
	  	int count = 0;
	    try 
	    {
	    	con = DBConnection.getConnection();
	      	String sql = "update zyyj_grade set major_id=?,name=?,comment=? where grade_id = ?";	
	  		pStmt = con.prepareStatement(sql);
	  		pStmt.setString(1, grade.getMajorid());
	  		pStmt.setString(2,grade.getName());		
	  		pStmt.setString(3,grade.getComment());
	  		pStmt.setString(4,grade.getGradeid());
	  		count = pStmt.executeUpdate();
			pStmt.close();
	      } 
	      catch (Exception e) 
	      {
	    	  e.printStackTrace();
	          System.out.println("修改指定年级信息失败！");
	      } 
	      finally
	      {
	    	  DBConnection.closeConnection();
	      }		
	      return count;
	}
	
	//通过指定年级号查询某年级的所有信息
	public GradeInfo getGradeById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	GradeInfo grade = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_grade where grade_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	grade = new GradeInfo();
		    	grade.setGradeid(rs.getString("grade_id"));
	        	grade.setMajorid(rs.getString("major_id"));
	        	grade.setName(rs.getString("name"));
	        	grade.setComment(rs.getString("comment"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("获取指定专业信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    return grade;
	}
	
	//通过年级号删除指定年级信息
	public int deleteGrade(String id) 
	{
		PreparedStatement pStmt=null; 
		int count=0;
		try 
		{
			con=DBConnection.getConnection();
			pStmt = con.prepareStatement("delete from zyyj_grade where grade_id=?");
			pStmt.setString(1,id);		
			count = pStmt.executeUpdate();
			pStmt.close();    		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("删除指定年级失败！");
		} 
		finally
		{
			DBConnection.closeConnection();
		}		
		return count;
	}   
	
	//通过年级号更新指定年级信息
	public String UpdategetGradeById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	GradeInfo grade = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_grade where grade_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	grade = new GradeInfo();
		    	grade.setGradeid(rs.getString("grade_id"));
	        	grade.setMajorid(rs.getString("major_id"));
	        	grade.setName(rs.getString("name"));
	        	grade.setComment(rs.getString("comment"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("获取指定年级信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    String json;
	    json = "{\"gradeid\":\""+grade.getGradeid()+"\",\"majorid\":\""+grade.getMajorid()+"\", \"name\":\""+grade.getName()+"\", \"detail\":\""+grade.getComment()+"\"}";
	    return json;
	  }
}
