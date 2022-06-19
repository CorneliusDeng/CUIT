<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "common.*, java.util.*,SingleUser.*, User.*" %>
<%
	String path = request.getContextPath();
	
	// 1、获取用户端请求中的用户名和密码
	String userid = request.getParameter("id");
	String userpwd = request.getParameter("password");
	int flag = 0;
	
	// 2、处理客户端提交的数据。使用SingleUserDB对象中的方法，获取指定用户的信息
	SingleUserInfo user = new SingleUserDB().GetUserbyId(userid);
	UserInfo usertest = new UserDB().GetUserbyId(userid);
	
	//3、 通过获取用户信息和客户端提交信息进行比较，设置flag的值。向客户端做出响应
	//登陆成功0，用户不存在1，密码错误2
	if (user == null)
	{
		flag = 1;
	}
	else if (!user.getPassword().equals(userpwd))
	{
		flag = 2;
	}
	
	if (flag == 0)
	{
		// 登陆成功发送用户名信息并重定向到信息显示页面
		
		
		//如果是管理员登陆，则去到管理员界面
		if (user.getPost_id() == 1)
		{
			session.setAttribute("SingleUserInfoId", userid);
			session.setAttribute("user", usertest);
			response.sendRedirect(path+"/admin.jsp");
		}
		
		//如果是管理员登陆，则去到管理员界面
		if (user.getPost_id() == 2)
		{
			session.setAttribute("SingleUserInfoId", userid);
			response.sendRedirect(path+"/teacher.jsp");
		}
		
	}
	else
	{	// 登陆不成功发送用户名信息并重定向到登陆页面
		session.setAttribute("SingleUserInfoId", userid);
		response.sendRedirect(path+"/login.jsp?loginflag="+flag);
	}
%>	
