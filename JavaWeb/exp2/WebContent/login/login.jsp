<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>��¼ҳ��</title>
<link rel=stylesheet type="text/css" href="../css/student.css">
<script type="text/javascript" src="../js/datacheck.js"></script>
</head>
<script language="JavaScript">
function check(){
	if (frm.username.value == "") {
		alert("�������û���");
		frm.username.focus();
		return false;
	}
	if (frm.password.value == "") {
		alert("����������");
		frm.password.focus();
		return false;
	}
	return true;
}
</script>

<body>

<div align="center">
��¼����

<form name="frm" action="login_action.jsp" method = "post">
<table border="1">
	<tr class="td_header"><td colspan="2"> �û���¼��Ϣ¼��,<span class="star">*</span>Ϊ������</td></tr>
	<tr ><td>�û���</td><td><input type="text" name="username" size="15" value=""><span class="star">*</span></td></tr>
	<tr><td>����</td><td><input type="password" name="password" size="15" value=""><span class="star">*</span></td></tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="�ύ" onclick="return check();">
		<input type="reset" value="����">
		</td>
	</tr>

</table>
</form>
</div>

</body>
</html>