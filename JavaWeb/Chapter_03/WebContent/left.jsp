<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��4�� ����</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
    �̲ķ��� <br>
    <a href="3_01/index.jsp" target="right_workspace">����3-1��errorPage��isErrorPage���Ե�ʹ��</a> <br>
    <a href="3_02/index.jsp" target="right_workspace">����3-2���򵥵���վ������</a><br>
    <a href="3_03/index.jsp" target="right_workspace">����3-3���ű������Ӧ��</a><br>
    <a href="3_04/index.jsp" target="right_workspace">����3-4��HTMLע�͵�ʹ��</a><br>
    <a href="3_05/index.jsp" target="right_workspace">����3-5������JSP���ʽ��ע��</a><br>
    <a href="3_06/index.jsp" target="right_workspace">����3-6������ע�͵�ʹ��</a><br>
    <a href="3_07/index.jsp" target="right_workspace">����3-7������ע��</a><br>
    <a href="3_08/index.jsp" target="right_workspace">����3-8������ע��</a><br>
    <a href="3_09/index.jsp" target="right_workspace">����3-9����ʾ�ĵ�ע��</a><br>
    <a href="3_10/index.jsp" target="right_workspace">����3-10��include����</a><br>
    <br>
    <a href="4_01/login.jsp" target="right_workspace">����4-1�������������ʾ��</a> <br>
    <a href="4_02/setAttribute.jsp" target="right_workspace">����4-2�����������й�������ʾ��</a><br>
    <a href="4_03/getCookie.jsp" target="right_workspace">����4-3����ȡCookieʾ��</a><br>
    <a href="4_04/getInfo.jsp" target="right_workspace">����4-4����ȡ�ͻ���Ϣʾ��</a><br>
    <a href="4_05/login.jsp" target="right_workspace">����4-5���ض�����ҳʾ��</a><br>
    <a href="4_06/saveAsWord.jsp" target="right_workspace">����4-6������HTTP��Ӧ��ͷʾ��</a><br>
    <a href="4_07/buffer.jsp" target="right_workspace">����4-7������������ʾ��</a><br>
    <a href="4_08/index.jsp" target="right_workspace">����4-8����������ȡ�ͻ��Ựʾ��</a><br>
    <a href="4_09/index.jsp" target="right_workspace">����4-9���ӻỰ���Ƴ�ָ������ʾ��</a><br>
    <a href="4_10/index.jsp" target="right_workspace">����4-10������Ӧ�ó����ʼ������ʾ��</a><br>
    <a href="4_11/counter.jsp" target="right_workspace">����4-11������Ӧ�ó��򻷾�����ʾ��</a><br>
    <a href="4_12/index.jsp" target="right_workspace">����4-12����ȡ�쳣��Ϣ��exception����ʾ��</a><br>
 	<br>
    ���䷶�� <br> 
	<a href="plusEg3_01/index.jsp" target="right_workspace">��plusEg3_1��includeָ���ʹ��</a><br>
	<a href="plusEg3_02/index.jsp" target="right_workspace">��plusEg3_2��taglibָ���ʹ��</a><br>
	<a href="plusEg3_03/index.jsp" target="right_workspace">��plusEg3_3��include������ʹ��</a><br>
	<br>
	<a href="plusEg3_04/index.jsp" target="right_workspace">��plusEg3_4��pageָ���ƶ��ͻ��˴򿪷�ʽ</a><br>
	<a href="plusEg3_05/index.jsp" target="right_workspace">��plusEg3_5��request����Ĵ�������</a><br>
	<a href="plusEg3_06/login.jsp" target="right_workspace">��plusEg3_6��ʹ��session����ʵ�ֹ������</a><br>
	<a href="plusEg3_07/showmessage.jsp" target="right_workspace">��plusEg3_7��application�������԰�</a><br>
	<a href="plusEg3_08/login.jsp" target="right_workspace"> ��plusEg3_8��Cookie�Զ���¼ʾ��</a><br>
  </body>
</html>
