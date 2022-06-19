<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>处理结果</title>
</head>

<body>
<%
request.setAttribute("error","很抱歉！您输入的用户名或密码不正确！");
%>
<jsp:forward page="error.jsp" />
</body>
</html>
