<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="mark.*, java.util.*" %>
<%
	ArrayList<markInfo> marklist = (ArrayList<markInfo>)session.getAttribute("markList1");
%>

<%!
	String editid = "";
%>
<div class="col-md-10 col-md-offset-1">
	<div class="row">
		<h1>成绩查看</h1>
	</div>
	
	<div class="row">
		<table class="table table-striped table-hover">
		<thead>
			<tr><th>学号</th><th>分数</th></tr>
		</thead>
		<tbody>
		<%
			for (int i = 0; i < marklist.size(); i++)
			{
				markInfo testmark = marklist.get(i);
		%>
			<tr>
				<td><%=testmark.getStudent_id() %></td>
				<td><%=testmark.getScore() %></td>
				
			</tr>
		<%
			}
		%>
		</tbody>
		</table>
	</div>
</div>