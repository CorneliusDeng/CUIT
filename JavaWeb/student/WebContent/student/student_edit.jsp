<%@ page contentType="text/html;charset=GB2312" import="student.*"%>
<%
String path = request.getContextPath();
StudentInfo student=(StudentInfo)session.getAttribute("studentinfo");

%>
<html>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/student.css">
<script type="text/javascript" src = "<%=path%>/js/datacheck.js"></script>
  <body>
  <center>									 
   <form name="frm" method="post" action="<%=path %>/servlet/StudentUpdateAction">
    <input type="hidden" name="id" value="<%=student.getStID() %>">
   <table border=1>
	<tr class="td_header"><td colspan="2"> 学生信息修改，<span class="star">*</span>为必填项</td></tr>
   <tr><td>学号</td><td><input type="text" name="code" value="<%=student.getStCode() %>" size="20" maxlength="5" onchange="checkCode();"><span class="star">*</span>5位字符数字<span id="codeSpan"></span></td></tr>
   <tr><td>姓名</td><td><input type="text" name="name" value="<%=student.getStName() %>" size="20" maxlength="20"><span class="star">*</span></td></tr>
   <tr><td>性别</td><td><input type="radio" name="sex" value="0" <%=student.getSex()==0?"checked":"" %>>男<input type="radio" name="sex" value="1" <%=student.getSex()==1?"checked":"" %>>女<span class="star">*</span></td></tr>
   <tr><td>年级</td><td><input type="text" name="grade" value="<%=student.getGrade() %>" size="20" maxlength="4"><span class="star">*</span>4位整数</td></tr>
   <tr><td>专业</td><td><select name="major" size='1' >
   <option value='1' <%=student.getMajor()==1?"selected":"" %>>软件工程</option>
   <option value='2' <%=student.getMajor()==2?"selected":"" %>>空间信息</option>
   </select><span class="star">*</span></td></tr>
   <tr><td>备注</td><td><TEXTAREA name="detail"  rows="2" cols="20" onpropertychange="if(this.value.length>200) {this.value=value.substr(0,200);alert('描述最多20个字符!');}"><%=student.getDetail()==null?"":student.getDetail() %></TEXTAREA>200个字符以内</td></tr>
   <tr><td colspan="2" align="center"><input type="reset"  value="重填" ><input type="button"  value="提交" onclick="check();"></td></tr>
   </table>   
   </form>
   </center>
  </body>
</html>
<script language="JavaScript">
function check(){
	if(frm.code.value.length!=5){
		alert("请输入5位字符数字的学号!");
		frm.code.focus();
		return ;
	}
	if(frm.name.value==""){
		alert("请输入姓名!");
		frm.name.focus();
		return ;
	}
	if(frm.grade.value.length!=4||!IsInt(frm.grade.value)){
		alert("请输入4位整数的年份!");
		frm.grade.focus();
		return ;
	}
	frm.submit();
}

//1、创建Ajax核心XMLHttpRequest对象实例	
var http_request = false;
function createRequest() {
    http_request = false;
    if (window.XMLHttpRequest) {     // Mozilla浏览器、IE7以上
        http_request = new XMLHttpRequest();
        if (http_request.overrideMimeType) {
            http_request.overrideMimeType('text/xml');     //设置MIME类别
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
//2、事件处理中启动Ajax异步请求，并注册Ajax响应的回调函数
function checkCode() {
if(http_request==false){//XMLHttpRequest对象未创建
	createRequest();//创建XMLHttpRequest对象
	if(http_request==false){return;} //创建不成功   	
}
var url="<%=path%>/servlet/StudentCodeCheckAction?code="+frm.code.value+"&id="+frm.id.value;
http_request.onreadystatechange = checkcode_callback;//注册Ajax响应的回调函数
	http_request.open("POST", url, true);
	http_request.send();		//发送Ajax异步请求
}
//3、Ajax响应的回调函数，在正常响应后处理反馈数据
function checkcode_callback() {  
if (http_request.readyState == 4) { // 完成
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
