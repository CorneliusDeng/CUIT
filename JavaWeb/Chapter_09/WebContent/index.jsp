<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>09 高级程序设计范例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
    教材范例 <br>
    Ajax技术 <br>
    <a href="bookEg/01/index.jsp">【例9-1】通过Ajax实现不刷新页面，从另一个页面请求信息</a> <br><br><br>

    补充范例 <br>
    Ajax技术 <br>
    <a href="plusEg/inputcheck.jsp">在数据输入时验证是否已经存在</a> <br><br>
    <a href="plusEg/ShowRetrieval.jsp">动态请求数据列表</a> <br><br>
    <a href="plusEg/dynamicselect.jsp">级联列表</a> <br>
 

  </body>
</html>
