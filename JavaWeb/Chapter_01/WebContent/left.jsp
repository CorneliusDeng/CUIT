<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��1�� JSP����</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
    �̲ķ��� <br>
    <a href="1_01/index.jsp">����1-1������ʾ��1</a> <br>
    <a href="1_02/index.jsp">����1-2������ʾ��2</a><br>

 	<br>
    ���䷶�����žų˷��� <br> 
	<a href="plusEg1_01/multi.htm">�� plusEg1_1 ���žų˷���-��̬ҳ��ʵ��</a><br>
	<a href="plusEg1_01/multi1_1.jsp">�� plusEg1_1 ���žų˷���-ȫ����HTML�Ķ�̬ҳ��</a><br>
	<a href="plusEg1_01/multi1_2.jsp">�� plusEg1_1 ���žų˷���-���ȫ��HTML�Ķ�̬ҳ��</a><br>
	<a href="plusEg1_01/multi2_1.jsp">�� plusEg1_1 ���žų˷���-����Java�����</a><br>
	<a href="plusEg1_01/multi2_2.jsp">�� plusEg1_1 ���žų˷���-Java������HTML����</a><br>

  </body>
</html>
