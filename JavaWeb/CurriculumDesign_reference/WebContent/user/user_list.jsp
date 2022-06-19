<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="user.*,student.*,java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>用户信息列表</title>
	<link rel="stylesheet" type="text/css" href="../css/student.css">
    <script type="text/javascript" src="../js/datacheck.js"></script>
<style>
	a {
		color: #703E3E;
        text-decoration: none;
        font-weight: bold;
        }
        </style>
</head>
<body>
<%
	String path = request.getContextPath();
	List<UserInfo> users = new  UserDB().getAll();
	if (users == null) {
		users = new ArrayList<>();
	}
%>
	<table width="100%" height="100" border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td bgcolor=“176C9B” height="25" colspan="4" align="center"><strong>用户信息列表</strong></td>
		</tr>
		<tr class="td_header">
			<td width="25%">ID</td>
			<td width="25%">姓名</td>
			<td width="25%">密码</td>
			<td width="25%"></td>
		</tr>
        <%
        int flag = 1;
		for (UserInfo user : users) {
			if (flag % 2 == 0){
		%>
		<tr bgcolor="DEECEC">
			<td><%=user.getUserID() %></td>
			<td><%=user.getUserName() %></td>
			<td><%=user.getUserPwd() %></td>
			<td>
				<a href="user_update.jsp?userId=<%=user.getUserID()%>">编辑</a>
				<a href="../UserDeleteAction?userId=<%=user.getUserID()%>">删除</a>
			</td>
		</tr>
		<%} else {%>
		<tr>
			<td><%=user.getUserID() %></td>
			<td><%=user.getUserName() %></td>
			<td><%=user.getUserPwd() %></td>
			<td>
				<a href="user_update.jsp?userId=<%=user.getUserID()%>">编辑</a>
				<a href="../UserDeleteAction?userId=<%=user.getUserID()%>">删除</a>
			</td>
		</tr>
		<%
			}
			flag++;
		}
		%>
		<tr>
			<td colspan="3"><a href="user_add.jsp">添加</a>
			<td><a href="<%=path %>/UserListAction">刷新数据列表</a>
		</tr>
	</table>
</body>
</html>