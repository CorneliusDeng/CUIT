<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��6��  AjaxӦ��</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
      �̲ķ��� <br><br>
    <a href="eg01/index.jsp" target="right_workspace">����9-1��Ӧ��Ajax���ע���û����Ƿ�Ψһ</a> <br>
    <a href="eg02/index.jsp" target="right_workspace">����9-2��Ӧ��jQuery����һ����ʾ�Ի���</a><br>
    <a href="eg03/index.jsp" target="right_workspace">����9-3��Ӧ��jQueryʵ��ʱ����ʾ</a><br><br>
    <a href="eg04/index.jsp" target="right_workspace">����9-4��Ӧ��jQueryʵ�ּ��ע���û����Ƿ�Ψһ</a><br><br>
    <a href="eg05/index.jsp" target="right_workspace">����9-5��ʵ��ʵʱ��ʾ�������ݣ����ص�������Ϣ���ַ���</a><br><br>
    <a href="eg06/index.jsp" target="right_workspace">����9-6��ʵ��ʵʱ��ʾ�������ݣ����ص�������Ϣ��XML</a><br><br>
    <a href="eg07/index.jsp" target="right_workspace">����9-7��ʵ��ʵʱ��ʾ�������ݣ����ص�������Ϣ��JSON</a><br><br>
        
  
  </body>
</html>
