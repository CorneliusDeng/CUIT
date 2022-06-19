<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" import="course.*,java.util.*"%>
<%
	String path = request.getContextPath();
	ArrayList<CourseInfo> list=(ArrayList<CourseInfo>)session.getAttribute("CourseList");
	session.removeAttribute("CourseList");
	if(list==null){//测试数据还未构建
		list=new ArrayList<CourseInfo>();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>课程信息列表</title>
<link rel="stylesheet" type="text/css" href="../css/student.css">
</head>
<script type="text/javascript">
	var data;
	data = {
			"courseList":[
<% for(int i=0;i<list.size();i++){
	CourseInfo course = list.get(i);
	String[] type = new String[]{"公共基础必修课","公共选修课","学科基础课","专业必修课","专业选修课","集中性实践教学环节"};
	String[] maj = new String[]{"软件工程","空间信息","大数据"};
	String c_type = type[course.getType()-1];
	String major = maj[course.getMajor()-1];
	%>
	{
		"id":<%=course.getCourseID()%>,
		"name":"<%=course.getName()%>",
		"type":"<%=c_type%>",
		"credit":<%=course.getCredit()%>,
		"grade":<%=course.getGrade()%>,
		"major":"<%=major%>",
	}
<%
if(i<list.size()-1){ out.println(",");}
}
%>
			]
	};
	
	function WriteCsList(data){
		var courseList=data["courseList"];
		var strHtml="";
		for(var i=0;i<courseList.length;i++){
			strHtml+="<table width=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">	";
			strHtml+="<tr class=\"td_"+(i%2+1)+"\">";
			strHtml+="<td width=\"15%\">"+courseList[i]["name"]+"</td>";
			strHtml+="<td width=\"15%\">"+courseList[i]["type"]+"</td>";
			strHtml+="<td width=\"15%\">"+courseList[i]["credit"]+"</td>";
			strHtml+="<td width=\"15%\">"+courseList[i]["grade"]+"</td>";
			strHtml+="<td width=\"15%\">"+courseList[i]["major"]+"</td>";
			strHtml+="<td><a href=\"<%=path %>/CourseGetAction?id="+courseList[i]["id"]+"\">编辑</a>";
			strHtml+="<a href=\"<%=path %>/CourseDelAction?id="+courseList[i]["id"]+"\">删除</a></td></tr>";	
			strHtml+="</table>";	
		}
		document.getElementById("coursesSpan").innerHTML =strHtml;
	}  
</script>
<body onload="WriteCsList(data);">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td height="25" colspan="6" class="tb_showall" align="center">
				课程信息列表
			</td>
		</tr>
		<tr class="td_header">
			<td width="15%">名称</td>
			<td width="15%">性质</td>
			<td width="15%">学分</td>
			<td width="15%">开设年级</td>
			<td width="15%">开设专业</td>
			<td ></td>
		</tr>
</table>
<div id="coursesSpan"></div>	
		<table width="100%"  border="0" cellpadding="0" cellspacing="0" align="center">
			<tr><td colspan="4"><a href="course_add.jsp">添加课程信息</a></td>
			<td colspan="4"><a href="<%=path %>/CourseListAction">刷新数据列表</a>
			</tr>
		</table>
</body>
</html>