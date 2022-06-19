<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>
    <title>查询数据</title>
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
      ResultSet rs = stmt.executeQuery("select * from tb_user ");
			while(rs.next()){
				out.println("<br>用户名："+rs.getString(2)+"	密码："+rs.getString(3));
			}
      rs.close();
      stmt.close();
      conn.close();
      %>
      <br> <br>
      <a href="<%=request.getContextPath() %>/index.jsp">返回目录</a>
    <br> <br>
     查询操作<br>
    <a href="<%=request.getContextPath() %>/8_04/index.jsp">【例8-4】Statement</a><br>
    <a href="<%=request.getContextPath() %>/8_05/index.jsp">【例8-5】PrepareStatement</a><br>
    添加操作<br>
    <a href="<%=request.getContextPath() %>/plusEg4_03/insert_S.jsp"> Statement </a><br>
    <a href="<%=request.getContextPath() %>/plusEg4_03/insert_P.jsp"> PrepareStatement </a><br>
    修改操作<br>
    <a href="<%=request.getContextPath() %>/plusEg4_03/update_S.jsp"> Statement </a><br>
    <a href="<%=request.getContextPath() %>/plusEg4_03/update_P.jsp"> PrepareStatement </a><br>
    删除操作<br>
    <a href="<%=request.getContextPath() %>/plusEg4_03/delete_S.jsp"> Statement </a><br>
    <a href="<%=request.getContextPath() %>/plusEg4_03/delete_P.jsp"> PrepareStatement </a><br><br>
      
</body>
  
</html>
