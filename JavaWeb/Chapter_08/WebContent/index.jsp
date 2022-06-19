<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>08 适用组件范例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
    教材范例 <br><br>
    jspSmartUpload组件 <br>
    <a href="bookEg/01/index.jsp">【例7-1】文件的上传下载</a> <br><br>
    mail组件 <br>    
    <a href="bookEg/02/sendmail.jsp">【例7-2】发送Email</a><br><br>
    JFreeChart组件 <br>    
    <a href="bookEg/03/index.jsp">【例7-3】绘制柱形图</a><br>
    <a href="bookEg/04/index.jsp">【例7-4】绘制饼形图</a><br><br>
    iText组件 <br>    
    <a href="bookEg/05/index.jsp">【例7-5】书写器对象</a><br>
    <a href="bookEg/06/index.jsp">【例7-6】中文处理</a><br>
    <a href="bookEg/07/index.jsp">【例7-7】表格1</a><br>
    <a href="bookEg/08/index.jsp">【例7-8】表格2</a><br>
    <a href="bookEg/08/index.jsp">【例7-9】图像处理</a><br><br>
    
    

  </body>
</html>
