<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>09 �߼�������Ʒ���</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
    �̲ķ��� <br>
    Ajax���� <br>
    <a href="bookEg/01/index.jsp">����9-1��ͨ��Ajaxʵ�ֲ�ˢ��ҳ�棬����һ��ҳ��������Ϣ</a> <br><br><br>

    ���䷶�� <br>
    Ajax���� <br>
    <a href="plusEg/inputcheck.jsp">����������ʱ��֤�Ƿ��Ѿ�����</a> <br><br>
    <a href="plusEg/ShowRetrieval.jsp">��̬���������б�</a> <br><br>
    <a href="plusEg/dynamicselect.jsp">�����б�</a> <br>
 

  </body>
</html>
