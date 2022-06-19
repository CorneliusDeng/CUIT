<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" type="text/css" href="../css/student.css">
<script type="text/javascript" src = "../js/datacheck.js"></script>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加课程</title>
    <style>
        tr {
            height: 25px;
        }

        textarea {
            resize: none;
        }
    </style>
</head>
<body>
	<form name="frm" method="post" action="<%=request.getContextPath()%>/UserInsertAction">
		<table weight="100%" border=1 align="center">
			<tr>
				<td colspan="2">课程信息录入，<font color="FF2B21">*</font>为必填项</td>
			</tr>
			<tr>
            	<td>用户名</td>
	            <td>
	                <input type="text" name="name" value="" onchange="checkName();">
	                <font color="FF2B21">*</font>
	                <span id="nameSpan"></span>
	            </td>
			</tr>
			<tr>
				<td>密码</td>
            	<td>
            		<input type="password" name="password" onchange="checkName();">
            		<font color="FF2B21">*</font>
            	</td>
            </tr>
            <tr>
            	<td colspan="2" align="center"><input type="submit" value="提交" onclick="return check();"></td>
            </tr>
		</table>
	</form>
</body>
</html>

<script language="JavaScript">
function check(){
	if((frm.name.value=="")){
		alert("用户名不能为空!");
		frm.name.focus();
		return false;
	}
	if(frm.password.value==""){
		alert("密码不能为空!");
		frm.password.focus();
		return false;
	}
	return true;
}

// 创建Ajax核心XMLHttpRequest对象实例	
var http_request = false;
function createRequest() {
	http_request = false;
        if (window.XMLHttpRequest) {     // Mozilla浏览器、IE7以上
            http_request = new XMLHttpRequest();
            if (http_request.overrideMimeType) {
                http_request.overrideMimeType('text/xml');     // 设置MIME类别
            }
        } else if (window.ActiveXObject) {     // IE5、IE6浏览器
        
         var MSXML = ['MSXML2.XMLHTTP.5.0', 'MSXML2.XMLHTTP.4.0', 'MSXML2.XMLHTTP.3.0', 'MSXML2.XMLHTTP', 'Microsoft.XMLHTTP'];
            for(var n=0; n<MSXML.length; n++){
                try{
                    var objXMLHttp = new ActiveXObject(MSXML[n]);
                    break;
                }catch(e){}
            }
            
        }
  }
  
  // 事件处理中启动Ajax异步请求，并注册Ajax响应的回调函数
  function checkName() {
    if(http_request==false){ // XMLHttpRequest对象未创建
    	createRequest(); // 创建XMLHttpRequest对象
    	if(http_request==false){return;} // 创建不成功   	
    }
    var url="<%=path%>/servlet/UserNameCheckAction?name="+frm.name.value;
    http_request.onreadystatechange = checkname_callback; // 注册Ajax响应的回调函数
  	http_request.open("POST", url, true);
  	http_request.send();		// 发送Ajax异步请求
  }
  
  // Ajax响应的回调函数，在正常响应后处理反馈数据
  function checkname_callback() {  
    if (http_request.readyState == 4) { // 完成
      if (http_request.status == 200) { // 正常响应   
        var flag=http_request.responseText;   //获取反馈数据
        
        // 处理反馈数据      
      	if(flag=="0"){
        	document.getElementById("nameSpan").innerHTML="<br>此用户名可以使用";
        }else if(flag=="1"){
        	document.getElementById("nameSpan").innerHTML="<br>此用户名["+frm.name.value+"]已经存在，请重新输入！";
        	frm.name.value="";
        }         
        
      } else {
        alert("Problem: " + http_request.statusText);
      }
    }
  }
</script>