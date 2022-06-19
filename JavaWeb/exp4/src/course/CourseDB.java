package course;
import java.sql.*;
import common.DBConnection;
import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;

//业务处理Bean
public class CourseDB 
{
    private Connection con = null;
    
    //课程信息查询显示功能M层，获取所有课程信息
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
            rs=sql.executeQuery("SELECT * FROM t_course");
            //TODO 2 循环遍历课程信息结果集，将每条记录保存为一个课程信息对象，并添加到数组中
            while(rs.next())
            {
	    		CourseInfo course=new CourseInfo();
	    		course.setCourseID(rs.getInt("N_COURSE_ID"));
	    		course.setName(rs.getString("VC_COURSE_NAME"));
	    		course.setType(rs.getInt("N_TYPE"));
	    		course.setCredit(rs.getFloat("F_CREDIT"));
	    		course.setGrade(rs.getInt("N_GRADE"));
	    		course.setMajor(rs.getInt("N_MAJOR"));
	    		courseList.add(course);	    		
	    	} 
			rs.close();
			sql.close();
        } 
        catch (Exception e) 
        {
            System.out.println("获取所有课程信息失败！");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return courseList;
    }
    
  //课程信息添加功能M层，添加课程信息
    public int insert(CourseInfo course) 
    {
    	PreparedStatement pStmt = null; 
    	int count = 0;
        try 
        {
        	con=DBConnection.getConnection();
        	String sql = "insert into t_course (VC_COURSE_NAME,N_TYPE,F_CREDIT,N_GRADE,N_MAJOR,VC_DETAIL) values (?,?,?,?,?,?)"; 
			pStmt = con.prepareStatement(sql);
    		pStmt.setString(1,course.getName());		
    		pStmt.setInt(2,course.getType());		
    		pStmt.setFloat(3,course.getCredit());		
    		pStmt.setInt(4,course.getGrade());		
    		pStmt.setInt(5,course.getMajor());	
    		pStmt.setString(6,course.getDetail());	
    		count = pStmt.executeUpdate();  
    		pStmt.close();
        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("添加课程失败！");
        } 
        finally
        {
        	DBConnection.closeConnection();
    	}		
        return count;
    }
    
  //课程信息更新功能M层，通过学号更新指定课程信息各项内容
    public int update(CourseInfo course) 
    {
    	PreparedStatement pStmt = null; 
    	int count = 0;
        try 
        {
        	con = DBConnection.getConnection();
        	String sql = "update t_course set VC_COURSE_NAME=?,N_TYPE=?,F_CREDIT=?,N_GRADE=?,N_MAJOR=?,VC_DETAIL=? where N_COURSE_ID=?";
    		pStmt = con.prepareStatement(sql);
    		pStmt.setString(1,course.getName());		
    		pStmt.setInt(2,course.getType());		
    		pStmt.setFloat(3,course.getCredit());		
    		pStmt.setInt(4,course.getGrade());		
    		pStmt.setInt(5,course.getMajor());	
    		pStmt.setString(6,course.getDetail());
    		pStmt.setInt(7,course.getCourseID());
    		count = pStmt.executeUpdate();
			pStmt.close();
        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("修改指定课程信息失败！");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return count;
    }
    
    //课程信息查询功能M层，通过指定学号查询某一课程信息的所有内容
    public CourseInfo getCourseById(int id) 
    {
        ResultSet rs=null;
    	PreparedStatement pStmt=null; 
    	CourseInfo course=null;
        try 
        {
        	con = DBConnection.getConnection();
    		pStmt = con.prepareStatement("SELECT * FROM t_course where N_COURSE_ID=?");
    		pStmt.setInt(1,id);		
    		rs = pStmt.executeQuery();
	    	if(rs.next())
	    	{
	    		course=new CourseInfo();
	    		course.setCourseID(rs.getInt("N_COURSE_ID"));
	    		course.setName(rs.getString("VC_COURSE_NAME"));
	    		course.setType(rs.getInt("N_TYPE"));
	    		course.setCredit(rs.getFloat("F_CREDIT"));
	    		course.setGrade(rs.getInt("N_GRADE"));
	    		course.setMajor(rs.getInt("N_MAJOR"));
	    		course.setDetail(rs.getString("VC_DETAIL"));
	    	} 
			rs.close();
			pStmt.close();

        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("获取指定课程信息失败！");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return course;
    }
    
    //课程信息删除功能M层，通过学号删除指定课程信息
    public int deleteCourse(int id) 
    {
     	PreparedStatement pStmt=null; 
    	int count=0;
        try 
        {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("delete from  t_course   where N_COURSE_ID=?");
    		pStmt.setInt(1,id);		
    		count = pStmt.executeUpdate();
    		pStmt.close();    		
        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("删除指定信息失败！");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return count;
    }   

}

