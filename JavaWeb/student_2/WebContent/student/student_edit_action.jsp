<%@ page contentType="text/html;charset=GB18030" import="java.util.*" %>
<%
String path = request.getContextPath();
request.setCharacterEncoding("GB18030");
//1、获取客户端提交数据
int index=Integer.parseInt(request.getParameter("index"));
String studentinfo=request.getParameter("code");
studentinfo+=";"+request.getParameter("name");
studentinfo+=";"+request.getParameter("sex");
studentinfo+=";"+request.getParameter("grade");
studentinfo+=";"+request.getParameter("major");
studentinfo+=";"+request.getParameter("detail");
ArrayList<String> reclist=(ArrayList<String>)session.getAttribute("studentlist");
reclist.set(index,studentinfo);
session.setAttribute("studentlist",reclist);
response.sendRedirect(request.getContextPath()+"/student/student_list.jsp");
%>