<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="GB18030">
<title>��ӿγ���Ϣ</title>
<link rel="stylesheet" type="text/css" href="../css/student.css">
<script type="text/javascript" src = "../js/datacheck.js"></script>
<script language="JavaScript">
function check(){
	// TODO 1 �γ����Ʋ�Ϊ���ҳ�����5~20
	// TODO 2 ѧ�ֲ���Ϊ����Ϊ��ֵ
	//3 �����꼶��Ϊ������4λ����
	if(frm.name.value.length<5||frm.name.value.length>20){
		alert("����������5��20���ַ�!");
		frm.name.focus();
		return false;
	}
	if(frm.Credits.value==""||!IsFloat(frm.Credits.value)){
		alert("����ȷ����ѧ��");
		frm.Credits.focus();
		return false;
	}
	if(frm.grade.value.length!=4||!IsInt(frm.grade.value)){
		alert("��������꼶����4λ���������!");
		frm.grade.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>							 
  <center>				
   <a href="JavaScript:history.back();">�γ���Ϣ����</a>						 
   <form name="frm" method="post" action="<%=request.getContextPath()%>/CourseInsertAction">
   <table border=1>
	<tr class="td_header"><td colspan="2"> �γ���Ϣ¼�룬<span class="star">*</span>Ϊ������</td></tr>
   <tr><td>����</td><td><input type="text" name="name" value="" size="20" maxlength="20"><span class="star">*</span>5��20���ַ�</td></tr>
   <tr><td>����</td><td><select name="Properties" size='1' ><option value='1'>�����������޿�</option><option value='2'>����ѡ�޿�</option>
   		<option value='3'>ѧ�ƻ�����</option><option value='4' selected>רҵ���޿�</option><option value='5'>רҵѡ�޿�</option>
   		<option value='6'>������ʵ����ѧ����</option></select><span class="star">*</span></td></tr>
   <tr><td>ѧ��</td><td><input type="text" name="Credits" value="" size="20" maxlength="20"><span class="star">*</span></td></tr>
   <tr><td>�����꼶</td><td><input type="text" name="grade" value="" size="20" maxlength="4"><span class="star">*</span>4λ����</td></tr>
   <tr><td>����רҵ</td><td><input type="radio" name="Professional" value="1" checked>�������<input type="radio" name="Professional" value="2">�ռ���Ϣ<input type="radio" name="Professional" value="3">������<span class="star">*</span></td></tr>
   <tr><td>��ע</td><td><TEXTAREA name="detail"  rows="2" cols="20" onpropertychange="if(this.value.length>200) {this.value=value.substr(0,200);alert('�������20���ַ�!');}"></TEXTAREA>200���ַ�����</td></tr>
   <tr><td colspan="2" align="center"><input type="reset"  value="����" ><input type="submit"  value="�ύ" onclick="return check();"></td></tr>
   </table>   
   </form>
   </center>
</body>
</html>
