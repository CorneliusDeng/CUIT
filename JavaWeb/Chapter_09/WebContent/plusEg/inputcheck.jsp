<!--  
作者:成都信息工程学院 软件工程系 胡道海
转载请保留此信息
-->
<%@ page contentType="text/html;charset=GB2312" %>
 
<%
String path = request.getContextPath();
%>
<html>
<head>
 <title>显示返回内容</title>
<script>
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
            
 //           try {
 //               http_request = new ActiveXObject("Msxml2.XMLHTTP");
 //           } catch (e) {
 //               try {
 //                   http_request = new ActiveXObject("Microsoft.XMLHTTP");
 //              } catch (e) {}
 //           }
        }
  }
  //2、事件处理中启动Ajax异步请求，并注册Ajax响应的回调函数
  function checkCode() {
    if(http_request==false){//XMLHttpRequest对象未创建
    	createRequest();//创建XMLHttpRequest对象
    	if(http_request==false){return;} //创建不成功   	
    }
    var url="<%=path%>/servlet/AjaxServlet?Action=GetFlagByText&code="+frm.stCode.value;
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
        	document.getElementById("codeSpan").innerHTML="此学号可以使用";
        }else if(flag=="1"){
        	frm.stCode.value="";
        	document.getElementById("codeSpan").innerHTML="此学号已经存在，请重新输入！";
        }         
        
      } else {
        alert("Problem: " + http_request.statusText);
      }
    }
  }

 function checkName() {
    if(http_request==false){	//XMLHttpRequest对象未创建
    	createRequest();		//创建XMLHttpRequest对象
    	if(http_request==false){return;} //创建不成功   	
    }
    var url="<%=path%>/servlet/AjaxServlet?Action=GetFlagByXML&name="+frm.stName.value;
    http_request.onreadystatechange = checkName_callback;
  	http_request.open("POST", url, true);
  	http_request.send();
  }

  function checkName_callback() { 
    if (http_request.readyState == 4) { // 完成
      if (http_request.status == 200) { // 正常响应   
        var flag=http_request.responseXML.getElementsByTagName("flag")[0].text;         

      	if(flag=="0"){
        	document.getElementById("nameSpan").innerHTML="<font color=green>此姓名可以使用</font>";
        }else if(flag=="1"){
        	frm.stName.value="";
        	document.getElementById("nameSpan").innerHTML="<font color=red>此姓名已经存在，请重新输入！</font>";
        }         
      } else {
        alert("Problem: " + http_request.statusText);
      }
    }
  }
</script>
</head>
<body>

<br><br>
<form name=frm>
学号<input type="text" name="stCode" value="" onblur="checkCode();">
	<span id="codeSpan" ></span><br>
姓名<input type="text" name="stName" value="" onchange="checkName();">
	<span id="nameSpan"></span><br>
年龄<input type="text" name="stAge" value=""><br>
<input type="button" value="添加">
</form>
<br>
<br>
测试：
<br>
学号用 001 会出现学号已使用的提示
<br>
姓名用 李晓华 会出现姓名已使用的提示

</body>
</html>
