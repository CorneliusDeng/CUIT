<%@ page language="java" import="java.sql.*" pageEncoding="GB2312"%>
<html>
  <head>
    <title>��ѯ����</title>
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
				out.println("<br>�û�����"+rs.getString(2)+"	���룺"+rs.getString(3));
			}
      rs.close();
      stmt.close();
      conn.close();
      %>
      <br> <br>
      <a href="<%=request.getContextPath() %>/index.jsp">����Ŀ¼</a>
    <br> <br>
     ��ѯ����<br>
    <a href="<%=request.getContextPath() %>/8_04/index.jsp">����8-4��Statement</a><br>
    <a href="<%=request.getContextPath() %>/8_05/index.jsp">����8-5��PrepareStatement</a><br>
    ��Ӳ���<br>
    <a href="<%=request.getContextPath() %>/plusEg4_03/insert_S.jsp"> Statement </a><br>
    <a href="<%=request.getContextPath() %>/plusEg4_03/insert_P.jsp"> PrepareStatement </a><br>
    �޸Ĳ���<br>
    <a href="<%=request.getContextPath() %>/plusEg4_03/update_S.jsp"> Statement </a><br>
    <a href="<%=request.getContextPath() %>/plusEg4_03/update_P.jsp"> PrepareStatement </a><br>
    ɾ������<br>
    <a href="<%=request.getContextPath() %>/plusEg4_03/delete_S.jsp"> Statement </a><br>
    <a href="<%=request.getContextPath() %>/plusEg4_03/delete_P.jsp"> PrepareStatement </a><br><br>
      
</body>
  
</html>
