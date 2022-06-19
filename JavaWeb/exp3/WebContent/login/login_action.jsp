<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import= "login.*, common.*, java.util.*" %>

<title>登录处理界面</title>
</head>

<body>
<%
	String path = request.getContextPath();
	
	// 1、获取用户端请求中的用户名和密码
	String username = request.getParameter("username");
	String pwd = request.getParameter("password");
	int flag = 0;
	
	// 2、处理客户端提交的数据。使用UserDB对象中的方法，获取指定用户名和密码
	UserInfo user = new UserDB().GetUserbyName(username);
	
	//3、 通过获取用户信息和客户端提交信息进行比较，设置flag的值。向客户端做出响应
	//登陆成功0，用户不存在1，密码错误2
	if (user == null)
	{
		flag = 1;
	}
	else if (!user.getUserPwd().equals(pwd))
	{
		flag = 2;
	}
	
	if (flag == 0)
	{
		// 登陆成功发送用户名信息并重定向到信息显示页面
		session.setAttribute("username", username);
		response.sendRedirect(path+"/login/user_info.jsp");
	}
	else
	{	// 登陆不成功发送用户名信息并重定向到登陆页面
		session.setAttribute("username", username);
		response.sendRedirect(path+"/login/login.jsp?loginflag="+flag);
	}
	
%>	
</body>
</html>