<%@ page contentType="text/html;charset=gb2312" %>
<%!
    int num=0;                      		//声明一个计数变量
    synchronized void add(){     		//该方法实现访问次数的累加操作
       num++;
    }
%>
<% add(); %>                      	<%-- 该脚本程序调用实现访问次数累加的方法 --%>
<html>
<body><center>您是第<%=num%>位访问该页的游客！</center></body>
</html>
