<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
//1、获取客户端登录信息
String user=request.getParameter("user");
String pwd=request.getParameter("pwd");
int saveDays=Integer.parseInt(request.getParameter("saveDays"));
//2、判断此用户是否登录成功
//假设用户名和密码不为空就算登录成功了
if(!user.equals("")&&!pwd.equals("")){
	out.println("Welcome user: "+user+"<br>");
	if(saveDays!=0){//使用Cookie保存登录信息
	   Cookie c = new Cookie("USER", user);
	   c.setMaxAge(saveDays*24*60*60);
	   response.addCookie(c);
	}
}else{
	out.println("登录失败 ");	
}
out.println("<a href='login.jsp?type=re'>重新登录</a>");

%>
