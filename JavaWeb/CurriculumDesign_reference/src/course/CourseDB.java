package course;

import java.sql.*;
import common.DBConnection;

import java.util.ArrayList;;

public class CourseDB {
    private static Connection con = null;
    /* ��ȡ���пγ���Ϣ */
    public static ArrayList<CourseInfo> getAll() {
    	CourseInfo course = new CourseInfo();
        ResultSet rs=null;
        Statement sql=null;
        ArrayList<CourseInfo> courseList=new ArrayList<CourseInfo>();
        try {
        	con=DBConnection.getConnection();
            sql=con.createStatement();
            //TODO 1 ִ�в�ѯ����ȡ���пγ���Ϣ
        	rs = sql.executeQuery("SELECT * FROM `t_course`");
            //TODO 2 ѭ�������γ���Ϣ���������ÿ����¼����Ϊһ���γ���Ϣ���󣬲��ѿγ���Ϣ������ӵ�����studentList�С�
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
            System.out.println("��ȡ���пγ���Ϣʧ�ܣ�");
        } finally{
        	DBConnection.closeConnection();
		}		
        return courseList;
    }
    /* ��ӿγ���Ϣ */
    public int insert(CourseInfo course) {
    	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into t_course(VC_COURSE_NAME,N_TYPE,F_CREDIT,N_GRADE,N_MAJOR,VC_DETAIL) values('" + course.getName() + "',"
    				+ "'" + course.getType() + "','" + course.getCredit() + "','" + course.getGrade() + "','" + course.getMajor() + "','" + course.getDetail() + "')");
    		//TODO Ԥ����SQL������������
    		count=pStmt.executeUpdate();  
			pStmt.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("��ӿγ�ʧ�ܣ�");
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
    		System.out.println("�޸Ŀγ���Ϣʧ��! ");
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
    		//TODO Ԥ����SQL������������
    		count=pStmt.executeUpdate();  
			pStmt.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("�޸Ŀγ���Ϣʧ�ܣ�");
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
    		//TODO Ԥ����SQL������������
    		count=pStmt.executeUpdate();  
			pStmt.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("ɾ���γ�ʧ�ܣ�");
        } finally{
        	DBConnection.closeConnection();
		}		
        return count;
        }
    /* ��ȡָ��ѧ������ */
    public int getCourseCountByName(String CourseName,int CourseId) {
        ResultSet rs=null;
    	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
        	if(CourseId!=0){//�޸Ŀγ�����ʱ
	    		pStmt = con.prepareStatement("SELECT count(*) C FROM t_course where  VC_COURSE_NAME=? and N_COURSE_ID<>?");
	    		pStmt.setString(1,CourseName);
	    		pStmt.setInt(2,CourseId);	
        	}else{//��ӿγ�
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
            System.out.println("��ȡָ���γ�ID��Ϣʧ�ܣ�");
        } finally{
        	DBConnection.closeConnection();
		}		
        return count;
    }
}