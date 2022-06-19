<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息管理界面</title>
<link rel="stylesheet" type="text/css" href="../css/student.css">
<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
</head>

<style> 
	body{text-align:center} 
	.divcss5{margin:0 auto;width:400px;height:100px}
</style>


<script type="text/javascript"> 

$(document).ready( getList() );

function getList() 
{
	$.get("../servlet/UserListAction",					//servlet
			function(data) { WriteStList(eval(data)); }, 	//JSON数据处理函数
			"JSON");										//JSON
}

function WriteStList(userList)
{
	var strHtml="";
	strHtml+="<table width=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">	";
	for(var i = 0; i < userList.length; i++)
	{
		strHtml+="<tr class=\"td_"+(i%2+1)+"\">";
		strHtml+="<td width=\"25%\">"+userList[i]["userid"]+"</td>";
		strHtml+="<td width=\"25%\">"+userList[i]["username"]+"</td>";
		strHtml+="<td width=\"25%\">"+userList[i]["userpassword"]+"</td>";
		strHtml+="<td><a href=\"JavaScript:show_input("+userList[i]["userid"]+")\">编辑</a>";
		strHtml+="<a href=\"JavaScript:delData("+userList[i]["userid"]+")\">删除</a></td></tr>";	
	}
	strHtml+="</table>";	

	document.getElementById("UsersSpan").innerHTML =strHtml;
}  


function show_input(id)
{
	$('#UsersEditDiv').css('display','block');
	if(id != -1)
	{
		$('#frmTitle').text("用户信息修改");
		$.get("../servlet/UserGetAction?id="+id,			//servlet
				function(data) { ShowData(eval(data)); },	//JSON数据处理函数
				"JSON");									//JSON		
	}
	else
	{
		$('#frmTitle').text("用户信息添加");
		ClearData();
	}
}

function ShowData(user)
{
	$("#id").val(user["userid"]);
	$("#name").val(user["username"]);
	$("#password").val(user["userpassword"]);
}
function ClearData()
{
	$("#id").val(-1);
	$("#name").val("");
	$("#password").val("");
	$("#password2").val("");
}
function submitData()
{
	re = /\S{2,10}/;
	if(!re.test($("#name").val()))
	{
		alert("请输入2~10个字符的姓名!");
		$("#name").focus();
		return ;
	}
	re = /\S{2,10}/;
	if(!re.test($("#password").val()))
	{
		alert("请输入2~10个字符的密码!");
		$("#password").focus();
		return ;
	}
	if(!re.test($("#password2").val()))
	{
		alert("请输入2~10个字符的密码");
		$("#password2").focus();
		return ;
	}
	if(frm.password.value != frm.password2.value)
	{
		alert("请确认两次输入密码是否相同!");
		$("#password2").focus();
		return ;
	}
	
	$.ajax({
				cache: true,
				type: "POST",
				url:"../servlet/UserUpdateAction",
				data:$("#UserFrm").serialize(), 
				async: false,
			    error: function(request) 
			    {
			        alert("Connection error");
			    },
			    success: function(data) 
			    {
				    if(data=="0")
				    { 
				    	alert("数据处理不成功"); 
				    }
				    else
				    {
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
					url:"../servlet/UserDelAction",
					data:{"id":id}, 
					async: false,
				    error: function(request) 
				    {
				        alert("Connection error");
				    },
				    success: function(data) 
				    {
					    if(data=="0")
					    { 
					    	alert("数据删除不成功"); 
					    }
					    else
					    {
					    	alert("数据删除成功!");
					    	getList();
					    }
				    }
				});

}
</script>
<body>
	<table width="100%"  border="0" cellpadding="0" cellspacing="0" >
		<tr>
			<td height="25" colspan="6" class="tb_showall" align="center">用户信息列表</td>
		</tr>
		<tr class="td_header">
			<td width="25%">用户ID</td>
			<td width="25%">用户名</td>
			<td width="25%">密码</td>
			<td width="25%" ></td>
		</tr>
	</table>
			
	<div id="UsersSpan" ></div>	
		<table width="100%"  border="0" cellpadding="0" cellspacing="0" align="center">	
			<tr>
				<td colspan="4"><a href="JavaScript:show_input(-1);">添加用户信息</a>
				<td colspan="4"><a href="JavaScript:getList();">刷新数据列表</a>
			</tr>
		</table>
		<br><br>
		
	<div id="UsersEditDiv" style="display:NONE" class="divcss5">
		<form name="frm" id="UserFrm"  method="post" action="../servlet/UserUpdateAction">
	    	<input type="hidden" name="id" id="id" value="">
	   		<table border=1>
				<tr class="td_header">
					<td colspan="2"> <span id="frmTitle">用户信息修改</span>，<span class="star">*</span>为必填项</td></tr>
	   				<tr>
	   					<td>用户名</td>
	   					<td align="left"><input type="text" name="name" id="name" value="" size="15" maxlength="10" onchange="checkName();"><span class="star">*</span>10位字符以内<span id="nameSpan"></span></td>
	   				</tr>
	   				<tr>
	   					<td>密码</td>
	   					<td align="left"><input type="password" name="password" id="password" value="" size="15" maxlength="10"><span class="star">*</span>第一次输入密码</td>
	   				</tr>
	   				<tr>
	   					<td>确认密码</td>
	   					<td align="left"><input type="password" name="password2" id="password2" value="" size="15" maxlength="10"><span class="star">*</span>第二次确认密码</td>
	   				</tr>
	  	
	   			<tr><td colspan="2" align="center"><input type="button"  value="提交" onclick="submitData();"></td></tr>
	  		 </table>   
	   </form>
	</div>	

</body>
</html>

<script language="JavaScript">
	
	//1、创建Ajax核心XMLHttpRequest对象实例	
	var http_request = false;
	function createRequest() 
	{
		if (window.XMLHttpRequest) 
		{ // 非IE浏览器
			http_request = new XMLHttpRequest(); //创建XMLHttpRequest对象
		} 
		else if (window.ActiveXObject) 
		{ // IE浏览器
			try 
			{
				http_request = new ActiveXObject("Msxml2.XMLHTTP"); //创建XMLHttpRequest对象
			} 
			catch (e) 
			{
				try 
				{
					http_request = new ActiveXObject("Microsoft.XMLHTTP"); //创建XMLHttpRequest对象
				} 
				catch (e) 
				{}
			}
		}
		if (!http_request) 
		{
			alert("不能创建XMLHttpRequest对象实例！");
			return false;
		}

	}
	
	//2、事件处理中启动Ajax异步请求，并注册Ajax响应的回调函数
	function checkName() 
	{
		if(http_request==false)
	    {//XMLHttpRequest对象未创建
	  		createRequest();//创建XMLHttpRequest对象
	  	  	if(http_request==false){return;} //创建不成功   	
	    }
	    var url="../servlet/UserNameCheckAction?name="+frm.name.value;
	   	http_request.onreadystatechange = checkname_callback();//注册Ajax响应的回调函数
	 	http_request.open("POST", url, true);
	 	http_request.send();		//发送Ajax异步请求
	}

	//3、Ajax响应的回调函数，在正常响应后处理反馈数据
 	function checkname_callback() 
 	{  
		if (http_request.readyState == 4) 
	   	{ // 完成
			console.log(http_request.status);
	   		if (http_request.status == 200) 
	    	{ // 正常响应   
	       		var flag=http_request.responseText;   //获取反馈数据
	       
	    		//处理反馈数据      
	      		if(flag=="0")
	      		{
	        		document.getElementById("nameSpan").innerHTML="<br>此用户名可以使用";
	        	}
	      		else if(flag=="1")
	      		{
	        		document.getElementById("nameSpan").innerHTML="<br>此用户名["+frm.name.value+"]已经存在，请重新输入！";
	        		frm.name.value="";
	        	}         
	     	} 
	   		else 
	   		{
	   			alert("Problem: " + http_request.statusText);
	     	}	
	   }
	}

</script>