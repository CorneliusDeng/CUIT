<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import= "user.*, common.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>登录页面</title>
<link rel=stylesheet type="text/css" href="../css/student.css">
<script type="text/javascript" src="../js/datacheck.js"></script>
</head>

<script>
<%
	String testname = (String)session.getAttribute("username");
	String loginFlag = request.getParameter("loginflag");
	if (loginFlag == null)//无登陆失败标识，正常访问页面
	{
		loginFlag = "";
	}
	if (loginFlag.equals("1"))
	{
		out.println("alert('用户【"+testname+"】不存在！')");	
	}
	else if (loginFlag.equals("2"))
	{
		out.println("alert('密码错误！')");
	}
%>	
</script>

<body>

<div align="center">
登录界面

<form name="frm" action="login_action.jsp" method = "post">
<table border="1">
	<tr class="td_header"><td colspan="2"> 用户登录信息录入,<span class="star">*</span>为必填项</td></tr>
	<tr ><td>用户名</td><td><input type="text" name="username" size="15" value=""><span class="star">*</span></td></tr>
	<tr><td>密码</td><td><input type="password" name="password" size="15" value=""><span class="star">*</span></td></tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="提交">
		<input type="reset" value="重置">
		</td>
	</tr>

</table>
</form>
</div>

</body>
</html>