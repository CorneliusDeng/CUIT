<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>08 �����������</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
    �̲ķ��� <br><br>
    jspSmartUpload��� <br>
    <a href="bookEg/01/index.jsp">����7-1���ļ����ϴ�����</a> <br><br>
    mail��� <br>    
    <a href="bookEg/02/sendmail.jsp">����7-2������Email</a><br><br>
    JFreeChart��� <br>    
    <a href="bookEg/03/index.jsp">����7-3����������ͼ</a><br>
    <a href="bookEg/04/index.jsp">����7-4�����Ʊ���ͼ</a><br><br>
    iText��� <br>    
    <a href="bookEg/05/index.jsp">����7-5����д������</a><br>
    <a href="bookEg/06/index.jsp">����7-6�����Ĵ���</a><br>
    <a href="bookEg/07/index.jsp">����7-7�����1</a><br>
    <a href="bookEg/08/index.jsp">����7-8�����2</a><br>
    <a href="bookEg/08/index.jsp">����7-9��ͼ����</a><br><br>
    
    

  </body>
</html>
