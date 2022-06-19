<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../css/student.css">
<script type="text/javascript" src = "../js/datacheck.js"></script>
<head>
<meta charset="UTF-8">
<title>登录</title>
<style>
        span {
            color: #FF2B21;
        }
    </style>
</head>
<body>
	<form action="login_action.jsp" name="frm" method="get">
        <table border="1" align="center">
            <tr>
                <td colspan="2">用户登录信息录入，<span>*</span>为必填项</td>
            </tr>
            <tr>
                <td>用户名：</td>
                <td>
                    <input type="text" name="username">
                    <span>*</span>
                </td>
            </tr>
            <tr>
                <td style="word-spacing:9px">密 码：</td>
                <td>
                    <input type="password" name="password">
                    <span>*</span>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" onclick="return check();">
                    <input type="reset">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>

<script language="JavaScript">
function check(){
	if(frm.username.value==""){
		alert("请输入不为空的用户名!");
		frm.username.focus();
		return false;
	}
	if(frm.password.value==""){
		alert("请输入不为空的密码!");
		frm.password.focus();
		return false;
	}
	return true;
}
</script>