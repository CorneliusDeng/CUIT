<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
//1����ȡ�ͻ��˵�¼��Ϣ
String user=request.getParameter("user");
String pwd=request.getParameter("pwd");
int saveDays=Integer.parseInt(request.getParameter("saveDays"));
//2���жϴ��û��Ƿ��¼�ɹ�
//�����û��������벻Ϊ�վ����¼�ɹ���
if(!user.equals("")&&!pwd.equals("")){
	out.println("Welcome user: "+user+"<br>");
	if(saveDays!=0){//ʹ��Cookie�����¼��Ϣ
	   Cookie c = new Cookie("USER", user);
	   c.setMaxAge(saveDays*24*60*60);
	   response.addCookie(c);
	}
}else{
	out.println("��¼ʧ�� ");	
}
out.println("<a href='login.jsp?type=re'>���µ�¼</a>");

%>
