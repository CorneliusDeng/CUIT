<!--  
作者:成都信息工程学院 软件工程系 胡道海
转载请保留此信息
-->
<%@ page contentType="text/html;charset=gb2312" %>
 
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
  function retrieveText(){
    if(http_request==false){//XMLHttpRequest对象未创建
    	createRequest();//创建XMLHttpRequest对象
    	if(http_request==false){return;} //创建不成功   	
    }
    var url="<%=path%>/servlet/AjaxServlet?Action=GetDataByText";
    http_request.onreadystatechange = callbackfortext;
  	http_request.open("post", url, true);
  	http_request.send();
  }
  function callbackfortext() { 
    if (http_request.readyState == 4) { // 完成
      if (http_request.status == 200) { // 正常响应
        var str=http_request.responseText;
        
		var html="<table border='1'><tr><td>id</td><td>name</td><td>math</td><td>english</td><td>physic</td></tr>";
		var infostr=str.split(";");
		for(i=0;i<infostr.length;i++){
			student=infostr[i].split(",");
			html+="<tr><td>"+student[0]+"</td><td>"+student[1]+"</td><td>"+student[2]+"</td><td>"+student[3]+"</td><td>"+student[4]+"</td></tr>";
		} 
		html+="</table>" ;
		
		document.getElementById("dataTable").innerHTML=html;
			
      } else {
        alert("Problem: " + http_request.statusText);
      }
    }
  }
 
  function retrieveXML() {
     if(http_request==false){//XMLHttpRequest对象未创建
    	createRequest();//创建XMLHttpRequest对象
    	if(http_request==false){return;} //创建不成功   	
    }
    var url="<%=path%>/servlet/AjaxServlet?Action=GetDataByXML";
    http_request.onreadystatechange = callbackforXML;
  	http_request.open("post", url, true);
  	http_request.send();
  }

  function callbackforXML() { 
    if (http_request.readyState == 4) { // 完成
      if (http_request.status == 200) { // 正常响应
        var xml=http_request.responseXML;
        
	  	var html="<table border='1'><tr><td>学号</td><td>姓名</td><td>数学</td><td>英语</td><td>物理</td></tr>";
	    //获取XML中的所有student标签，放到students数组
	    var students=xml.getElementsByTagName("student");
	    //对students数组进行遍历，获取每个子节点的内容
	    if (students.length != 0) {
	        for (var i = 0; i < students.length; i++) {
	            var student = students[i];
				html+="<tr><td>"+student.childNodes[0].childNodes[0].nodeValue+"</td>"+
				"<td>"+student.childNodes[1].childNodes[0].nodeValue+"</td>"+
				"<td>"+student.childNodes[2].childNodes[0].nodeValue+"</td>"+
				"<td>"+student.childNodes[3].childNodes[0].nodeValue+"</td>"+
				"<td>"+student.childNodes[4].childNodes[0].nodeValue+"</td></tr>";
	        }
		   	html+="</table>" ;
		   //	alert(html);
			document.getElementById("dataTable").innerHTML=html;
	    }
	          
    } else {
        alert("Problem: " + http_request.statusText);
      }
    }
  }
</script>
</head>
<body>

<h1>显示返回内容</h1>

<br><br>
<form>
<input type="button" value="按responseText方式获取数据" onClick="retrieveText();">
<input type="button" value="按responseXML方式获取数据" onClick="retrieveXML();">
</form>
<br>
<table border="1" bordercolor="#000000" cellpadding="5" cellspacing="0" width="100%">
  <tr>
    <td>
      <span id="dataTable">显示获取的数据</span>
    </td>
  </tr>

</table>
<br>

</body>
</html>
