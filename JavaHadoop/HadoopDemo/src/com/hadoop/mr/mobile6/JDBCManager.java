package com.hadoop.mr.mobile6;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.hadoop.conf.Configuration;

public class JDBCManager {

	public static Connection getConnection(Configuration conf)
	{
		String url=conf.get("url");
		String dirver=conf.get("driver");
		String username=conf.get("username");
		String password=conf.get("password");
		
		try {
			Class.forName(dirver);
			Connection con=DriverManager.getConnection(url, username, password);
			return con;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
