<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@page import="java.util.*, login.*, common.*"%>
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
	String testname = (String)session.getAttribute("username");
	
	//����UserDB��ķ�������admin�û�����Ϣ�洢��һ��list��
	UserDB testdb = new UserDB();
	ArrayList<UserInfo> testlist = testdb.GetOtherUsers(); 
	
	//admin�û���¼flagΪ1���ǹ���Ա��½flagΪ0
	int flag = 1;
	if (testname.equals("admin"))
	{
		out.println("����Ա"+testname+"�ɹ���½!");
	}
	
	else
	{
		out.println("��ͨ�û�"+testname+"�ɹ���½!");
		flag = 0;
	}
%>	
</div>
<%
	//����Ա��½��չʾ���зǹ���Ա�û���Ϣ
	if (flag == 1)
	{
		for (int i = 0; i < testlist.size(); i++)
		{
			UserInfo testuser1 = testlist.get(i);
%>	
			<div class="col-md-8 col-md-offset-4">
				<div class="row">
					<h4>�����û���Ϣ��<%=i+1 %></h4>
					<div class="col-md-2" align="center">
						<img class="img-circle" src="../Sourse/user.jpg" alt="�û�ͷ��" width="100px" height="100px"><br>
					</div>
					<div class="col-md-10">
						<ul>
						<li>�û�����<%=testuser1.getUserName() %></li>
						<li>���룺<%=testuser1.getUserPwd() %></li>
						</ul>
					</div>
				</div>
				
				<div class="row">
					<table class="table table-striped table-hover">
					<tbody>
						<tr><td>����</td><td>demo<%=i+1 %></td></tr>
						<tr><td>�Ա�</td><td>��</td></tr>
						<tr><td>����</td><td>��182��</td></tr>
						<tr><td>�绰</td><td>12345678	</td></tr>
						<tr><td>����</td><td>xxxxxx@demo<%=i+1 %>.com</td></tr>
					</tbody>
					</table>
				</div>
			</div>
<%
		}
	} 
	
	//��ͨ�û���½��ֱ��չʾ��ǰ�û���Ϣ
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
				<h4>��ǰ�û���Ϣ��</h4>
				<div class="col-md-2" align="center">
					<img class="img-circle" src="../Sourse/user.jpg" alt="�û�ͷ��" width="100px" height="100px"><br>
				</div>
				<div class="col-md-10">
					<ul>
						<li>�û�����<%=testuser2.getUserName() %></li>
						<li>���룺<%=testuser2.getUserPwd() %></li>
					</ul>
				</div>
			</div>
					
			<div class="row">
				<table class="table table-striped table-hover">
					<tbody>
						<tr><td>����</td><td>demo</td></tr>
						<tr><td>�Ա�</td><td>��</td></tr>
						<tr><td>����</td><td>��182��</td></tr>
						<tr><td>�绰</td><td>12345678	</td></tr>
						<tr><td>����</td><td>xxxxxx@demo.com</td></tr>
					</tbody>
				</table>
			</div>
		</div>
<% 
	}
%>	
</body>
</html>