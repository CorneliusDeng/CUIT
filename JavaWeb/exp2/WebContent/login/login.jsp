<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>登录页面</title>
<link rel=stylesheet type="text/css" href="../css/student.css">
<script type="text/javascript" src="../js/datacheck.js"></script>
</head>
<script language="JavaScript">
function check(){
	if (frm.username.value == "") {
		alert("请输入用户名");
		frm.username.focus();
		return false;
	}
	if (frm.password.value == "") {
		alert("请输入密码");
		frm.password.focus();
		return false;
	}
	return true;
}
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
		<input type="submit" value="提交" onclick="return check();">
		<input type="reset" value="重置">
		</td>
	</tr>

</table>
</form>
</div>

</body>
</html>