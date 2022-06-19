<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ page import="java.sql.*"%>
<html>
  <head>
    <title>SQL Server 2000</title>
  </head>
  
<body>
连接SQL Server 2000数据库<br>
      <%
      String driverClass="com.microsoft.jdbc.sqlserver.SQLServerDriver";
      String url = "jdbc:microsoft:sqlserver://127.0.0.1:1433;DatabaseName=db_database08";
      String username = "sa";
      String password = "";
      Class.forName(driverClass);
      Connection conn=DriverManager.getConnection(url, username, password);
      Statement stmt=conn.createStatement();
      ResultSet rs = stmt.executeQuery("select * from tb_user");
	  while(rs.next()){
			out.println("<br>用户名："+rs.getString(2)+"	密码："+rs.getString(3));
	  }
      rs.close();
      stmt.close();
      conn.close();
      %>
</body>
  
</html>
