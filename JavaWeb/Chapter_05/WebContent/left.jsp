<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>第5章  MVC模式应用</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
      教材范例 <br><br>
    <a href="<%=path%>/textServlet" target="right_workspace">【例6-1】简单的servlet应用</a> <br>
    <a href="6_02/index.jsp" target="right_workspace">【例6-2】使用servlet实现留言薄</a><br>
    <a href="6_03/index.jsp" target="right_workspace">【例6-3】使用servlet实现购物车</a><br><br>
        
  
  </body>
</html>
