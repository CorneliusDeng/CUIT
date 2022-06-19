package course;

import java.sql.*;
import java.util.*;
import common.DBConnection;

public class CourseDB {
    private Connection con = null;
    /* 获取所有课程信息 */
    public ArrayList<CourseInfo> getAll() {
        ResultSet rs=null;
        Statement sql=null;
        CourseInfo course = null;
        ArrayList<CourseInfo> CourseList=new ArrayList<CourseInfo>();
        try {
        	con=DBConnection.getConnection();
            sql=con.createStatement();
	//TODO 1 执行查询语句获取所有课程信息
            rs = sql.executeQuery("SELECT * from t_course");
	//TODO 2 循环遍历课程信息结果集，将每条记录保存为一个课程信息对象，并把课程信息对象添加到数组studentList中。
            while(rs.next()) {
            	course = new CourseInfo();
            	course.setCourseID(rs.getInt("N_COURSE_ID"));
            	course.setName(rs.getString("VC_COURSE_NAME"));
            	course.setType(rs.getInt("N_TYPE"));
            	course.setCredit(rs.getFloat("F_CREDIT"));
            	course.setGrade(rs.getInt("N_GRADE"));
            	course.setMajor(rs.getInt("N_MAJOR"));
            	course.setDetail(rs.getString("VC_DETAIL"));
            	CourseList.add(course);
			}
			rs.close();
			sql.close();
        } catch (Exception e) {
            System.out.println("获取所有课程信息失败！");
        } finally{
        	DBConnection.closeConnection();
		}		
        return CourseList;
    }
    
    /* 添加课程信息 */
    public int insert(CourseInfo course) {
    	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into t_course (VC_COURSE_NAME,N_TYPE,F_CREDIT,N_GRADE,N_MAJOR,VC_DETAIL) values (?,?,?,?,?,?)");
    		//TODO 预编译SQL语句参数的设置
    		pStmt.setString(1,course.getName());		
    		pStmt.setInt(2,course.getType());		
    		pStmt.setFloat(3,course.getCredit());		
    		pStmt.setInt(4,course.getGrade());		
    		pStmt.setInt(5,course.getMajor());		
    		pStmt.setString(6,course.getDetail());	
    		count=pStmt.executeUpdate();  
			pStmt.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("添加课程失败！");
        } finally{
        	DBConnection.closeConnection();
		}		
        return count;
}    
    /* 修改课程信息 */
    public int edit(CourseInfo course) {
    	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("update t_course set VC_COURSE_NAME=?,N_TYPE=?,F_CREDIT=?,N_GRADE=?,N_MAJOR=?,VC_DETAIL=? where N_COURSE_ID=?");
    		//TODO 预编译SQL语句参数的设置
    		pStmt.setString(1,course.getName());		
    		pStmt.setInt(2,course.getType());		
    		pStmt.setFloat(3,course.getCredit());		
    		pStmt.setInt(4,course.getGrade());		
    		pStmt.setInt(5,course.getMajor());		
    		pStmt.setString(6,course.getDetail());	
    		pStmt.setInt(7,course.getCourseID());
    		count=pStmt.executeUpdate();  
			pStmt.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("修改课程信息失败！");
        } finally{
        	DBConnection.closeConnection();
		}		
        return count;
}
    /*ID查询课程信息*/
	public CourseInfo getCourseById(int id) {
		ResultSet rs=null;
		PreparedStatement pStmt=null;
        CourseInfo course = null;
        try {
        	con=DBConnection.getConnection();
        	pStmt = con.prepareStatement("SELECT * FROM t_course where N_COURSE_ID=?");
    		pStmt.setInt(1,id);		
    		rs = pStmt.executeQuery();
   
            //TODO 1 执行查询语句获取课程信息
    		if(rs.next()){
    			course = new CourseInfo();
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
        } catch (Exception e) {
            System.out.println("获取课程信息失败！");
        } finally{
        	DBConnection.closeConnection();
		}		
        return course;
	}    
	/*删除课程*/
	public int deleteCourse(int id) {
     	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("delete from  t_course   where N_COURSE_ID=?");
    		pStmt.setInt(1,id);		
    		count=pStmt.executeUpdate();
    		pStmt.close();    		
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("删除课程信息失败！");
        } finally{
        	DBConnection.closeConnection();
		}		
        return count;
    }   
}
