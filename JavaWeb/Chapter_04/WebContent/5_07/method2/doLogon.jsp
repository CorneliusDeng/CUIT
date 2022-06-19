<%@ page contentType="text/html;charset=gb2312" %>
<jsp:useBean id="user" class="eg5_01.UserInfo">
	<jsp:setProperty name="user" property="*"/>
</jsp:useBean>
<center>
	<b>用户名：</b><jsp:getProperty name="user" property="userName"/>
	<b>密码：</b><jsp:getProperty name="user" property="userPass"/>	
</center>

<p>
<a href="index.jsp">重新输入</a>