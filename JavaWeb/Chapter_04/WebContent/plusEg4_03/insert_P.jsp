<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>
    <title>Ӧ��PreparedStatement����ʵ��������Ӳ���</title>
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
	  out.println("�ɹ�ִ�м�¼����"+rtn);
      pStmt.close();
      conn.close();
      %>
      <br><br>
      <a href="<%=request.getContextPath() %>/plusEg4_03/index.jsp">����</a>
</body>
  
</html>
