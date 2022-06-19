package teacher;

import java.sql.*;
import common.DBConnection;

import java.util.ArrayList;;

public class TeacherDB {
    private static Connection con = null;
    /* 获取所有课程信息 */
    public static ArrayList<TeacherInfo> getAll() {
    	TeacherInfo teacher = new TeacherInfo();
        ResultSet rs=null;
        Statement sql=null;
        ArrayList<TeacherInfo> teacherList=new ArrayList<TeacherInfo>();
        try {
        	con=DBConnection.getConnection();
            sql=con.createStatement();
            //TODO 1 执行查询语句获取所有课程信息
        	rs = sql.executeQuery("SELECT * FROM `t_teacher`");
            //TODO 2 循环遍历课程信息结果集，将每条记录保存为一个课程信息对象，并把课程信息对象添加到数组studentList中。
        	while(rs.next()) {
        		teacher=new TeacherInfo();
        		teacher.setTeacherID(rs.getInt("N_TEACHER_ID"));
        		teacher.setSex(rs.getInt("N_SEX"));
        		teacher.setName(rs.getString("VC_TEACHER_NAME"));
        		teacher.setBirthday(rs.getString("N_BIRTHDAY"));
        		teacher.setEducation(rs.getString("N_EDUCATION"));
        		teacher.setTitle(rs.getString("N_TITLE"));
        		teacher.setDepartment(rs.getString("N_DEPARTMENT"));
        		teacher.setDetail(rs.getString("VC_DETAIL"));
        		teacherList.add(teacher);
        	}
			rs.close();
			sql.close();
        } catch (Exception e) {
            System.out.println("获取所有课程信息失败！");
        } finally{
        	DBConnection.closeConnection();
		}		
        return teacherList;
    }
    /* 添加课程信息 */
    public int insert(TeacherInfo teacher) {
    	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into t_teacher(VC_TEACHER_NAME,N_SEX,N_BIRTHDAY,N_EDUCATION,N_TITLE,N_DEPARTMENT,VC_DETAIL) "
    				+ "values('" + teacher.getName() + "','" + teacher.getSex() + "','" + teacher.getBirthday() + "','" + teacher.getEducation() + "',"
    						+ "'" + teacher.getTitle() + "','" + teacher.getDepartment() + "','" + teacher.getDetail() + "')");
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
    public TeacherInfo select(int TeacherId) {
    	TeacherInfo teacher = new TeacherInfo();
    	PreparedStatement pStmt = null;
    	ResultSet rs = null;
    	try {
    		con = DBConnection.getConnection();
    		pStmt = con.prepareStatement("SELECT * FROM `t_teacher` where N_TEACHER_ID=?");
    		pStmt.setInt(1,TeacherId); 
    		rs = pStmt.executeQuery();
    		if(rs.next()) {
    			teacher=new TeacherInfo();
    			teacher.setTeacherID(rs.getInt("N_TEACHER_ID"));
        		teacher.setName(rs.getString("VC_TEACHER_NAME"));
        		teacher.setSex(rs.getInt("N_SEX"));
        		teacher.setBirthday(rs.getString("N_BIRTHDAY"));
        		teacher.setEducation(rs.getString("N_EDUCATION"));
        		teacher.setTitle(rs.getString("N_TITLE"));
        		teacher.setDepartment(rs.getString("N_DEPARTMENT"));
        		teacher.setDetail(rs.getString("VC_DETAIL"));
    		}
    		rs.close();
    		pStmt.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println("修改课程信息失败! ");
    	} finally {
    		DBConnection.closeConnection();
    	}
    	return teacher;
    }
    public int modify(int TeacherId, TeacherInfo teacher) {
    	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("update t_teacher set VC_TEACHER_NAME = '" + teacher.getName() + "',N_BIRTHDAY = '" + teacher.getBirthday() + "',N_SEX = '" + teacher.getSex() + "',"
    				+ "N_EDUCATION = '" + teacher.getEducation() + "',N_TITLE = '" + teacher.getTitle() + "',N_DEPARTMENT = '" + teacher.getDepartment() + "',VC_DETAIL = '" + teacher.getDetail() + "' where N_TEACHER_ID = '"+ TeacherId +"'");
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
    public int delete(int TeacherId) {
    	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("delete from t_teacher where N_TEACHER_ID = '"+ TeacherId +"'");
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
    public int getTeacherCountByName(String TeacherName,int TeacherId) {
        ResultSet rs=null;
    	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
        	if(TeacherId!=0){//修改用户名称时
	    		pStmt = con.prepareStatement("SELECT count(*) C FROM t_teacher where  VC_TEACHER_NAME=? and N_TEACHER_ID<>?");
	    		pStmt.setString(1,TeacherName);
	    		pStmt.setInt(2,TeacherId);	
        	}else{//添加用户
	    		pStmt = con.prepareStatement("SELECT count(*) C FROM t_teacher where  VC_TEACHER_NAME=?");
	    		pStmt.setString(1,TeacherName);	       		
        	}
    		rs = pStmt.executeQuery();
	    	if(rs.next()){
	    		count=rs.getInt("C");
	    	} 
			rs.close();
			pStmt.close();

        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("获取指定教师信息失败！");
        } finally{
        	DBConnection.closeConnection();
		}		
        return count;
    }
}