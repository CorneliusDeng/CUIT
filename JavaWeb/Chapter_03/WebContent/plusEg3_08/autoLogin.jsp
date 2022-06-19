<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String user=request.getParameter("user");
out.println("Welcome user: "+user+"<br>");
out.println("<a href='login.jsp?type=re'>ÖØĞÂµÇÂ¼</a>");

%>
