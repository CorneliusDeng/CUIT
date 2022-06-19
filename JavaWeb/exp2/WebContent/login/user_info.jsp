<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
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
	String username = (String)session.getAttribute("username");

	out.println("普通用户" + username + "登录成功");
%>
</div>

<div class="col-md-6 col-md-offset-2">
	<div class="row">
		<h1>个人中心</h1>
		<div class="col-md-2" align="center">
			<img class="img-circle" src="../Sourse/user.jpg" alt="用户头像" width="100px" height="100px"><br>
		</div>
		<div class="col-md-10">
			<ul>
			<li>用户ID: 2018081062</li>
			<li>角色: 学生</li>
			<li>用户名：<%=username%></li>
			</ul>
		</div>
	</div>
	
	<div class="row">
		<table class="table table-striped table-hover">
		<tbody>
			<tr><td>姓名</td><td>邓棋</td></tr>
			<tr><td>性别</td><td>男</td></tr>
			<tr><td>部门</td><td>软工182班</td></tr>
			<tr><td>电话</td><td>12345678	</td></tr>
			<tr><td>邮箱</td><td>xxxxxx@demo.com</td></tr>
		</tbody>
		</table>
	</div>
</div>
</body>
</html>