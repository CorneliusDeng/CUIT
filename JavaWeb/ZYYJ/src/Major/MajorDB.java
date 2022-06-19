package Major;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import common.DBConnection;

public class MajorDB 
{
	private Connection con = null;
	
	//获取所有专业信息
	public ArrayList<MajorInfo> getAll() 
	{
		ResultSet rs=null;
		Statement sql=null;
		ArrayList<MajorInfo> majorList = new ArrayList<MajorInfo>();
		try 
		{
			con=DBConnection.getConnection();
	        sql=con.createStatement();
	        rs=sql.executeQuery("SELECT * FROM zyyj_major");
	        while(rs.next())
	        {
	        	MajorInfo major =new MajorInfo();
	        	major.setMajorid(rs.getString("major_id"));
	        	major.setCollegeid(rs.getString("college_id"));
	        	major.setName(rs.getString("name"));
	        	major.setComment(rs.getString("comment"));
	        	majorList.add(major);	    		
	        }  
	        rs.close();
	        sql.close();
	    } 
	    catch (Exception e) 
	    {
	    	System.out.println("获取所有专业信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
		}		
	    return majorList;
	 }
	
	//添加专业信息
	public int Majorinsert(MajorInfo major) 
	{
		PreparedStatement pStmt = null; 
  		int count = 0;
	    try 
	    {
	      	con = DBConnection.getConnection();
	      	String sql = "insert into zyyj_major (major_id,college_id,name,comment) values (?,?,?,?)";
	      	pStmt = con.prepareStatement(sql);
	      	pStmt.setString(1,major.getMajorid());
	  		pStmt.setString(2,major.getCollegeid());		
	  		pStmt.setString(3,major.getName());		
	  		pStmt.setString(4,major.getComment());	
	  		count = pStmt.executeUpdate();  
	  		pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("添加专业失败！");
	    } 
	    finally
	    {
	      	DBConnection.closeConnection();
	  	}		
	    return count;
	}
	
	//更新专业信息各项内容
	public int update(MajorInfo major) 
	{
		PreparedStatement pStmt = null; 
	  	int count = 0;
	    try 
	    {
	    	con = DBConnection.getConnection();
	      	String sql = "update zyyj_major set college_id=?,name=?,comment=? where major_id = ?";	
	  		pStmt = con.prepareStatement(sql);
	  		pStmt.setString(1, major.getCollegeid());
	  		pStmt.setString(2,major.getName());		
	  		pStmt.setString(3,major.getComment());
	  		pStmt.setString(4,major.getMajorid());
	  		count = pStmt.executeUpdate();
			pStmt.close();
	      } 
	      catch (Exception e) 
	      {
	    	  e.printStackTrace();
	          System.out.println("修改指定专业信息失败！");
	      } 
	      finally
	      {
	    	  DBConnection.closeConnection();
	      }		
	      return count;
	}
	
	//通过指定专业号查询某专业的所有信息
	public MajorInfo getMajorById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	MajorInfo major = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_major where major_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	major = new MajorInfo();
		    	major.setMajorid(rs.getString("major_id"));
		    	major.setCollegeid(rs.getString("college_id"));
		    	major.setName(rs.getString("name"));
		    	major.setComment(rs.getString("comment"));
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
	    return major;
	}
	
	//通过专业号删除指定专业信息
	public int deleteMajor(String id) 
	{
		PreparedStatement pStmt=null; 
		int count=0;
		try 
		{
			con=DBConnection.getConnection();
			pStmt = con.prepareStatement("delete from zyyj_major where major_id=?");
			pStmt.setString(1,id);		
			count = pStmt.executeUpdate();
			pStmt.close();    		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("删除指定专业失败！");
		} 
		finally
		{
			DBConnection.closeConnection();
		}		
		return count;
	}   
	
	//通过专业号更新指定专业信息
	public String UpdategetMajorById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	MajorInfo major = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_major where major_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	major = new MajorInfo();
		    	major.setMajorid(rs.getString("major_id"));
		    	major.setCollegeid(rs.getString("college_id"));
		    	major.setName(rs.getString("name"));
		    	major.setComment(rs.getString("comment"));
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
	    String json;
	    json = "{\"majorid\":\""+major.getMajorid()+"\",\"collegeid\":\""+major.getCollegeid()+"\", \"name\":\""+major.getName()+"\", \"detail\":\""+major.getComment()+"\"}";
	    return json;
	  }
	
}
