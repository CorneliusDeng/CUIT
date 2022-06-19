<%@ page language="java" import="java.sql.*" pageEncoding="GBK"%>
<html>
  <head>
    <title>Access</title>
  </head>
  
<body>
连接Access数据库<br>
    <%
    String driverClass="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/db_database08";
    String username = "root";
    String password = "rootpassword";
    Class.forName(driverClass);
    Connection conn=DriverManager.getConnection(url, username, password);
    Statement stmt=conn.createStatement();
    ResultSet rs = stmt.executeQuery("select * from tb_user");
    %> <table width="100%"  border="1" >
    <tr><td>序号</td><td>用户名</td><td>密码</td></tr>
    <%int i=0;
    while(rs.next()){    
    %>
    	<tr><td> <%=i ++%> </td>
                 <td> <%= rs.getString("name") %> </td>
                <td> <%= rs.getString("pwd") %> </td>
         </tr>
    <%}
    rs.close();stmt.close();conn.close();
     %> </table>


</body>
  
</html>
