<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="teach.*,teacher.*,course.*,java.util.*"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" type="text/css" href="../css/student.css">
<script type="text/javascript" src = "../js/datacheck.js"></script>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加授课信息</title>
    <style>
        tr {
            height: 25px;
        }

        textarea {
            resize: none;
        }
    </style>
</head>
<body>
<%
	List<CourseInfo> courses = new  CourseDB().getAll();
	if (courses == null) {
		courses = new ArrayList<>();
	}
	List<TeacherInfo> teachers = new  TeacherDB().getAll();
	if (teachers == null) {
		teachers = new ArrayList<>();
	}
%>
	<form name="frm" method="post" action="<%=request.getContextPath()%>/TeachInsertAction">
	<table weight="100%" border=1 align="center">
	<tr>
		<td colspan="2">授课信息录入，<font color="FF2B21">*</font>为必填项</td>
	</tr>
	<tr>
		<td>教师</td>
		<td>
			<select name="teacherId">
			<%
				for (TeacherInfo teacher : teachers) {
					%>
            		<option value="<%=teacher.getTeacherID() %>"><%=teacher.getName() %></option>
            		<%
				}
            %>
            </select>
            <font color="FF2B21">*</font>
		</td>
		</tr>
		<tr>
            <td>课程</td>
            <td>
            	<select name="courseId">
            	<%
        		int flag1 = 1;
				for (CourseInfo course : courses) {
					%>
            		<option value="<%=course.getCourseID() %>"><%=course.getName() %></option>
            		<%
				}
            	%>
            	</select>
                <font color="FF2B21">*</font>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交" "></td>
        </tr>
	</table>
	</form>
</body>
</html>