<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*,java.util.*" %>
<HTML><BODY><br><br>
 <% 
    Statement sql; 
    ResultSet rs;
    Connection conn=null;
    try { 
        String driverClass="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/db_database08";
        String username = "root";
        String password = "rootpassword";
        Class.forName(driverClass);
        conn=DriverManager.getConnection(url, username, password);
		sql=conn.createStatement();
		rs=sql.executeQuery("select * from tb_user");
        ArrayList userList=new ArrayList();
        Hashtable userInfo=null;
		while(rs.next()){
			userInfo=new Hashtable();
			userInfo.put("name",rs.getString("name"));
			userInfo.put("pwd",rs.getString("pwd"));
			userList.add(userInfo);
        }
        session.setAttribute("USERLIST",userList);
        rs.close();
        sql.close();        
     }
   catch(SQLException e1) 
     {  out.print(e1);
     }
   finally{
        if(conn!=null){        
        	conn.close();
        	conn=null;
        }

   }
   response.sendRedirect("list.jsp");
 %>
</BODY></HTML>
