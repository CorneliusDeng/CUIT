<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<!-- �γ���Ϣ��ӽ���V�� -->
<head>
<meta charset="GB18030">
<title>��ӿγ�</title>
<link rel=stylesheet type="text/css" href="../css/student.css">
<script type="text/javascript" src="../js/datacheck.js"></script>
</head>
<script>

	//�ж��ַ����Ƿ�Ϊ����
	function checkNumber(nubmer) 
	{
	    var re = /^[0-9]+.?[0-9]*$/;
	    if (re.test(nubmer)) 
	    {
	       return true;
	    }
	    else
	    {
	        return false;
	    }
	}
	
	function check()
	{
		if (frm.coursename.value.length > 20 || frm.coursename.value == "")
		{//�γ�����Ϊ���ҳ��Ȳ��ܴ���20�ַ�
			alert("�γ��������Ϲ淶��");
			frm.coursename.focus();//������ԭλ
			return false;
		}
		
		if (frm.credit.value == " " || !checkNumber(frm.credit.value))
		{//ѧ�ֱ���Ϊ�����Ҳ���Ϊ��
			alert("ѧ�ֲ����Ϲ淶��");
			frm.credit.focus();//������ԭλ
			return false;
		} 
		if (frm.grade.value.length != 4 || !IsInt(frm.grade.value)|| frm.grade.value == "")
		{//�꼶����Ϊ��λ������������Ϊ��
			alert("�����꼶�����Ϲ淶��");
			frm.grade.focus();//������ԭλ
			return false;
		} 
		return true; 
	}
</script>

<body>
<div align="center">
�γ����ҳ��
<form name="frm" action="<%=request.getContextPath()%>/CourseInsertAction" method = "post">
<table border="1">
	<tr class="td_header"><td colspan="2"> �γ���Ϣ¼��,<span class="star">*</span>Ϊ������</td></tr>
	<tr ><td>�γ���</td><td><input type="text" name="coursename" size="20" value=""><span class="star">*</span>20λ�ַ�</td></tr>
	<tr><td>����</td><td><select name="nature" size="1">
			<option value="1">�����������޿�</option>
			<option value="2">����ѡ�޿�</option>
			<option value="3">ѧ�ƻ�����</option>
			<option value="4">רҵ���޿�</option>
			<option value="5">רҵѡ�޿�</option>
			<option value="6">������ʵ����ѧ����</option>
		</select><span class="star">*</span></td></tr>
	<tr><td>ѧ��</td><td><input type="text" name="credit" size="20" value=""><span class="star">*</span>��ֵ</td></tr>
	<tr><td>�����꼶</td><td><input type="text" name="grade" size="20" value=""><span class="star">*</span>4λ�����</td></tr>
	<tr><td>����רҵ</td><td><input type="radio" name="major" size="20" value="1" checked>�������
		<input type="radio" name="major" size="20" value="2" >�ռ���Ϣ
		<input type="radio" name="major" size="20" value="3" >������</td>
	</tr>
	<tr>
		<td>��ע</td>
		<td>
			<TEXTAREA name="detail"  rows="2" cols="20" onpropertychange="if(this.value.length>200) {this.value=value.substr(0,200);alert('�������200���ַ�!');}"></TEXTAREA>200���ַ�����
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="reset" value="����">
		<input type="submit" value="�ύ" onclick="return check();"></td>
	</tr>
</table>
</form>
</div>
</body>
</html>