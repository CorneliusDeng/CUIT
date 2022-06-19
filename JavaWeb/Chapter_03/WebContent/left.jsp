<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>第4章 范例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
    教材范例 <br>
    <a href="3_01/index.jsp" target="right_workspace">【例3-1】errorPage、isErrorPage属性的使用</a> <br>
    <a href="3_02/index.jsp" target="right_workspace">【例3-2】简单的网站计数器</a><br>
    <a href="3_03/index.jsp" target="right_workspace">【例3-3】脚本程序的应用</a><br>
    <a href="3_04/index.jsp" target="right_workspace">【例3-4】HTML注释的使用</a><br>
    <a href="3_05/index.jsp" target="right_workspace">【例3-5】带有JSP表达式的注释</a><br>
    <a href="3_06/index.jsp" target="right_workspace">【例3-6】隐藏注释的使用</a><br>
    <a href="3_07/index.jsp" target="right_workspace">【例3-7】单行注释</a><br>
    <a href="3_08/index.jsp" target="right_workspace">【例3-8】多行注释</a><br>
    <a href="3_09/index.jsp" target="right_workspace">【例3-9】提示文档注释</a><br>
    <a href="3_10/index.jsp" target="right_workspace">【例3-10】include动作</a><br>
    <br>
    <a href="4_01/login.jsp" target="right_workspace">【例4-1】访问请求参数示例</a> <br>
    <a href="4_02/setAttribute.jsp" target="right_workspace">【例4-2】在作用域中管理属性示例</a><br>
    <a href="4_03/getCookie.jsp" target="right_workspace">【例4-3】获取Cookie示例</a><br>
    <a href="4_04/getInfo.jsp" target="right_workspace">【例4-4】获取客户信息示例</a><br>
    <a href="4_05/login.jsp" target="right_workspace">【例4-5】重定向网页示例</a><br>
    <a href="4_06/saveAsWord.jsp" target="right_workspace">【例4-6】设置HTTP响应报头示例</a><br>
    <a href="4_07/buffer.jsp" target="right_workspace">【例4-7】缓冲区配置示例</a><br>
    <a href="4_08/index.jsp" target="right_workspace">【例4-8】创建及获取客户会话示例</a><br>
    <a href="4_09/index.jsp" target="right_workspace">【例4-9】从会话中移除指定对象示例</a><br>
    <a href="4_10/index.jsp" target="right_workspace">【例4-10】访问应用程序初始化参数示例</a><br>
    <a href="4_11/counter.jsp" target="right_workspace">【例4-11】管理应用程序环境属性示例</a><br>
    <a href="4_12/index.jsp" target="right_workspace">【例4-12】获取异常信息的exception对象示例</a><br>
 	<br>
    补充范例 <br> 
	<a href="plusEg3_01/index.jsp" target="right_workspace">【plusEg3_1】include指令的使用</a><br>
	<a href="plusEg3_02/index.jsp" target="right_workspace">【plusEg3_2】taglib指令的使用</a><br>
	<a href="plusEg3_03/index.jsp" target="right_workspace">【plusEg3_3】include动作的使用</a><br>
	<br>
	<a href="plusEg3_04/index.jsp" target="right_workspace">【plusEg3_4】page指令制定客户端打开方式</a><br>
	<a href="plusEg3_05/index.jsp" target="right_workspace">【plusEg3_5】request对象的处理数组</a><br>
	<a href="plusEg3_06/login.jsp" target="right_workspace">【plusEg3_6】使用session变量实现购物程序</a><br>
	<a href="plusEg3_07/showmessage.jsp" target="right_workspace">【plusEg3_7】application制作留言板</a><br>
	<a href="plusEg3_08/login.jsp" target="right_workspace"> 【plusEg3_8】Cookie自动登录示例</a><br>
  </body>
</html>
