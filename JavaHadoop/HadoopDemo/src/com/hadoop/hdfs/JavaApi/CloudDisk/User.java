package com.hadoop.hdfs.JavaApi.CloudDisk;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class User {
	public String id;
	private String username;
	private String password;

	public User(String username, String password) {
		this.id = "";
		this.username = username;
		this.password = password;
	}

	// 获取最后一个用户的ID
	public String getLastUserId() throws IOException {
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);

		Path src = new Path("/clouddisk/user.dat");
		FSDataInputStream dis = fs.open(src);

		String lastUser = null;
		String nextUser = dis.readLine();
		while (nextUser != null) { // 寻找最后一个用户
			lastUser = nextUser;
			nextUser = dis.readLine(); // 读取下一个用户数据
		}

		dis.close();
		fs.close();

		String lastUserid = "";
		if (lastUser != null) // 提取最后一个用户的ID
		{
			String lastUserinfo[] = lastUser.split(",");
			lastUserid = lastUserinfo[0];
		}
		return lastUserid;
	}

	// 用户注册
	public boolean register() throws IOException {
		String lastUserid = getLastUserId();
		int id = Integer.parseInt(lastUserid) + 1; // 生成用户ID值
		this.id = String.valueOf(id); // 设置用户ID

		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		Path src = new Path("/clouddisk/user.dat");
		FSDataOutputStream dos = fs.append(src); // 以追加方式打开文件

		// 写入用户信息
		dos.writeChars(this.id);
		dos.writeChars("," + this.username);
		dos.writeChars("," + this.password);
		dos.flush();
		dos.close();

		// 创建用户的专属目录
		Path dst = new Path("/clouddisk/" + this.id);
		Boolean isSuccessed = fs.mkdirs(dst);
		fs.close();
		return (isSuccessed) ? true : false;
	}

	public boolean login() throws IOException {
		boolean isLogined = false;
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		Path src = new Path("/clouddisk/user.dat");
		FSDataInputStream dis = fs.open(src);

		String user = dis.readLine();
		while (user != null) { // 遍历用户数据文件的每一行
			String userinfo[] = user.split(",");
			String userid = userinfo[0];
			String username = userinfo[1];
			String password = userinfo[2];
			
			//如果在文件中找到了相同的用户，则登录成功
			if (this.username.equals(username) && this.password.equals(password)) {
				this.id = userid;      //记录用户ID
				isLogined = true;   
				break;
			}
			user = dis.readLine(); // 读取下一个用户数据
		}
		dis.close();
		fs.close();
		return isLogined;
	}
}
