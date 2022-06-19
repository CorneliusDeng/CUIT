<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="course.*,common.*,java.util.*"%>
<%
	//从查询出待修改的课程信息C层中获取数据
	String path = request.getContextPath();
	CourseInfo testcourse = (CourseInfo)session.getAttribute("Courseinfo");
%>
<!DOCTYPE html>
<html>
<!-- 课程信息更新功能V层 -->
<head>
<title>修改课程</title>
<link rel=stylesheet type="text/css" href="../css/student.css">
<script type="text/javascript" src="../js/datacheck.js"></script>
</head>
<script>

	//判断字符串是否为数字
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
		{//课程名不为空且长度不能大于20字符
			alert("课程名不符合规范！");
			frm.coursename.focus();//光标落回原位
			return false;
		}
		
		if (frm.credit.value == " " || !checkNumber(frm.credit.value))
		{//学分必须为数字且不能为空
			alert("学分不符合规范！");
			frm.credit.focus();//光标落回原位
			return false;
		} 
		if (frm.grade.value.length != 4 || !IsInt(frm.grade.value)|| frm.grade.value == "")
		{//年级必须为四位数整数，不能为空
			alert("开设年级不符合规范！");
			frm.grade.focus();//光标落回原位
			return false;
		} 
		return true; 
	}
</script>
<body>
<div align="center">
课程修改页面
<form name="frm" action="<%=request.getContextPath()%>/CourseUpdateAction" method = "post">
	<table border="1">
		<!-- 需要课程ID，但因为是数据库自动获取的缘故，此处隐藏 -->
		<input type="hidden" name="id" value="<%=testcourse.getCourseID() %>">
		<tr class="td_header"><td colspan="2"> 课程信息修改,<span class="star">*</span>为必填项</td></tr>
		<tr ><td>课程名</td><td><input type="text" name="coursename" size="20" value="<%=testcourse.getName() %>"><span class="star">*</span>20位字符</td></tr>
		<tr><td>性质</td><td><select name="nature" size="1">
			<option value="1"<%=testcourse.getType()==1?"selected":"" %>>公共基础必修课</option>
			<option value="2"<%=testcourse.getType()==2?"selected":"" %>>公共选修课</option>
			<option value="3"<%=testcourse.getType()==3?"selected":"" %>>学科基础课</option>
			<option value="4"<%=testcourse.getType()==4?"selected":"" %>>专业必修课</option>
			<option value="5"<%=testcourse.getType()==5?"selected":"" %>>专业选修课</option>
			<option value="6"<%=testcourse.getType()==6?"selected":"" %>>集中性实践教学环节</option>
		</select><span class="star">*</span></td></tr>
		<tr><td>学分</td><td><input type="text" name="credit" size="20" value="<%=testcourse.getCredit() %>"><span class="star">*</span>数值</td></tr>
		<tr><td>开设年级</td><td><input type="text" name="grade" size="20" value="<%=testcourse.getGrade()%>"><span class="star">*</span>4位数年份</td></tr>
		<tr><td>开设专业</td><td><input type="radio" name="major" size="20" value="1" <%=testcourse.getMajor()==1?"checked":"" %>>软件工程
			<input type="radio" name="major" size="20" value="2" <%=testcourse.getMajor()==2?"checked":"" %>>空间信息
			<input type="radio" name="major" size="20" value="3" <%=testcourse.getMajor()==3?"checked":"" %>>大数据</td>
		</tr>
		<tr>
			<td>备注</td>
			<td>
				<TEXTAREA name="detail"  rows="2" cols="20" onpropertychange="if(this.value.length>200) {this.value=value.substr(0,200);alert('描述最多200个字符!');}"><%=testcourse.getDetail()==null?"":testcourse.getDetail() %></TEXTAREA>200个字符以内
			</td>
		<tr>
			<td colspan="2" align="center"><input type="reset" value="重置">
			<input type="submit" value="提交" onclick="return check();"></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>