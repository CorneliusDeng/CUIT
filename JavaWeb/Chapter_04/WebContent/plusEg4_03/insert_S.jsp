<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>
    <title>Ӧ��Statement����ʵ���������</title>
  </head>
  
<body>
      <%
      String driverClass="com.mysql.jdbc.Driver";
      String url="jdbc:mysql://localhost:3306/db_database08";
      String username = "root";
      String password = "rootpassword";
      Class.forName(driverClass);
      Connection conn=DriverManager.getConnection(url, username, password);
      Statement stmt=conn.createStatement();
      int rtn= stmt.executeUpdate("insert into tb_user (name,pwd) values('hope','111')");
	  out.println("�ɹ�ִ�м�¼����"+rtn);
      stmt.close();
      conn.close();
      %>
      <br><br>
      <a href="<%=request.getContextPath() %>/plusEg4_03/index.jsp">����</a>
</body>
  
</html>
