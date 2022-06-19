<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="teach.*,teacher.*,course.*,java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>授课信息列表</title>
	<link rel="stylesheet" type="text/css" href="../css/student.css">
    <script type="text/javascript" src="../js/datacheck.js"></script>
<style>
	a {
		color: #703E3E;
        text-decoration: none;
        font-weight: bold;
        }
        </style>
</head>
<body>
<%
	String path = request.getContextPath();
	List<TeachInfo> teachs = new  TeachDB().getAll();
	if (teachs == null) {
		teachs = new ArrayList<>();
	}
	List<CourseInfo> courses = new  CourseDB().getAll();
	if (courses == null) {
		courses = new ArrayList<>();
	}
	List<TeacherInfo> teachers = new  TeacherDB().getAll();
	if (teachers == null) {
		teachers = new ArrayList<>();
	}
%>
<table width="100%" cellspacing="0">
	<tr>
		<td bgcolor=“176C9B” height="25" colspan="6" align="center"><strong>授课信息列表</strong></td>
	</tr>
	<tr bgcolor="E6E6E6">
		<td width="25%">ID</td>
		<td width="25%">授课老师</td>
		<td width="25%">课程名称</td>
		<td width="25%"></td>
	</tr>
	<%
		int flag = 1;
		for (TeachInfo teach : teachs) {
			if (flag % 2 == 0){
	%>
	<tr bgcolor="DEECEC">
		<td><%=teach.getTeachId() %></td>
		<td>
			<%
			for (TeacherInfo teacher : teachers) {
				if(teach.getTeacherId() == teacher.getTeacherID()) {
					%><%=teacher.getName() %><%
				}
			}
			%>
		</td>
		<td>
			<%
			for (CourseInfo course : courses) {
				if(teach.getCourseId() == course.getCourseID()) {
					%><%=course.getName() %><%
				}
			}
			%>
		</td>
		<td>
			<a href="teach_modify.jsp?TeachId=<%=teach.getTeachId() %>">编辑</a>
			<a href="../TeachDeleteAction?TeachId=<%=teach.getTeachId() %>">删除</a>
		</td>
	</tr>
	<%} else {%>
	<tr>
		<td><%=teach.getTeachId() %></td>
		<td>
		<%
		for (TeacherInfo teacher : teachers) {
			if(teach.getTeacherId() == teacher.getTeacherID()) {
				%><%=teacher.getName() %><%
			}
		}
		%>
		</td>
		<td>
		<%
		for (CourseInfo course : courses) {
			if(teach.getCourseId() == course.getCourseID()) {
				%><%=course.getName() %><%
			}
		}
		%>
		</td>
		<td>
			<a href="teach_modify.jsp?TeachId=<%=teach.getTeachId() %>">编辑</a>
			<a href="../TeachDeleteAction?TeachId=<%=teach.getTeachId() %>">删除</a>
		</td>
	</tr>
	<%
		}
		flag++;
	}
	%>
	<tr>
		<td colspan="3"><a href="teach_add.jsp">添加</a>
		<td><a href="<%=path %>/TeachListAction">刷新数据列表</a>
	</tr>
</table>
</body>
</html>