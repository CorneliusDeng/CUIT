<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>05 JDBC范例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
          教材范例 <br><br>
    <a href="5_07/index.jsp" target="right_workspace">【例5-7】在JSP页面中应用值JavaBean</a> <br>
    <a href="5_08/index.jsp" target="right_workspace">【例5-8】在JSP页面中应用工具JavaBean</a><br>
    <a href="5_09/index.jsp" target="right_workspace">【例5-9】应用JavaBean解决中文乱码</a><br><br>
    <a href="5_10/index.jsp" target="right_workspace">【例5-10】应用JavaBean实现购物车</a><br><br>
    
    链接指定数据库<br>
    <a href="8_01/index.jsp" target="right_workspace">【例8-1】SQLServer</a> <br>
    <a href="8_02/index.jsp" target="right_workspace">【例8-2】Access</a><br>
    <a href="8_03/index.jsp" target="right_workspace">【例8-3】MySQL</a><br><br>
    数据库操作<br>
    <a href="8_04/index.jsp" target="right_workspace">【例8-4】Statement查询</a><br><br>
   	<a href="8_05/index.jsp" target="right_workspace">【例8-5】PrepareStatement查询</a><br><br>
    数据库连接池技术<br>
    <a href="8_07/index.jsp" target="right_workspace">【例8-6】数据库连接池技术</a><br><br>
    补充范例 <br> 
	<a href="plusEg4_01/querylist.jsp" target="right_workspace">【plusEg4_1】使用表格显示查询结果</a><br>
	<a href="plusEg4_02/query.jsp" target="right_workspace">【plusEg4_2】规范的查询操作代码 (针对【例8-3】)</a><br>
 	<a href="plusEg4_03/index.jsp" target="right_workspace">【plusEg4_3】数据库操作</a><br>
 

  </body>
</html>
