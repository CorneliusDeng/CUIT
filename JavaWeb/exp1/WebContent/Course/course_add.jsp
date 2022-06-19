<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="GB18030">
<title>添加课程</title>
<link rel=stylesheet type="text/css" href="../css/student.css">
<script type="text/javascript" src="../js/datacheck.js"></script>
</head>
<a href="JavaScript:history.back();">返回</a>
<script>
	function check()
	{
		if (frm.coursename.value.length > 20 || frm.coursename.value == "")
		{
			alert("课程名不符合规范！");
			frm.coursename.focus();//光标落回原位
			return false;
		}
		if (frm.coursecredit.value.length > 4 || frm.coursecredit.value == "" )
		{
			alert("学分不符合规范！");
			frm.coursecredit.focus();//光标落回原位
			return false;
		} 
		if ( frm.grade.value.length > 4 || !IsInt(frm.grade.value)|| frm.grade.value == "")
		{
			alert("开设年级不符合规范！");
			frm.grade.focus();//光标落回原位
			return false;
		} 
		return true;
	}
</script>

<body>
<div align="center">
课程添加页面

<form name="frm" action="" method = "post">
<table border="1">
	<tr class="td_header">
		<td colspan="2"> 课程信息录入,<span class="star">*</span>为必填项</td>
		</tr>
	<tr>
		<td>课程名</td>
		<td>
			<input type="text" name="coursename" size="20" value=""><span class="star">*</span>20位字符
		</td>
	</tr>
	<tr>
		<td>性质</td>
		<td>
			<select name="nature" size="1">
				<option value="1">公共基础必修课</option>
				<option value="2">公共基础选修课</option>
				<option value="3">专业必修课</option>
				<option value="4">专业选修课</option>
			</select><span class="star">*</span></td></tr>
	<tr><td>学分</td><td><input type="text" name="coursecredit" size="20" value=""><span class="star">*</span>数值</td></tr>
	<tr><td>开设年级</td><td><input type="text" name="grade" size="20" value=""><span class="star">*</span>4位数年份</td></tr>
	<tr>
		<td>开设专业</td>
		<td>
			<input type="radio" name="major" size="3" value="1" checked >软件工程
			<input type="radio" name="major" size="2" value="2" >空间信息
			<input type="radio" name="major" size="3" value="3" >大数据
		</td>
	</tr>
	<tr>
		<td>备注</td>
		<td>
			<TEXTAREA name="detail"  rows="2" cols="20" onpropertychange="if(this.value.length>200) {this.value=value.substr(0,200);alert('描述最多20个字符!');}"></TEXTAREA>200个字符以内
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="reset" value="重置">
		<input type="submit" value="提交" onclick="return check();"></td>
	</tr>
</table>
</form>
</div>
</body>
</html>