package Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.DBConnection;
import Course.CourseInfo;

//ҵ����Bean
public class CourseDB
{
	private Connection con = null;
  
	//��ȡ���п�Ŀ��Ϣ
	public ArrayList<CourseInfo> getAll() 
	{
		ResultSet rs=null;
	    Statement sql=null;
	    ArrayList<CourseInfo> courseList=new ArrayList<CourseInfo>();
	    try 
	    {
	    	con=DBConnection.getConnection();
	        sql=con.createStatement();
	        //TODO 1 ִ�в�ѯ����ȡ���пγ���Ϣ
	        rs=sql.executeQuery("SELECT * FROM zyyj_course");
	        //TODO 2 ѭ������ѧԺ��Ϣ���������ÿ����¼����Ϊһ���γ���Ϣ���󣬲���ӵ�������
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
	    	System.out.println("��ȡ���п�Ŀ��Ϣʧ�ܣ�");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
		}		
	    return courseList;
	 }
  
  //��ӿ�Ŀ��Ϣ
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
	        System.out.println("��ӿ�Ŀʧ�ܣ�");
	    } 
	    finally
	    {
	      	DBConnection.closeConnection();
	  	}		
	    return count;
	}
  
	//���¿�Ŀ��Ϣ��������
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
	          System.out.println("�޸�ָ����Ŀ��Ϣʧ�ܣ�");
	      } 
	      finally
	      {
	    	  DBConnection.closeConnection();
	      }		
	      return count;
	  }
  
	//ͨ��ָ����Ŀ��Ų�ѯĳ��Ŀ��������Ϣ
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
	        System.out.println("��ȡָ����Ŀ��Ϣʧ�ܣ�");
	    } 
	    finally
	    {
	    	DBConnection.closeConnection();
	    }		
	    return course;
	  }
  
  //ͨ����Ŀ���ɾ��ָ����Ŀ��Ϣ
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
          System.out.println("ɾ��ָ����Ŀʧ�ܣ�");
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
	        System.out.println("��ȡָ����Ŀ��Ϣʧ�ܣ�");
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