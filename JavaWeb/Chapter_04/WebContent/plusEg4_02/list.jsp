<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.util.*" %>
<HTML><BODY><br><br>
<table width="100%"  border="1">
<tr><td>ĞòºÅ</td><td>ÓÃ»§Ãû</td><td>ÃÜÂë</td></tr>
 <% 
 ArrayList userList=(ArrayList)session.getAttribute("USERLIST");
 session.removeAttribute("USERLIST");
 if(userList==null){
 	userList=new ArrayList();
 }
 for(int i=0;i<userList.size();i++){
 	Hashtable userInfo=(Hashtable)userList.get(i);
 	out.println("<tr>");
	out.println("<td>"+(i+1)+"</td>");
	out.println("<td>"+userInfo.get("name").toString()+"</td>");
 	out.println("<td>"+userInfo.get("pwd").toString()+"</td>"); 
 	out.println("</tr>"); 	
 } 
 %>
 </table>
</BODY></HTML>
