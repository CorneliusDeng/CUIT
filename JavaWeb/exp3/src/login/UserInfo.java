package login;

import java.io.Serializable;

//值Bean
public class UserInfo implements Serializable 
{
	private int userId;
	private String userName;
	private String userPwd;
	
	public int getUserId() 
	{
		return userId;
	}
	public void setUserId(int userId) 
	{
		this.userId = userId;
	}
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) 
	{
		this.userPwd = userPwd;
	}
	
	
}
