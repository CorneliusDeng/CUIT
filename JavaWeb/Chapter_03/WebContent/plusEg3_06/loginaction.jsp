 <%@ page contentType="text/html;charset=GB2312" %>
<%
request.setCharacterEncoding("GB2312");
String name=request.getParameter("name");
if(name==null||name.equals("")){  
	response.sendRedirect("login.jsp");
}else{
	session.setAttribute("name",name);
	response.sendRedirect("goodslist.jsp");
}
%> 
 

