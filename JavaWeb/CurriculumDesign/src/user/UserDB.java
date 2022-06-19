package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.DBConnection;

public class UserDB 
{
	 private Connection con = null;
	
	 /* 获取所有用户信息 */
    public ArrayList<UserInfo> getAllUsers() 
    {
        ResultSet rs=null;
        Statement sql=null;
        ArrayList<UserInfo> userList=new ArrayList<UserInfo>();
        try 
        {
        	con = DBConnection.getConnection();
            sql = con.createStatement();
	    	rs = sql.executeQuery("SELECT * from t_user");
	    	while(rs.next())
	    	{
	    		UserInfo user = new UserInfo();
	    		user.setUserid(rs.getInt("N_USER_ID"));
	    		user.setUsername(rs.getString("VC_LOGIN_NAME"));
	    		user.setPassword(rs.getString("VC_PASSWORD"));
	    		userList.add(user);	    		
	    	}  
			rs.close();
			sql.close();

        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("获取所有用户信息失败！");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return userList;
    }
    
    /* 获取指定用户信息 */
    public UserInfo getUserById(int id) 
    {
        ResultSet rs = null;
    	PreparedStatement pStmt = null; 
    	UserInfo user = null;
        try 
        {
        	con = DBConnection.getConnection();
    		pStmt = con.prepareStatement("SELECT * FROM t_user where N_USER_ID=?");
    		pStmt.setInt(1,id);		
    		rs = pStmt.executeQuery();
	    	if(rs.next())
	    	{
	    		user = new UserInfo();
	    		user.setUserid(rs.getInt("N_USER_ID"));
	    		user.setUsername(rs.getString("VC_LOGIN_NAME"));
	    		user.setPassword(rs.getString("VC_PASSWORD"));
	    	} 
			rs.close();
			pStmt.close();

        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("获取指定用户信息失败！");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return user;
    }
    
    /* 添加用户信息 */
    public int insertUser(UserInfo user) 
    {
    	PreparedStatement pStmt = null; 
    	int count = 0;
        try 
        {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into t_user (VC_LOGIN_NAME,VC_PASSWORD) values (?,?)");
    		//pStmt.setInt(1,user.getUserid());	这里不要插入id，自动递增！！！
    		pStmt.setString(1,user.getUsername());		
    		pStmt.setString(2,user.getPassword());		
    		count=pStmt.executeUpdate();  
			pStmt.close();
        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("添加用户失败！");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return count;
    }
    
    /* 修改用户信息 */
    public int updateUser(UserInfo user) 
    {
    	PreparedStatement pStmt = null; 
    	int count = 0;
        try {
        	con = DBConnection.getConnection();
    		pStmt = con.prepareStatement("update t_user set VC_LOGIN_NAME=?,VC_PASSWORD=? where N_USER_ID=?");
    		pStmt.setString(1,user.getUsername());		
    		pStmt.setString(2,user.getPassword());		
    		pStmt.setInt(3,user.getUserid());		
    		count=pStmt.executeUpdate();
			pStmt.close();

        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("修改用户信息失败！");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return count;
    }
    
    /* 删除用户信息 */
    public int deleteUser(int id) 
    {
     	PreparedStatement pStmt = null; 
    	int count=0;
        try 
        {
        	con = DBConnection.getConnection();
    		pStmt = con.prepareStatement("delete from t_user where N_USER_ID=?");
    		pStmt.setInt(1,id);		
    		count = pStmt.executeUpdate();
    		pStmt.close();    		
        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("删除用户信息失败！");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return count;
    } 
    
    /* 获取指定姓名人数 */
    public int getUserNameById(String name,int id) 
    {
        ResultSet rs = null;
    	PreparedStatement pStmt = null; 
    	int count = 0;
        try 
        {
        	con = DBConnection.getConnection();
        	if(id != 0)
        	{//修改用户信息时时
	    		pStmt = con.prepareStatement("SELECT count(*) C FROM t_user where  VC_LOGIN_NAME=? and N_USER_ID<>?");
	    		pStmt.setString(1,name);
	    		pStmt.setInt(2,id);	
        	}
        	else
        	{//添加新用户
	    		pStmt = con.prepareStatement("SELECT count(*) C FROM t_user where  VC_LOGIN_NAME=?");
	    		pStmt.setString(1,name);	       		
        	}
    		rs = pStmt.executeQuery();
	    	if(rs.next())
	    	{
	    		count = rs.getInt("C");
	    	} 
			rs.close();
			pStmt.close();

        } 
        catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("获取指定用户名人数信息失败！");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return count;
    }
    
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
  				user.setUserid(rs.getInt("N_USER_ID"));
  				user.setUsername(rs.getString("VC_LOGIN_NAME"));
  				user.setPassword(rs.getString("VC_PASSWORD"));
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
}
