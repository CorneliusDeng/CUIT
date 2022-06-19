<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ page import= "common.*, java.util.*, user.*" %>
<%
	String path = request.getContextPath();

	// 1、获取用户端请求中的用户名和密码
	String userid = request.getParameter("id");
	String userpwd = request.getParameter("password");
	int flag = 0;

	// 2、处理客户端提交的数据。使用SingleUserDB对象中的方法，获取指定用户的信息
	UserInfo user = new UserDB().GetUserbyId(userid);
	UserInfo usertest = new UserDB().GetUserbyId(userid);
	System.out.println("name:"+usertest.getUsername());

	//3、 通过获取用户信息和客户端提交信息进行比较，设置flag的值。向客户端做出响应
	//登陆成功0，用户不存在1，密码错误2,非管理员访问3
	if (user == null)
	{
		flag = 1;
	}
	else if (!user.getPassword().equals(userpwd))
	{
		flag = 2;
	}
	else if (user.getSort() != 1)
	{
		flag = 3;
	}

	if (flag == 0)
	{
		response.sendRedirect(path+"/admin.jsp");
	}
	else
	{
		response.sendRedirect(path+"/login/login.jsp?loginflag="+flag);
	}
%>
