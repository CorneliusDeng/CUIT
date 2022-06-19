<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import ="java.util.*" %>
<title>登录处理界面</title>
</head>

<body>
<%
	//request.setCharacterEncoding("gb2312");//post方法提交下设置编码格式
	String path = request.getContextPath();
	
	// 1、获取用户名和密码，并保存到变量
	String username = request.getParameter("username");
	String pwd = request.getParameter("password");
	
	// 2、如果输入指定账号和密码，显示管理员登录成功
	if(username.equals("admin") && pwd.equals("Abc123#")) 
	{
		out.println("管理员登录成功");
	}
	
	// 3、如果用户名和密码相同，在新的页面显示“普通用户XXX成功登录”(XXX使用用户名替代)
	else if (username.equals(pwd))
	{
		session.setAttribute("username", username);
		response.sendRedirect(path+"/login/user_info.jsp");
	
	}
	
	// 4、 登录不成功返回登录界面
	else 
	{
		response.sendRedirect(path+"/login/login.jsp");
	} 
%>
	



	
</body>
</html>