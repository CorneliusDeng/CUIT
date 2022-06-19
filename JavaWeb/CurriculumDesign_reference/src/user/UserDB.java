package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.DBConnection;
import teacher.TeacherInfo;


public class UserDB {
	 private Connection con = null;
	    public ArrayList<UserInfo> getAll() {
	        ResultSet rs=null;
	        Statement sql=null;
	        UserInfo use = null;
	        ArrayList<UserInfo> userList=new ArrayList<UserInfo>();
	        try {
	        	con=DBConnection.getConnection();
	            sql=con.createStatement();
	            String a = "select * from t_user";
	            rs = sql.executeQuery(a);
	            while(rs.next()) {
	            	use = new UserInfo();
	            	use.setUserID(rs.getInt("N_USER_ID"));
	            	use.setUserName(rs.getString("VC_LOGIN_NAME"));
	            	use.setUserPwd(rs.getString("VC_PASSWORD"));
	            	userList.add(use);
	            }        
				rs.close();
				sql.close();            
	        }catch (Exception e) {
	            System.out.println("��ȡ�û���Ϣʧ��");
	        } finally{
	        	DBConnection.closeConnection();
			}		
	        return userList;
	    }
	    
	    public int insert(UserInfo use) {
	    	PreparedStatement p=null; 
	    	int count=0;
	        try {
	        	con=DBConnection.getConnection();
	        	p = con.prepareStatement("insert into t_user(VC_LOGIN_NAME,VC_PASSWORD)values(?,?)");
	        	p.setString(1,use.getUserName());
	        	p.setString(2, use.getUserPwd());
	        	count=p.executeUpdate();  
	        	p.close();
	        }
	        	catch (Exception e) {
	               	e.printStackTrace();
	                System.out.println("����û�ʧ��");
	            } finally{
	            	DBConnection.closeConnection();
	    		}		
	    
	            return count;
	    }
	    public UserInfo select(int UserId) {
	    	UserInfo user = new UserInfo();
	    	PreparedStatement pStmt = null;
	    	ResultSet rs = null;
	    	try {
	    		con = DBConnection.getConnection();
	    		pStmt = con.prepareStatement("select * from `t_user` where N_USER_ID=?");
	    		pStmt.setInt(1,UserId); 
	    		rs = pStmt.executeQuery();
	    		if(rs.next()) {
	    			user=new UserInfo();
	    			user.setUserID(rs.getInt("N_USER_ID"));
	    			user.setUserName(rs.getString("VC_LOGIN_NAME"));
	    			user.setUserPwd(rs.getString("VC_PASSWORD"));
	    		}
	    		rs.close();
	    		pStmt.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    		System.out.println("��ȡָ���û���Ϣʧ��! ");
	    	} finally {
	    		DBConnection.closeConnection();
	    	}
	    	return user;
	    }
	    public int update(UserInfo use)
	    {
	    	int count=0;
	    	PreparedStatement p = null;
	    	try {
	    		con = DBConnection.getConnection();
	    		p = con.prepareStatement("update t_user set VC_LOGIN_NAME=?,VC_PASSWORD=? where N_USER_ID = ?");
	    		p.setString(1, use.getUserName());
	    		p.setString(2, use.getUserPwd());
	    		p.setInt(3, use.getUserID());
	    		count=p.executeUpdate();  
				p.close();
	    	 }catch (Exception e) {
	            	e.printStackTrace();
	             System.out.println("�޸��û���Ϣʧ��");
	         } finally{
	         	DBConnection.closeConnection();
	 		}
	    	return count;
	    }
	    public int delete(int UserId) {
	    	PreparedStatement p=null; 
	    	int count=0;
	        try {
	        	con=DBConnection.getConnection();
	    		p = con.prepareStatement("delete from t_user where N_USER_ID = '"+ UserId +"'");
	    		count=p.executeUpdate();  
				p.close();
	        } catch (Exception e) {
	           	e.printStackTrace();
	            System.out.println("ɾ���û�ʧ��");
	        } finally{
	        	DBConnection.closeConnection();
			}		
	        return count;
	        }
	    public int getUserCountByName(String UserName,int UserId) {
	        ResultSet rs=null;
	    	PreparedStatement pStmt=null; 
	    	int count=0;
	        try {
	        	con=DBConnection.getConnection();
	        	if(UserId!=0){//�޸��û�����ʱ
		    		pStmt = con.prepareStatement("SELECT count(*) C FROM t_user where  VC_LOGIN_NAME=? and N_USER_ID<>?");
		    		pStmt.setString(1,UserName);
		    		pStmt.setInt(2,UserId);	
	        	}else{//����û�
		    		pStmt = con.prepareStatement("SELECT count(*) C FROM t_user where  VC_LOGIN_NAME=?");
		    		pStmt.setString(1,UserName);	       		
	        	}
	    		rs = pStmt.executeQuery();
		    	if(rs.next()){
		    		count=rs.getInt("C");
		    	} 
				rs.close();
				pStmt.close();

	        } catch (Exception e) {
	           	e.printStackTrace();
	            System.out.println("��ȡָ���û���Ϣʧ�ܣ�");
	        } finally{
	        	DBConnection.closeConnection();
			}		
	        return count;
	    }
	    
	    
	    public UserInfo GetUserbyName(String username) {
	        ResultSet rs=null;
	    	PreparedStatement pStmt=null; 
	    	UserInfo userinfo = null;
	        try {
	        	con=DBConnection.getConnection();
	  		    pStmt = con.prepareStatement("SELECT * FROM t_user where  VC_LOGIN_NAME=?");
	  		    pStmt.setString(1,username);
	    		rs = pStmt.executeQuery();
		    	while(rs.next()) {
		    		int id = rs.getInt("N_USER_ID");
		    		String name = rs.getString("VC_LOGIN_NAME");
		    		String password = rs.getString("VC_PASSWORD");
		    		userinfo = new UserInfo(id,name,password);
		    	}
				rs.close();
				pStmt.close();
			

	        } catch (Exception e) {
	           	e.printStackTrace();
	            System.out.println("��ȡָ���û���Ϣʧ�ܣ�");
	        } finally{
	        	DBConnection.closeConnection();
			}		
	    	return userinfo;
	    }
	    
}

