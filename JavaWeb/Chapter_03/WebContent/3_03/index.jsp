<%@ page contentType="text/html;charset=gb2312"%>
<% int able=1; %>
<html>
<body>
<table>
<% if(able==1){%>
<tr><td>欢迎登录!您的身份为“普通管理员”。</td></tr>
<% }
       else if(able==2){
  	%>
   <tr><td>欢迎登录!您的身份为“系统管理员”。</td></tr>
   <% } %>
 </table>
</body>
</html>
