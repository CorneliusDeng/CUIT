package teach;

import java.sql.*;
import common.DBConnection;
import java.util.ArrayList;;

public class TeachDB {
    private static Connection con = null;
    public static ArrayList<TeachInfo> getAll() {
    	TeachInfo teach = new TeachInfo();
        ResultSet rs=null;
        Statement sql=null;
        ArrayList<TeachInfo> teachList=new ArrayList<TeachInfo>();
        try {
        	con=DBConnection.getConnection();
            sql=con.createStatement();
        	rs = sql.executeQuery("SELECT * FROM `t_tc`");
        	while(rs.next()) {
        		teach=new TeachInfo();
        		teach.setTeachId(rs.getInt("N_TEACH_ID"));
        		teach.setTeacherId(rs.getInt("N_TEACHER_ID"));
        		teach.setCourseId(rs.getInt("N_COURSE_ID"));
        		teachList.add(teach);
        	}
			rs.close();
			sql.close();
        } catch (Exception e) {
            System.out.println("»ñÈ¡ËùÓÐÊÚ¿ÎÐÅÏ¢Ê§°Ü£¡");
        } finally{
        	DBConnection.closeConnection();
		}		
        return teachList;
    }
    public int insert(TeachInfo teach) {
    	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into `t_tc`(N_TEACH_ID,N_TEACHER_ID,N_COURSE_ID) values('" + teach.getTeachId() + "',"
    				+ "'" + teach.getTeacherId() + "','" + teach.getCourseId() + "')");
    		count=pStmt.executeUpdate();  
			pStmt.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("Ìí¼ÓÊÚ¿ÎÐÅÏ¢Ê§°Ü£¡");
        } finally{
        	DBConnection.closeConnection();
		}		
        return count;
        }
    public TeachInfo select(int TeachId) {
    	TeachInfo teach = new TeachInfo();
    	PreparedStatement pStmt = null;
    	ResultSet rs = null;
    	try {
    		con = DBConnection.getConnection();
    		pStmt = con.prepareStatement("SELECT * FROM `t_tc` where N_TEACH_ID=?");
    		pStmt.setInt(1,TeachId); 
    		rs = pStmt.executeQuery();
    		if(rs.next()) {
    			teach=new TeachInfo();
    			teach.setTeachId(rs.getInt("N_TEACH_ID"));
    			teach.setTeacherId(rs.getInt("N_TEACHER_ID"));
        		teach.setCourseId(rs.getInt("N_COURSE_ID"));
    		}
    		rs.close();
    		pStmt.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println("ÐÞ¸ÄÊÚ¿ÎÐÅÏ¢Ê§°Ü! ");
    	} finally {
    		DBConnection.closeConnection();
    	}
    	return teach;
    }
    public int modify(int TeachId, TeachInfo teach) {
    	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("update t_tc set N_TEACHER_ID = '" + teach.getTeacherId() + "',N_COURSE_ID = '" + teach.getCourseId() + "' where N_TEACH_ID = '" + TeachId + "'");
    		count=pStmt.executeUpdate();  
			pStmt.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("ÐÞ¸ÄÊÚ¿ÎÐÅÏ¢Ê§°Ü£¡");
        } finally{
        	DBConnection.closeConnection();
		}		
        return count;
        }
    public int delete(int TeachId) {
    	PreparedStatement pStmt=null; 
    	int count=0;
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("delete from t_tc where N_TEACH_ID = '"+ TeachId +"'");
    		count=pStmt.executeUpdate();  
			pStmt.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("É¾³ýÊÚ¿ÎÐÅÏ¢Ê§°Ü£¡");
        } finally{
        	DBConnection.closeConnection();
		}		
        return count;
        }
}