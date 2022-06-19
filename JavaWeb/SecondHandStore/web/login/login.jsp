<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>管理平台登录</title>
	<meta charset="utf-8">
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>

<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-4 col-md-offset-4 card-body" id="login-form" align="center">
			<form class="form-signin" name="frm" action="login_action.jsp" method="post">
				<h2 class="text-gray-900">用户登录</h2>
				<table>
					<tr><td><input class="form-control" type="text" name="id" placeholder="用户ID" value = ""></td></tr>
					<tr><td><input class="form-control" type="password" name="password" placeholder="密码"></td></tr>


				</table>
				<!--  <a href="forgetPassword.html">忘记密码?</a><br> -->
				<button class="btn btn-warning" type="reset">重置</button>
				<button class="btn btn-info" type="submit" onclick="return check()">登录</button><br>
			</form>
		</div>
	</div>
</div>
</body>

<script>
	function check()
	{
		if(frm.id.value == ""){
			alert('用户id不能为空');
			frm.id.focus();
			return false;
		}
		if(frm.password.value == ""){
			alert("密码不能为空");
			frm.password.focus();
			return false;
		}
		return true;
	}

	<%
        String loginFlag = request.getParameter("loginflag");
        if (loginFlag == null)//无登陆失败标识，正常访问页面
        {
            loginFlag = "";
        }
        if (loginFlag.equals("1"))
        {
            out.println("alert('此账号不存在！请重新输入')");
        }
        else if (loginFlag.equals("2"))
        {
            out.println("alert('密码错误！')");
        }

        else if (loginFlag.equals("3"))
        {
            out.println("alert('非管理员登陆，登陆失败！')");
        }
    %>
</script>

<style>
	body{background-color:#4e73df;}
	#login-form{
		background-color:white;
		margin-top:100px; margin-top:100px;
		padding-bottom:50px; padding-top:20px; padding-left:50px; padding-right:50px;
		border-radius:30px 30px 30px 30px;
	}
	.form-control{margin-bottom:20px; }
</style>
</html>
