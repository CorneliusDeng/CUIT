<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��5��  MVCģʽӦ��</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
      �̲ķ��� <br><br>
    <a href="<%=path%>/textServlet" target="right_workspace">����6-1���򵥵�servletӦ��</a> <br>
    <a href="6_02/index.jsp" target="right_workspace">����6-2��ʹ��servletʵ�����Ա�</a><br>
    <a href="6_03/index.jsp" target="right_workspace">����6-3��ʹ��servletʵ�ֹ��ﳵ</a><br><br>
        
  
  </body>
</html>
