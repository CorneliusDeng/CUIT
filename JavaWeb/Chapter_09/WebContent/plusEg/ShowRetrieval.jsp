<!--  
����:�ɶ���Ϣ����ѧԺ �������ϵ ������
ת���뱣������Ϣ
-->
<%@ page contentType="text/html;charset=gb2312" %>
 
<%
String path = request.getContextPath();
%>
<html>
<head>
 <title>��ʾ��������</title>
<script>
	//1������Ajax����XMLHttpRequest����ʵ��	
    var http_request = false;
    function createRequest() {
        http_request = false;
        if (window.XMLHttpRequest) {     // Mozilla�������IE7����
            http_request = new XMLHttpRequest();
            if (http_request.overrideMimeType) {
                http_request.overrideMimeType('text/xml');     //����MIME���
            }
        } else if (window.ActiveXObject) {     // IE5��IE6�����
        
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
    if(http_request==false){//XMLHttpRequest����δ����
    	createRequest();//����XMLHttpRequest����
    	if(http_request==false){return;} //�������ɹ�   	
    }
    var url="<%=path%>/servlet/AjaxServlet?Action=GetDataByText";
    http_request.onreadystatechange = callbackfortext;
  	http_request.open("post", url, true);
  	http_request.send();
  }
  function callbackfortext() { 
    if (http_request.readyState == 4) { // ���
      if (http_request.status == 200) { // ������Ӧ
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
     if(http_request==false){//XMLHttpRequest����δ����
    	createRequest();//����XMLHttpRequest����
    	if(http_request==false){return;} //�������ɹ�   	
    }
    var url="<%=path%>/servlet/AjaxServlet?Action=GetDataByXML";
    http_request.onreadystatechange = callbackforXML;
  	http_request.open("post", url, true);
  	http_request.send();
  }

  function callbackforXML() { 
    if (http_request.readyState == 4) { // ���
      if (http_request.status == 200) { // ������Ӧ
        var xml=http_request.responseXML;
        
	  	var html="<table border='1'><tr><td>ѧ��</td><td>����</td><td>��ѧ</td><td>Ӣ��</td><td>����</td></tr>";
	    //��ȡXML�е�����student��ǩ���ŵ�students����
	    var students=xml.getElementsByTagName("student");
	    //��students������б�������ȡÿ���ӽڵ������
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

<h1>��ʾ��������</h1>

<br><br>
<form>
<input type="button" value="��responseText��ʽ��ȡ����" onClick="retrieveText();">
<input type="button" value="��responseXML��ʽ��ȡ����" onClick="retrieveXML();">
</form>
<br>
<table border="1" bordercolor="#000000" cellpadding="5" cellspacing="0" width="100%">
  <tr>
    <td>
      <span id="dataTable">��ʾ��ȡ������</span>
    </td>
  </tr>

</table>
<br>

</body>
</html>
