<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>
    <title>MySQL</title>
  </head>
  
<body>
����MySQL���ݿ�<br>
<%
String driverClass="com.mysql.jdbc.Driver";
String url="jdbc:mysql://localhost:3306/db_database08";
String username = "root";
String password = "rootpassword";
Class.forName(driverClass);	 // �������ݿ�����
Connection conn=DriverManager.getConnection(url, username, password);	//��������
Statement stmt=conn.createStatement();
ResultSet rs = stmt.executeQuery("select * from tb_user");	//ִ��SQL���
while(rs.next()){
	out.println("<br>�û�����"+rs.getString(2)+"	���룺"+rs.getString(3));
}
rs.close();
stmt.close();
conn.close();
%>
</body></html>
