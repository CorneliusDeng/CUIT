<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
	session.removeAttribute("information");
	if (session.getAttribute("information") == null) {
		out.print("session����information�Ѿ���������");
	}else{
		out.print(session.getAttribute("information"));
	}
%>