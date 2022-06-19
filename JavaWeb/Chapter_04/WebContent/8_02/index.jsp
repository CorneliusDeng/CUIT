<%@ page language="java" import="java.sql.*" pageEncoding="GBK"%>
<html>
  <head>
    <title>Access</title>
  </head>
  
<body>
连接Access数据库<br>
    <%
    String driverClass="sun.jdbc.odbc.JdbcOdbcDriver";
    String path=request.getRealPath("");
    String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ="+path+"/8_02/db_database08.mdb";
    System.out.println("URL:"+url);
    String username = "";
    String password = "";
    Class.forName(driverClass);	 // 加载数据库驱动
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
