<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>���ѧ����Ϣ</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/student.css">
<script type="text/javascript" src = "<%=path%>/js/datacheck.js"></script>
</head>
  <body>
  <center>		
      <a href="JavaScript:history.back();">>>ѧ����Ϣ����</a><br><br>
   <form name="frm" method="post" action="<%=path%>/student/student_add_action.jsp">
   <table border=1>
	<tr class="td_header"><td colspan="2"> ѧ����Ϣ¼�룬<span class="star">*</span>Ϊ������</td></tr>
   <tr><td>ѧ��</td><td><input type="text" name="code" value="" size="20" maxlength="5" placeholder="5λ�ַ�����" required pattern="[0-9]{5}"><span class="star">*</span></td></tr>
   <tr><td>����</td><td><input type="text" name="name" value="" size="20" maxlength="20" placeholder="����Ϊ2-20���ַ�" required pattern="\S{2,20}"><span class="star">*</span></td></tr>
   <tr><td>�Ա�</td><td><input type="radio" name="sex" value="0" checked>��<input type="radio" name="sex" value="1">Ů<span class="star">*</span></td></tr>
   <tr><td>�꼶</td><td><input type="text" name="grade" value="" size="20" maxlength="4" placeholder="4λ�������20xx" required pattern="20[0-9]{2}"><span class="star">*</span></td></tr>
   <tr><td>רҵ</td><td><select name="major" size='1' ><option value='1'>�������</option><option value='2'>�ռ���Ϣ</option></select><span class="star">*</span></td></tr>
   <tr><td>��ע</td><td><TEXTAREA name="detail"  rows="2" cols="20" onpropertychange="if(this.value.length>200) {this.value=value.substr(0,200);alert('�������200���ַ�!');}"></TEXTAREA>200���ַ�����</td></tr>
   <tr><td colspan="2" align="center"><input type="reset"  value="����" ><input type="submit"  value="�ύ"  ></td></tr>
   </table>   
   </form>
   </center>
  </body>
</html>