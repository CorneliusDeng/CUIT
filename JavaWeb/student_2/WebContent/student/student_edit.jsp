<%@ page contentType="text/html;charset=GB18030" import="java.util.*"%>
<%
	String path = request.getContextPath();
	int index=Integer.parseInt(request.getParameter("index"));
	ArrayList<String> reclist=(ArrayList<String>)session.getAttribute("studentlist");
	String studentinfo=reclist.get(index);
	String infos[]=studentinfo.split(";");
	

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>ѧ����Ϣ�޸�ҳ��</title>
<link rel="stylesheet" type="text/css" href="../css/student.css">
<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
</head>
<script language="JavaScript">
var testData;
testData={"id":"<%=index%>","code":"<%=infos[0]%>","name":"<%=infos[1]%>","sex":<%=infos[2]%>,"grade":<%=infos[3]%>,"major":<%=infos[4]%>};

function ShowData(student){
	//id
	$("#index").val(student["id"]);
	//ѧ��
	$("#code").val(student["code"]);
	//����
	$("#name").val(student["name"]);
	//�Ա�
	$("input[type=radio][name=sex][value='"+student["sex"]+"']").prop("checked",true);
	/*if(student["sex"] == 0){
		$("#sex0").prop("checked",true);
		$("#sex1").prop("checked",false);
	}else{
		$("#sex0").prop("checked",false);
		$("#sex1").prop("checked",true);
	}*/
   //�꼶
	$("#grade").val(student["grade"]);
	//רҵ
	$("#major").val(student["major"]);
	//$("#major").find("option[value='"+student["major"]+"']").prop("selected",true);
}
</script>

 <body onload="ShowData(testData);">
  <center>
    <a href="JavaScript:history.back();">>>ѧ����Ϣ����</a>	<br><br>								 
  
    <form name="frm" method="post" action="student_edit_action.jsp">
    <input type="hidden" name="index" id="index" value="1">
   <table border=1>
	<tr class="td_header"><td colspan="2"> ѧ����Ϣ�޸ģ�<span class="star">*</span>Ϊ������</td></tr>
   <tr><td>ѧ��</td><td><input type="text" name="code" id="code" value="" size="20" maxlength="5"><span class="star">*</span>5λ�ַ�����</td></tr>
   <tr><td>����</td><td><input type="text" name="name" id="name" value="" size="20" maxlength="20"><span class="star">*</span></td></tr>
   <tr><td>�Ա�</td><td><input type="radio" name="sex"  id="sex0" value="0" >��<input type="radio" name="sex" id="sex1" value="1" >Ů<span class="star">*</span></td></tr>
   <tr><td>�꼶</td><td><input type="text" name="grade" id="grade" value="" size="20" maxlength="4"><span class="star">*</span>4λ����</td></tr>
   <tr><td>רҵ</td><td><select name="major" id="major" size='1' >
   <option value='1' >�������</option>
   <option value='2' >�ռ���Ϣ</option>
   </select><span class="star">*</span></td></tr>
   <tr><td>��ע</td><td><TEXTAREA name="detail"  rows="2" cols="20" onpropertychange="if(this.value.length>200) {this.value=value.substr(0,200);alert('�������20���ַ�!');}"></TEXTAREA>200���ַ�����</td></tr>
   <tr><td colspan="2" align="center"><input type="reset"  value="����" ><input type="button"  value="�ύ" onclick="check();"></td></tr>
   </table>   
   </form>
   </center>
  </body>
</html>
<script language="JavaScript">
function check(){
	var re = /[0-9]{5}/;
//	if(!re.test(frm.code.value)){
	if(!re.test($("#code").val())){
		alert("������5λ�ַ����ֵ�ѧ��!");
		//frm.code.focus();
		$("#code").focus();
		return ;
	}
	re = /\S{2,20}/;
	if(!re.test($("#name").val())){
		alert("������2~20���ַ�������!");
		$("#name").focus();
		return ;
	}
	re = /20[0-9]{2}/;
	if(!re.test($("#grade").val())){
		alert("������4λ�������20xx!");
		$("#grade").focus();
		return ;
	}
	frm.submit();
}

</script>
