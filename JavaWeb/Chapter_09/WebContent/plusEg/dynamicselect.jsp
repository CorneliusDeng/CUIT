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
   function getProvince() { 
    if(http_request==false){//XMLHttpRequest对象未创建
    	createRequest();//创建XMLHttpRequest对象
    	if(http_request==false){return;} //创建不成功   	
    }
   
	var url="<%=path%>/servlet/AjaxServlet?Action=GetArea&parent=0&level=0";	
	
    http_request.onreadystatechange = callback_province;
  	http_request.open("POST", url, true);
  	http_request.send(null);
  	
  }
 
  function callback_province() { 
    if (http_request.readyState == 4) { // 完成
      if (http_request.status == 200) { // 正常响应
    	 // alert(http_request.responseText);
     	 createProvince(http_request.responseXML);
      } else {
        alert("Problem: " + http_request.statusText);
      }
    }
  }
  function createProvince(xml){ 
	var selectObj=document.getElementById("provinceID");
	//删除列表中原有数据
	for(var i=selectObj.length-1;i>=0;i--){
		selectObj.options.remove(i);
	}
	//解析XML节点
	var cities=xml.getElementsByTagName("area");
	if(cities.length>0){
		for(i=0;i<cities.length;i++){
			op=new Option(cities[i].childNodes[1].childNodes[0].nodeValue,cities[i].childNodes[0].childNodes[0].nodeValue);
			selectObj.options.add(op);
		}
		selectObj.selectedIndex=0;
		getCity();     

	}else{
		document.getElementById("warning").innerHTML="没有省份数据！";
	}
  } 
  function getCity() { 
    if(http_request==false){//XMLHttpRequest对象未创建
    	createRequest();//创建XMLHttpRequest对象
    	if(http_request==false){return;} //创建不成功   	
    }
   
  	var selectObj=document.getElementById("provinceID"); 
	var url="<%=path%>/servlet/AjaxServlet?Action=GetArea&level=1&parent="+selectObj[selectObj.selectedIndex].value;	
    http_request.onreadystatechange = callback_city;
  	http_request.open("POST", url, true);
  	http_request.send(null);
  	
  }
 
  function callback_city() { 
    if (http_request.readyState == 4) { // 完成
      if (http_request.status == 200) { // 正常响应
     	 createCity(http_request.responseXML);
      } else {
        alert("Problem: " + http_request.statusText);
      }
    }
  }
  function createCity(xml){ 
	var selectObj=document.getElementById("cityID");
	//删除列表中原有数据
	for(var i=selectObj.length-1;i>=0;i--){
		selectObj.options.remove(i);
	}
	//解析XML节点
	var cities=xml.getElementsByTagName("area");
	if(cities.length>0){
		for(i=0;i<cities.length;i++){
			op=new Option(cities[i].childNodes[1].childNodes[0].nodeValue,cities[i].childNodes[0].childNodes[0].nodeValue);
			selectObj.options.add(op);
			document.getElementById("warning").innerHTML="";
		}
	}else{
		document.getElementById("warning").innerHTML="没有对应的城市数据！";
	}
	getCounty();     
  }
  function getCounty() { 
   if(http_request==false){//XMLHttpRequest对象未创建
    	createRequest();//创建XMLHttpRequest对象
    	if(http_request==false){return;} //创建不成功   	
    }
  	var selectObj=document.getElementById("cityID"); 
	var url="<%=path%>/servlet/AjaxServlet?Action=GetArea&level=2&parent="+selectObj[selectObj.selectedIndex].value;	
    http_request.onreadystatechange = callback_county;
  	http_request.open("POST", url, true);
  	http_request.send(null);
  }
 
  function callback_county() { 
    if (http_request.readyState == 4) { // 完成
      if (http_request.status == 200) { // 正常响应
     	 createCounty(http_request.responseXML);
      } else {
        alert("Problem: " + http_request.statusText);
      }
    }
  }
  function createCounty(xml){ 
	var selectObj=document.getElementById("countyID");
	//删除列表中原有数据
	for(var i=selectObj.length-1;i>=0;i--){
		selectObj.options.remove(i);
	}
	//解析XML节点
	var counties=xml.getElementsByTagName("area");
	if(counties.length>0){
		for(i=0;i<counties.length;i++){
			op=new Option(counties[i].childNodes[1].childNodes[0].nodeValue,counties[i].childNodes[0].childNodes[0].nodeValue);
			selectObj.options.add(op);
			document.getElementById("warning1").innerHTML="";
			
		}
	}else{
		document.getElementById("warning1").innerHTML="没有对应的区县数据！";
	}     
  }

</script>
</head>
<body onload="getProvince();">
<br><br><br>
<form name=frm>
<table border="1" bordercolor="#000000" cellpadding="5" cellspacing="0" width="100%">
  <tr>
    <td>
      省份
      <select name="provinceID" id="provinceID" onchange="getCity();">
      </select>
    </td>
    <td>城市
      <select name="cityID" id="cityID"  onchange="getCounty();"></select>
      <span id="warning"></span> 
    </td>
    <td>区县
      <select name="countyID" id="countyID"></select>
      <span id="warning1"></span>
    </td>
  </tr>

</table>
</form>
<br>

</body>
</html>
