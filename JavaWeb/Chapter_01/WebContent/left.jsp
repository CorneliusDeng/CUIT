<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>第1章 JSP概述</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
    教材范例 <br>
    <a href="1_01/index.jsp">【例1-1】测试示例1</a> <br>
    <a href="1_02/index.jsp">【例1-2】测试示例2</a><br>

 	<br>
    补充范例（九九乘法表） <br> 
	<a href="plusEg1_01/multi.htm">【 plusEg1_1 】九九乘法表-静态页面实现</a><br>
	<a href="plusEg1_01/multi1_1.jsp">【 plusEg1_1 】九九乘法表-全部是HTML的动态页面</a><br>
	<a href="plusEg1_01/multi1_2.jsp">【 plusEg1_1 】九九乘法表-输出全部HTML的动态页面</a><br>
	<a href="plusEg1_01/multi2_1.jsp">【 plusEg1_1 】九九乘法表-完整Java代码块</a><br>
	<a href="plusEg1_01/multi2_2.jsp">【 plusEg1_1 】九九乘法表-Java代码块和HTML混用</a><br>

  </body>
</html>
