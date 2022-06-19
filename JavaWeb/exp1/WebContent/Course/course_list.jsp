<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
 
<head>
<meta charset="GB18030">
<title>课程列表</title>
<link rel=stylesheet type="text/css" href="../css/student.css">
<script type="text/javascript" src="../js/datacheck.js"></script>
</head>

<body>
<div align="center">
	<table border="0" width="90%" border="0" cellpadding="0" cellspacing="0">
	
		<tr>
			<td height="25" colspan="6" class="tb_showall" align="center">
				课程信息列表
			</td>
		</tr>
		<tr class="td_header">
			<td width="15%">名称</td>
	        <td width="12%">性质</td>
	        <td width="4%">学分</td>
	        <td width="5%">开设年级</td>
	        <td width="8%">开设专业</td>
	        <td width="15%"></td>
	    </tr>
	    
	    <tr class="td_1">
	        <td>Java程序设计</td>
	        <td>专业必修课</td>
	        <td>3</td>
	        <td>2015</td>
	        <td>软件工程</td>
	        <td><a href="course_edit.jsp">编辑  </a><a href="JavaScript:alert('删除成功')">  删除</a></td>
	    </tr>
	    
	    <tr class="td_2">
	        <td>Web应用程序设计</td>
	        <td>专业选修课</td>
	        <td>2</td>
	        <td>2015</td>
	        <td>软件工程</td>
	        <td><a href="course_edit.jsp">编辑  </a><a href="JavaScript:alert('删除成功')">  删除</a></td>
	     </tr>
	     
	     <tr class="td_3">
	        <td>Jsp程序设计</td>
	        <td>专业选修课</td>
	        <td>2</td>
	        <td>2015</td>
	        <td>软件工程</td>
	        <td><a href="course_edit.jsp">编辑  </a><a href="JavaScript:alert('删除成功')">  删除</a></td>
	     </tr>
	     
	     <tr>
	     	<td colspan="5"><a href="course_add.jsp">添加课程信息</a>
			<td colspan="4"><a href="course_list.jsp">刷新数据列表</a>
			</tr>
	    
	</table>
</div>
</body>
</html>