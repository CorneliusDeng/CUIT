<%@ page contentType="text/html;charset=GB18030" import="student.*,java.util.*"%>
<%
	String path = request.getContextPath();
	ArrayList<StudentInfo> reclist=(ArrayList<StudentInfo>)session.getAttribute("studentlist");
	session.removeAttribute("studentlist");
	if(reclist==null){//�������ݻ�δ����
		reclist=new ArrayList<StudentInfo>();
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>ѧ����Ϣ�б�ҳ��</title>
<link rel="stylesheet" type="text/css" href="../css/student.css">
</head>
<script type="text/javascript"> 
var testData;
testData={
		"studentList":[
<%for(int i=0;i<reclist.size();i++){
	StudentInfo student=reclist.get(i);
	String major=(student.getMajor()==1?"�������":"�ռ���Ϣ");
%>			
	{"id":<%=student.getStID()%>,"code":"<%=student.getStCode()%>","name":"<%=student.getStName()%>","sex":<%=student.getSex()%>,"grade":<%=student.getGrade()%>,"major":"<%=major%>"}
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
		strHtml+="<td width=\"15%\">"+(studentList[i]["sex"]==0?"��":"Ů")+"</td>";
		strHtml+="<td width=\"15%\">"+studentList[i]["grade"]+"</td>";
		strHtml+="<td width=\"15%\">"+studentList[i]["major"]+"</td>";
		strHtml+="<td><a href=\"student_get_action.jsp?id="+studentList[i]["id"]+"\">�༭</a>";
		strHtml+="<a href=\"student_del_action.jsp?id="+studentList[i]["id"]+"\">ɾ��</a></td></tr>";	
		strHtml+="</table>";	
	}
	document.getElementById("studentsSpan").innerHTML =strHtml;
}  
</script>
<body onload="WriteStList(testData);">
		<table width="100%"  border="0" cellpadding="0" cellspacing="0" align="center">
			<tr>
				<td height="25" colspan="6" class="tb_showall" align="center">
					ѧ����Ϣ�б�
				</td>
			</tr>
			<tr class="td_header"><td width="15%">ѧ��</td>
				<td width="15%">����</td>
				<td width="15%">�Ա�</td>
				<td width="15%">�꼶</td>
				<td width="15%">רҵ</td>
				<td></td>
			</tr>
			</table>
			
<div id="studentsSpan"></div>	

		<table width="100%"  border="0" cellpadding="0" cellspacing="0" align="center">	
			<tr><td colspan="4"><a href="student_add.jsp">���ѧ����Ϣ</a>
				<td colspan="4"><a href="student_list_action.jsp">ˢ�������б�</a>
			</tr>
		</table>


  </body>
</html>

