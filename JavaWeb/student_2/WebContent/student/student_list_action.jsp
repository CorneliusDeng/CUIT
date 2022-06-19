<%@ page contentType="text/html;charset=GB2312" import="java.util.*" %>
<%
String path = request.getContextPath();
//1、获取客户端提交数据
String studentinfo=request.getParameter("code");
ArrayList<String> reclist=new ArrayList<String>();
reclist.add("00001;王亮;0;2015;1;");
reclist.add("00002;李树国;0;2015;1;");
reclist.add("00003;赵欣;1;2015;2;");
session.setAttribute("studentlist",reclist);
response.sendRedirect(request.getContextPath()+"/student/student_list.jsp");
%>
