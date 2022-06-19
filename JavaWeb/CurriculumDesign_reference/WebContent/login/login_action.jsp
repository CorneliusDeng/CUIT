<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="user.*,common.*" %>

<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../css/student.css">
<script type="text/javascript" src = "../js/datacheck.js"></script>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
<%
	String path = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
	
	// TODO 1 获取客户端请求中的用户名和密码
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	
	// TODO 2 使用UserDB对象的方法，获取制定用户名的用户对象
	UserInfo user = new UserInfo();
	UserInfo usersearch = new UserInfo();
	user.setUserName(username);
	user.setUserPwd(password);
	UserDB userDB = new UserDB();
	usersearch = userDB.GetUserbyName(username);
	
	// TODO 3 通过获取用户信息和客户端提交信息进行比较，设置flag的值
	int flag;
	if (usersearch == null) {
		flag = 1;
	} else if (usersearch.getUserPwd().equals(user.getUserPwd())){
		flag = 0;
	} else {
		flag = 2;
	}
	
	// 向客户端做出响应
	if (flag == 0) {
		if(username.equals("admin")) {
			response.sendRedirect("../home.jsp");
		}else{
			response.sendRedirect("../home1.jsp");
		}
	}else if (flag == 1){
		out.print("<script type='text/javascript'>alert('用户名不存在，请重新输入！');</script>");
		%><script>window.location= "../login/login.jsp ";</script><%
	}else {
		out.print("<script type='text/javascript'>alert('密码错误，请重新输入！');</script>");
		%><script>window.location= "../login/login.jsp ";</script><%
	}
%>
</body>
</html>