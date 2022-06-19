package department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import department.DepartmentInfo;
import common.DBConnection;

public class DepartmentDB
{
	private Connection con = null;
  
	//获取所有部门信息
	public ArrayList<DepartmentInfo> getAll() 
	{
		ResultSet rs=null;
	    Statement sql=null;
	    ArrayList<DepartmentInfo> departmentList = new ArrayList<DepartmentInfo>();
	    try 
	    {
	    	con=DBConnection.getConnection();
	        sql=con.createStatement();
	        //TODO 1 执行查询语句获取所有课程信息
	        rs=sql.executeQuery("SELECT * FROM zyyj_department");
	        //TODO 2 循环遍历部门信息结果集，将每条记录保存为一个课程信息对象，并添加到数组中
	        while(rs.next())
	        {
	        	DepartmentInfo department =new DepartmentInfo();
	        	department.setDepartmentid(rs.getString("department_id"));
	        	department.setCollegeid(rs.getString("college_id"));
	        	department.setName(rs.getString("Name"));
	        	department.setComment(rs.getString("comment"));
	        	departmentList.add(department);	    		
	        }  
	        rs.close();
	        sql.close();
	    } 
	    catch (Exception e) 
	    {
	    	System.out.println("获取所有部门信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
		}		
	    return departmentList;
	 }
  
  //添加部门信息
	public int Departmentinsert(DepartmentInfo department) 
	{
		PreparedStatement pStmt = null; 
  		int count = 0;
	    try 
	    {
	      	con = DBConnection.getConnection();
	      	String sql = "insert into zyyj_department (department_id,college_id,Name,comment) values (?,?,?,?)";
	      	pStmt = con.prepareStatement(sql);
	  		pStmt.setString(1,department.getDepartmentid());		
	  		pStmt.setString(2,department.getCollegeid());		
	  		pStmt.setString(3,department.getName());	
	  		pStmt.setString(4,department.getComment());	
	  		count = pStmt.executeUpdate();  
	  		pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("添加部门失败！");
	    } 
	    finally
	    {
	      	DBConnection.closeConnection();
	  	}		
	    return count;
	}
  
	//更新部门信息各项内容
	public int update(DepartmentInfo department) 
	{
		PreparedStatement pStmt = null; 
	  	int count = 0;
	    try 
	    {
	    	con = DBConnection.getConnection();
	      	String sql = "update zyyj_department set college_id=?,Name=?,comment=? where department_id = ?";	
	  		pStmt = con.prepareStatement(sql);
	  		pStmt.setString(1,department.getCollegeid());	
	  		pStmt.setString(2,department.getName());		
	  		pStmt.setString(3,department.getComment());
	  		pStmt.setString(4, department.getDepartmentid());
	  		count = pStmt.executeUpdate();
			pStmt.close();
	      } 
	      catch (Exception e) 
	      {
	    	  e.printStackTrace();
	          System.out.println("修改指定部门信息失败！");
	      } 
	      finally
	      {
	    	  DBConnection.closeConnection();
	      }		
	      return count;
	  }
  
	//通过指定部门号查询某部门的所有信息
	public DepartmentInfo getDepartmentById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	DepartmentInfo department = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_department where department_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	department = new DepartmentInfo();
		    	department.setDepartmentid(rs.getString("department_id"));
		    	department.setCollegeid(rs.getString("college_id"));
		    	department.setName(rs.getString("Name"));
		    	department.setComment(rs.getString("comment"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("获取指定部门信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    return department;
	  }
  
	  //通过部门删除指定部门信息
	  public int deleteDepartment(String id) 
	  {
		  PreparedStatement pStmt = null; 
		  int count=0;
	      try 
	      {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("delete from zyyj_department where department_id=?");
	  		pStmt.setString(1,id);		
	  		count = pStmt.executeUpdate();
	  		pStmt.close();    		
	      } 
	      catch (Exception e) 
	      {
	         	e.printStackTrace();
	          System.out.println("删除指定部门失败！");
	      } 
	      finally
	      {
	    	  DBConnection.closeConnection();
	      }		
	      return count;
	  }   
	  
	  public String UpdategetDepartmentById(String id) 
		{
			ResultSet rs = null;
		  	PreparedStatement pStmt = null; 
		  	DepartmentInfo department = null;
		    try 
		    {
		      	con = DBConnection.getConnection();
		  		pStmt = con.prepareStatement("SELECT * FROM zyyj_department where department_id=?");
		  		pStmt.setString(1,id);		
		  		rs = pStmt.executeQuery();
			    if(rs.next())
			    {
			    	department = new DepartmentInfo();
			    	department.setDepartmentid(rs.getString("department_id"));
			    	department.setCollegeid(rs.getString("college_id"));
			    	department.setName(rs.getString("Name"));
			    	department.setComment(rs.getString("comment"));
			    } 
				rs.close();
				pStmt.close();
		    } 
		    catch (Exception e) 
		    {
		    	e.printStackTrace();
		        System.out.println("获取指定部门信息失败！");
		    } 
		    finally
		    {
		    	DBConnection.closeConnection();
		    }		
		    String json;
		    json = "{\"departmentid\":\""+department.getDepartmentid()+"\", \"collegeid\":\""+department.getCollegeid()+"\", \"name\":\""+department.getName()+"\", \"comment\":\""+department.getComment()+"\"}";
		    return json;
		  }

}
