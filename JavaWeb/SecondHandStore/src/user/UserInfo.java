package user;

public class UserInfo 
{
	private String userid;
	private String username;
	private String password;
	private int sort;
	private String tt;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSort() { return sort; }

	public void setSort(int sort) { this.sort = sort; }

	public String getTt() {
		return tt;
	}

	public void setTt(String tt) {
		this.tt = tt;
	}
}
