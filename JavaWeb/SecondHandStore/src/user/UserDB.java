package user;

import common.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDB 
{
	 private Connection con = null;

    //获取所有用户的信息
    public ArrayList<UserInfo> GetAllUsers()
    {
        ResultSet rs=null;
        Statement sql=null;
        ArrayList<UserInfo> userList=new ArrayList<UserInfo>();
        try
        {
            con = DBConnection.getConnection();
            sql = con.createStatement();
            rs = sql.executeQuery("SELECT * from td_user");
            while(rs.next())
            {
                UserInfo user=new UserInfo();
                user.setUserid(rs.getString("user_id"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setSort(rs.getInt("user_sort"));
                userList.add(user);
            }
            rs.close();
            sql.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("获取所有用户信息失败");
        }
        finally
        {
            DBConnection.closeConnection();
        }
        return userList;
    }
    
    /* 添加用户信息 */
    public int insertUser(UserInfo user)
    {
    	PreparedStatement pStmt = null; 
    	int count = 0;
        try 
        {
        	con= DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into td_notice values (?,?,?,?)");
    		pStmt.setString(1,user.getUserid());
    		pStmt.setString(2,user.getUsername());
    		pStmt.setString(3,user.getPassword());
			pStmt.setString(4,user.getTt());
			System.out.println("username"+user.getUserid());
			System.out.println("pass"+user.getPassword());
			count=pStmt.executeUpdate();
			pStmt.close();
        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("发布消息失败！");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return count;
    }

    public UserInfo GetUserbyId(String user_id)
    {
        UserInfo user = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try
        {
            Connection con = DBConnection.getConnection();
            pStmt = con.prepareStatement("SELECT * from td_user where user_id=?");
            pStmt.setString(1, user_id);
            rs = pStmt.executeQuery();
            if (rs.next())
            {
                user = new UserInfo();
                user.setUserid(rs.getString("user_id"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setSort(rs.getInt("user_sort"));
            }
            rs.close();
            pStmt.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("获取指定用户所有信息失败");
        }
        finally
        {
            DBConnection.closeConnection();
        }
        return user;
    }
}
