package teacher;

import java.sql.*;
import common.DBConnection;

import java.util.ArrayList;;

public class TeacherDB {
    private static Connection con = null;
    /* ��ȡ���пγ���Ϣ */
    public static ArrayList<TeacherInfo> getAll() {
    	TeacherInfo teacher = new TeacherInfo();
        ResultSet rs=null;
        Statement sql=null;
        ArrayList<TeacherInfo> teacherList=new ArrayList<TeacherInfo>();
        try {
        	con=DBConnection.getConnection();
            sql=con.createStatement();
            //TODO 1 ִ�в�ѯ����ȡ���пγ���Ϣ
        	rs = sql.executeQuery("SELECT * FROM `t_teacher`");
            //TODO 2 ѭ�������γ���Ϣ���������ÿ����¼����Ϊһ���γ���Ϣ���󣬲��ѿγ���Ϣ������ӵ�����studentList�С�
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
            System.out.println("��ȡ���пγ���Ϣʧ�ܣ�");
        } finally{
        	DBConnection.closeConnection();
		}		
        return teacherList;
    }
    /* ��ӿγ���Ϣ */
    public int insert(TeacherInfo teacher) {
    	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into t_teacher(VC_TEACHER_NAME,N_SEX,N_BIRTHDAY,N_EDUCATION,N_TITLE,N_DEPARTMENT,VC_DETAIL) "
    				+ "values('" + teacher.getName() + "','" + teacher.getSex() + "','" + teacher.getBirthday() + "','" + teacher.getEducation() + "',"
    						+ "'" + teacher.getTitle() + "','" + teacher.getDepartment() + "','" + teacher.getDetail() + "')");
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
    		System.out.println("�޸Ŀγ���Ϣʧ��! ");
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
    public int delete(int TeacherId) {
    	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("delete from t_teacher where N_TEACHER_ID = '"+ TeacherId +"'");
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
    public int getTeacherCountByName(String TeacherName,int TeacherId) {
        ResultSet rs=null;
    	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
        	if(TeacherId!=0){//�޸��û�����ʱ
	    		pStmt = con.prepareStatement("SELECT count(*) C FROM t_teacher where  VC_TEACHER_NAME=? and N_TEACHER_ID<>?");
	    		pStmt.setString(1,TeacherName);
	    		pStmt.setInt(2,TeacherId);	
        	}else{//����û�
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
            System.out.println("��ȡָ����ʦ��Ϣʧ�ܣ�");
        } finally{
        	DBConnection.closeConnection();
		}		
        return count;
    }
}