<%@ page contentType="text/html;charset=gb2312" %>
<jsp:useBean id="user" class="eg5_01.UserInfo">
	<jsp:setProperty name="user" property="*"/>
</jsp:useBean>
<center>
	<b>�û�����</b><jsp:getProperty name="user" property="userName"/>
	<b>���룺</b><jsp:getProperty name="user" property="userPass"/>	
</center>

<p>
<a href="index.jsp">��������</a>