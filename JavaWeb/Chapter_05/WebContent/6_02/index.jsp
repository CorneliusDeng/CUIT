<%@ page contentType="text/html;charset=gb2312" %>
<%
String path = request.getContextPath();
%>
<form action="<%=path %>/addWord" method="post">
	�� �� �ߣ�<input type="text" name="author" size="25">
	<br>
	���Ա��⣺<input type="text" name="title" size="31">
	<br>
	�������ݣ�<textarea name="content" rows="7"  cols="30"></textarea>
	<p>
	<input type="submit" value="�ύ">
	<input type="reset" value="����">
	<a href="<%=path %>/6_02/show.jsp">�鿴����</a>		
</form>
