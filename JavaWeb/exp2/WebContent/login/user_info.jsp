<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<link rel="stylesheet" href="../css/bootstrap.min.css">	
<title>�û���¼��Ϣ</title>
</head>
<body>
<div class="col-md-2 sidebar">

<%
	//��ȡ�û���������
	String username = (String)session.getAttribute("username");

	out.println("��ͨ�û�" + username + "��¼�ɹ�");
%>
</div>

<div class="col-md-6 col-md-offset-2">
	<div class="row">
		<h1>��������</h1>
		<div class="col-md-2" align="center">
			<img class="img-circle" src="../Sourse/user.jpg" alt="�û�ͷ��" width="100px" height="100px"><br>
		</div>
		<div class="col-md-10">
			<ul>
			<li>�û�ID: 2018081062</li>
			<li>��ɫ: ѧ��</li>
			<li>�û�����<%=username%></li>
			</ul>
		</div>
	</div>
	
	<div class="row">
		<table class="table table-striped table-hover">
		<tbody>
			<tr><td>����</td><td>����</td></tr>
			<tr><td>�Ա�</td><td>��</td></tr>
			<tr><td>����</td><td>��182��</td></tr>
			<tr><td>�绰</td><td>12345678	</td></tr>
			<tr><td>����</td><td>xxxxxx@demo.com</td></tr>
		</tbody>
		</table>
	</div>
</div>
</body>
</html>