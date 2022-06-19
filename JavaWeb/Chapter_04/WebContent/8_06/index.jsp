<%@ page language="java" import="javax.naming.*" pageEncoding="GB2312"%>
<%@ page import="javax.sql.*" %>
<%@ page import="java.sql.*" %>
<html>
  <head>
    <title></title>
  </head>
  
<body>
<%
try {
			Context ctx = new InitialContext();
			ctx = (Context) ctx.lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("TestJNDI");	//获取连接池对象
			Connection conn=ds.getConnection();
			Statement stmt=conn.createStatement();
			String sql="SELECT * FROM tb_user";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				out.println("<br>用户名："+rs.getString(2)+"	密码："+rs.getString(3));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (NamingException e) {
			e.printStackTrace();
		}
%>
</body>
</html>
