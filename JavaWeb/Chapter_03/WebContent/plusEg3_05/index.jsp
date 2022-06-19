<%@page contentType="text/html;charset=gb2312"%>
<HTML>
<HEAD><TITLE>request</TITLE></HEAD>
<BODY>
<FORM action=" action.jsp" method=post name=formTest>
您的职业是：<br><br>
<!--供选取职业类型的检查框-->
<input type="hidden" name="formName" value="formTest">
<INPUT type="checkbox" name=job value="学生">学生
<INPUT type="checkbox" name=job value="教师">教师
<INPUT type="checkbox" name=job value="程序员">程序员
<INPUT type="checkbox" name=job value="医生">医生
<INPUT type="checkbox" name=job value="技术员">技术员<br><br>
<INPUT type="submit" value="送出" name=submit>
<INPUT type="reset" value="清除" name=reset>
</FORM></BODY></HTML>
