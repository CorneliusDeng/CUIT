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
	<tr class="td_header"><td colspan="2"> ѧ����Ϣ�޸ģ�<span class="star">*</span>Ϊ������</td></tr>
   <tr><td>ѧ��</td><td><input type="text" name="code" value="<%=student.getStCode() %>" size="20" maxlength="5" onchange="checkCode();"><span class="star">*</span>5λ�ַ�����<span id="codeSpan"></span></td></tr>
   <tr><td>����</td><td><input type="text" name="name" value="<%=student.getStName() %>" size="20" maxlength="20"><span class="star">*</span></td></tr>
   <tr><td>�Ա�</td><td><input type="radio" name="sex" value="0" <%=student.getSex()==0?"checked":"" %>>��<input type="radio" name="sex" value="1" <%=student.getSex()==1?"checked":"" %>>Ů<span class="star">*</span></td></tr>
   <tr><td>�꼶</td><td><input type="text" name="grade" value="<%=student.getGrade() %>" size="20" maxlength="4"><span class="star">*</span>4λ����</td></tr>
   <tr><td>רҵ</td><td><select name="major" size='1' >
   <option value='1' <%=student.getMajor()==1?"selected":"" %>>�������</option>
   <option value='2' <%=student.getMajor()==2?"selected":"" %>>�ռ���Ϣ</option>
   </select><span class="star">*</span></td></tr>
   <tr><td>��ע</td><td><TEXTAREA name="detail"  rows="2" cols="20" onpropertychange="if(this.value.length>200) {this.value=value.substr(0,200);alert('�������20���ַ�!');}"><%=student.getDetail()==null?"":student.getDetail() %></TEXTAREA>200���ַ�����</td></tr>
   <tr><td colspan="2" align="center"><input type="reset"  value="����" ><input type="button"  value="�ύ" onclick="check();"></td></tr>
   </table>   
   </form>
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
	if(frm.name.value==""){
		alert("����������!");
		frm.name.focus();
		return ;
	}
	if(frm.grade.value.length!=4||!IsInt(frm.grade.value)){
		alert("������4λ���������!");
		frm.grade.focus();
		return ;
	}
	frm.submit();
}

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
        
    }
}
//2���¼�����������Ajax�첽���󣬲�ע��Ajax��Ӧ�Ļص�����
function checkCode() {
if(http_request==false){//XMLHttpRequest����δ����
	createRequest();//����XMLHttpRequest����
	if(http_request==false){return;} //�������ɹ�   	
}
var url="<%=path%>/servlet/StudentCodeCheckAction?code="+frm.code.value+"&id="+frm.id.value;
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
    	document.getElementById("codeSpan").innerHTML="<br>��ѧ�ſ���ʹ��";
    }else if(flag=="1"){
    	document.getElementById("codeSpan").innerHTML="<br>��ѧ��["+frm.code.value+"]�Ѿ����ڣ����������룡";
    	frm.code.value="";
    }         
    
  } else {
    alert("Problem: " + http_request.statusText);
  }
}
}

</script>
