<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
</head>

<body>
<%
//��request�л��Cookies��
Cookie[] cookies=request.getCookies();
//��ʼ��Cookie����Ϊ��
Cookie cookie_response=null;
if(cookies!=null){  
	  cookie_response=cookies[0];
	}
out.println("���η���ʱ�䣺"+new java.util.Date()+"<br>");

if(cookie_response!=null){
 //�����һ�η��ʵ�ʱ�䡣������cookie_response����Ϊ����ʱ�䡣
   out.println("��һ�η���ʱ�䣺"+cookie_response.getValue());
   cookie_response.setValue(new java.util.Date().toString());
 }
//���Cookies��Ϊ�գ�����cookie�������뵽response��
if(cookies==null){
   cookie_response=new Cookie("AccessTime","");
   cookie_response.setValue(new java.util.Date().toString());
   response.addCookie(cookie_response);
 }
%>
</body>
</html>
