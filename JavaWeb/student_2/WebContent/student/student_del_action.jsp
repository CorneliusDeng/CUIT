<%@ page contentType="text/html;charset=GB2312" import="java.util.*" %>
<%
String path = request.getContextPath();
//1����ȡ�ͻ����ύ����
int index=Integer.parseInt(request.getParameter("index"));
ArrayList<String> reclist=(ArrayList<String>)session.getAttribute("studentlist");
reclist.remove(index);
session.setAttribute("studentlist",reclist);
response.sendRedirect(request.getContextPath()+"/student/student_list.jsp");
%>

