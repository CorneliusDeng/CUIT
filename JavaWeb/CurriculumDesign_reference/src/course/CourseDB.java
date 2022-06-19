package course;

import java.sql.*;
import common.DBConnection;

import java.util.ArrayList;;

public class CourseDB {
    private static Connection con = null;
    /* 获取所有课程信息 */
    public static ArrayList<CourseInfo> getAll() {
    	CourseInfo course = new CourseInfo();
        ResultSet rs=null;
        Statement sql=null;
        ArrayList<CourseInfo> courseList=new ArrayList<CourseInfo>();
        try {
        	con=DBConnection.getConnection();
            sql=con.createStatement();
            //TODO 1 执行查询语句获取所有课程信息
        	rs = sql.executeQuery("SELECT * FROM `t_course`");
            //TODO 2 循环遍历课程信息结果集，将每条记录保存为一个课程信息对象，并把课程信息对象添加到数组studentList中。
        	while(rs.next()) {
        		course=new CourseInfo();
        		course.setCourseID(rs.getInt("N_COURSE_ID"));
        		course.setName(rs.getString("VC_COURSE_NAME"));
        		course.setType(rs.getInt("N_TYPE"));
        		course.setCredit(rs.getFloat("F_CREDIT"));
        		course.setGrade(rs.getInt("N_GRADE"));
        		course.setMajor(rs.getInt("N_MAJOR"));
        		course.setDetail(rs.getString("VC_DETAIL"));
        		courseList.add(course);
        	}
			rs.close();
			sql.close();
        } catch (Exception e) {
            System.out.println("获取所有课程信息失败！");
        } finally{
        	DBConnection.closeConnection();
		}		
        return courseList;
    }
    /* 添加课程信息 */
    public int insert(CourseInfo course) {
    	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into t_course(VC_COURSE_NAME,N_TYPE,F_CREDIT,N_GRADE,N_MAJOR,VC_DETAIL) values('" + course.getName() + "',"
    				+ "'" + course.getType() + "','" + course.getCredit() + "','" + course.getGrade() + "','" + course.getMajor() + "','" + course.getDetail() + "')");
    		//TODO 预编译SQL语句参数的设置
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
    public CourseInfo select(int CourseId) {
    	CourseInfo course = new CourseInfo();
    	PreparedStatement pStmt = null;
    	ResultSet rs = null;
    	try {
    		con = DBConnection.getConnection();
    		pStmt = con.prepareStatement("SELECT * FROM `t_course` where N_COURSE_ID=?");
    		pStmt.setInt(1,CourseId); 
    		rs = pStmt.executeQuery();
    		if(rs.next()) {
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
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println("修改课程信息失败! ");
    	} finally {
    		DBConnection.closeConnection();
    	}
    	return course;
    }
    public int modify(int CourseId, CourseInfo course) {
    	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("update t_course set VC_COURSE_NAME = '" + course.getName() + "',N_TYPE = '" + course.getType() + "',F_CREDIT = '" + course.getCredit() + "',"
    				+ "N_GRADE = '" + course.getGrade() + "',N_MAJOR = '" + course.getMajor() + "',VC_DETAIL = '" + course.getDetail() + "' where N_COURSE_ID = '"+ CourseId +"'");
    		//TODO 预编译SQL语句参数的设置
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
    public int delete(int CourseId) {
    	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("delete from t_course where N_COURSE_ID = '"+ CourseId +"'");
    		//TODO 预编译SQL语句参数的设置
    		count=pStmt.executeUpdate();  
			pStmt.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("删除课程失败！");
        } finally{
        	DBConnection.closeConnection();
		}		
        return count;
        }
    /* 获取指定学号人数 */
    public int getCourseCountByName(String CourseName,int CourseId) {
        ResultSet rs=null;
    	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
        	if(CourseId!=0){//修改课程名称时
	    		pStmt = con.prepareStatement("SELECT count(*) C FROM t_course where  VC_COURSE_NAME=? and N_COURSE_ID<>?");
	    		pStmt.setString(1,CourseName);
	    		pStmt.setInt(2,CourseId);	
        	}else{//添加课程
	    		pStmt = con.prepareStatement("SELECT count(*) C FROM t_course where  VC_COURSE_NAME=?");
	    		pStmt.setString(1,CourseName);	       		
        	}
    		rs = pStmt.executeQuery();
	    	if(rs.next()){
	    		count=rs.getInt("C");
	    	} 
			rs.close();
			pStmt.close();

        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("获取指定课程ID信息失败！");
        } finally{
        	DBConnection.closeConnection();
		}		
        return count;
    }
}