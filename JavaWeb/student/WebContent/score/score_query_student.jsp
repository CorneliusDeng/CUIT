<%@ page contentType="text/html;charset=GB2312" %>
<%
String path = request.getContextPath();
%>
<html>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/student.css">
<script type="text/javascript" src = "<%=path%>/js/datacheck.js"></script>
  <body>
  <center>									 
   <form name="frm" method="post" >
   <table border=0>
	<tr class="td_header"><td colspan="2"> ���������ڲ�ѯ��ѧ��ѧ�ţ�</td></tr>
   <tr><td><input type="text" name="code" value="" size="20" maxlength="5"></td><td><input type="button"  value="��ѯ" onclick="return check();"></td></tr>
   </table>   
   </form>
  
   
   <table border="1" bordercolor="#000000" cellpadding="5" cellspacing="0" width="60%" >
  <tr>
    <td width="60%"  id="dataTable" align="center">��ʾ��ȡ������</td>
  </tr>

</table>
 </center>
  </body>
</html>
<script language="JavaScript">
function check(){
	if(frm.code.value.length!=5){
		alert("������5λ�ַ����ֵ�ѧ��!");
		frm.code.focus();
		return ;
	}
	retrieveXML();
}
</script>
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

 
  function retrieveXML() {
     if(http_request==false){//XMLHttpRequest����δ����
    	createRequest();//����XMLHttpRequest����
    	if(http_request==false){return;} //�������ɹ�   	
    }
    var url="<%=path%>/ScoreAction?Action=GetStudentScoresByAjax&code="+frm.code.value;
    http_request.onreadystatechange = callbackforXML;
  	http_request.open("post", url, true);
  	http_request.send();
  }

  function callbackforXML() { 
    if (http_request.readyState == 4) { // ���
      if (http_request.status == 200) { // ������Ӧ
        var xml=http_request.responseXML;
        
	  	var html="<table border='1' width='90%' align='center'><tr class='td_header' align='center'><td>���</td><td>�γ�����</td><td>����</td></tr>";
	    //��ȡXML�е�����score��ǩ���ŵ�scores����
	    var scores=xml.getElementsByTagName("score");
	    //��scores������б�������ȡÿ���ӽڵ������
	    if (scores.length != 0) {
	        for (var i = 0; i < scores.length; i++) {
	            var score = scores[i];
				html+="<tr align='center'><td>"+(i+1)+"</td>"+
				"<td>"+score.childNodes[0].childNodes[0].nodeValue+"</td>"+
				"<td>"+score.childNodes[1].childNodes[0].nodeValue+"</td></tr>";
	        }
		   	html+="</table>" ;
		   //	alert(html);
			document.getElementById("dataTable").innerHTML=html;
	    }else{
	    	document.getElementById("dataTable").innerHTML="��ѧ�Ų����ڣ����߸�ѧ��û�гɼ���Ϣ��";
	    }
	          
    } else {
        alert("Problem: " + http_request.statusText);
      }
    }
  }
</script>