<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>
    <title>Ӧ��PreparedStatement�����ѯ����</title>
  </head>
  
<body>
      <%
      String driverClass="com.mysql.jdbc.Driver";
      String url="jdbc:mysql://localhost:3306/db_database08";
      String username = "root";
      String password = "rootpassword";
      Class.forName(driverClass);
      Connection conn=DriverManager.getConnection(url, username, password);
      PreparedStatement pStmt = conn.prepareStatement("select * from tb_user where name like ?");
	  pStmt.setString(1,"%w%");
	  ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				out.println("�û�����"+rs.getString(2)+"	���룺"+rs.getString(3));
			}
      rs.close();
      pStmt.close();
      conn.close();
      %>
      <br> <br>
      <a href="<%=request.getContextPath() %>/plusEg4_03/index.jsp">����Ŀ¼</a>
      
</body>
  
</html>
