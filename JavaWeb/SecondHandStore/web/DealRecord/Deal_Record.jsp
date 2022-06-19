<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>交易记录</title>
<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
</head>
<style>
	.form-control{margin-bottom:20px;}
/*.divcss5{margin:0 auto;width:400px;height:100px}*/
</style>
<script type="text/javascript">
$(document).ready( getList() );

function getList() {
	$.get("../servlet/StudentListAction",					//servlet
			function(data) { WriteStList(eval(data)); }, 	//JSON数据处理函数
			"JSON");										//JSON
}

function WriteStList(studentList){
	var strHtml="";
	strHtml+="<table width=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">	";
	for(var i=0;i<studentList.length;i++){
		strHtml+="<tr class=\"td_"+(i%2+1)+"\">";
		strHtml+="<td width=\"15%\">"+studentList[i]["id"]+"</td>";
		strHtml+="<td width=\"15%\">"+studentList[i]["code"]+"</td>";
		strHtml+="<td width=\"15%\">"+studentList[i]["name"]+"</td>";
		strHtml+="<td width=\"15%\">"+studentList[i]["sex"]+"</td>";
		strHtml+="<td width=\"15%\">"+studentList[i]["grade"]+"</td>";
		strHtml+="<td>";
		strHtml+="</td></tr>";
	}
	strHtml+="</table>";	

	document.getElementById("studentsSpan").innerHTML =strHtml;
}  


function show_input(id){
	$('#studentsEditDiv').css('display','block');
	if(id!=-1){
		$('#frmTitle').text("学生信息修改");
		$.get("../servlet/StudentGetAction?id="+id,			//servlet
				function(data) { ShowData(eval(data)); },	//JSON数据处理函数
				"JSON");									//JSON		
	}else{
		$('#frmTitle').text("学生信息添加");
		ClearData();
	}
}

function ShowData(student){
	$("#id").val(student["id"]);
	$("#code").val(student["code"]);
	$("#name").val(student["name"]);
	$("input[type=radio][name=sex][value='"+student["sex"]+"']").prop("checked",true);
	$("#grade").val(student["grade"]);
	$("#major").val(student["major"]);
	$("#detail").val(student["detail"]);
}
function ClearData(){
	$("#id").val(-1);
	$("#code").val("");
	$("#name").val("");
	$("input[type=radio][name=sex][value='"+0+"']").prop("checked",true);
	$("#grade").val("");
	$("#major").val(1);
	$("#detail").val("");
}
function submitData(){
	var re = /[0-9]{5}/;
	if(!re.test($("#code").val())){
		alert("请输入5位字符数字的学号!");		
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
	$.ajax({
					cache: true,
					type: "POST",
					url:"../servlet/StudentUpdateAction",
					data:$("#studentFrm").serialize(), 
					async: false,
				    error: function(request) {
				        alert("Connection error");
				    },
				    success: function(data) {
					    if(data=="0"){ 
					    	alert("数据处理不成功"); 
					    }else{
					    	$("#studentsEditDiv").css("display","none");
					    	alert("数据处理成功!");
					    	getList();
					    }
				    }
				});

}
 
function delData(id){
 
	$.ajax({
					cache: true,
					type: "POST",
					url:"../servlet/StudentDelAction",
					data:{"id":id}, 
					async: false,
				    error: function(request) {
				        alert("Connection error");
				    },
				    success: function(data) {
					    if(data=="0"){ 
					    	alert("数据删除不成功"); 
					    }else{
					    	alert("数据删除成功!");
					    	getList();
					    }
				    }
				});

}
</script>
<body >
<div class="col-md-10 col-md-offset-1">
		<table width="100%"  border="0" cellpadding="0" cellspacing="0" >
			<tr>
				<td height="25" colspan="6" class="tb_showall" align="center">
					交易记录列表
				</td>
			</tr>
			<tr class="td_header"><td width="15%">订单ID</td>
				<td width="15%">商品编号</td>
				<td width="15%">用户ID</td>
				<td width="15%">订单状态</td>
				<td width="15%">交易时间</td>
				<td></td>
			</tr>
			</table>


		<table width="100%"  border="0" cellpadding="0" cellspacing="0" align="center">	
			<tr><td colspan="4">
				<td colspan="4">
			</tr>
		</table>
		<br><br>
</div>
  </body>
</html>
<script language="JavaScript">
	//1、创建Ajax核心XMLHttpRequest对象实例	
    var http_request = false;
    function createRequest() {
		if (window.XMLHttpRequest) { // 非IE浏览器
			http_request = new XMLHttpRequest(); //创建XMLHttpRequest对象
		} else if (window.ActiveXObject) { // IE浏览器
			try {
				http_request = new ActiveXObject("Msxml2.XMLHTTP"); //创建XMLHttpRequest对象
			} catch (e) {
				try {
					http_request = new ActiveXObject("Microsoft.XMLHTTP"); //创建XMLHttpRequest对象
				} catch (e) {
				}
			}
		}
		if (!http_request) {
			alert("不能创建XMLHttpRequest对象实例！");
			return false;
		}
 
  }
  //2、事件处理中启动Ajax异步请求，并注册Ajax响应的回调函数
  function checkCode() {
    if(http_request==false){//XMLHttpRequest对象未创建
    	createRequest();//创建XMLHttpRequest对象
    	if(http_request==false){return;} //创建不成功   	
    }
    var url="../servlet/StudentCodeCheckAction?code="+frm.code.value;
    http_request.onreadystatechange = checkcode_callback;//注册Ajax响应的回调函数
  	http_request.open("POST", url, true);
  	http_request.send();		//发送Ajax异步请求
  }
  //3、Ajax响应的回调函数，在正常响应后处理反馈数据
  function checkcode_callback() {  
    if (http_request.readyState == 4) { 
    	// 完成
    	console.log(http_request.status);
      if (http_request.status == 200) { // 正常响应   
        var flag=http_request.responseText;   //获取反馈数据
        
        //处理反馈数据      
      	if(flag=="0"){
        	document.getElementById("codeSpan").innerHTML="<br>此学号可以使用";
        }else if(flag=="1"){
        	document.getElementById("codeSpan").innerHTML="<br>此学号["+frm.code.value+"]已经存在，请重新输入！";
        	frm.code.value="";
        }         
        
      } else {
        alert("Problem: " + http_request.statusText);
      }
    }
  }

</script>

