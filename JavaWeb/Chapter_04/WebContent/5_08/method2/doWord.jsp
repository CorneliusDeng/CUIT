<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="eg5_02.MyTools" %>
<%
	String title=request.getParameter("title");					//��ȡ���Ա���
	String content=request.getParameter("content");				//��ȡ��������
	if(title==null)title="";
	if(content==null)content="";
	
	title=MyTools.change(title);		//����change()����ת�������еġ�<���͡�>���ַ�
	content=MyTools.change(content);	//����change()����ת�������еġ�<���͡�>���ַ�
%>
���⣺<%=title%>
<br>
���ݣ�<%=content%>

<p>
<a href="index.jsp">��������</a>

