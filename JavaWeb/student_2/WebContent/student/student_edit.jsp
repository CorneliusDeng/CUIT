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
<title>学生信息修改页面</title>
<link rel="stylesheet" type="text/css" href="../css/student.css">
<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
</head>
<script language="JavaScript">
var testData;
testData={"id":"<%=index%>","code":"<%=infos[0]%>","name":"<%=infos[1]%>","sex":<%=infos[2]%>,"grade":<%=infos[3]%>,"major":<%=infos[4]%>};

function ShowData(student){
	//id
	$("#index").val(student["id"]);
	//学号
	$("#code").val(student["code"]);
	//姓名
	$("#name").val(student["name"]);
	//性别
	$("input[type=radio][name=sex][value='"+student["sex"]+"']").prop("checked",true);
	/*if(student["sex"] == 0){
		$("#sex0").prop("checked",true);
		$("#sex1").prop("checked",false);
	}else{
		$("#sex0").prop("checked",false);
		$("#sex1").prop("checked",true);
	}*/
   //年级
	$("#grade").val(student["grade"]);
	//专业
	$("#major").val(student["major"]);
	//$("#major").find("option[value='"+student["major"]+"']").prop("selected",true);
}
</script>

 <body onload="ShowData(testData);">
  <center>
    <a href="JavaScript:history.back();">>>学生信息管理</a>	<br><br>								 
  
    <form name="frm" method="post" action="student_edit_action.jsp">
    <input type="hidden" name="index" id="index" value="1">
   <table border=1>
	<tr class="td_header"><td colspan="2"> 学生信息修改，<span class="star">*</span>为必填项</td></tr>
   <tr><td>学号</td><td><input type="text" name="code" id="code" value="" size="20" maxlength="5"><span class="star">*</span>5位字符数字</td></tr>
   <tr><td>姓名</td><td><input type="text" name="name" id="name" value="" size="20" maxlength="20"><span class="star">*</span></td></tr>
   <tr><td>性别</td><td><input type="radio" name="sex"  id="sex0" value="0" >男<input type="radio" name="sex" id="sex1" value="1" >女<span class="star">*</span></td></tr>
   <tr><td>年级</td><td><input type="text" name="grade" id="grade" value="" size="20" maxlength="4"><span class="star">*</span>4位整数</td></tr>
   <tr><td>专业</td><td><select name="major" id="major" size='1' >
   <option value='1' >软件工程</option>
   <option value='2' >空间信息</option>
   </select><span class="star">*</span></td></tr>
   <tr><td>备注</td><td><TEXTAREA name="detail"  rows="2" cols="20" onpropertychange="if(this.value.length>200) {this.value=value.substr(0,200);alert('描述最多20个字符!');}"></TEXTAREA>200个字符以内</td></tr>
   <tr><td colspan="2" align="center"><input type="reset"  value="重填" ><input type="button"  value="提交" onclick="check();"></td></tr>
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
		alert("请输入5位字符数字的学号!");
		//frm.code.focus();
		$("#code").focus();
		return ;
	}
	re = /\S{2,20}/;
	if(!re.test($("#name").val())){
		alert("请输入2~20个字符的姓名!");
		$("#name").focus();
		return ;
	}
	re = /20[0-9]{2}/;
	if(!re.test($("#grade").val())){
		alert("请输入4位整数年份20xx!");
		$("#grade").focus();
		return ;
	}
	frm.submit();
}

</script>
