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
			DataSource ds = (DataSource) ctx.lookup("TestJNDI");	//��ȡ���ӳض���
			Connection conn=ds.getConnection();
			Statement stmt=conn.createStatement();
			String sql="SELECT * FROM tb_user";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				out.println("<br>�û�����"+rs.getString(2)+"	���룺"+rs.getString(3));
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
