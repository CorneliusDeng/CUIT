<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import ="course.*, java.util.*"%>

<%
	//接收从C层发送的课程信息集合数组
	String path = request.getContextPath();
	ArrayList<CourseInfo> testlist=(ArrayList<CourseInfo>)session.getAttribute("courseList");
%>
<!DOCTYPE html>
<html>
 
<head>
<title>课程信息列表</title>
<link rel=stylesheet type="text/css" href="../css/student.css">
<script type="text/javascript" src="../js/datacheck.js"></script>
</head>

<body>
<!-- 课程信息查询显示功能V层 -->
<div align="center">
	<table border="0" width="80%" cellpadding="0" cellspacing="0" >
		<tr>
			<td height="25" colspan="8" class="tb_showall" align="center">
				课程信息列表
			</td>
		</tr>
		<tr class="td_header" align="center">
			<td width="5%">课程ID</td>
	        <td width="10%">名称</td>
	        <td width="8%">性质</td>
	        <td width="5%">学分</td>
	        <td width="5%">开设年级</td>
	        <td width="8%">开设专业</td>
	        <td width="4%"></td>
	        <td width="4%"></td>
	    </tr>
		<%
			for (int i = 0; i < testlist.size(); i++)
			{
				//循环遍历课程信息列表，输出数据
				CourseInfo testcourse = testlist.get(i);
				
				int flag1 = testcourse.getType();
				String type = "";
				if (flag1 == 1)
				{
					type = "公共基础必修课";
				}
				else if (flag1 == 2)
				{
					type = "公共选修课";
				}
				else if (flag1 == 3)
				{
					type = "学科基础课";
				}
				else if (flag1 == 4)
				{
					type = "专业必修课";
				}
				else if (flag1 == 5)
				{
					type = "专业选修课";
				}
				else
				{
					type = "集中性教学实践环节";
				}
				
				int flag2 = testcourse.getMajor();
				String major = "";
				if (flag2 == 1)
				{
					major = "软件工程";
				}
				else if (flag2 == 2)
				{
					major = "空间信息";
				}
				else
				{
					major = "大数据";
				}
		%>
		<tr class="td" align="center">
	       	<td><%=testcourse.getCourseID() %></td>
	        <td><%=testcourse.getName() %></td>
	   		<td><%=type %></td>
	        <td><%=testcourse.getCredit() %></td>
	        <td><%=testcourse.getGrade() %></td>
	        <td><%=major %></td>
	        <td align="left"><a href="<%=path %>/CourseGetAction?id=<%=testcourse.getCourseID()%>">编辑</a></td>
	        <td align="left"><a href="<%=path %>/CourseDelAction?id=<%=testcourse.getCourseID()%>">删除</a></td>
	    </tr>
		<%	
			}
		%>
		<tr>
			<td colspan="4"><a href="<%=path %>/course/course_add.jsp">添加</a>
			<td colspan="4"><a href="<%=path %>/CourseListAction">刷新数据列表</a>
		</tr>
		
	</table>
</div>
</body>
</html>