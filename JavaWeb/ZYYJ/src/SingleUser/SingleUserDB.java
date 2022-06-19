package SingleUser;
import java.sql.*;
import java.util.ArrayList;

import User.UserInfo;
import common.*;

//M层，业务处理Bean
public class SingleUserDB 
{
	//获取所有用户的信息
	public ArrayList<SingleUserInfo> GetAllUsers() 
	{
        ResultSet rs=null;
        Statement sql=null;
        ArrayList<SingleUserInfo> userList=new ArrayList<SingleUserInfo>();
        try 
        {
        	Connection con = DBConnection.getConnection();
            sql = con.createStatement();
	    	rs = sql.executeQuery("SELECT * from zyyj_user");
	    	while(rs.next())
	    	{
	    		SingleUserInfo user=new SingleUserInfo();
	    		user.setUser_id(rs.getString("user_id"));
				user.setPost_id(rs.getInt("post_id"));
				user.setName(rs.getString("name"));
				user.setRealname(rs.getString("realname"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getInt("gender"));
				user.setStatus(rs.getInt("status"));
				user.setPhoto(rs.getString("photo"));
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
	
	//插入用户信息
	public int inserUser(SingleUserInfo user)
	{
		int count = 0;
		
		try 
		{
			Connection con = DBConnection.getConnection();
			PreparedStatement pStmt = null; 
			String sql = "insert into zyyj_user (user_id,post_id,name,realname,password,phone,email,gender,status) values (?,?,?,?,?,?,?,?,?)";
	      	pStmt = con.prepareStatement(sql);
	  		pStmt.setString(1,user.getUser_id());
	  		pStmt.setInt(2,user.getPost_id());
	  		pStmt.setString(3,user.getName());
	  		pStmt.setString(4,user.getRealname());
	  		pStmt.setString(5,user.getPassword());
	  		pStmt.setString(6,user.getPhone());
	  		pStmt.setString(7,user.getEmail());
	  		pStmt.setInt(8,user.getGender());
	  		pStmt.setInt(9,user.getStatus());
	  		count = pStmt.executeUpdate();  
	  		pStmt.close();
			
		}
		catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("添加用户信息失败");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return count;
	}
	
	//通过Id获取指定用户所有信息
	public SingleUserInfo GetUserbyId(String user_id)
	{
		SingleUserInfo user = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try 
		{
			Connection con = DBConnection.getConnection();
			pStmt = con.prepareStatement("SELECT * from zyyj_user where user_id=?");
			pStmt.setString(1, user_id);
			rs = pStmt.executeQuery();
			if (rs.next())
			{
				user = new SingleUserInfo();
				user.setUser_id(rs.getString("user_id"));
				user.setPost_id(rs.getInt("post_id"));
				user.setName(rs.getString("name"));
				user.setRealname(rs.getString("realname"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getInt("gender"));
				user.setStatus(rs.getInt("status"));
				user.setPhoto(rs.getString("photo"));
			
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
	
	//更新用户信息
	public int updateUser(SingleUserInfo user)
	{
		int count = 0;
		try 
		{
			Connection con = DBConnection.getConnection();
			String sql = "update zyyj_user set post_id=?,name=?,realname=?,password=?,phone=?,email=?,gender=?,status=? where user_id=?";
			PreparedStatement stm = con.prepareStatement(sql);
			System.out.println(user.toString());
			stm.setInt(1, user.getPost_id());
			stm.setString(2, user.getName());
			stm.setString(3, user.getRealname());
			stm.setString(4, user.getPassword());
			stm.setString(5, user.getPhone());
			stm.setString(6, user.getEmail());
			stm.setInt(7, user.getGender());
			stm.setInt(8, user.getStatus());
			stm.setString(9, user.getUser_id());
			count = stm.executeUpdate();
			stm.close();
		}
		catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("更新用户信息失败");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return count;
	}
	
	//删除指定用户信息
	public int deleteUser(String user_id)
	{
		int count = 0;
		try 
		{
			Connection con = DBConnection.getConnection();
			PreparedStatement stm = con.prepareStatement("delete from zyyj_user where user_id=?"); 
			stm.setString(1, user_id);
			count= stm.executeUpdate();
			stm.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("删除指定用户信息失败");
		}
		finally 
		{
			DBConnection.closeConnection();
		}
		return count;
	}
	
	//更新密码
	public int updateUserPassowrd(SingleUserInfo user)
	{
		int count = 0;
		try 
		{
			Connection con = DBConnection.getConnection();
			String sql = "update zyyj_user set password=? where user_id=?";
			PreparedStatement stm = con.prepareStatement(sql);
			System.out.println(user.toString());
			stm.setString(1, user.getPassword());
			stm.setString(2, user.getUser_id());
			count = stm.executeUpdate();
			stm.close();
		}
		catch (Exception e) 
        {
           	e.printStackTrace();
            System.out.println("更新密码失败！");
        } 
        finally
        {
        	DBConnection.closeConnection();
		}		
        return count;
	}
}
