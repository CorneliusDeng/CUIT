<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>
    <title>MySQL</title>
  </head>
  
<body>
连接MySQL数据库<br>
<%
String driverClass="com.mysql.jdbc.Driver";
String url="jdbc:mysql://localhost:3306/db_database08";
String username = "root";
String password = "rootpassword";
Class.forName(driverClass);	 // 加载数据库驱动
Connection conn=DriverManager.getConnection(url, username, password);	//建立连接
Statement stmt=conn.createStatement();
ResultSet rs = stmt.executeQuery("select * from tb_user");	//执行SQL语句
while(rs.next()){
	out.println("<br>用户名："+rs.getString(2)+"	密码："+rs.getString(3));
}
rs.close();
stmt.close();
conn.close();
%>
</body></html>
