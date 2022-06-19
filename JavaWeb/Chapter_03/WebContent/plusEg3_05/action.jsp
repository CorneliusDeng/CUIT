<%@ page contentType="text/html;charset=GB2312" %>
<HTML><BODY>
<br>您的职业是： 
<UL>
<%
//利用request对象的getParameterValues方法,
//取得复选框的输出值,并设定给job字符串数组
String job[] = request.getParameterValues("job");
//利用for循环输出群组检查框输出的值
if(job!=null) {
for(int i = 0; i < job.length ; i++) {
byte  b[ ]=job[i].getBytes("ISO-8859-1");
     String tmp=new String(b);
out.println("<LI>" + tmp + "</LI>");
	}
}
out.println("<br>");
String str=request.getParameter("job");
if(str!=null){
	byte  b[ ]=str.getBytes("ISO-8859-1");
	str=new String(b);
}else{
	str="";
}
out.println("第一个职业是："+str);
%>
</UL>
<a href="JavaScript:history.go(-1);">返回</a>
</BODY></HTML>
