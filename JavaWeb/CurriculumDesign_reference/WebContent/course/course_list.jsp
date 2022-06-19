<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="course.*,common.*,java.util.*" %>
<%
	String path = request.getContextPath();
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
<title>课程信息列表</title>
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
            <td bgcolor=“176C9B” height="25" colspan="6" align="center"><strong>课程信息列表</strong></td>
        </tr>
        <tr bgcolor="E6E6E6">
            <td>名称</td>
            <td>性质</td>
            <td>学分</td>
            <td>开设年级</td>
            <td>开设专业</td>
            <td></td>
        </tr>
        
        <%
        int flag = 1;
		for (CourseInfo course : courses) {
			if (flag % 2 == 0){
		%>
		
		<tr bgcolor="DEECEC">
			<td><%=course.getName() %></td>
			<td>
			<% 
			switch(course.getType()){
				case 1:%>公共必修课<%break;
				case 2:%>公共选修课<%break;
				case 3:%>专业基础课<%break;
				case 4:%>专业必修课<%break;
				case 5:%>专业选修课<%break;
			}
			%>
			</td>
			<td><%=course.getCredit() %></td>
			<td><%=course.getGrade() %></td>
			<td>
			<% 
			switch(course.getMajor()){
				case 1:%>软件工程<%break;
				case 2:%>空间信息<%break;
			}
			%>
			</td>
			<td><a href="course_modify.jsp?CourseId=<%=course.getCourseID() %>">编辑</a> <a href="../CourseDeleteAction?CourseId=<%=course.getCourseID() %>">删除</a></td>
		</tr>
		<%} else {%>
		<tr>
			<td><%=course.getName() %></td>
			<td>
			<% 
			switch(course.getType()){
				case 1:%>公共必修课<%break;
				case 2:%>公共选修课<%break;
				case 3:%>专业基础课<%break;
				case 4:%>专业必修课<%break;
				case 5:%>专业选修课<%break;
			}
			%>
			</td>
			<td><%=course.getCredit() %></td>
			<td><%=course.getGrade() %></td>
			<td>
			<% 
			switch(course.getMajor()){
				case 1:%>软件工程<%break;
				case 2:%>空间信息<%break;
			}
			%>
			</td>
			<td><a href="course_modify.jsp?CourseId=<%=course.getCourseID() %>">编辑</a> <a href="../CourseDeleteAction?CourseId=<%=course.getCourseID() %>">删除</a></td>
		</tr>
		<%
			}
			flag++;
		}
		%>
        
        <tr>
            <td><a href="course_add.jsp">添加</a></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="course_list.jsp">刷新数据列表</a></td>
            <td></td>
        </tr>
    </table>
</body>
</html>