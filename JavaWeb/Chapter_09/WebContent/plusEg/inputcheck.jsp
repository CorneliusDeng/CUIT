<!--  
����:�ɶ���Ϣ����ѧԺ �������ϵ ������
ת���뱣������Ϣ
-->
<%@ page contentType="text/html;charset=GB2312" %>
 
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
  //2���¼�����������Ajax�첽���󣬲�ע��Ajax��Ӧ�Ļص�����
  function checkCode() {
    if(http_request==false){//XMLHttpRequest����δ����
    	createRequest();//����XMLHttpRequest����
    	if(http_request==false){return;} //�������ɹ�   	
    }
    var url="<%=path%>/servlet/AjaxServlet?Action=GetFlagByText&code="+frm.stCode.value;
    http_request.onreadystatechange = checkcode_callback;//ע��Ajax��Ӧ�Ļص�����
  	http_request.open("POST", url, true);
  	http_request.send();		//����Ajax�첽����
  }
  //3��Ajax��Ӧ�Ļص���������������Ӧ����������
  function checkcode_callback() {  
    if (http_request.readyState == 4) { // ���
      if (http_request.status == 200) { // ������Ӧ   
        var flag=http_request.responseText;   //��ȡ��������
        
        //����������      
      	if(flag=="0"){
        	document.getElementById("codeSpan").innerHTML="��ѧ�ſ���ʹ��";
        }else if(flag=="1"){
        	frm.stCode.value="";
        	document.getElementById("codeSpan").innerHTML="��ѧ���Ѿ����ڣ����������룡";
        }         
        
      } else {
        alert("Problem: " + http_request.statusText);
      }
    }
  }

 function checkName() {
    if(http_request==false){	//XMLHttpRequest����δ����
    	createRequest();		//����XMLHttpRequest����
    	if(http_request==false){return;} //�������ɹ�   	
    }
    var url="<%=path%>/servlet/AjaxServlet?Action=GetFlagByXML&name="+frm.stName.value;
    http_request.onreadystatechange = checkName_callback;
  	http_request.open("POST", url, true);
  	http_request.send();
  }

  function checkName_callback() { 
    if (http_request.readyState == 4) { // ���
      if (http_request.status == 200) { // ������Ӧ   
        var flag=http_request.responseXML.getElementsByTagName("flag")[0].text;         

      	if(flag=="0"){
        	document.getElementById("nameSpan").innerHTML="<font color=green>����������ʹ��</font>";
        }else if(flag=="1"){
        	frm.stName.value="";
        	document.getElementById("nameSpan").innerHTML="<font color=red>�������Ѿ����ڣ����������룡</font>";
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
ѧ��<input type="text" name="stCode" value="" onblur="checkCode();">
	<span id="codeSpan" ></span><br>
����<input type="text" name="stName" value="" onchange="checkName();">
	<span id="nameSpan"></span><br>
����<input type="text" name="stAge" value=""><br>
<input type="button" value="���">
</form>
<br>
<br>
���ԣ�
<br>
ѧ���� 001 �����ѧ����ʹ�õ���ʾ
<br>
������ ������ �����������ʹ�õ���ʾ

</body>
</html>
