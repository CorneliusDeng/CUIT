<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>
    <title>应用PreparedStatement对象实现数据添加操作</title>
  </head>
  
<body>
      <%
      String driverClass="com.mysql.jdbc.Driver";
      String url="jdbc:mysql://localhost:3306/db_database08";
      String username = "root";
      String password = "rootpassword";
      Class.forName(driverClass);
      Connection conn=DriverManager.getConnection(url, username, password);
      PreparedStatement pStmt = conn.prepareStatement("insert into tb_user (name,pwd) values(?,?)");
	  pStmt.setString(1,"dream");
	  pStmt.setString(2,"111");
	  int rtn= pStmt.executeUpdate();
	  out.println("成功执行记录数："+rtn);
      pStmt.close();
      conn.close();
      %>
      <br><br>
      <a href="<%=request.getContextPath() %>/plusEg4_03/index.jsp">返回</a>
</body>
  
</html>
