<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>������</title>
</head>

<body>
<%
request.setAttribute("error","�ܱ�Ǹ����������û��������벻��ȷ��");
%>
<jsp:forward page="error.jsp" />
</body>
</html>
