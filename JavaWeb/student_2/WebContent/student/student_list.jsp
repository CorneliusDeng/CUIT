<%@ page contentType="text/html;charset=GB2312" import="java.util.*"%>
<%
	String path = request.getContextPath();
	ArrayList<String> reclist=(ArrayList<String>)session.getAttribute("studentlist");
	if(reclist==null){//测试数据还未构建
		reclist=new ArrayList<String>();
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>学生信息列表页面</title>
<link rel="stylesheet" type="text/css" href="../css/student.css">
</head>
<script type="text/javascript"> 
var testData;
testData={
		"studentList":[
			//{"code":"00001","name":"王亮","sex":0,"grade":2015,"major":"软件工程"},
			//{"code":"00002","name":"李树国 ","sex":0,"grade":2015,"major":"软件工程"},
			//{"code":"00003","name":"赵欣","sex":1,"grade":2015,"major":"空间信息"}

<%for(int i=0;i<reclist.size();i++){
	String studentinfo=reclist.get(i);
	String infos[]=studentinfo.split(";");
	String major=(infos[4].equals("1")?"软件工程":"空间信息");
%>			
	{"code":"<%=infos[0]%>","name":"<%=infos[1]%>","sex":<%=infos[2]%>,"grade":<%=infos[3]%>,"major":"<%=major%>"}
<%
	if(i<reclist.size()-1){ out.println(",");}
}%>
		]
};

function WriteStList(data){
	var studentList=data["studentList"];
	var strHtml="";
	for(var i=0;i<studentList.length;i++){
		strHtml+="<table width=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">	";
		strHtml+="<tr class=\"td_"+(i%2+1)+"\">";
		strHtml+="<td width=\"15%\">"+studentList[i]["code"]+"</td>";
		strHtml+="<td width=\"15%\">"+studentList[i]["name"]+"</td>";
		strHtml+="<td width=\"15%\">"+(studentList[i]["sex"]==0?"男":"女")+"</td>";
		strHtml+="<td width=\"15%\">"+studentList[i]["grade"]+"</td>";
		strHtml+="<td width=\"15%\">"+studentList[i]["major"]+"</td>";
		strHtml+="<td><a href=\"student_edit.jsp?index="+i+"\">编辑</a>";
		strHtml+="<a href=\"student_del_action.jsp?index="+i+"\">删除</a></td></tr>";	
		strHtml+="</table>";	
	}
	document.getElementById("studentsSpan").innerHTML =strHtml;
}  
</script>
<body onload="WriteStList(testData);">
		<table width="100%"  border="0" cellpadding="0" cellspacing="0" align="center">
			<tr>
				<td height="25" colspan="6" class="tb_showall" align="center">
					学生信息列表
				</td>
			</tr>
			<tr class="td_header"><td width="15%">学号</td>
				<td width="15%">姓名</td>
				<td width="15%">性别</td>
				<td width="15%">年级</td>
				<td width="15%">专业</td>
				<td></td>
			</tr>
			</table>
			
<div id="studentsSpan"></div>	

		<table width="100%"  border="0" cellpadding="0" cellspacing="0" align="center">	
			<tr><td colspan="4"><a href="student_add.jsp">添加学生信息</a>
				<td colspan="4"><a href="student_list_action.jsp">刷新数据列表</a>
			</tr>
		</table>


  </body>
</html>
