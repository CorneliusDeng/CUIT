<%@ page contentType="text/html;charset=GB2312" %>
<HTML><BODY>
 <FORM action="dealmessage.jsp" method="post" name="form">
  <P>输入您的名字：
  <INPUT  type="text" name="peopleName">
  <BR>输入您的留言标题：
  <INPUT  type="text"  name="Title">
  <BR>输入您的留言：  
<BR> <TEXTAREA name="messages" ROWs="4" COLS=36 WRAP="physical">
</TEXTAREA>
<BR> <INPUT type="submit" value="提交信息" name="submit">
</FORM>
<a href="showmessage.jsp">查看留言板</a>
</BODY></HTML>
