<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String type=request.getParameter("type");
if(type==null){//������¼����Ҫ�鿴cookie���Ƿ����гɹ���¼���û���
	//1����ȡcookie�д�ŵĳɹ���¼���û���
	String user="";
	Cookie cookies[] = request.getCookies();
	for(int i=0; i<cookies.length; i++) {
		if(cookies[i].getName().equals("USER")){
			user=cookies[i].getValue();
		}
	}
	//2���гɹ���¼���û���
	if(!user.equals("")){
		response.sendRedirect("autoLogin.jsp?user="+user);
	}
}
//ǿ�������µ�¼��������cookie���Ƿ����гɹ���¼���û���

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>��¼ҳ��</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
    <form action="loginAction.jsp">
    user:<input type="text" name="user" value=""><br>
    password:<input type="password" name="pwd" value=""><br>
    auotlogin:
    <select name="saveDays">
    	<option value="350">one year</option>
    	<option value="30">one month</option>
    	<option value="7">one week</option>
   		<option value="0">none</option>
    </select>
    <br>
    <input type="submit"><br>
    
    </form> <br>
  </body>
</html>
