<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>第6章  Ajax应用</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
      教材范例 <br><br>
    <a href="eg01/index.jsp" target="right_workspace">【例9-1】应用Ajax检查注册用户名是否唯一</a> <br>
    <a href="eg02/index.jsp" target="right_workspace">【例9-2】应用jQuery弹出一个提示对话框</a><br>
    <a href="eg03/index.jsp" target="right_workspace">【例9-3】应用jQuery实现时间显示</a><br><br>
    <a href="eg04/index.jsp" target="right_workspace">【例9-4】应用jQuery实现检查注册用户名是否唯一</a><br><br>
    <a href="eg05/index.jsp" target="right_workspace">【例9-5】实现实时显示聊天内容，返回的聊天信息用字符串</a><br><br>
    <a href="eg06/index.jsp" target="right_workspace">【例9-6】实现实时显示聊天内容，返回的聊天信息用XML</a><br><br>
    <a href="eg07/index.jsp" target="right_workspace">【例9-7】实现实时显示聊天内容，返回的聊天信息用JSON</a><br><br>
        
  
  </body>
</html>
