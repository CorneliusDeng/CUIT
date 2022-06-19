<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
session.setAttribute("information","向session中保存数据");
response.sendRedirect("forward.jsp");
%>
