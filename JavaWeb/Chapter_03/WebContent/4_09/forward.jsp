<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
	session.removeAttribute("information");
	if (session.getAttribute("information") == null) {
		out.print("session对象information已经不存在了");
	}else{
		out.print(session.getAttribute("information"));
	}
%>