<%@ page contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
%>

<html>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=GB2312">
<link rel="stylesheet" href="<%=path%>/css/menu_style.css" type="text/css">
<TITLE>menu</TITLE>
</HEAD>
<script>
	  var classCount = 5; // 菜单大类的个数
	  function Show(theId) {
	  	theTr = eval("tr_" + theId);
		if (theTr.style.display == "none") {
			theTr.style.display = "block";
		}
		else {
			theTr.style.display = "none";
		}
		for (i = 0; i < classCount; i++) {
			if (i == theId)
				continue;
			theTr = eval("tr_" + i);
			theTr.style.display = "none";
		}
	  }
	  
var menuList={
0:{1:"学生管理","学生信息管理":"<%=path%>/servlet/StudentListAction"},
1:{1:"课程管理","课程信息管理":"<%=path%>/course/course_list.jsp"},
2:{1:"成绩管理","学生成绩查询":"<%=path%>/score/score_query_student.jsp","课程成绩查询":"<%=path%>/score/score_query_course.jsp","成绩录入":"<%=path%>/score/score_add.jsp"},
3:{1:"教师管理","教师信息管理":"<%=path%>/teacher/teacher_list.jsp","教师授课管理":"<%=path%>/teach/teach_list.jsp"},
4:{1:"用户管理","用户信息管理":"<%=path%>/user/user_list.jsp"}
};

function createMenu(){	
	for( menu in menuList){
    	document.write('<TR><TD  id="td_'+menu+'"  align="center" width="90%" bgColor="#1f65c2" ><A  href="javascript:Show('+menu+')">'+menuList[menu][1]+'</A></TD></TR>');
		document.write(' <TR id=tr_'+menu+' style="DISPLAY: none;cursor:hand">');
		document.write(' 	<TD  width="100%" align="center"  bgColor="#4c84ce" height="50">');
		document.write(' 		<table align="center" border="0" width="90%">');
	    for(submenu in menuList[menu]){
            if(submenu==1){
				continue;
		    }
		    document.write('<tr><td width="150" align="center" ><A href="'+menuList[menu][submenu]+'" target="right_workspace">'+submenu+'</A> </td><tr>');
		}
		document.write(' </table> </TD> </TR>');	
	}
}
</script>

<BODY link="#333333" vlink="#333333" alink="#FF0000" bgColor="#1fa5a2">
<table class="guide guideText" width="100%">
<script>
createMenu();
</script>

</table>
</BODY>
</html>
