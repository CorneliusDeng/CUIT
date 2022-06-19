<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ฬ๘ืชาณรๆ</title>
</head>
<body>
	<%
		String path = request.getContextPath();
		response.sendRedirect(path+"/login/login.jsp");
	%>
</body>
</html>