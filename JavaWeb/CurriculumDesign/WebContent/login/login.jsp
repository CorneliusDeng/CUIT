<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import= "user.*, common.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>��¼ҳ��</title>
<link rel=stylesheet type="text/css" href="../css/student.css">
<script type="text/javascript" src="../js/datacheck.js"></script>
</head>

<script>
<%
	String testname = (String)session.getAttribute("username");
	String loginFlag = request.getParameter("loginflag");
	if (loginFlag == null)//�޵�½ʧ�ܱ�ʶ����������ҳ��
	{
		loginFlag = "";
	}
	if (loginFlag.equals("1"))
	{
		out.println("alert('�û���"+testname+"�������ڣ�')");	
	}
	else if (loginFlag.equals("2"))
	{
		out.println("alert('�������')");
	}
%>	
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
		<input type="submit" value="�ύ">
		<input type="reset" value="����">
		</td>
	</tr>

</table>
</form>
</div>

</body>
</html>