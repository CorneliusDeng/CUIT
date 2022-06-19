<%@ page contentType="text/html;charset=UTF-8" import="student.*,java.util.*"%>
<%
	String path = request.getContextPath();
	ArrayList<StudentInfo> reclist=(ArrayList<StudentInfo>)session.getAttribute("studentlist");
	session.removeAttribute("studentlist");
	if(reclist==null){ //测试数据还未构建
		reclist=new ArrayList<StudentInfo>();
	}
%>

<html>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/student.css">
<style>
	a {
		color: #703E3E;
        text-decoration: none;
        font-weight: bold;
        }
        </style>

	<body>
		<table width="100%" height="100" border="0" cellpadding="0"
			cellspacing="0" align="center">
			<tr>
				<td height="25" colspan="6" class="tb_showall" align="center">
					学生信息列表
				</td>
			</tr>
			<tr class="td_header">
				<td>学号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>年级</td>
				<td>专业</td>
				<td></td>
			</tr>
			<% int count=reclist.size();
			for(int i=0;i<count;i++){
				StudentInfo student=reclist.get(i);
			%>
			<tr class="td_<%=i%2+1%>">
				<td><%=student.getStCode() %></td>
				<td><%=student.getStName() %></td>
				<td><%=student.getSex()==0?"男":"女"  %></td>
				<td><%=student.getGrade() %></td>
				<td><%=student.getMajor()==1?"软件工程":"空间信息"  %></td>
				<td>
					<a href="<%=path %>/servlet/StudentGetAction?id=<%=student.getStID()%>">编辑</a>
					<a href="<%=path %>/servlet/StudentDelAction?id=<%=student.getStID()%>">删除</a>
				</td>
			</tr>
			<%
			}
		 	%>	
			<tr>
				<td colspan="4"><a href="<%=path %>/student/student_add.jsp">添加学生信息</a>
				<td colspan="4"><a href="<%=path %>/servlet/StudentListAction">刷新数据列表</a>
			</tr>
		</table>
	</body>
</html>
