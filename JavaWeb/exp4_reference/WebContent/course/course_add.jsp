<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="GB18030">
<title>添加课程信息</title>
<link rel="stylesheet" type="text/css" href="../css/student.css">
<script type="text/javascript" src = "../js/datacheck.js"></script>
<script language="JavaScript">
function check(){
	// TODO 1 课程名称不为空且长度是5~20
	// TODO 2 学分不能为空且为数值
	//3 开设年级不为空且是4位整数
	if(frm.name.value.length<5||frm.name.value.length>20){
		alert("名称请输入5至20个字符!");
		frm.name.focus();
		return false;
	}
	if(frm.Credits.value==""||!IsFloat(frm.Credits.value)){
		alert("请正确输入学分");
		frm.Credits.focus();
		return false;
	}
	if(frm.grade.value.length!=4||!IsInt(frm.grade.value)){
		alert("请给开设年级输入4位整数的年份!");
		frm.grade.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>							 
  <center>				
   <a href="JavaScript:history.back();">课程信息管理</a>						 
   <form name="frm" method="post" action="<%=request.getContextPath()%>/CourseInsertAction">
   <table border=1>
	<tr class="td_header"><td colspan="2"> 课程信息录入，<span class="star">*</span>为必填项</td></tr>
   <tr><td>名称</td><td><input type="text" name="name" value="" size="20" maxlength="20"><span class="star">*</span>5至20个字符</td></tr>
   <tr><td>性质</td><td><select name="Properties" size='1' ><option value='1'>公共基础必修课</option><option value='2'>公共选修课</option>
   		<option value='3'>学科基础课</option><option value='4' selected>专业必修课</option><option value='5'>专业选修课</option>
   		<option value='6'>集中性实践教学环节</option></select><span class="star">*</span></td></tr>
   <tr><td>学分</td><td><input type="text" name="Credits" value="" size="20" maxlength="20"><span class="star">*</span></td></tr>
   <tr><td>开设年级</td><td><input type="text" name="grade" value="" size="20" maxlength="4"><span class="star">*</span>4位整数</td></tr>
   <tr><td>开设专业</td><td><input type="radio" name="Professional" value="1" checked>软件工程<input type="radio" name="Professional" value="2">空间信息<input type="radio" name="Professional" value="3">大数据<span class="star">*</span></td></tr>
   <tr><td>备注</td><td><TEXTAREA name="detail"  rows="2" cols="20" onpropertychange="if(this.value.length>200) {this.value=value.substr(0,200);alert('描述最多20个字符!');}"></TEXTAREA>200个字符以内</td></tr>
   <tr><td colspan="2" align="center"><input type="reset"  value="重填" ><input type="submit"  value="提交" onclick="return check();"></td></tr>
   </table>   
   </form>
   </center>
</body>
</html>
