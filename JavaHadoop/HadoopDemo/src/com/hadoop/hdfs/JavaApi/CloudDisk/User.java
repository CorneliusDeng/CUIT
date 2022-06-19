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

	// ��ȡ���һ���û���ID
	public String getLastUserId() throws IOException {
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);

		Path src = new Path("/clouddisk/user.dat");
		FSDataInputStream dis = fs.open(src);

		String lastUser = null;
		String nextUser = dis.readLine();
		while (nextUser != null) { // Ѱ�����һ���û�
			lastUser = nextUser;
			nextUser = dis.readLine(); // ��ȡ��һ���û�����
		}

		dis.close();
		fs.close();

		String lastUserid = "";
		if (lastUser != null) // ��ȡ���һ���û���ID
		{
			String lastUserinfo[] = lastUser.split(",");
			lastUserid = lastUserinfo[0];
		}
		return lastUserid;
	}

	// �û�ע��
	public boolean register() throws IOException {
		String lastUserid = getLastUserId();
		int id = Integer.parseInt(lastUserid) + 1; // �����û�IDֵ
		this.id = String.valueOf(id); // �����û�ID

		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		Path src = new Path("/clouddisk/user.dat");
		FSDataOutputStream dos = fs.append(src); // ��׷�ӷ�ʽ���ļ�

		// д���û���Ϣ
		dos.writeChars(this.id);
		dos.writeChars("," + this.username);
		dos.writeChars("," + this.password);
		dos.flush();
		dos.close();

		// �����û���ר��Ŀ¼
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
		while (user != null) { // �����û������ļ���ÿһ��
			String userinfo[] = user.split(",");
			String userid = userinfo[0];
			String username = userinfo[1];
			String password = userinfo[2];
			
			//������ļ����ҵ�����ͬ���û������¼�ɹ�
			if (this.username.equals(username) && this.password.equals(password)) {
				this.id = userid;      //��¼�û�ID
				isLogined = true;   
				break;
			}
			user = dis.readLine(); // ��ȡ��һ���û�����
		}
		dis.close();
		fs.close();
		return isLogined;
	}
}
