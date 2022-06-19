package Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.DBConnection;
import Course.CourseInfo;

//业务处理Bean
public class CourseDB
{
	private Connection con = null;
  
	//获取所有科目信息
	public ArrayList<CourseInfo> getAll() 
	{
		ResultSet rs=null;
	    Statement sql=null;
	    ArrayList<CourseInfo> courseList=new ArrayList<CourseInfo>();
	    try 
	    {
	    	con=DBConnection.getConnection();
	        sql=con.createStatement();
	        //TODO 1 执行查询语句获取所有课程信息
	        rs=sql.executeQuery("SELECT * FROM zyyj_course");
	        //TODO 2 循环遍历学院信息结果集，将每条记录保存为一个课程信息对象，并添加到数组中
	        while(rs.next())
	        {
	        	CourseInfo course =new CourseInfo();
	        	course.setCourse_id(rs.getString("course_id"));
	        	course.setUser_id(rs.getString("user_id"));
	        	course.setName(rs.getString("name"));
	        	course.setIntroduction(rs.getString("introduction"));
	        	course.setPhoto(rs.getString("photo"));
	        	course.setPractice_count(rs.getInt("practice_count"));

	        	courseList.add(course);	      		
	        }  
	        rs.close();
	        sql.close();
	    } 
	    catch (Exception e) 
	    {
	    	System.out.println("获取所有科目信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
		}		
	    return courseList;
	 }
  
  //添加科目信息
	public int Courseinsert(CourseInfo course) 
	{
		PreparedStatement pStmt = null; 
  		int count = 0;
	    try 
	    {
	    	con = DBConnection.getConnection();
	      	String sql = "insert into zyyj_course (course_id,user_id,name,introduction,photo,practice_count) values (?,?,?,?,?,?)";
	      	pStmt = con.prepareStatement(sql);
	  		pStmt.setString(1,course.getCourse_id());		
	  		pStmt.setString(2,course.getUser_id());		
	  		pStmt.setString(3,course.getName());	
	  		pStmt.setString(4,course.getIntroduction());
	  		pStmt.setString(5,course.getPhoto());
	  		pStmt.setInt(6,course.getPractice_count());

	  		count = pStmt.executeUpdate();  
	  		pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("添加科目失败！");
	    } 
	    finally
	    {
	      	DBConnection.closeConnection();
	  	}		
	    return count;
	}
  
	//更新科目信息各项内容
	public int update(CourseInfo course) 
	{
		PreparedStatement pStmt = null; 
	  	int count = 0;
	    try 
	    {
	    	con = DBConnection.getConnection();
	      	String sql = "update zyyj_course set user_id=?,name=?,introduction=?, photo=?,practice_count=? where course_id = ?";	
	  		pStmt = con.prepareStatement(sql);	
	  		pStmt.setString(1,course.getUser_id());		
	  		pStmt.setString(2,course.getName());	
	  		pStmt.setString(3,course.getIntroduction());
	  		pStmt.setString(4,course.getPhoto());
	  		pStmt.setInt(5,course.getPractice_count());
	  		pStmt.setString(6,course.getCourse_id());	
	  		
	  		count = pStmt.executeUpdate();
			pStmt.close();
	      } 
	      catch (Exception e) 
	      {
	    	  e.printStackTrace();
	          System.out.println("修改指定科目信息失败！");
	      } 
	      finally
	      {
	    	  DBConnection.closeConnection();
	      }		
	      return count;
	  }
  
	//通过指定科目编号查询某科目的所有信息
	public CourseInfo getCourseById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	CourseInfo course = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_course where course_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	course = new CourseInfo();
		    	course.setCourse_id(rs.getString("course_id"));
		    	course.setUser_id(rs.getString("user_id"));
		    	course.setName(rs.getString("name"));
		    	course.setIntroduction(rs.getString("introduction"));
		    	course.setPhoto(rs.getString("photo"));
		    	course.setPractice_count(rs.getInt("practice_count"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("获取指定科目信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    return course;
	  }
  
  //通过科目编号删除指定科目信息
  public int deleteCourse(String id) 
  {
	  PreparedStatement pStmt=null; 
	  int count=0;
      try 
      {
      	con=DBConnection.getConnection();
  		pStmt = con.prepareStatement("delete from zyyj_course where course_id=?");
  		pStmt.setString(1,id);		
  		count = pStmt.executeUpdate();
  		pStmt.close();    		
      } 
      catch (Exception e) 
      {
         	e.printStackTrace();
          System.out.println("删除指定科目失败！");
      } 
      finally
      {
    	  DBConnection.closeConnection();
      }		
      return count;
  }   
  public String UpdategetCourseById(String id) 
	{
		ResultSet rs = null;
	  	PreparedStatement pStmt = null; 
	  	CourseInfo course = null;
	    try 
	    {
	      	con = DBConnection.getConnection();
	  		pStmt = con.prepareStatement("SELECT * FROM zyyj_course where course_id=?");
	  		pStmt.setString(1,id);		
	  		rs = pStmt.executeQuery();
		    if(rs.next())
		    {
		    	course = new CourseInfo();
		    	course.setCourse_id(rs.getString("course_id"));
	        	course.setUser_id(rs.getString("user_id"));
	        	course.setName(rs.getString("name"));
	        	course.setIntroduction(rs.getString("introduction"));
	        	course.setPhoto(rs.getString("photo"));
	        	course.setPractice_count(rs.getInt("practice_count"));
		    } 
			rs.close();
			pStmt.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	        System.out.println("获取指定科目信息失败！");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    String json;
	    json = "{\"course_id\":\""+course.getCourse_id()+"\", \"user_id\":\""+course.getUser_id()+"\", \"name\":\""+course.getName()+"\",\"introduction\":\""+course.getIntroduction()+"\", \"photo\":\""+course.getPhoto()+"\", \"practice_count\":"+course.getPractice_count()+"}";
	    return json;
	  }
}