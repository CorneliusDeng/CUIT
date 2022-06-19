package login;
import java.sql.*;
import java.util.ArrayList;
import common.*;

//业务处理Bean
public class UserDB 
{
	private Connection con = null;
	
	//通过用户名获取用户信息
	public UserInfo GetUserbyName(String userName)
	{
		System.out.println("GetUserbyName: userName"+userName);
		UserInfo user = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try 
		{
			con = DBConnection.getConnection();
			pStmt = con.prepareStatement("SELECT * from t_user where VC_LOGIN_NAME=?");
			pStmt.setString(1, userName);
			rs = pStmt.executeQuery();
			if (rs.next())
			{
				user = new UserInfo();
				user.setUserId(rs.getInt("N_USER_ID"));
				user.setUserName(rs.getString("VC_LOGIN_NAME"));
				user.setUserPwd(rs.getString("VC_PASSWORD"));
			}
			rs.close();
			pStmt.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("获取指定用户信息失败");
		}
		finally 
		{
			DBConnection.closeConnection();
		}
		return user;
	}
	
	// 获取除了admin用户外的其他用户的信息
	public ArrayList<UserInfo> GetOtherUsers() 
	{
        ResultSet rs=null;
        Statement sql=null;
        ArrayList<UserInfo> userList=new ArrayList<UserInfo>();
        try 
        {
        	con = DBConnection.getConnection();
            sql = con.createStatement();
	    	rs = sql.executeQuery("SELECT * FROM t_user where VC_LOGIN_NAME <> 'admin'");
	    	while(rs.next())
	    	{
	    		UserInfo user=new UserInfo();
				user.setUserId(rs.getInt("N_USER_ID"));
				user.setUserName(rs.getString("VC_LOGIN_NAME"));
				user.setUserPwd(rs.getString("VC_PASSWORD"));
	    		userList.add(user);	    		
	    	}  
			rs.close();
			sql.close();

        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("获取非管理员信息失败！");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return userList;
    }
}
