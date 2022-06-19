<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" import="course.*,java.util.*"%>
<%
	String path = request.getContextPath();
	ArrayList<CourseInfo> list=(ArrayList<CourseInfo>)session.getAttribute("CourseList");
	session.removeAttribute("CourseList");
	if(list==null){//�������ݻ�δ����
		list=new ArrayList<CourseInfo>();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>�γ���Ϣ�б�</title>
<link rel="stylesheet" type="text/css" href="../css/student.css">
</head>
<script type="text/javascript">
	var data;
	data = {
			"courseList":[
<% for(int i=0;i<list.size();i++){
	CourseInfo course = list.get(i);
	String[] type = new String[]{"�����������޿�","����ѡ�޿�","ѧ�ƻ�����","רҵ���޿�","רҵѡ�޿�","������ʵ����ѧ����"};
	String[] maj = new String[]{"�������","�ռ���Ϣ","������"};
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
			strHtml+="<td><a href=\"<%=path %>/CourseGetAction?id="+courseList[i]["id"]+"\">�༭</a>";
			strHtml+="<a href=\"<%=path %>/CourseDelAction?id="+courseList[i]["id"]+"\">ɾ��</a></td></tr>";	
			strHtml+="</table>";	
		}
		document.getElementById("coursesSpan").innerHTML =strHtml;
	}  
</script>
<body onload="WriteCsList(data);">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td height="25" colspan="6" class="tb_showall" align="center">
				�γ���Ϣ�б�
			</td>
		</tr>
		<tr class="td_header">
			<td width="15%">����</td>
			<td width="15%">����</td>
			<td width="15%">ѧ��</td>
			<td width="15%">�����꼶</td>
			<td width="15%">����רҵ</td>
			<td ></td>
		</tr>
</table>
<div id="coursesSpan"></div>	
		<table width="100%"  border="0" cellpadding="0" cellspacing="0" align="center">
			<tr><td colspan="4"><a href="course_add.jsp">��ӿγ���Ϣ</a></td>
			<td colspan="4"><a href="<%=path %>/CourseListAction">ˢ�������б�</a>
			</tr>
		</table>
</body>
</html>