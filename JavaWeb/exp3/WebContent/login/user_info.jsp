<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@page import="java.util.*, login.*, common.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<link rel="stylesheet" href="../css/bootstrap.min.css">	
<title>用户登录信息</title>
</head>
<body>
<div class="col-md-2 sidebar">
<%
	//获取用户名和密码
	String testname = (String)session.getAttribute("username");
	
	//调用UserDB类的方法将非admin用户的信息存储在一个list中
	UserDB testdb = new UserDB();
	ArrayList<UserInfo> testlist = testdb.GetOtherUsers(); 
	
	//admin用户登录flag为1，非管理员登陆flag为0
	int flag = 1;
	if (testname.equals("admin"))
	{
		out.println("管理员"+testname+"成功登陆!");
	}
	
	else
	{
		out.println("普通用户"+testname+"成功登陆!");
		flag = 0;
	}
%>	
</div>
<%
	//管理员登陆，展示所有非管理员用户信息
	if (flag == 1)
	{
		for (int i = 0; i < testlist.size(); i++)
		{
			UserInfo testuser1 = testlist.get(i);
%>	
			<div class="col-md-8 col-md-offset-4">
				<div class="row">
					<h4>其他用户信息：<%=i+1 %></h4>
					<div class="col-md-2" align="center">
						<img class="img-circle" src="../Sourse/user.jpg" alt="用户头像" width="100px" height="100px"><br>
					</div>
					<div class="col-md-10">
						<ul>
						<li>用户名：<%=testuser1.getUserName() %></li>
						<li>密码：<%=testuser1.getUserPwd() %></li>
						</ul>
					</div>
				</div>
				
				<div class="row">
					<table class="table table-striped table-hover">
					<tbody>
						<tr><td>姓名</td><td>demo<%=i+1 %></td></tr>
						<tr><td>性别</td><td>男</td></tr>
						<tr><td>部门</td><td>软工182班</td></tr>
						<tr><td>电话</td><td>12345678	</td></tr>
						<tr><td>邮箱</td><td>xxxxxx@demo<%=i+1 %>.com</td></tr>
					</tbody>
					</table>
				</div>
			</div>
<%
		}
	} 
	
	//普通用户登陆，直接展示当前用户信息
	else
	{
		int k = -1;
		if (testname.equals("user1"))
		{
			k = 0;
		}
		else if (testname.equals("user2"))
		{
			k = 1;
		}
		else
		{
			k = 2; 
		}
		
		UserInfo testuser2 = testlist.get(k); 
%>
		<div class="col-md-8 col-md-offset-4">
			<div class="row">
				<h4>当前用户信息：</h4>
				<div class="col-md-2" align="center">
					<img class="img-circle" src="../Sourse/user.jpg" alt="用户头像" width="100px" height="100px"><br>
				</div>
				<div class="col-md-10">
					<ul>
						<li>用户名：<%=testuser2.getUserName() %></li>
						<li>密码：<%=testuser2.getUserPwd() %></li>
					</ul>
				</div>
			</div>
					
			<div class="row">
				<table class="table table-striped table-hover">
					<tbody>
						<tr><td>姓名</td><td>demo</td></tr>
						<tr><td>性别</td><td>男</td></tr>
						<tr><td>部门</td><td>软工182班</td></tr>
						<tr><td>电话</td><td>12345678	</td></tr>
						<tr><td>邮箱</td><td>xxxxxx@demo.com</td></tr>
					</tbody>
				</table>
			</div>
		</div>
<% 
	}
%>	
</body>
</html>