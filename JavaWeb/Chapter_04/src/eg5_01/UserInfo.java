package eg5_01;

public class UserInfo {
	private String userName;						//对应表单中userName字段
	private String userPass;						//对应表单中userPass字段
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
}
