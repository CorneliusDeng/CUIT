<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="course.*,teacher.*,common.*,java.util.*" %>
<%
	String path = request.getContextPath();
	List<TeacherInfo> teachers = new  TeacherDB().getAll();
	if (teachers == null) {
		teachers = new ArrayList<>();
	}
	List<CourseInfo> courses = new  CourseDB().getAll();
	if (courses == null) {
		courses = new ArrayList<>();
	}
%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/student.css">
<head>
<meta charset="UTF-8">
<title>教师信息列表</title>
<style>
	a {
		color: #703E3E;
        text-decoration: none;
        font-weight: bold;
        }
        </style>
</head>
<body>
	<table width="100%" cellspacing="0">
    	<tr>
            <td bgcolor=“176C9B” height="25" colspan="7" align="center"><strong>教师信息列表</strong></td>
        </tr>
        <tr bgcolor="E6E6E6">
            <td width="15%">名称</td>
            <td width="13%">性别</td>
            <td width="15%">生日</td>
            <td width="14%">文凭</td>
            <td width="14%">职能</td>
            <td width="14%">部门</td>
            <td width="15%"></td>
        </tr>
        <%
        int flag = 1;
		for (TeacherInfo teacher : teachers) {
			if (flag % 2 == 0){
		%>
		<tr bgcolor="DEECEC">
			<td><%=teacher.getName() %></td>
			<td>
			<% 
			switch(teacher.getSex()){
				case 1:%>男<%break;
				case 2:%>女<%break;
			}
			%>
			</td>
			<td><%=teacher.getBirthday() %></td>
			<td><%=teacher.getEducation() %></td>
			<td><%=teacher.getTitle() %></td>
			<td><%=teacher.getDepartment() %></td>
			<td><a href="teacher_modify.jsp?TeacherId=<%=teacher.getTeacherID() %>">编辑</a> <a href="../TeacherDeleteAction?TeachereId=<%=teacher.getTeacherID() %>">删除</a></td>
		</tr>
		<%} else {%>
		<tr>
			<td><%=teacher.getName() %></td>
			<td>
			<% 
			switch(teacher.getSex()){
				case 1:%>男<%break;
				case 2:%>女<%break;
			}
			%>
			</td>
			<td><%=teacher.getBirthday() %></td>
			<td><%=teacher.getEducation() %></td>
			<td><%=teacher.getTitle() %></td>
			<td><%=teacher.getDepartment() %></td>
			<td><a href="teacher_modify.jsp?TeacherId=<%=teacher.getTeacherID() %>">编辑</a> <a href="../TeacherDeleteAction?TeacherId=<%=teacher.getTeacherID() %>">删除</a></td>
		</tr>
		<%
			}
			flag++;
		}
		%>
        <tr>
            <td><a href="teacher_add.jsp">添加</a></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="teacher_list.jsp">刷新数据列表</a></td>
            <td></td>
        </tr>
    </table>
</body>
</html>