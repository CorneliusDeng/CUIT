<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="course.*,common.*,java.util.*" %>
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
    <title>修改课程</title>
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
   	<form name="frm" method="post" action="<%=request.getContextPath()%>/CourseInsertAction">
    <table weight="100%" border=1 align="center">
        <tr>
            <td colspan="2">课程信息录入，<font color="FF2B21">*</font>为必填项</td>
        </tr>
        <tr>
            <td>名称</td>
            <td>
            	<input type="text" name="name" value="" onchange="checkName();">
                <font color="FF2B21">*</font>20位字符
                <span id="nameSpan"></span>
            </td>
        </tr>
        <tr>
            <td>性质</td>
            <td>
                <select name="type" id="properties">
                    <option value="1">公共必修课</option>
                    <option value="2">公共选修课</option>
                    <option value="3">专业基础课</option>
                    <option value="4">专业必修课</option>
                    <option value="5">专业选修课</option>
                </select>
                <font color="FF2B21">*</font>
            </td>

        </tr>
        <tr>
            <td>学分</td>
            <td>
                <input type="text" name="credit">
                <font color="FF2B21">*</font>数值
            </td>
        </tr>
        <tr>
            <td>开设年级</td>
            <td>
                <input type="text" name="grade">
                <font color="FF2B21">*</font>4位数年份
            </td>
        </tr>
        <tr>
            <td>开设专业</td>
            <td>
                <input type="radio" checked="checked" id="software" name="major" value="1"><label for="software">软件工程</abel>
                    <input type="radio" id="Spatial Information" name="major" value="2"><label for="Spatial Information">空间信息</abel>
                        <font color="FF2B21">*</font>
            </td>
        </tr>
        <tr>
            <td>备注</td>
            <td>
                <textarea style="overflow:scroll; overflow-x:hidden; height:30px; width: 200px;" cols="2" rows="20" name="detail" ></textarea>
                200个字符以内
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
	if((frm.name.value.length<5)||(frm.name.value.length>20)){
		alert("请输入不为空且长度是5~20的课程名称!");
		frm.name.focus();
		return false;
	}
	if(frm.credit.value==""||!IsInt(frm.credit.value)){
		alert("请输入学分!");
		frm.credit.focus();
		return false;
	}
	if(frm.grade.value.length!=4||!IsInt(frm.grade.value)){
		alert("开设年级应为4位整数的年份!");
		frm.grade.focus();
		return false;
	}
	frm.submit();
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
    if(http_request==false){// XMLHttpRequest对象未创建
    	createRequest();// 创建XMLHttpRequest对象
    	if(http_request==false){return;} // 创建不成功   	
    }
    var url="<%=path%>/servlet/CourseNameCheckAction?name="+frm.name.value;
    http_request.onreadystatechange = checkname_callback;// 注册Ajax响应的回调函数
  	http_request.open("POST", url, true);
  	http_request.send();		// 发送Ajax异步请求
  }
  
  // Ajax响应的回调函数，在正常响应后处理反馈数据
  function checkname_callback() {  
    if (http_request.readyState == 4) { // 完成
      if (http_request.status == 200) { // 正常响应   
        var flag=http_request.responseText;   // 获取反馈数据
        
        // 处理反馈数据      
      	if(flag=="0"){
        	document.getElementById("nameSpan").innerHTML="<br>此课程名可以使用";
        }else if(flag=="1"){
        	document.getElementById("nameSpan").innerHTML="<br>此课程["+frm.name.value+"]已经存在，请重新输入！";
        	frm.name.value="";
        }         
      } else {
        alert("Problem: " + http_request.statusText);
      }
    }
  }
</script>
